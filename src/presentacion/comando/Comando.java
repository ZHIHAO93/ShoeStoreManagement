package presentacion.comando;

import presentacion.comando.factoriaComando.CommandResponse;


public interface Comando {
	
	public CommandResponse ejecutar(Object datos);
	
}