package presentacion.comando.producto;

import java.sql.SQLException;

import business.factory.ApplicationServiceFactory;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class TopProducto implements Comando{

	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(ApplicationServiceFactory.getInstance().getProductAS().topProducto());
			cr.setEvento(IDEventos.EVENTO_TOP_PRODUCTO);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_TOP_PRODUCTO);
		}
		return cr;
	}
}
