package presentacion.comando.cliente;

import java.sql.SQLException;

import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class ListarClientes implements Comando{

	@Override
	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(FactorySA.getInstance().getSACliente().listarClientes());
			cr.setEvento(IDEventos.EVENTO_LISTAR_CLIENTES);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_LISTAR_CLIENTES);
		}
		return cr;
	}
}
