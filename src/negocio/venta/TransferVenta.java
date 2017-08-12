package negocio.venta;

import java.sql.Date;
import java.util.HashMap;

public class TransferVenta {
	private int IDVenta;
	private Integer IDCliente;
	private Float totalVenta;
	private Date fecha;
	private HashMap<Integer, TransferLineaVenta> carrito;
	
	
	public Float getTotalVenta() {
		return totalVenta;
	}

	public Integer getIDCliente() {
		return IDCliente;
	}

	public Date getFecha(){
		return fecha;
	}

	public Integer getIDVenta() {
		return IDVenta;
	}

	public void setIDVenta(int IDVenta) {
		this.IDVenta=IDVenta;
	}

	public void setIDCliente(Integer IDCliente) {
		this.IDCliente=IDCliente;
	}

	public void setTotalVenta(Float costeTotal) {
		this.totalVenta=costeTotal;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public HashMap<Integer, TransferLineaVenta> getCarrito() {
		return carrito;
	}

	public void setCarrito(HashMap<Integer, TransferLineaVenta> carrito) {
		this.carrito = carrito;
	}

	public String toString()
	{
		return " " + IDVenta + IDCliente + totalVenta + fecha; 
	}
}
