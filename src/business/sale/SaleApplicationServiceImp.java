package business.sale;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import business.product.TransferProduct;
import dao.customer.DAOCustomer;
import dao.factory.DAOFactory;
import dao.product.DAOProduct;
import dao.sale.DAOSale;
import dao.transations.connection.Exceptions;
import dao.transations.transactioManager.TransactionManager;
import dao.transations.transaction.Transaction;

public class SaleApplicationServiceImp implements SaleApplicationService{

	@Override
	public TransferSale abrirVenta(int IDCliente) throws SQLException {
		
		TransferSale v = new TransferSale();
		HashMap<Integer, TransferLifeLine> carrito = new HashMap<Integer, TransferLifeLine>();
		v.setCarrito(carrito);
		v.setIDCliente(IDCliente);
		
		return v;
	}

	@Override
	public boolean devolucion(TransferLifeLine lv) throws SQLException {
		
		boolean correcto = false;
		TransactionManager t = TransactionManager.getInstance();
		Transaction transaccion = t.nuevaTransaccion();
		DAOSale daoVenta = DAOFactory.getInstance().generaDAOVenta();
		DAOProduct daoProd = DAOFactory.getInstance().generaDAOProducto();
		
		transaccion.start();
		TransferLifeLine lvDao = daoVenta.consultarLineaVenta(lv.getIdVenta(), lv.getIDProducto());
		TransferProduct p = daoProd.readById_Producto(lv.getIDProducto());
		TransferSale v = daoVenta.readById_Venta(lv.getIdVenta());
		
		try {
			if(lv == null || v == null) {
				transaccion.rollback();
				throw new Exceptions("El transfer es null");
			}
			else if(lv.getCantidad() > lvDao.getCantidad()) {
				transaccion.rollback();
				throw new Exceptions("La cantidad a devolver es mayor que la comprada");
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
		catch (Exceptions e){
			transaccion.rollback();
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}

		
		return correcto;
	}

	
	@Override
	public TransferSale consultarUnaVenta(int IDVenta) throws SQLException {
		
		TransferSale v = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaction transaccion = t.nuevaTransaccion();
		DAOSale daoVenta = DAOFactory.getInstance().generaDAOVenta();
		
		transaccion.start();
		
		try {
			v = daoVenta.readById_Venta(IDVenta);
		}
		catch (Exceptions e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return v;
	}

	@Override
	public ArrayList<TransferSale> listarVentas() throws SQLException {
		
		ArrayList<TransferSale> listaVentas = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaction transaccion = t.nuevaTransaccion();
		DAOSale daoVenta = DAOFactory.getInstance().generaDAOVenta();
		
		transaccion.start();
		
		try {
			listaVentas = daoVenta.readAll();
		}
		catch (Exceptions e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return listaVentas;
	}

	@Override
	public boolean cerrarVenta(TransferSale v) throws SQLException {
		
		boolean correcto = false;
		float auxTotalVenta = 0;
		TransactionManager t = TransactionManager.getInstance();
		Transaction transaccion = t.nuevaTransaccion();
		DAOSale daoVenta = DAOFactory.getInstance().generaDAOVenta();
		DAOCustomer daoCli = DAOFactory.getInstance().generaDAOCliente();
		DAOProduct daoProd = DAOFactory.getInstance().generaDAOProducto();
				
		transaccion.start();
		
		try {	
			
			if(v == null) {
				transaccion.rollback();
				throw new Exceptions("El transfer es null");
			}
			//Cliente existe y activo
			else if((daoCli.readById_Cliente(v.getIDCliente()) != null) && (daoCli.readById_Cliente(v.getIDCliente())).getEnable()) {
				
				//Comprobar que el carrito no esta vacio
				if(!v.getCarrito().isEmpty()) {
					//Iterador para recorrer el hashmap e ir cogiendo las idProducto
					Iterator<Entry<Integer, TransferLifeLine>> it = v.getCarrito().entrySet().iterator();
					while(it.hasNext()) {
						Entry<Integer, TransferLifeLine> e = it.next();
						
						//Producto dentro del carrito
						if(v.getCarrito().containsKey(e.getKey())) {
							//Producto existe y activo en base de datos
							TransferProduct p = daoProd.readById_Producto(e.getKey());
							if(p != null && p.getEnable()) {
								//Comprobar que el stock es mayor que la cantidad de ese producto
								if(p.getStock() >= v.getCarrito().get(e.getKey()).getCantidad()) {
									
									//Meto precio de cada producto a cada linea de venta del carrito
									v.getCarrito().get(e.getKey()).setPrecio(p.getPrice());
									
									//Incrementar totalVenta
									auxTotalVenta += v.getCarrito().get(e.getKey()).getCantidad() * p.getPrice();
										
									//Actualizar stock de ese producto
									p.setStock(p.getStock()-v.getCarrito().get(e.getKey()).getCantidad());
									
									daoProd.update(p);
								}
								else {
									transaccion.rollback();
									throw new Exceptions("El stock no es suficiente");
								}
							}
							else {
								transaccion.rollback();
								throw new Exceptions("El producto no existe o no esta activo");
							}
						}
						else {
							transaccion.rollback();
							throw new Exceptions("El producto no esta en la linea de venta");
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
					throw new Exceptions("El carrito esta vacio");
				}	
			}
			else {
				transaccion.rollback();
				throw new Exceptions("El cliente no existe o no esta activo");
				
			}
		}
		catch (Exceptions e){
			transaccion.rollback();
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return correcto;
	}

	@Override
	public TransferCart anadirProductoCarrito(TransferCart cr) throws SQLException {
		
		TransferLifeLine lv = null;
		
		
		//Si existe el producto en el carrito aumentamos la cantidad
		if(cr.getCarrito().containsKey(cr.getIDProducto())) {
			
			lv = cr.getCarrito().get(cr.getIDProducto());
			lv.setCantidad(lv.getCantidad() + cr.getCantidad());
			cr.setCantidad(lv.getCantidad());
			cr.getCarrito().remove(cr.getIDProducto());
		}
		//Si no, introducimos esa cantidad y asignamos la IDProducto
		else {
			lv = new TransferLifeLine();
			lv.setCantidad(cr.getCantidad());
			lv.setIDProducto(cr.getIDProducto());
		}
		//Anadir la linea de venta al carrito y el precio
		//lv.setPrecio(p.getPrecio());
		
		cr.getCarrito().put(cr.getIDProducto(), lv);
	
		return cr;
	}

	@Override
	public TransferCart eliminarProductoCarrito(TransferCart cr) throws SQLException {
		

		TransferLifeLine lv = null;
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
				throw new Exceptions("El producto no esta en el carrito");
			}
		}
		catch (Exceptions e){
			throw e;
		}
		return cr;
	}

}
