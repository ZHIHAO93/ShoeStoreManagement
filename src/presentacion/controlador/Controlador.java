package presentacion.controlador;

import presentacion.comando.IDEventos;

public abstract class Controlador {
	
	private static Controlador controladorAplicacionInstance;

	
	public static Controlador getInstance() {
		createApplicationController();
		return controladorAplicacionInstance;
	}

	private synchronized static void createApplicationController() {
		if (controladorAplicacionInstance == null)
			controladorAplicacionInstance = new ControladorImp();
	}

	
	public abstract void handleRequest(IDEventos evento, Object datos);
	

}
