package dao.transations.connection;

import java.sql.SQLException;

public class Exceptions extends SQLException {
	
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public Exceptions(String mensajeError) {
		mensaje = mensajeError;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensajeError) {
		mensaje = mensajeError;
	}
}
