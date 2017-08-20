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

/**
 * 销售应用服务接口的实现类
 * 
 * @author zhihao
 *
 */
public class SaleApplicationServiceImp implements SaleApplicationService {

	/**
	 * 事务管理对象
	 */
	TransactionManager tm;
	/**
	 * 事务对象
	 */
	Transaction transaction;
	/**
	 * 销售持久层对象
	 */
	DAOSale daoSale;
	/**
	 * 客户持久层对象
	 */
	DAOCustomer daoCustomer;
	/**
	 * 产品持久层对象
	 */
	DAOProduct daoProduct;

	/**
	 * 传递客户的id来开启新的销售
	 * 
	 * @param idCustomer
	 *            客户的id
	 * 
	 * @return v 销售传递对象
	 */
	@Override
	public TransferSale openSale(int idCustomer) throws SQLException {

		TransferSale v = new TransferSale(); // 创建新的销售传递对象
		HashMap<Integer, TransferLifeLine> cart = new HashMap<Integer, TransferLifeLine>(); // 创建购物车
		v.setCart(cart); // 把购物车放入销售传递对象
		v.setIDCliente(idCustomer); // 设置用户id

		return v;
	}

	/**
	 * 用过生命线传递对象退还产品
	 * 
	 * @param ll
	 *            产品生命线传递对象
	 * 
	 * @return correct true 表示成功， false 表示失败
	 */
	@Override
	public boolean refund(TransferLifeLine ll) throws SQLException {

		boolean correct = false; // 创建操所是否成功的布尔值
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoSale = DAOFactory.getInstance().generaDAOVenta(); // 创建销售的DAO对象
		daoProduct = DAOFactory.getInstance().generaDAOProducto(); // 创建产品的DAO对象

		transaction.start();

		// 使用销售DAO通过销售id和产品id查找
		TransferLifeLine daoLl = daoSale.consultarLineaVenta(ll.getIDSale(), ll.getIDProduct());
		// 使用产品DAO通过产品id查找
		TransferProduct p = daoProduct.readById_Producto(ll.getIDProduct());
		// 使用销售DAO通过销售id查找
		TransferSale v = daoSale.readById_Venta(ll.getIDSale());

		try {
			if (ll == null || v == null) { // 生命线对象空 或者不存在这个销售
				transaction.rollback();
				throw new Exceptions("产品不存在");
			} else if (ll.getQuantity() > daoLl.getQuantity()) { // 退还产品数量大于购买数量
				transaction.rollback();
				throw new Exceptions("退还产品数量大于购买数量");
			} else {
				// 产品库存增加退还产品的数量
				p.setStock(p.getStock() + ll.getQuantity());
				// 退还金额
				float devuelto = daoLl.getPrice() * ll.getQuantity();
				// 设置销售的新金额
				v.setTotalVenta(v.getTotalSale() - devuelto);

				// 生命线金额减去退还的产品的数量
				daoLl.setCantidad(daoLl.getQuantity() - ll.getQuantity());

				correct = daoSale.devolucion(daoLl, p, v);
				transaction.commit();
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
	 * 通过id查找销售资料
	 * 
	 * @param idSale
	 *            销售id
	 * 
	 * @return s 销售的数据传输对象
	 */
	@Override
	public TransferSale consultSale(int idSale) throws SQLException {

		TransferSale s = null;
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoSale = DAOFactory.getInstance().generaDAOVenta(); // 创建销售的DAO对象

		transaction.start();

		try {
			s = daoSale.readById_Venta(idSale); // 通过id查找销售
		} catch (Exceptions e) {
			throw e;
		} finally {
			tm.removeTransaction(); // 删除事务对象
		}

		return s;
	}

	/**
	 * 列举所有销售
	 * 
	 * @return saleList 所有销售的数据传递对象的ArrayList
	 */
	@Override
	public ArrayList<TransferSale> toListSale() throws SQLException {

		ArrayList<TransferSale> saleList = null;
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoSale = DAOFactory.getInstance().generaDAOVenta(); // 創建銷售的DAO對象

		transaction.start();

		try {
			saleList = daoSale.readAll(); // 获得所有销售资料
		} catch (Exceptions e) {
			throw e;
		} finally {
			tm.removeTransaction(); // 删除事务对象
		}

		return saleList;
	}

	/**
	 * 结算销售
	 * 
	 * @param v
	 *            销售数据传递对象
	 * 
	 * @return correct true 成功， false 失败
	 */
	@Override
	public boolean toCloseSale(TransferSale v) throws SQLException {

		boolean correct = false;
		float auxTotalVenta = 0;
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		// 创建DAO对象
		daoSale = DAOFactory.getInstance().generaDAOVenta();
		daoCustomer = DAOFactory.getInstance().generaDAOCliente();
		daoProduct = DAOFactory.getInstance().generaDAOProducto();

		transaction.start();

		try {

			if (v == null) {
				transaction.rollback();
				throw new Exceptions("销售对象为空");
			}
			// 客户存在并且处于活动中
			else if ((daoCustomer.readById_Cliente(v.getIDCustomer()) != null)
					&& (daoCustomer.readById_Cliente(v.getIDCustomer())).getEnable()) {

				// 确认不是空购物车
				if (!v.getCart().isEmpty()) {
					// 迭代代表购物车的hashmap，获取所有产品id
					Iterator<Entry<Integer, TransferLifeLine>> it = v.getCart().entrySet().iterator();
					while (it.hasNext()) {
						Entry<Integer, TransferLifeLine> e = it.next();

						if (v.getCart().containsKey(e.getKey())) {
							// 产品存在与数据库中并在线
							TransferProduct p = daoProduct.readById_Producto(e.getKey());
							if (p != null && p.getEnable()) {
								// 确认产品库存大于购买数量
								if (p.getStock() >= v.getCart().get(e.getKey()).getQuantity()) {

									// 把产品价格放入代表每个产品的生命线对象中
									v.getCart().get(e.getKey()).setPrice(p.getPrice());

									// 增加总金额
									auxTotalVenta += v.getCart().get(e.getKey()).getQuantity() * p.getPrice();

									// 更新新的库存数量
									p.setStock(p.getStock() - v.getCart().get(e.getKey()).getQuantity());

									daoProduct.update(p);
								} else {
									transaction.rollback();
									throw new Exceptions("库存不足");
								}
							} else {
								transaction.rollback();
								throw new Exceptions("产品不存在或已下架");
							}
						} else {
							transaction.rollback();
							throw new Exceptions("产品不存在于生命线");
						}
					}
					// 更新总金额
					v.setTotalVenta(auxTotalVenta);

					// 输入时间
					java.util.Date date = new Date();
					java.sql.Date fecha = new java.sql.Date(date.getTime());
					v.setFecha(fecha);

					correct = daoSale.cerrarVenta(v);
					transaction.commit();
				} else {
					transaction.rollback();
					throw new Exceptions("购物车为空");
				}
			} else {
				transaction.rollback();
				throw new Exceptions("不存在该用户");

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
	 * 添加产品到购物车
	 * 
	 * @param cr
	 *            购物车数据传递对象
	 * 
	 * @return cr 更新后的购物车数据传递对象
	 */
	@Override
	public TransferCart addProductToCart(TransferCart cr) throws SQLException {

		TransferLifeLine lv = null;

		// 如果产品已经存在于购物车，增加数量
		if (cr.getCarrito().containsKey(cr.getIDProduct())) {

			lv = cr.getCarrito().get(cr.getIDProduct());
			lv.setCantidad(lv.getQuantity() + cr.getQuantity());
			cr.setCantidad(lv.getQuantity());
			cr.getCarrito().remove(cr.getIDProduct());
		}
		// 否则，加入该产品到购物车
		else {
			lv = new TransferLifeLine();
			lv.setCantidad(cr.getQuantity());
			lv.setIDProducto(cr.getIDProduct());
		}
		// Anadir la linea de venta al carrito y el precio
		// lv.setPrecio(p.getPrecio());

		cr.getCarrito().put(cr.getIDProduct(), lv);

		return cr;
	}

	/**
	 * 从购物车中移除产品
	 * 
	 * @param cr 购物车数据传递对象
	 * 
	 * @return cr 更新后的购物车数据传递对象
	 */
	@Override
	public TransferCart removeProductFromCart(TransferCart cr) throws SQLException {

		TransferLifeLine lv = null;
		try {
			// 如果产品存在于购物车中
			if (cr.getCarrito().containsKey(cr.getIDProduct())) {
				lv = cr.getCarrito().get(cr.getIDProduct());
				// 如果需要移除的产品数量大于购物车中的产品数量， 移除产品
				if (cr.getQuantity() >= lv.getQuantity()) {
					cr.getCarrito().remove(cr.getIDProduct());
				}
				// 否则，移除相应数量的产品
				else {
					lv.setCantidad(lv.getQuantity() - cr.getQuantity());
					cr.getCarrito().get(cr.getIDProduct()).setCantidad(lv.getQuantity());
				}
			} else {
				throw new Exceptions("产品不存在于购物车中");
			}
		} catch (Exceptions e) {
			throw e;
		}
		return cr;
	}

}
