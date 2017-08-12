package presentacion.comando.factoriaComando;

import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.cliente.AltaCliente;
import presentacion.comando.cliente.BajaCliente;
import presentacion.comando.cliente.ConsultarUnCliente;
import presentacion.comando.cliente.ListarClientes;
import presentacion.comando.cliente.ModificarCliente;
import presentacion.comando.cliente.TopTenClientes;
import presentacion.comando.producto.AltaProducto;
import presentacion.comando.producto.BajaProducto;
import presentacion.comando.producto.ConsultarUnProducto;
import presentacion.comando.producto.ListarProducto;
import presentacion.comando.producto.ModificarProducto;
import presentacion.comando.producto.TopProducto;
import presentacion.comando.venta.AbrirVenta;
import presentacion.comando.venta.EliminarProductoCarrito;
import presentacion.comando.venta.CerrarVenta;
import presentacion.comando.venta.ConsultarUnaVenta;
import presentacion.comando.venta.Devolucion;
import presentacion.comando.venta.AnadirProductoCarrito;
import presentacion.comando.venta.ListarVentas;


public class CommandFactoryImp extends CommandFactory {

	@Override
	public Comando nuevoComando(IDEventos id_comando) {
		
		Comando comando = null;
		
		switch(id_comando){
			
		//Cliente
		case EVENTO_ALTA_CLIENTE:
			comando = new AltaCliente();
			break;
		case EVENTO_BAJA_CLIENTE:
			comando = new BajaCliente();
			break;
		case EVENTO_CONSULTAR_UN_CLIENTE:
			comando = new ConsultarUnCliente();
			break;
		case EVENTO_LISTAR_CLIENTES:
			comando = new ListarClientes();
			break;
		case EVENTO_MODIFICAR_CLIENTE:
			comando = new ModificarCliente();
			break;
		case EVENTO_TOP_TEN_CLIENTES:
			comando = new TopTenClientes();
			break;

			
		//Producto
		case EVENTO_ALTA_PRODUCTO:
			comando = new AltaProducto();
			break;
		case EVENTO_BAJA_PRODUCTO:
			comando = new BajaProducto();
			break;
		case EVENTO_CONSULTAR_UN_PRODUCTO:
			comando = new ConsultarUnProducto();
			break;
		case EVENTO_LISTAR_PRODUCTOS:
			comando = new ListarProducto();
			break;
		case EVENTO_MODIFICAR_PRODUCTO:
			comando = new ModificarProducto();
			break;
		case EVENTO_TOP_PRODUCTO:
			comando = new TopProducto();
			break;
			
			
			
		//Venta		
		case EVENTO_ABRIR_VENTA:
			comando = new AbrirVenta();
			break;
		case  EVENTO_CERRAR_VENTA:
			comando = new CerrarVenta();
			break;
		case EVENTO_CONSULTAR_UNA_VENTA:
			comando = new ConsultarUnaVenta();
			break;	
		case EVENTO_LISTAR_VENTAS:
			comando = new ListarVentas();
			break;	
		case EVENTO_DEVOLUCION_VENTA:
			comando = new Devolucion();
			break;	
		case EVENTO_ANADIR_PRODUCTO_CARRITO:
			comando = new AnadirProductoCarrito();
			break;
		case EVENTO_ELIMINAR_PRODUCTO_CARRITO:
			comando = new EliminarProductoCarrito();
			break;
			
		default:
			break;
		}	
		return comando;
	}
	
}