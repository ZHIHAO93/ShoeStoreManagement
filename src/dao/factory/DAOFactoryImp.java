package dao.factory;

import dao.customer.DAOCustomer;
import dao.customer.DAOCustomerImp;
import dao.product.DAOProduct;
import dao.product.DAOProductImp;
import dao.sale.DAOSale;
import dao.sale.DAOSaleImp;


public class DAOFactoryImp extends DAOFactory{

	public DAOCustomer generaDAOCliente(){
		return new DAOCustomerImp();
	}
	
	@Override
	public DAOSale generaDAOVenta() {
		return new DAOSaleImp();
	}

	@Override
	public DAOProduct generaDAOProducto() {
		return new DAOProductImp();
	}

}
