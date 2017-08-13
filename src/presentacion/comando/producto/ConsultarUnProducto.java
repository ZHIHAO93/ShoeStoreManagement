package presentacion.comando.producto;

import java.sql.SQLException;

import business.factory.ApplicationServiceFactory;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;



public class ConsultarUnProducto implements Comando{

	public CommandResponse ejecutar(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(ApplicationServiceFactory.getInstance().getProductAS().consultarUnProducto((Integer)datos));
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_UN_PRODUCTO);

		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_EVENTO_CONSULTAR_UN_PRODUCTO);
		} 

		return cr;
	}
}
