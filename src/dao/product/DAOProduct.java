package dao.product;

import java.sql.SQLException;
import java.util.ArrayList;

import business.product.TransferProduct;

public interface DAOProduct {
	public boolean create(TransferProduct t) throws SQLException;
	public boolean bajaProducto(int IDProducto) throws SQLException;
	public boolean update(TransferProduct t) throws SQLException;
	public TransferProduct readById_Producto(int IDProducto) throws SQLException;
	public TransferProduct readByName(String marca, String tipo, String color) throws SQLException;
	public ArrayList<TransferProduct> readAll() throws SQLException;
	public TransferProduct productoMasVendido() throws SQLException;
}
