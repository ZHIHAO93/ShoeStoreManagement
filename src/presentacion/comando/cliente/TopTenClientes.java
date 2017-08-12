package presentacion.comando.cliente;

import java.sql.SQLException;

import business.customer.TransferQuery;
import business.factory.ApplicationServiceFactory;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class TopTenClientes implements Comando{

	@Override
	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(ApplicationServiceFactory.getInstance().getSACliente().topTenCustomers((TransferQuery) datos));
			cr.setEvento(IDEventos.EVENTO_TOP_TEN_CLIENTES);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_TOP_TEN_CLIENTES);
		}
		return cr;
	}
}
