package business.factory;

import business.customer.CustomerApplicationService;
import business.product.ProductApplicationService;
import business.sale.SaleApplicationService;


public abstract class ApplicationServiceFactory 
{
	private static ApplicationServiceFactory factorySAInstance;
	
	private synchronized static void createFactorySA()
	{
		if(factorySAInstance == null)
			factorySAInstance = new ApplicationServiceFactoryImp();
	}
	
	public static ApplicationServiceFactory getInstance()
	{
		createFactorySA();
		return factorySAInstance;
	}
	
	public abstract CustomerApplicationService getSACliente();
	public abstract ProductApplicationService getSAProducto();
	public abstract SaleApplicationService getSAVenta();	
}
