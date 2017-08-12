package presentacion.comando.producto;

import java.sql.SQLException;

import negocio.producto.TransferProducto;
import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class ModificarProducto implements Comando{

	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(FactorySA.getInstance().getSAProducto().modificarProducto((TransferProducto)datos));
			cr.setEvento(IDEventos.EVENTO_MODIFICAR_PRODUCTO);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_MODIFICAR_PRODUCTO);
		}
		return cr;
	}
}
