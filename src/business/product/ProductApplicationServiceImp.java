package business.product;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.factory.DAOFactory;
import dao.product.DAOProduct;
import dao.transations.connection.Exceptions;
import dao.transations.transactioManager.TransactionManager;
import dao.transations.transaction.Transaction;

public class ProductApplicationServiceImp implements ProductApplicationService {

	@Override
	public boolean altaProducto(TransferProduct p) throws SQLException {
		
		boolean correcto = false;
		TransactionManager t = TransactionManager.getInstance();
		Transaction transaccion = t.nuevaTransaccion();
		DAOProduct daoProd = DAOFactory.getInstance().generaDAOProducto();
		
		
		transaccion.start();
		
		
		
		try {
			TransferProduct pDao = daoProd.readByName(p.getMarca(), p.getTipo(), p.getColor());
			
			if( pDao != null ) {
				if(pDao.getActivo()) {
					transaccion.rollback();
					throw new Exceptions("Ya existe producto");
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
				throw new Exceptions("Es necesario introducir una marca, un tipo y color");
			}
			else if(p.getStock() < 0 || p.getStock() > 999){
				transaccion.rollback();
				throw new Exceptions("Es necesario que el stock este entre 0 y 999");
			}
			else if(p.getPrecio() < 0){
				transaccion.rollback();
				throw new Exceptions("Es necesario que el precio sea mayor que 0");
			}
			else {
				correcto = daoProd.create(p);
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
	public boolean bajaProducto(int IDProducto) throws SQLException {
		
		boolean correcto = false;
		TransactionManager t = TransactionManager.getInstance();
		Transaction transaccion = t.nuevaTransaccion();
		DAOProduct daoProd = DAOFactory.getInstance().generaDAOProducto();
		
		transaccion.start();
		
		try {
			TransferProduct p = daoProd.readById_Producto(IDProducto);
			if(p == null) {
				throw new Exceptions("El producto no existe");
			}
			else {
				if(p.getActivo()) {
					correcto = daoProd.bajaProducto(IDProducto);
					transaccion.commit();
				}
				else {
					transaccion.rollback();
					throw new Exceptions("El producto ya esta dado de baja");
				}
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
	public boolean modificarProducto(TransferProduct p) throws SQLException {
		
		boolean correcto = false;
		TransactionManager t = TransactionManager.getInstance();
		Transaction transaccion = t.nuevaTransaccion();
		DAOProduct daoProd = DAOFactory.getInstance().generaDAOProducto();
		
		transaccion.start();
		
		try {
			if(p == null) {
				transaccion.rollback();
				throw new Exceptions("El transfer es null");
			}
			else if((daoProd.readById_Producto(p.getIDProducto()) == null)) {
				transaccion.rollback();
				throw new Exceptions("No existe producto");
			}
			else if(p.getMarca().equals("") || p.getTipo().equals("") || p.getColor().equals("")){
				transaccion.rollback();
				throw new Exceptions("Es necesario introducir una marca, un tipo y color");
			}
			else if(p.getStock() < 0 || p.getStock() > 999){
				transaccion.rollback();
				throw new Exceptions("Es necesario que el stock este entre 0 y 999");
			}
			else if(p.getPrecio() < 0){
				transaccion.rollback();
				throw new Exceptions("Es necesario que el precio sea mayor que 0");
			}
			else {
				correcto = daoProd.update(p);
				transaccion.commit();
			}
			
		}
		catch (Exceptions e){
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
	public TransferProduct consultarUnProducto(int IDProducto) throws SQLException { //Duda*

		TransferProduct p = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaction transaccion = t.nuevaTransaccion();
		DAOProduct daoProd = DAOFactory.getInstance().generaDAOProducto();
		
		transaccion.start();
		
		try {
			p = daoProd.readById_Producto(IDProducto);
		}
		catch (Exceptions e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return p;
	}

	@Override
	public ArrayList<TransferProduct> listarProductos() throws SQLException {
		
		ArrayList<TransferProduct> listaProductos = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaction transaccion = t.nuevaTransaccion();
		DAOProduct daoProd = DAOFactory.getInstance().generaDAOProducto();
		
		transaccion.start();
		
		try {
			listaProductos = daoProd.readAll();
		}
		catch (Exceptions e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return listaProductos;
	}

	@Override
	public TransferProduct topProducto() throws SQLException {
		
		TransferProduct p = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaction transaccion = t.nuevaTransaccion();
		DAOProduct daoProd = DAOFactory.getInstance().generaDAOProducto();
		
		transaccion.start();
		
		try {
			p = daoProd.productoMasVendido();
			if(p == null) {
				transaccion.rollback();
				throw new Exceptions("El transfer es null");
			}
		}
		catch (Exceptions e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return p;
	}

}
