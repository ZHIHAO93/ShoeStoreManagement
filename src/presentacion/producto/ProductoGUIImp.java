package presentacion.producto;

import presentacion.comando.IDEventos;

public class ProductoGUIImp extends ProductoGUI{

	private static PanelProducto pProducto;
	
	
	public void update(IDEventos evento_actual, Object datos) {
		
		switch (evento_actual) {

		case EVENTO_ALTA_PRODUCTO:
		case ERROR_EVENTO_ALTA_PRODUCTO:
			getPanelProducto().actualizarVentanaAlta(evento_actual, datos);
			break;
			
		case EVENTO_BAJA_PRODUCTO:
		case ERROR_EVENTO_BAJA_PRODUCTO:
			getPanelProducto().actualizarVentanaBorra(evento_actual, datos);
			break;
			
		case EVENTO_CONSULTAR_UN_PRODUCTO:
		case ERROR_EVENTO_CONSULTAR_UN_PRODUCTO:
			getPanelProducto().actualizarVentanaConsulta(evento_actual, datos);
			break;
			
		case EVENTO_LISTAR_PRODUCTOS:
		case ERROR_EVENTO_LISTAR_PRODUCTOS:
			getPanelProducto().actualizarVentanaListar(evento_actual, datos);
			break;
			
		case EVENTO_MODIFICAR_PRODUCTO:
		case ERROR_EVENTO_MODIFICAR_PRODUCTO:
			getPanelProducto().actualizarVentanaModificar(evento_actual, datos);
			break;
			
		case EVENTO_TOP_PRODUCTO:
		case ERROR_EVENTO_TOP_PRODUCTO:
			getPanelProducto().actualizarVentanaTop(evento_actual, datos);
			break;
			
		default:
			break;

		}
		
	}

	public PanelProducto getPanelProducto() {
		
		if(pProducto == null)
			pProducto = new PanelProducto();
		
		return pProducto;
	}
}
