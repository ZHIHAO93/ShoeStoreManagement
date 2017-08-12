package negocio.venta;

import integracion.cliente.DAOCliente;
import integracion.factoriaDAO.FactoriaDAO;
import integracion.producto.DAOProducto;
import integracion.transacciones.conexion.Excepciones;
import integracion.transacciones.transaccion.Transaccion;
import integracion.transacciones.transactioManager.TransactionManager;
import integracion.venta.DAOVenta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import negocio.producto.TransferProducto;

public class SAVentaImp implements SAVenta{

	@Override
	public TransferVenta abrirVenta(int IDCliente) throws SQLException {
		
		TransferVenta v = new TransferVenta();
		HashMap<Integer, TransferLineaVenta> carrito = new HashMap<Integer, TransferLineaVenta>();
		v.setCarrito(carrito);
		v.setIDCliente(IDCliente);
		
		return v;
	}

	@Override
	public boolean devolucion(TransferLineaVenta lv) throws SQLException {
		
		boolean correcto = false;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOVenta daoVenta = FactoriaDAO.getInstance().generaDAOVenta();
		DAOProducto daoProd = FactoriaDAO.getInstance().generaDAOProducto();
		
		transaccion.start();
		TransferLineaVenta lvDao = daoVenta.consultarLineaVenta(lv.getIdVenta(), lv.getIDProducto());
		TransferProducto p = daoProd.readById_Producto(lv.getIDProducto());
		TransferVenta v = daoVenta.readById_Venta(lv.getIdVenta());
		
		try {
			if(lv == null || v == null) {
				transaccion.rollback();
				throw new Excepciones("El transfer es null");
			}
			else if(lv.getCantidad() > lvDao.getCantidad()) {
				transaccion.rollback();
				throw new Excepciones("La cantidad a devolver es mayor que la comprada");
			}
			else {
				p.setStock(p.getStock()+lv.getCantidad());
				//Precio devuelto
				float devuelto = lvDao.getPrecio()*lv.getCantidad();
				v.setTotalVenta(v.getTotalVenta()-devuelto);
				
				lvDao.setCantidad(lvDao.getCantidad()-lv.getCantidad());
				
				correcto = daoVenta.devolucion(lvDao, p, v);
				transaccion.commit();
			}
		
		}
		catch (Excepciones e){
			transaccion.rollback();
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}

		
		return correcto;
	}

	
	@Override
	public TransferVenta consultarUnaVenta(int IDVenta) throws SQLException {
		
		TransferVenta v = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOVenta daoVenta = FactoriaDAO.getInstance().generaDAOVenta();
		
		transaccion.start();
		
		try {
			v = daoVenta.readById_Venta(IDVenta);
		}
		catch (Excepciones e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return v;
	}

	@Override
	public ArrayList<TransferVenta> listarVentas() throws SQLException {
		
		ArrayList<TransferVenta> listaVentas = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOVenta daoVenta = FactoriaDAO.getInstance().generaDAOVenta();
		
		transaccion.start();
		
		try {
			listaVentas = daoVenta.readAll();
		}
		catch (Excepciones e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return listaVentas;
	}

	@Override
	public boolean cerrarVenta(TransferVenta v) throws SQLException {
		
		boolean correcto = false;
		float auxTotalVenta = 0;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOVenta daoVenta = FactoriaDAO.getInstance().generaDAOVenta();
		DAOCliente daoCli = FactoriaDAO.getInstance().generaDAOCliente();
		DAOProducto daoProd = FactoriaDAO.getInstance().generaDAOProducto();
				
		transaccion.start();
		
		try {	
			
			if(v == null) {
				transaccion.rollback();
				throw new Excepciones("El transfer es null");
			}
			//Cliente existe y activo
			else if((daoCli.readById_Cliente(v.getIDCliente()) != null) && (daoCli.readById_Cliente(v.getIDCliente())).getActivo()) {
				
				//Comprobar que el carrito no esta vacio
				if(!v.getCarrito().isEmpty()) {
					//Iterador para recorrer el hashmap e ir cogiendo las idProducto
					Iterator<Entry<Integer, TransferLineaVenta>> it = v.getCarrito().entrySet().iterator();
					while(it.hasNext()) {
						Entry<Integer, TransferLineaVenta> e = it.next();
						
						//Producto dentro del carrito
						if(v.getCarrito().containsKey(e.getKey())) {
							//Producto existe y activo en base de datos
							TransferProducto p = daoProd.readById_Producto(e.getKey());
							if(p != null && p.getActivo()) {
								//Comprobar que el stock es mayor que la cantidad de ese producto
								if(p.getStock() >= v.getCarrito().get(e.getKey()).getCantidad()) {
									
									//Meto precio de cada producto a cada linea de venta del carrito
									v.getCarrito().get(e.getKey()).setPrecio(p.getPrecio());
									
									//Incrementar totalVenta
									auxTotalVenta += v.getCarrito().get(e.getKey()).getCantidad() * p.getPrecio();
										
									//Actualizar stock de ese producto
									p.setStock(p.getStock()-v.getCarrito().get(e.getKey()).getCantidad());
									
									daoProd.update(p);
								}
								else {
									transaccion.rollback();
									throw new Excepciones("El stock no es suficiente");
								}
							}
							else {
								transaccion.rollback();
								throw new Excepciones("El producto no existe o no esta activo");
							}
						}
						else {
							transaccion.rollback();
							throw new Excepciones("El producto no esta en la linea de venta");
						}
					}
					//Actualizar totalVenta
					v.setTotalVenta(auxTotalVenta);
					
					//Introducir fecha
					java.util.Date date = new Date();
					java.sql.Date fecha = new java.sql.Date(date.getTime());
					v.setFecha(fecha);
					
					correcto = daoVenta.cerrarVenta(v);
					transaccion.commit();
				}
				else {
					transaccion.rollback();
					throw new Excepciones("El carrito esta vacio");
				}	
			}
			else {
				transaccion.rollback();
				throw new Excepciones("El cliente no existe o no esta activo");
				
			}
		}
		catch (Excepciones e){
			transaccion.rollback();
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return correcto;
	}

	@Override
	public TransferCarrito anadirProductoCarrito(TransferCarrito cr) throws SQLException {
		
		TransferLineaVenta lv = null;
		
		
		//Si existe el producto en el carrito aumentamos la cantidad
		if(cr.getCarrito().containsKey(cr.getIDProducto())) {
			
			lv = cr.getCarrito().get(cr.getIDProducto());
			lv.setCantidad(lv.getCantidad() + cr.getCantidad());
			cr.setCantidad(lv.getCantidad());
			cr.getCarrito().remove(cr.getIDProducto());
		}
		//Si no, introducimos esa cantidad y asignamos la IDProducto
		else {
			lv = new TransferLineaVenta();
			lv.setCantidad(cr.getCantidad());
			lv.setIDProducto(cr.getIDProducto());
		}
		//Anadir la linea de venta al carrito y el precio
		//lv.setPrecio(p.getPrecio());
		
		cr.getCarrito().put(cr.getIDProducto(), lv);
	
		return cr;
	}

	@Override
	public TransferCarrito eliminarProductoCarrito(TransferCarrito cr) throws SQLException {
		

		TransferLineaVenta lv = null;
		try {
			//Si existe el producto en el carrito
			if(cr.getCarrito().containsKey(cr.getIDProducto())) {
				lv = cr.getCarrito().get(cr.getIDProducto());
				//Comprobamos si la cantidad introducida es mayor o igual que la que hay en esa linea de venta y si es asi, lo borramos
				if(cr.getCantidad() >= lv.getCantidad()) {
					cr.getCarrito().remove(cr.getIDProducto());
				}
				//Si es menor, actualizamos la cantidad
				else {
					lv.setCantidad(lv.getCantidad() - cr.getCantidad());
					cr.getCarrito().get(cr.getIDProducto()).setCantidad(lv.getCantidad());
				}
			}
			else {
				throw new Excepciones("El producto no esta en el carrito");
			}
		}
		catch (Excepciones e){
			throw e;
		}
		return cr;
	}

}
