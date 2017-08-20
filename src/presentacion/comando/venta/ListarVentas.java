package presentacion.comando.venta;

import java.sql.SQLException;

import business.factory.ApplicationServiceFactory;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class ListarVentas implements Comando{

	@Override
	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(ApplicationServiceFactory.getInstance().getSaleAS().toListSale());
			cr.setEvento(IDEventos.EVENTO_LISTAR_VENTAS);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_LISTAR_VENTAS);
		}
		return cr;
	}
}
