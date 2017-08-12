package dao.factory;

import dao.customer.DAOCustomer;
import dao.product.DAOProduct;
import dao.sale.DAOSale;


public abstract class DAOFactory {
	
	private static DAOFactory instancia;
	
	private static synchronized void createFactoriaDAO() {
		
		if (instancia == null) {
			instancia = new DAOFactoryImp();
		}
	}
	
	public static DAOFactory getInstance(){

		createFactoriaDAO();

		return instancia;
	}
	
	public abstract DAOCustomer generaDAOCliente();
	
	public abstract DAOSale generaDAOVenta();
	
	public abstract DAOProduct generaDAOProducto();
	
}
