package business.product;

import java.sql.SQLException;
import java.util.ArrayList;

import business.product.TransferProduct;

public interface ProductApplicationService {
	public boolean altaProducto(TransferProduct p) throws SQLException;
	public boolean bajaProducto(int IDProducto) throws SQLException;
	public boolean modificarProducto(TransferProduct p) throws SQLException;
	public TransferProduct consultarUnProducto(int IDProducto) throws SQLException;
	public ArrayList<TransferProduct> listarProductos() throws SQLException;
	public TransferProduct topProducto() throws SQLException;
}
