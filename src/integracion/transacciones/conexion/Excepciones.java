package integracion.transacciones.conexion;

import java.sql.SQLException;

public class Excepciones extends SQLException {
	
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public Excepciones(String mensajeError) {
		mensaje = mensajeError;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensajeError) {
		mensaje = mensajeError;
	}
}
