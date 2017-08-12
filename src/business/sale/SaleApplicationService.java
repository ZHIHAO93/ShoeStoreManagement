package business.sale;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SaleApplicationService {
	public TransferSale abrirVenta(int IDCliente) throws SQLException;
	public boolean devolucion(TransferLifeLine lv) throws SQLException;
	public TransferSale consultarUnaVenta(int IDVenta) throws SQLException;
	public ArrayList<TransferSale> listarVentas() throws SQLException;
	public boolean cerrarVenta(TransferSale v) throws SQLException;
	public TransferCart anadirProductoCarrito(TransferCart cr) throws SQLException;
	public TransferCart eliminarProductoCarrito(TransferCart cr) throws SQLException;
}
