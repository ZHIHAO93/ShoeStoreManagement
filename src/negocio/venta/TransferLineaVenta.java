package negocio.venta;

public class TransferLineaVenta {
	private Integer IDProducto;
	private Float precio;
	private Integer cantidad;
	private Integer idVenta;
	
	
	public Integer getIDProducto() {
		return IDProducto;
	}
	public void setIDProducto(Integer IDProducto) {
		this.IDProducto = IDProducto;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	public String toString() {
		return  "" + IDProducto + 
				precio  + cantidad;
	}
}
