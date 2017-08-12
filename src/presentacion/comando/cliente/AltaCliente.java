package presentacion.comando.cliente;

import java.sql.SQLException;

import negocio.cliente.TransferCliente;
import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class AltaCliente implements Comando{

	@Override
	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(FactorySA.getInstance().getSACliente().altaCliente((TransferCliente) datos));
			cr.setEvento(IDEventos.EVENTO_ALTA_CLIENTE);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_ALTA_CLIENTE);
		}
		return cr;
	}
}
