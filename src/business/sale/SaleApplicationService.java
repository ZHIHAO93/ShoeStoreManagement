package business.sale;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 销售的应用服务接口
 * 
 * @author zhihao
 *
 */
public interface SaleApplicationService {
	public TransferSale openSale(int idClient) throws SQLException;
	public boolean refund(TransferLifeLine ll) throws SQLException;
	public TransferSale consultSale(int idSale) throws SQLException;
	public ArrayList<TransferSale> toListSale() throws SQLException;
	public boolean toCloseSale(TransferSale s) throws SQLException;
	public TransferCart addProductToCart(TransferCart c) throws SQLException;
	public TransferCart removeProductFromCart(TransferCart c) throws SQLException;
}
