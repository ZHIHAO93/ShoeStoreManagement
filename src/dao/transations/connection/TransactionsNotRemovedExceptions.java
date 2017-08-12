package dao.transations.connection;

public class TransactionsNotRemovedExceptions extends Exceptions {

	private static final long serialVersionUID = 1L;

	private String source;
	
	public TransactionsNotRemovedExceptions(String error) {
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
