package presentacion.controlador;

import presentacion.comando.factoriaComando.CommandResponse;


public abstract class Dispatcher {
	
	
	private static Dispatcher dispatcherInstance;

	
	public abstract void redirect(CommandResponse respuestacomando);

	private synchronized static void createDispatcher() {
		if (dispatcherInstance == null)
			dispatcherInstance = new DispatcherImp();
	}

	public static Dispatcher getInstance() {
		createDispatcher();
		return dispatcherInstance;

	}
}