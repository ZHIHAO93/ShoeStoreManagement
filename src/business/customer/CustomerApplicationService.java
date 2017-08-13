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
	public boolean registerCustomer(TransferCustomer tc) throws SQLException;
	public boolean inactiveCustomer(int idCustomer) throws SQLException;
	public boolean modifyCustomer(TransferCustomer tc) throws SQLException;
	public TransferCustomer consultCustomer(int idCustomer) throws SQLException;
	public ArrayList<TransferCustomer> toListCustomer() throws SQLException;
	public ArrayList<TransferCustomer> topTenCustomers(TransferQuery topCustomer) throws SQLException;
}