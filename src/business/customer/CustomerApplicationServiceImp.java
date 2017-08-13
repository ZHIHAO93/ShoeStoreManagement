package business.customer;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.customer.DAOCustomer;
import dao.factory.DAOFactory;
import dao.transations.connection.Exceptions;
import dao.transations.transactioManager.TransactionManager;
import dao.transations.transaction.Transaction;

/**
 * 客户应用服务接口的实现类
 * 
 * @author zhihao
 *
 */
public class CustomerApplicationServiceImp implements CustomerApplicationService {

	/**
	 * 事务管理对象
	 */
	TransactionManager tm;
	/**
	 * 事务对象
	 */
	Transaction transaction;
	/**
	 * 客户持久层对象
	 */
	DAOCustomer daoCustomer;

	/**
	 * 传递新客户的transfer对象来注册新客户
	 * 
	 * @param tc
	 *            新客户的数据传递对象
	 * @return correct true 表示成功，false 表示失败
	 */
	@Override
	public boolean registerCustomer(TransferCustomer tc) throws SQLException {

		boolean correct = false; // 创建操作是否成功的布尔值
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoCustomer = DAOFactory.getInstance().generaDAOCliente(); // 创建客户的DAO对象

		transaction.start();

		try {

			TransferCustomer cDao = daoCustomer.readByDNI(tc.getIdNumber()); // 从身份证查找新的客户

			if ((cDao != null)) { // 客户已经存在

				if (cDao.getEnable()) { // 活动客户， 抛出异常
					transaction.rollback();
					throw new Exceptions("这个身份证已经被使用！");
				} else { // 静止客户， 把状态改为活动中并提交
					tc.setIdCustomer(cDao.getIdCustomer());
					correct = daoCustomer.update(tc);
					transaction.commit();
				}
			} else if (tc.getName().equals("") || tc.getLastName().equals("")) { // 确认姓名不是空值
				transaction.rollback();
				throw new Exceptions("姓名不能为空");
			} else if (tc.getCreditLimit() > 0) {

				if (tc.getNewsletter()) {
					transaction.rollback();
					throw new Exceptions("Un Socio no puede tener Newsletter");
				} else {
					correct = daoCustomer.create(tc);
					transaction.commit();
				}
			} else { // 创建普通客户
				correct = daoCustomer.create(tc);
				transaction.commit();
			}
		} catch (Exceptions e) {
			transaction.rollback();
			throw e;
		} finally {
			tm.eliminaTransaccion(); // 删除事件对象
		}

		return correct;
	}

	/**
	 * 通过id禁用客户
	 * 
	 * @param idCustomer
	 *            客户的id
	 * @return correct true 表示成功，false 表示失败
	 */
	@Override
	public boolean inactiveCustomer(int idCustomer) throws SQLException {

		boolean correct = false; // 创建操作是否成功的布尔值
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoCustomer = DAOFactory.getInstance().generaDAOCliente(); // 创建客户的DAO对象

		transaction.start();

		try {
			TransferCustomer cDao = daoCustomer.readById_Cliente(idCustomer); // 从id查找客户， 返回一个TransferCustomer对象

			if (cDao == null) { // 未找到客户，抛出异常
				throw new Exceptions("该客户不存在");
			} else {
				if (cDao.getEnable()) { // 如果是活动客户，禁用客户并提交
					correct = daoCustomer.bajaCliente(idCustomer);
					transaction.commit();
				} else { // 否则报错
					transaction.rollback();
					throw new Exceptions("该客户已经被禁用");
				}
			}

		} catch (Exceptions e) {
			transaction.rollback();
			throw e;
		} finally {
			tm.eliminaTransaccion(); // 删除事件对象
		}

		return correct;

	}

	/**
	 * 传递一个transferCustomer对象来修改客户的资料
	 * 
	 * @param c
	 *            客户的数据传递对象
	 * @return correct true 表示成功，false 表示失败
	 */
	@Override
	public boolean modifyCustomer(TransferCustomer c) throws SQLException {

		boolean correct = false; // 创建操作是否成功的布尔值
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoCustomer = DAOFactory.getInstance().generaDAOCliente(); // 创建客户的DAO对象

		transaction.start();

		try {
			if (c == null) { // 检查数据传递对象是否为空值
				transaction.rollback();
				throw new Exceptions("客户的新数据出错");
			} else if ((daoCustomer.readById_Cliente(c.getIdCustomer()) == null)) { // 通过id查找客户
				transaction.rollback();
				throw new Exceptions("该客户不存在");
			} else if (c.getName().equals("") || c.getLastName().equals("")) {
				transaction.rollback();
				throw new Exceptions("请填写客户的姓名");
			} else if (c.getCreditLimit() > 0) {

				if (c.getNewsletter()) {
					transaction.rollback();
					throw new Exceptions("Un Socio no puede tener Newsletter");
				} else {
					correct = daoCustomer.update(c);
					transaction.commit();
				}
			} else {
				correct = daoCustomer.update(c);
				transaction.commit();
			}

		} catch (Exceptions e) {
			transaction.rollback();
			throw e;

		} finally {
			tm.eliminaTransaccion(); // 删除事件对象
		}

		return correct;
	}

	/**
	 * 通过id查询客户资料
	 * 
	 * @param idCustomer
	 *            客户id
	 * @return c 客户的数据传递对象
	 */
	@Override
	public TransferCustomer consultCustomer(int idCustomer) throws SQLException {

		TransferCustomer c = null; // 创建新的数据传递对象
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoCustomer = DAOFactory.getInstance().generaDAOCliente(); // 创建客户的DAO对象

		transaction.start();

		try {
			c = daoCustomer.readById_Cliente(idCustomer); // 通过id查找用户
		} catch (Exceptions e) {
			throw e;
		} finally {
			tm.eliminaTransaccion(); // 删除事件对象
		}

		return c;
	}

	/**
	 * 列举所有客户
	 * 
	 * @return customerList 所有客户的数据传递对象的ArrayList
	 */
	@Override
	public ArrayList<TransferCustomer> toListCustomer() throws SQLException {

		ArrayList<TransferCustomer> customerList = null; // 创建客户列表对象

		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoCustomer = DAOFactory.getInstance().generaDAOCliente(); // 创建客户的DAO对象

		transaction.start();

		try {
			customerList = daoCustomer.readAll(); // 获得所有用户资料
		} catch (Exceptions e) {
			throw e;
		} finally {
			tm.eliminaTransaccion(); // 删除事件对象
		}

		return customerList;
	}

	/**
	 * 列举在一个时间段和一定金额以上的十佳客户
	 * 
	 * @param topCustomer
	 *            数据传递对象
	 * 
	 * @return topCustomerList 十个客户数据传递的ArrayList对象
	 */
	@Override
	public ArrayList<TransferCustomer> topTenCustomers(TransferQuery topCustomer) throws SQLException {

		ArrayList<TransferCustomer> topCustomerList = null; // 创建十佳客户列表对象
		tm = TransactionManager.getInstance(); // 获得Transaction manager 的实例
		transaction = tm.nuevaTransaccion(); // 创建新的Transaction对象
		daoCustomer = DAOFactory.getInstance().generaDAOCliente(); // 创建客户的DAO对象

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 格式化时间格式
		Date fechaIni = null;
		Date fechaFin = null;

		try {
			fechaIni = format.parse(topCustomer.getStartDate());
			fechaFin = format.parse(topCustomer.getFinalDate());

		} catch (ParseException ex) {
			System.out.println(ex);
		}

		transaction.start();

		try {
			if (topCustomer.getNEuros() <= 0) {
				throw new Exceptions("金额不能为负数");
			} else if (!fechaIni.before(fechaFin)) {
				throw new Exceptions("开始时间不能在结束时间之后");
			} else {
				topCustomerList = daoCustomer.top10Clientes(topCustomer); // 获得十佳客户资料对象
				if (topCustomerList.isEmpty()) {
					transaction.rollback();
					throw new Exceptions("不存在十佳客户");
				}
			}
		} catch (Exceptions e) {
			throw e;
		} finally {
			tm.eliminaTransaccion(); // 删除事件对象
		}

		return topCustomerList;
	}

}
