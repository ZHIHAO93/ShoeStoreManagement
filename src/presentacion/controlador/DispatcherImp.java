package presentacion.controlador;

import presentacion.cliente.ClienteGUI;
import presentacion.comando.IDEventos;
import presentacion.comando.factoriaComando.CommandResponse;
import presentacion.producto.ProductoGUI;
import presentacion.venta.VentaGUI;


public class DispatcherImp extends Dispatcher {
	
	
	public void redirect(CommandResponse respuestacomando) {

		IDEventos eventoActual = respuestacomando.getEvento();
		Object datos = respuestacomando.getDatos();

		//Cliente
		if (eventoActual == IDEventos.EVENTO_ALTA_CLIENTE
				|| eventoActual == IDEventos.EVENTO_BAJA_CLIENTE
				|| eventoActual == IDEventos.EVENTO_CONSULTAR_UN_CLIENTE
				|| eventoActual == IDEventos.EVENTO_LISTAR_CLIENTES
				|| eventoActual == IDEventos.EVENTO_MODIFICAR_CLIENTE
				|| eventoActual == IDEventos.EVENTO_TOP_TEN_CLIENTES
				|| eventoActual == IDEventos.ERROR_EVENTO_ALTA_CLIENTE
				|| eventoActual == IDEventos.ERROR_EVENTO_BAJA_CLIENTE
				|| eventoActual == IDEventos.ERROR_EVENTO_CONSULTAR_UN_CLIENTE
				|| eventoActual == IDEventos.ERROR_EVENTO_LISTAR_CLIENTES
				|| eventoActual == IDEventos.ERROR_EVENTO_MODIFICAR_CLIENTE
				|| eventoActual == IDEventos.ERROR_EVENTO_TOP_TEN_CLIENTES) {
			
			ClienteGUI.getInstance().update(eventoActual, datos);
		}
		//Producto
		else if(eventoActual == IDEventos.EVENTO_ALTA_PRODUCTO
			    || eventoActual == IDEventos.EVENTO_BAJA_PRODUCTO
			    || eventoActual == IDEventos.EVENTO_CONSULTAR_UN_PRODUCTO
			    || eventoActual == IDEventos.EVENTO_LISTAR_PRODUCTOS
			    || eventoActual == IDEventos.EVENTO_MODIFICAR_PRODUCTO
			    || eventoActual == IDEventos.EVENTO_TOP_PRODUCTO
				|| eventoActual == IDEventos.ERROR_EVENTO_ALTA_PRODUCTO
			    || eventoActual == IDEventos.ERROR_EVENTO_BAJA_PRODUCTO
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTAR_UN_PRODUCTO
			    || eventoActual == IDEventos.ERROR_EVENTO_LISTAR_PRODUCTOS
	    		|| eventoActual == IDEventos.ERROR_EVENTO_MODIFICAR_PRODUCTO
	    		|| eventoActual == IDEventos.ERROR_EVENTO_TOP_PRODUCTO) {
			
			ProductoGUI.getInstance().update(eventoActual, datos);
		}
		//Venta
		else if(eventoActual == IDEventos.EVENTO_ABRIR_VENTA
			    || eventoActual == IDEventos.EVENTO_CERRAR_VENTA
			    || eventoActual == IDEventos.EVENTO_CONSULTAR_UNA_VENTA
			    || eventoActual == IDEventos.EVENTO_LISTAR_VENTAS
			    || eventoActual == IDEventos.EVENTO_DEVOLUCION_VENTA
			    || eventoActual == IDEventos.EVENTO_ANADIR_PRODUCTO_CARRITO
			    || eventoActual == IDEventos.EVENTO_ELIMINAR_PRODUCTO_CARRITO
				|| eventoActual == IDEventos.ERROR_EVENTO_ABRIR_VENTA
				|| eventoActual == IDEventos.ERROR_EVENTO_CERRAR_VENTA
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTAR_UNA_VENTA
			    || eventoActual == IDEventos.ERROR_EVENTO_LISTAR_VENTAS
			    || eventoActual == IDEventos.ERROR_EVENTO_DEVOLUCION_VENTA
			    || eventoActual == IDEventos.ERROR_EVENTO_ANADIR_PRODUCTO_CARRITO
			    || eventoActual == IDEventos.ERROR_EVENTO_ELIMINAR_PRODUCTO_CARRITO) {
			
			VentaGUI.getInstance().update(eventoActual, datos);
		}
	}
}