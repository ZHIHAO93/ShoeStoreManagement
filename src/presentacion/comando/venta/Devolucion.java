package presentacion.comando.venta;

import java.sql.SQLException;

import negocio.serviciosAplicacion.FactorySA;
import negocio.venta.TransferLineaVenta;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class Devolucion implements Comando{

	@Override
	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(FactorySA.getInstance().getSAVenta().devolucion((TransferLineaVenta)datos));
			cr.setEvento(IDEventos.EVENTO_DEVOLUCION_VENTA);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_DEVOLUCION_VENTA);
		}
		return cr;
	}
}
