package presentacion.comando.producto;

import java.sql.SQLException;

import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class BajaProducto implements Comando{

	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(FactorySA.getInstance().getSAProducto().bajaProducto((Integer)datos));
			cr.setEvento(IDEventos.EVENTO_BAJA_PRODUCTO);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_BAJA_PRODUCTO);
		}
		return cr;
	}
}
