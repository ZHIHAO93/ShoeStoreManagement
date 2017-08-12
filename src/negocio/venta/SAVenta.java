package negocio.venta;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SAVenta {
	public TransferVenta abrirVenta(int IDCliente) throws SQLException;
	public boolean devolucion(TransferLineaVenta lv) throws SQLException;
	public TransferVenta consultarUnaVenta(int IDVenta) throws SQLException;
	public ArrayList<TransferVenta> listarVentas() throws SQLException;
	public boolean cerrarVenta(TransferVenta v) throws SQLException;
	public TransferCarrito anadirProductoCarrito(TransferCarrito cr) throws SQLException;
	public TransferCarrito eliminarProductoCarrito(TransferCarrito cr) throws SQLException;
}
