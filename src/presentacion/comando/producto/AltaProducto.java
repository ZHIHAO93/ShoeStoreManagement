package presentacion.comando.producto;

import java.sql.SQLException;

import business.factory.ApplicationServiceFactory;
import business.product.TransferProduct;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;


public class AltaProducto implements Comando{

	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(ApplicationServiceFactory.getInstance().getProductAS().altaProducto((TransferProduct)datos));
			cr.setEvento(IDEventos.EVENTO_ALTA_PRODUCTO);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_ALTA_PRODUCTO);
		}
		return cr;
	}
}
