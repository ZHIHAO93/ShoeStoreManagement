package presentacion.cliente;

import presentacion.comando.IDEventos;

public class ClienteGUIImp extends ClienteGUI{

	private static PanelCliente pCliente;
	
	
	public void update(IDEventos evento_actual, Object datos) {
		
		switch (evento_actual) {

		case EVENTO_ALTA_CLIENTE:
		case ERROR_EVENTO_ALTA_CLIENTE:
			getPanelCliente().actualizarVentanaAlta(evento_actual, datos);
			break;
			
		case EVENTO_BAJA_CLIENTE:
		case ERROR_EVENTO_BAJA_CLIENTE:
			getPanelCliente().actualizarVentanaBorra(evento_actual, datos);
			break;
			
		case EVENTO_CONSULTAR_UN_CLIENTE:
		case ERROR_EVENTO_CONSULTAR_UN_CLIENTE:
			getPanelCliente().actualizarVentanaConsulta(evento_actual, datos);
			break;
			
		case EVENTO_LISTAR_CLIENTES:
		case ERROR_EVENTO_LISTAR_CLIENTES:
			getPanelCliente().actualizarVentanaListar(evento_actual, datos);
			break;
			
		case EVENTO_MODIFICAR_CLIENTE:
		case ERROR_EVENTO_MODIFICAR_CLIENTE:
			getPanelCliente().actualizarVentanaModificar(evento_actual, datos);
			break;
			
		case EVENTO_TOP_TEN_CLIENTES:
		case ERROR_EVENTO_TOP_TEN_CLIENTES:
			getPanelCliente().actualizarVentanaTopTen(evento_actual, datos);
			break;
			
		default:
			break;

		}
		
	}

	public PanelCliente getPanelCliente() {
		
		if(pCliente == null)
			pCliente = new PanelCliente();
		
		return pCliente;
	}

}
