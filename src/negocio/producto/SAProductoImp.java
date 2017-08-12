package negocio.producto;

import integracion.factoriaDAO.FactoriaDAO;
import integracion.producto.DAOProducto;
import integracion.transacciones.conexion.Excepciones;
import integracion.transacciones.transaccion.Transaccion;
import integracion.transacciones.transactioManager.TransactionManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class SAProductoImp implements SAProducto {

	@Override
	public boolean altaProducto(TransferProducto p) throws SQLException {
		
		boolean correcto = false;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOProducto daoProd = FactoriaDAO.getInstance().generaDAOProducto();
		
		
		transaccion.start();
		
		
		
		try {
			TransferProducto pDao = daoProd.readByName(p.getMarca(), p.getTipo(), p.getColor());
			
			if( pDao != null ) {
				if(pDao.getActivo()) {
					transaccion.rollback();
					throw new Excepciones("Ya existe producto");
				}
				else {
					//Reactivar
					p.setIDProducto(pDao.getIDProducto());
					correcto = daoProd.update(p);
					transaccion.commit();
				}
			}
			else if(p.getTipo().equals("") || p.getMarca().equals("") || p.getColor().equals("")){
				transaccion.rollback();
				throw new Excepciones("Es necesario introducir una marca, un tipo y color");
			}
			else if(p.getStock() < 0 || p.getStock() > 999){
				transaccion.rollback();
				throw new Excepciones("Es necesario que el stock este entre 0 y 999");
			}
			else if(p.getPrecio() < 0){
				transaccion.rollback();
				throw new Excepciones("Es necesario que el precio sea mayor que 0");
			}
			else {
				correcto = daoProd.create(p);
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
	public boolean bajaProducto(int IDProducto) throws SQLException {
		
		boolean correcto = false;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOProducto daoProd = FactoriaDAO.getInstance().generaDAOProducto();
		
		transaccion.start();
		
		try {
			TransferProducto p = daoProd.readById_Producto(IDProducto);
			if(p == null) {
				throw new Excepciones("El producto no existe");
			}
			else {
				if(p.getActivo()) {
					correcto = daoProd.bajaProducto(IDProducto);
					transaccion.commit();
				}
				else {
					transaccion.rollback();
					throw new Excepciones("El producto ya esta dado de baja");
				}
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
	public boolean modificarProducto(TransferProducto p) throws SQLException {
		
		boolean correcto = false;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOProducto daoProd = FactoriaDAO.getInstance().generaDAOProducto();
		
		transaccion.start();
		
		try {
			if(p == null) {
				transaccion.rollback();
				throw new Excepciones("El transfer es null");
			}
			else if((daoProd.readById_Producto(p.getIDProducto()) == null)) {
				transaccion.rollback();
				throw new Excepciones("No existe producto");
			}
			else if(p.getMarca().equals("") || p.getTipo().equals("") || p.getColor().equals("")){
				transaccion.rollback();
				throw new Excepciones("Es necesario introducir una marca, un tipo y color");
			}
			else if(p.getStock() < 0 || p.getStock() > 999){
				transaccion.rollback();
				throw new Excepciones("Es necesario que el stock este entre 0 y 999");
			}
			else if(p.getPrecio() < 0){
				transaccion.rollback();
				throw new Excepciones("Es necesario que el precio sea mayor que 0");
			}
			else {
				correcto = daoProd.update(p);
				transaccion.commit();
			}
			
		}
		catch (Excepciones e){
			transaccion.rollback();
			System.err.println(e.getMensaje());
			throw e;
			
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return correcto;
	}

	@Override
	public TransferProducto consultarUnProducto(int IDProducto) throws SQLException { //Duda*

		TransferProducto p = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOProducto daoProd = FactoriaDAO.getInstance().generaDAOProducto();
		
		transaccion.start();
		
		try {
			p = daoProd.readById_Producto(IDProducto);
		}
		catch (Excepciones e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return p;
	}

	@Override
	public ArrayList<TransferProducto> listarProductos() throws SQLException {
		
		ArrayList<TransferProducto> listaProductos = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOProducto daoProd = FactoriaDAO.getInstance().generaDAOProducto();
		
		transaccion.start();
		
		try {
			listaProductos = daoProd.readAll();
		}
		catch (Excepciones e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return listaProductos;
	}

	@Override
	public TransferProducto topProducto() throws SQLException {
		
		TransferProducto p = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOProducto daoProd = FactoriaDAO.getInstance().generaDAOProducto();
		
		transaccion.start();
		
		try {
			p = daoProd.productoMasVendido();
			if(p == null) {
				transaccion.rollback();
				throw new Excepciones("El transfer es null");
			}
		}
		catch (Excepciones e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return p;
	}

}
