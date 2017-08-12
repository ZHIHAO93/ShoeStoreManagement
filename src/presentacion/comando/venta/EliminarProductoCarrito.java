package presentacion.comando.venta;

import java.sql.SQLException;

import negocio.serviciosAplicacion.FactorySA;
import negocio.venta.TransferCarrito;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class EliminarProductoCarrito implements Comando{

	@Override
	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(FactorySA.getInstance().getSAVenta().eliminarProductoCarrito((TransferCarrito) datos));
			cr.setEvento(IDEventos.EVENTO_ELIMINAR_PRODUCTO_CARRITO);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_ELIMINAR_PRODUCTO_CARRITO);
		}
		return cr;
	}
}
