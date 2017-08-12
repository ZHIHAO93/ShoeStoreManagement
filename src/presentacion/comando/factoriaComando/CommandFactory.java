package presentacion.comando.factoriaComando;

import presentacion.comando.Comando;
import presentacion.comando.IDEventos;


public abstract class CommandFactory {
	
	private static CommandFactory commandFactoryInstancia;


	public static CommandFactory getInstancia() {

		crearCommandFactory();
		return commandFactoryInstancia;		
	}
	
	private synchronized static void crearCommandFactory(){
		if(commandFactoryInstancia==null)
			commandFactoryInstancia = new CommandFactoryImp();
	}

	
	public abstract Comando nuevoComando(IDEventos id_comando);
}