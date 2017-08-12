package negocio.serviciosAplicacion;

import negocio.cliente.SACliente;
import negocio.producto.SAProducto;
import negocio.venta.SAVenta;


public abstract class FactorySA 
{
	private static FactorySA factorySAInstance;
	
	private synchronized static void createFactorySA()
	{
		if(factorySAInstance == null)
			factorySAInstance = new FactorySAImp();
	}
	
	public static FactorySA getInstance()
	{
		createFactorySA();
		return factorySAInstance;
	}
	
	public abstract SACliente getSACliente();
	public abstract SAProducto getSAProducto();
	public abstract SAVenta getSAVenta();	
}
