package negocio.cliente;

public class TransferCliente {
	private int IDCliente;
	private String DNI;
	private String nombre;
	private String apellidos;
	private Boolean activo;
	private Float limiteCredito;
	private boolean newsletter;
	
	public TransferCliente() {
		IDCliente = 0;
	}
	
	
	public int getIDCliente() {
		return IDCliente;
	}
	public void setIDCliente(int iDCliente) {
		this.IDCliente = iDCliente;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		this.DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Float getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(Float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public boolean getNewsletter() {
		return newsletter;
	}
	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
	
	
	
	public String toString() {
		return IDCliente + " " + DNI + " "
				+ nombre + " " + apellidos + " "
				+ limiteCredito + " " + newsletter + " " + activo;
	}
	
	
	
}
