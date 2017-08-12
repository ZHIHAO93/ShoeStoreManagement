package negocio.venta;

import java.util.HashMap;

public class TransferCarrito {

	private Integer IDProducto;
	private float precio;
	private Integer cantidad;
	private HashMap<Integer, TransferLineaVenta> carrito;
	
	
	public Integer getIDProducto() {
		return IDProducto;
	}
	public void setIDProducto(int IDArticulo) {
		this.IDProducto = IDArticulo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public HashMap<Integer, TransferLineaVenta> getCarrito() {
		return carrito;
	}
	public void setCarrito(HashMap<Integer, TransferLineaVenta> carrito) {
		this.carrito = carrito;
	}

}
