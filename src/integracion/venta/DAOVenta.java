package integracion.venta;

import java.sql.SQLException;
import java.util.ArrayList;

import negocio.producto.TransferProducto;
import negocio.venta.TransferLineaVenta;
import negocio.venta.TransferVenta;

public interface DAOVenta { 
	public boolean devolucion(TransferLineaVenta lv, TransferProducto p, TransferVenta v) throws SQLException;
	public TransferVenta readById_Venta(int IDVenta) throws SQLException;
	public TransferLineaVenta consultarLineaVenta(int IDVenta, int IDProducto) throws SQLException;
	public ArrayList<TransferVenta> readAll() throws SQLException;
	public boolean cerrarVenta(TransferVenta v) throws SQLException;
}
