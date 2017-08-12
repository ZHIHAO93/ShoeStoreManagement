package negocio.serviciosAplicacion;

import negocio.cliente.SACliente;
import negocio.cliente.SAClienteImp;
import negocio.producto.SAProducto;
import negocio.producto.SAProductoImp;
import negocio.venta.SAVenta;
import negocio.venta.SAVentaImp;


public class FactorySAImp extends FactorySA {

	@Override
	public SACliente getSACliente() {
		return new SAClienteImp();
	}

	@Override
	public SAVenta getSAVenta() {
		return new SAVentaImp();
	}

	@Override
	public SAProducto getSAProducto() {
		return new SAProductoImp();
	}

}
