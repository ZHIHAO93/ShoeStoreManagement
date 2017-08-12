package dao.sale;

import java.sql.SQLException;
import java.util.ArrayList;

import business.product.TransferProduct;
import business.sale.TransferLifeLine;
import business.sale.TransferSale;

public interface DAOSale { 
	public boolean devolucion(TransferLifeLine lv, TransferProduct p, TransferSale v) throws SQLException;
	public TransferSale readById_Venta(int IDVenta) throws SQLException;
	public TransferLifeLine consultarLineaVenta(int IDVenta, int IDProducto) throws SQLException;
	public ArrayList<TransferSale> readAll() throws SQLException;
	public boolean cerrarVenta(TransferSale v) throws SQLException;
}
