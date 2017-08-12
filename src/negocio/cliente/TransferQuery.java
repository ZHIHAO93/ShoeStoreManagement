package negocio.cliente;

public class TransferQuery {

	private Float nEuros;
	private String fechaInicio;
	private String fechaFin;
	
	public Float getnEuros() {
		return nEuros;
	}
	public void setnEuros(Float nEuros) {
		this.nEuros = nEuros;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	@Override
	public String toString() {
		return nEuros + " " + fechaInicio +
				" " + fechaFin;
	}
	
	
	
}
