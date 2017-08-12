package dao.sale;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import business.product.TransferProduct;
import business.sale.TransferLifeLine;
import business.sale.TransferSale;
import dao.factory.DAOFactory;
import dao.product.DAOProduct;
import dao.transations.connection.Exceptions;
import dao.transations.connection.JdbcUtils;
import dao.transations.transactioManager.TransactionManager;
import dao.transations.transaction.Transaction;

public class DAOSaleImp implements DAOSale{

	private final String actualizarStock = "UPDATE `mshoes`.`Producto` set `STOCK` = ? WHERE `ID_PRODUCTO` = ?";
	private final String actualizarTotalVenta = "UPDATE `mshoes`.`Venta` set `TOTAL_VENTA` = ? WHERE `ID_VENTA` = LAST_INSERT_ID()";
	private final String actualizarTotalVentaDevolucion = "UPDATE `mshoes`.`Venta` set `TOTAL_VENTA` = ? WHERE `ID_VENTA` = ?";
	private final String actualizarLineaVenta = "UPDATE `mshoes`.`Linea_De_Venta` set `CANTIDAD` = ? WHERE `ID_PRODUCTO` = ? AND `ID_VENTAS` = ?";
	private final String listarVentas = "Select * from `mshoes`.`Venta` FOR UPDATE";
	private final String consultarVenta = "Select * from `mshoes`.`Venta` WHERE `ID_VENTA` = ? FOR UPDATE";
	private final String consultarLineaVenta = "Select * from `mshoes`.`Linea_De_Venta` WHERE `ID_PRODUCTO` = ? AND `ID_VENTAS` = ? FOR UPDATE";
	private final String cerrarVenta = "INSERT INTO `mshoes`.`Venta` (`TOTAL_VENTA`, `FECHA`, `ID_CLIENTE`) VALUES (?, ?, ?)";
	private final String cerrarLineaVenta = "INSERT INTO `mshoes`.`Linea_De_Venta` (`ID_PRODUCTO`, `ID_VENTAS`, `CANTIDAD`, `PRECIO`) VALUES (?, LAST_INSERT_ID(), ?, ?)";
	


	@Override
	public boolean devolucion(TransferLifeLine lv, TransferProduct p, TransferSale v) throws SQLException {
		
		boolean correcto = false;
		boolean esDevolucion = true;
		 
		if(auxActualizarLineaVenta(lv, v.getIDVenta()) && auxActualizarStock(p) && auxActualizarTotalVenta(v, esDevolucion)) {
			correcto = true;
		}
	
		return correcto;
	}

	@Override
	public TransferSale readById_Venta(int IDVenta) throws SQLException {
		
		TransferSale v = null;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement consulta = conexion.prepareStatement(consultarVenta);
			consulta.setInt(1, IDVenta);
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				
				v = new TransferSale();
				v.setIDVenta(resultado.getInt("ID_Venta"));
				v.setTotalVenta(resultado.getFloat("Total_Venta"));
				v.setFecha(resultado.getDate("Fecha"));
				v.setIDCliente(resultado.getInt("ID_Cliente"));
				
			}
		}
		catch (Exceptions e){
			
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error en la consulta de la venta");
			
		}
		
		return v;
	}
	
	@Override
	public TransferLifeLine consultarLineaVenta(int IDVenta, int IDProducto) throws SQLException {
		
		TransferLifeLine lv = null;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement consulta = conexion.prepareStatement(consultarLineaVenta);
			consulta.setInt(1, IDProducto);
			consulta.setInt(2, IDVenta);
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				
				lv = new TransferLifeLine();
				lv.setIDProducto(resultado.getInt("ID_Producto"));
				lv.setCantidad(resultado.getInt("Cantidad"));
				lv.setPrecio(resultado.getFloat("Precio"));
				
			}
		}
		catch (Exceptions e){
			
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error en la consulta de la linea de venta");
			
		}
		
		return lv;
	}

	@Override
	public ArrayList<TransferSale> readAll() throws SQLException {
		
		TransferSale v = null;
		ArrayList<TransferSale> ventas= new ArrayList<TransferSale>();
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement lista = conexion.prepareStatement(listarVentas);
			ResultSet resultado = lista.executeQuery();
			
			
			while(resultado.next()) {
				
				v = new TransferSale();
				v.setIDVenta(resultado.getInt("ID_Venta"));
				v.setTotalVenta(resultado.getFloat("Total_Venta"));
				v.setFecha(resultado.getDate("Fecha"));
				v.setIDCliente(resultado.getInt("ID_Cliente"));
				ventas.add(v);
			}
			
		}
		catch (Exceptions e){
			
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error al listar las ventas");
		}
		
		return ventas;
	
	
	}

	public boolean cerrarVenta(TransferSale v) throws SQLException {
		
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		boolean correcto = false;
		boolean esDevolucion = false;
		
		try {
			
			//Insertamos la venta
			PreparedStatement cerrarV = conexion.prepareStatement(cerrarVenta);
			cerrarV.setFloat(1, v.getTotalVenta());
			cerrarV.setDate(2, v.getFecha());
			cerrarV.setInt(3, v.getIDCliente());
			
			if(cerrarV.executeUpdate()==1)
				correcto = true;
			else
				throw new SQLException();
			
			DAOProduct daoProd = DAOFactory.getInstance().generaDAOProducto();
			
			//Iterador para recorrer el hashmap e ir cogiendo las idProducto
			//Vamos insertando en su tabla cada linea de venta
			Iterator<Entry<Integer, TransferLifeLine>> it = v.getCarrito().entrySet().iterator();
			while(it.hasNext()) {
				Entry<Integer, TransferLifeLine> e = it.next();
				
				PreparedStatement cerrar = conexion.prepareStatement(cerrarLineaVenta);
				cerrar.setInt(1, v.getCarrito().get(e.getKey()).getIDProducto());
				cerrar.setInt(2, v.getCarrito().get(e.getKey()).getCantidad());
				cerrar.setFloat(3, v.getCarrito().get(e.getKey()).getPrecio());
				
				if(cerrar.executeUpdate()==1)
					correcto = true;
				else
					throw new SQLException();
				
				//Actualizamos el stock de cada producto
				if(auxActualizarStock(daoProd.readById_Producto(e.getKey()))) {
					correcto = true;
				}
				else
					throw new SQLException();
			}
			
			//Actualizamos el totalVenta
			if(auxActualizarTotalVenta(v, esDevolucion)) {
				correcto = true;
			}
			else
				throw new SQLException();
			
			
		} catch (Exceptions e) {
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error al cerrar la venta");
		}
		
		return correcto;
	}
	
	//Metodos auxiliares

	public boolean auxActualizarStock(TransferProduct p) throws SQLException {
		
		boolean correcto = false;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			
			PreparedStatement modificaStock = conexion.prepareStatement(actualizarStock);
			modificaStock.setInt(1, p.getStock());
			modificaStock.setInt(2, p.getIDProducto());
			
			if(modificaStock.executeUpdate() == 1) {
				correcto = true;
			}
			else
				throw new SQLException();
		}
		catch (Exceptions e){
			
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error en modificar stock");
		}
		
		return correcto;
	}
	
	public boolean auxActualizarTotalVenta(TransferSale v, boolean esDevolucion) throws SQLException {
			
			boolean correcto = false;
			Transaction transaccion = TransactionManager.getInstance().getTransaction();
			Connection conexion = transaccion.getResource();
			
			try {
				PreparedStatement modificaTotal = null;
				if(!esDevolucion) {
					modificaTotal = conexion.prepareStatement(actualizarTotalVenta);
					modificaTotal.setFloat(1, v.getTotalVenta());
				}
				else {
					modificaTotal = conexion.prepareStatement(actualizarTotalVentaDevolucion);
					modificaTotal.setFloat(1, v.getTotalVenta());
					modificaTotal.setInt(2, v.getIDVenta());
				}
					
				if(modificaTotal.executeUpdate() == 1) {
					correcto = true;
				}
				else
					throw new SQLException();
			}
			catch (Exceptions e){
				
				JdbcUtils.printSQLException(e);
				throw new Exceptions("Error en modificar total venta");
			}
			
			return correcto;
		}
	
	public boolean auxActualizarLineaVenta(TransferLifeLine lv, int IDVenta) throws SQLException {
		
		boolean correcto = false;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			
			PreparedStatement modificaTotal = conexion.prepareStatement(actualizarLineaVenta);
			modificaTotal.setInt(1, lv.getCantidad());
			modificaTotal.setInt(2, lv.getIDProducto());
			modificaTotal.setInt(3, IDVenta);
			
			if(modificaTotal.executeUpdate() == 1) {
				correcto = true;
			}
			else
				throw new SQLException();
		}
		catch (Exceptions e){
			
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error en modificar la linea de venta");
		}
		
		return correcto;
	}

}
