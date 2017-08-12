package presentacion.comando.cliente;

import java.sql.SQLException;

import negocio.cliente.TransferQuery;
import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class TopTenClientes implements Comando{

	@Override
	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(FactorySA.getInstance().getSACliente().topTenClientes((TransferQuery) datos));
			cr.setEvento(IDEventos.EVENTO_TOP_TEN_CLIENTES);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_TOP_TEN_CLIENTES);
		}
		return cr;
	}
}
