package presentacion.cliente;

import presentacion.comando.IDEventos;



public abstract class ClienteGUI {

	private static ClienteGUI ClienteGUIInstance;

	public abstract void update(IDEventos evento_actual, Object datos);

	public static ClienteGUI getInstance() {

		createClienteGUI();

		return ClienteGUIInstance;
	}

	private static synchronized void createClienteGUI() {

		if (ClienteGUIInstance == null) {
			ClienteGUIInstance = new ClienteGUIImp();
		}
	}
	
	public abstract PanelCliente getPanelCliente();

}
