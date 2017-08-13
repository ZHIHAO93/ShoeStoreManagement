package business.factory;

import business.customer.CustomerApplicationService;
import business.customer.CustomerApplicationServiceImp;
import business.product.ProductApplicationService;
import business.product.ProductApplicationServiceImp;
import business.sale.SaleApplicationService;
import business.sale.SaleApplicationServiceImp;

/**
 * 逻辑层应用服务工厂的继承类<br>
 * 实现ApplicationServiceFactory的方法
 * 
 * @author zhihao
 *
 */

public class ApplicationServiceFactoryImp extends ApplicationServiceFactory {

	/**
	 * 获取客户应用服务接口的实现类
	 */
	@Override
	public CustomerApplicationService getCustomerAS() {
		return new CustomerApplicationServiceImp();
	}

	/**
	 * 获取销售应用服务接口的实现类
	 */
	@Override
	public SaleApplicationService getSaleAS() {
		return new SaleApplicationServiceImp();
	}

	/**
	 * 获取产平应用服务接口的实现类
	 */
	@Override
	public ProductApplicationService getProductAS() {
		return new ProductApplicationServiceImp();
	}

}
