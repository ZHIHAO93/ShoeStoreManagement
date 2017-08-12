package integracion.producto;

import java.sql.SQLException;
import java.util.ArrayList;

import negocio.producto.TransferProducto;

public interface DAOProducto {
	public boolean create(TransferProducto t) throws SQLException;
	public boolean bajaProducto(int IDProducto) throws SQLException;
	public boolean update(TransferProducto t) throws SQLException;
	public TransferProducto readById_Producto(int IDProducto) throws SQLException;
	public TransferProducto readByName(String marca, String tipo, String color) throws SQLException;
	public ArrayList<TransferProducto> readAll() throws SQLException;
	public TransferProducto productoMasVendido() throws SQLException;
}
