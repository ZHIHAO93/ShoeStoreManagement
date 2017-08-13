package business.product;

import java.sql.SQLException;
import java.util.ArrayList;

import business.product.TransferProduct;

/**
 * 产品的应用服务接口
 * 
 * @author zhihao
 *
 */

public interface ProductApplicationService {
	public boolean registerProduct(TransferProduct p) throws SQLException;
	public boolean inactiveProduct(int idProduct) throws SQLException;
	public boolean modifyProduct(TransferProduct p) throws SQLException;
	public TransferProduct consultProduct(int idProduct) throws SQLException;
	public ArrayList<TransferProduct> toListProduct() throws SQLException;
	public TransferProduct topProduct() throws SQLException;
}
