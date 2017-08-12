package business.customer;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * 客户的应用服务接口
 * 
 * @author zhihao
 *
 */

public interface CustomerApplicationService {
	public boolean registerCustomer(TransferCustomer c) throws SQLException;
	public boolean inactiveCustomer(int idCustomer) throws SQLException;
	public boolean modifyCustomer(TransferCustomer c) throws SQLException;
	public TransferCustomer consultCustomer(int idCustomer) throws SQLException;
	public ArrayList<TransferCustomer> toListCustomer() throws SQLException;
	public ArrayList<TransferCustomer> topTenCustomers(TransferQuery topCustomer) throws SQLException;
}