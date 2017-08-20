package business.product;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.factory.DAOFactory;
import dao.product.DAOProduct;
import dao.transations.connection.Exceptions;
import dao.transations.transactioManager.TransactionManager;
import dao.transations.transaction.Transaction;

/**
 * 产品应用服务接口的实现类
 * 
 * @author zhihao
 *
 */

public class ProductApplicationServiceImp implements ProductApplicationService {

	/**
	 * 事务管理对象
	 */
	TransactionManager tm;
	/**
	 * 事务对象
	 */
	Transaction transaction;
	/**
	 * 产品持久层对象
	 */
	DAOProduct daoProduct;

	/**
	 * 传递新产品的transfer对象来发布新产品
	 * 
	 * @param tp
	 *            新产品的数据传递对象
	 * 
	 * @return correct true 表示成功，false 表示失败
	 */
	@Override
	public boolean registerProduct(TransferProduct tp) throws SQLException {

		boolean correct = false; // 创建操作是否成功的布尔值
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoProduct = DAOFactory.getInstance().generaDAOProducto(); // 创建产品的DAO对象

		transaction.start();

		try {
			TransferProduct pDao = daoProduct.readByName(tp.getBrand(), tp.getType(), tp.getColor()); // 从品牌、类型和颜色查找新的产品

			if (pDao != null) { // 产品已经存在
				if (pDao.getEnable()) { // 产品已上线， 抛出异常
					transaction.rollback();
					throw new Exceptions("这个产品已经存在");
				} else { // 下架产品，把状态改为已上线并提交
					tp.setIDProduct(pDao.getIDProduct());
					correct = daoProduct.update(tp);
					transaction.commit();
				}
			} else if (tp.getType().equals("") || tp.getBrand().equals("") || tp.getColor().equals("")) { // 确认品牌、类型和颜色不是空值
				transaction.rollback();
				throw new Exceptions("请输入品牌、类型和颜色");
			} else if (tp.getStock() < 0 || tp.getStock() > 999) { // 确认库存量的值处于0和999之间
				transaction.rollback();
				throw new Exceptions("库存量必须在1-999之间");
			} else if (tp.getPrice() < 0) { // 确认价格不是负数
				transaction.rollback();
				throw new Exceptions("价格不能是负数");
			} else { // 发布新产品，提交
				correct = daoProduct.create(tp);
				transaction.commit();
			}

		} catch (Exceptions e) {
			transaction.rollback();
			throw e;
		} finally {
			tm.removeTransaction(); // 删除事件对象
		}

		return correct;
	}

	/**
	 * 通过id下架产品
	 * 
	 * @param idProduct
	 *            产品的id
	 * 
	 * @return correct true 表示成功，false 表示失败
	 */
	@Override
	public boolean inactiveProduct(int idProduct) throws SQLException {

		boolean correct = false; // 创建操作是否成功的布尔值
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoProduct = DAOFactory.getInstance().generaDAOProducto(); // 创建产品的DAO对象

		transaction.start();

		try {
			TransferProduct pDao = daoProduct.readById_Producto(idProduct); // 从id查找产品，返回一个TransferProduct对象
			if (pDao == null) {
				throw new Exceptions("该产品不存在");
			} else {
				if (pDao.getEnable()) { // 如果产品已上线，下架产品并提交
					correct = daoProduct.bajaProducto(idProduct);
					transaction.commit();
				} else { // 否则报错
					transaction.rollback();
					throw new Exceptions("该产品已经下架");
				}
			}

		} catch (Exceptions e) {
			transaction.rollback();
			throw e;
		} finally {
			tm.removeTransaction(); // 删除事务对象
		}

		return correct;
	}

	/**
	 * 传递一个transferProduct对象来修改产品的资料
	 * 
	 * @param tp
	 */
	@Override
	public boolean modifyProduct(TransferProduct tp) throws SQLException {

		boolean correct = false; // 创建操作是否成功的布尔值
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoProduct = DAOFactory.getInstance().generaDAOProducto(); // 创建产品的DAO对象

		transaction.start();

		try {
			if (tp == null) { // 检查数据传递对象是否为空值
				transaction.rollback();
				throw new Exceptions("产品的新数据出错");
			} else if ((daoProduct.readById_Producto(tp.getIDProduct()) == null)) { // 通过id查找产品
				transaction.rollback();
				throw new Exceptions("该产品不存在");
			} else if (tp.getBrand().equals("") || tp.getType().equals("") || tp.getColor().equals("")) {
				transaction.rollback();
				throw new Exceptions("请输入品牌、类型和颜色");
			} else if (tp.getStock() < 0 || tp.getStock() > 999) {
				transaction.rollback();
				throw new Exceptions("库存量必须在1-999之间");
			} else if (tp.getPrice() < 0) {
				transaction.rollback();
				throw new Exceptions("价格不能是负数");
			} else {
				correct = daoProduct.update(tp);
				transaction.commit();
			}

		} catch (Exceptions e) {
			transaction.rollback();
			System.err.println(e.getMensaje());
			throw e;

		} finally {
			tm.removeTransaction(); // 删除事件对象
		}

		return correct;
	}

	/**
	 * 通过id查询产品资料
	 * 
	 * @param idProduct
	 *            产品id
	 * 
	 * @return p 产品的数据传输对象
	 */
	@Override
	public TransferProduct consultProduct(int idProduct) throws SQLException { // Duda*

		TransferProduct p = null;
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoProduct = DAOFactory.getInstance().generaDAOProducto(); // 创建产品的DAO对象

		transaction.start();

		try {
			p = daoProduct.readById_Producto(idProduct); // 通过id查找产品
		} catch (Exceptions e) {
			throw e;
		} finally {
			tm.removeTransaction(); // 删除事务对象
		}

		return p;
	}

	/**
	 * 列举所有产品
	 * 
	 * @return productList 所有产品的数据传递对象的ArrayList
	 */
	@Override
	public ArrayList<TransferProduct> toListProduct() throws SQLException {

		ArrayList<TransferProduct> productList = null; // 创建产品列表对象
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoProduct = DAOFactory.getInstance().generaDAOProducto(); // 创建产品的DAO对象

		transaction.start();

		try {
			productList = daoProduct.readAll(); // 获得所有产品资料
		} catch (Exceptions e) {
			throw e;
		} finally {
			tm.removeTransaction(); // 删除事务对象
		}

		return productList;
	}

	/**
	 * 列举最佳产品
	 * 
	 * @return p 最佳产品的数据传输对象
	 */
	@Override
	public TransferProduct topProduct() throws SQLException {

		TransferProduct p = null; // 创建最佳产品的数据传输对象
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoProduct = DAOFactory.getInstance().generaDAOProducto(); // 创建产品的DAO对象

		transaction.start();

		try {
			p = daoProduct.bestSellerProduct(); // 查询最佳产品
			if (p == null) {
				transaction.rollback();
				throw new Exceptions("最佳产品不存在");
			}
		} catch (Exceptions e) {
			throw e;
		} finally {
			tm.removeTransaction(); // 删除事件对象
		}

		return p;
	}

}
