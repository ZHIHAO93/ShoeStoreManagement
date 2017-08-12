package negocio.producto;

public class TransferProducto {
	
	private Integer IDProducto;
	private String marca;
	private String tipo;
	private String color;
	private boolean activo;
	private Integer stock;
	private Float precio;
	
	public TransferProducto() {
		IDProducto = 0;
	}
	
	public Integer getIDProducto() {
		return IDProducto;
	}
	public void setIDProducto(Integer iDProducto) {
		this.IDProducto = iDProducto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public String toString() {
		return  IDProducto + " " + marca + " "
				+ tipo + " " + color + " "
				+ activo + " " + stock + " " + precio;
	}
	
}
