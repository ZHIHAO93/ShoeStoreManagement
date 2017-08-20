package presentacion.comando.venta;

import java.sql.SQLException;

import business.factory.ApplicationServiceFactory;
import business.sale.TransferSale;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;

public class CerrarVenta implements Comando{

	@Override
	public CommandResponse ejecutar(Object datos) {
		
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(ApplicationServiceFactory.getInstance().getSaleAS().toCloseSale((TransferSale)datos));
			cr.setEvento(IDEventos.EVENTO_CERRAR_VENTA);
		}
		catch (SQLException e) {
			cr.setDatos(e);
			cr.setEvento(IDEventos.ERROR_EVENTO_CERRAR_VENTA);
		}
		return cr;
	}
}
