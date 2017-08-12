package integracion.transacciones.conexion;

public class TransaccionNoEliminadaException extends Excepciones {

	private static final long serialVersionUID = 1L;

	private String source;
	
	public TransaccionNoEliminadaException(String error) {
		super("La transaccion no se ha podido eliminar: ");
	}
	
	@Override
	public String getMensaje() {
		
		return super.getMensaje() + source;
	}
	
	public String getOrigen() {
		
		return source;
	}
	
	public void setOrigen(String error) {
		
		source = error;
	}
}
