package presentacion.comando.cliente;

import java.sql.SQLException;

import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class ConsultarUnCliente implements Comando{

	@Override
	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(FactorySA.getInstance().getSACliente().consultarUnCliente((Integer) datos));
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_UN_CLIENTE);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_CONSULTAR_UN_CLIENTE);
		}
		return cr;
	}
}
