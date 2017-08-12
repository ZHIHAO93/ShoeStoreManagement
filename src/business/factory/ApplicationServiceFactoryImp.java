package business.factory;

import business.customer.CustomerApplicationService;
import business.customer.CustomerApplicationServiceImp;
import business.product.ProductApplicationService;
import business.product.ProductApplicationServiceImp;
import business.sale.SaleApplicationService;
import business.sale.SaleApplicationServiceImp;


public class ApplicationServiceFactoryImp extends ApplicationServiceFactory {

	@Override
	public CustomerApplicationService getSACliente() {
		return new CustomerApplicationServiceImp();
	}

	@Override
	public SaleApplicationService getSAVenta() {
		return new SaleApplicationServiceImp();
	}

	@Override
	public ProductApplicationService getSAProducto() {
		return new ProductApplicationServiceImp();
	}

}
