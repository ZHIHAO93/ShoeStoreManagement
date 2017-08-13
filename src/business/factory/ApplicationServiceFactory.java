package business.factory;

import business.customer.CustomerApplicationService;
import business.product.ProductApplicationService;
import business.sale.SaleApplicationService;

/**
 * 逻辑层应用服务工厂的抽象类
 * 
 * @author zhihao
 *
 */

public abstract class ApplicationServiceFactory 
{
	/**
	 * 应用服务工厂的实例常量对象
	 */
	private static ApplicationServiceFactory AS_FACTORY_INSTANCE;
	
	/**
	 * 创建一个应用服务工厂的继承类的实例对象
	 */
	private synchronized static void createASFactory()
	{
		if(AS_FACTORY_INSTANCE == null)
			AS_FACTORY_INSTANCE = new ApplicationServiceFactoryImp();
	}
	
	/**
	 * 获取应用服务工厂的实例
	 * @return AS_FACTORY_INSTANCE 应用服务工厂实例
	 */
	public static ApplicationServiceFactory getInstance()
	{
		createASFactory();
		return AS_FACTORY_INSTANCE;
	}
	
	public abstract CustomerApplicationService getCustomerAS();
	public abstract ProductApplicationService getProductAS();
	public abstract SaleApplicationService getSaleAS();	
}
