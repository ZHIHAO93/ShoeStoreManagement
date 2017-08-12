package presentacion.venta;

import presentacion.comando.IDEventos;

public class VentaGUIImp extends VentaGUI{

	private static PanelVenta pVenta;
	
	
	public void update(IDEventos evento_actual, Object datos) {
		
		switch (evento_actual) {

		case EVENTO_ABRIR_VENTA:
		case ERROR_EVENTO_ABRIR_VENTA:
			getPanelVenta().actualizarVentanaAbrirVenta(evento_actual, datos);
			break;
			
		case EVENTO_CERRAR_VENTA:
		case ERROR_EVENTO_CERRAR_VENTA:
			getPanelVenta().actualizarVentanaCerrarVenta(evento_actual, datos);
			break;
			
		case EVENTO_CONSULTAR_UNA_VENTA:
		case ERROR_EVENTO_CONSULTAR_UNA_VENTA:
			getPanelVenta().actualizarVentanaConsulta(evento_actual, datos);
			break;
			
		case EVENTO_LISTAR_VENTAS:
		case ERROR_EVENTO_LISTAR_VENTAS:
			getPanelVenta().actualizarVentanaListar(evento_actual, datos);
			break;
			
		case EVENTO_DEVOLUCION_VENTA:
		case ERROR_EVENTO_DEVOLUCION_VENTA:
			getPanelVenta().actualizarVentanaDevolucion(evento_actual, datos);
			break;
			
		case EVENTO_ANADIR_PRODUCTO_CARRITO:
		case ERROR_EVENTO_ANADIR_PRODUCTO_CARRITO:
			getPanelVenta().actualizarVentanaAnadirProductoCarrito(evento_actual, datos);
			break;
			
		case EVENTO_ELIMINAR_PRODUCTO_CARRITO:
		case ERROR_EVENTO_ELIMINAR_PRODUCTO_CARRITO:
			getPanelVenta().actualizarVentanaEliminarProductoCarrito(evento_actual, datos);
			break;
			
		default:
			break;

		}
		
	}

	public PanelVenta getPanelVenta() {
		
		if(pVenta == null)
			pVenta = new PanelVenta();
		
		return pVenta;
	}
}
