package dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.product.TransferProduct;
import dao.transations.connection.Exceptions;
import dao.transations.connection.JdbcUtils;
import dao.transations.transactioManager.TransactionManager;
import dao.transations.transaction.Transaction;


public class DAOProductImp implements DAOProduct{
	
	private final String altaProducto = "INSERT INTO `mshoes`.`Producto` (`MARCA`,`TIPO`,`COLOR`,`STOCK`,"
			+ "`ACTIVO`,`PRECIO`) VALUES (?,?,?,?,?,?)";
	
	private final String consultaProductoID = "Select * from `mshoes`.`Producto` where `ID_PRODUCTO` = ? FOR UPDATE";
	
	private final String consultaProductoOtros = "Select * from `mshoes`.`Producto` where `MARCA` = ? AND `TIPO` = ? AND `COLOR` = ? FOR UPDATE";
	
	private final String listarProductos = "Select * from `mshoes`.`Producto` FOR UPDATE";
	
	private final String bajaProducto = "Update `mshoes`.`Producto` set `ACTIVO`=0 WHERE `ID_PRODUCTO`=?";
	
	private final String modificaProducto = "Update `mshoes`.`Producto` set `MARCA` = ?, `TIPO` = ?, `COLOR` = ?, "
			+ "`STOCK` = ?, `ACTIVO` = 1, `PRECIO`= ? WHERE `ID_PRODUCTO` = ? ";
	
	private final String topProducto = "Select `mshoes`.`Producto`.`ID_PRODUCTO`, `mshoes`.`Producto`.`MARCA`, `mshoes`.`Producto`.`TIPO`,"
			+ "`mshoes`.`Producto`.`COLOR`, `mshoes`.`Producto`.`STOCK`, `mshoes`.`Producto`.`PRECIO`, `mshoes`.`Producto`.`ACTIVO`, SUM(CANTIDAD) AS `NUM_VENTAS` "
			+ "FROM `mshoes`.`linea_de_venta`, `mshoes`.`Producto` WHERE `mshoes`.`linea_de_venta`.`ID_PRODUCTO` = `mshoes`.`Producto`.`ID_PRODUCTO` "
			+ "AND `mshoes`.`Producto`.`ACTIVO` = 1 GROUP BY `ID_PRODUCTO` ORDER BY `NUM_VENTAS` DESC LIMIT 1";

	@Override
	public boolean create(TransferProduct t) throws SQLException {
		boolean correcto = false;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement alta = conexion.prepareStatement(altaProducto);
			alta.setString(1, t.getMarca());
			alta.setString(2, t.getTipo());
			alta.setString(3, t.getColor());
			alta.setInt(4, t.getStock());
			alta.setBoolean(5, true);
			alta.setFloat(6, t.getPrecio());
			
			if(alta.executeUpdate() == 1) {
				correcto = true;
			}
			else
				throw new SQLException();
		}
		catch (Exceptions e){
			
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error en alta del Producto");
		}
		
		return correcto;
	}


	@Override
	public boolean bajaProducto(int IDProducto) throws SQLException {
		boolean correcto = false;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement baja = conexion.prepareStatement(bajaProducto);
			baja.setInt(1, IDProducto);
		
			if(baja.executeUpdate() == 1) {
				correcto = true;
			}
			else
				throw new SQLException();
		}
		catch (Exceptions e){
			
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error en baja Producto");
		}
		
		return correcto;
	}


	@Override
	public boolean update(TransferProduct p) throws SQLException {
		boolean correcto = false;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			
			PreparedStatement modifica = conexion.prepareStatement(modificaProducto); 
			modifica.setString(1, p.getMarca());
			modifica.setString(2, p.getTipo());
			modifica.setString(3, p.getColor());
			modifica.setInt(4, p.getStock());
			modifica.setFloat(5, p.getPrecio());
			modifica.setInt(6, p.getIDProducto());
		
			
			if(modifica.executeUpdate() == 1) {
				correcto = true;
			}
			else
				throw new SQLException();
		}
		catch (Exceptions e){
			
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error en modificacion del Producto");
		}
		
		return correcto;
	}


	@Override
	public TransferProduct readById_Producto(int IDProducto) throws SQLException {
		TransferProduct p = null;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement consulta = conexion.prepareStatement(consultaProductoID);
			consulta.setInt(1, IDProducto);
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				
				p = new TransferProduct();
				p.setIDProducto(resultado.getInt("ID_Producto"));
				p.setMarca(resultado.getString("Marca"));
				p.setTipo(resultado.getString("Tipo"));
				p.setColor(resultado.getString("Color"));
				p.setActivo(resultado.getBoolean("Activo"));
				p.setStock(resultado.getInt("Stock"));
				p.setPrecio(resultado.getFloat("Precio"));
			}
		
			
		}
		catch (Exceptions e){
			
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error en la consulta del Producto");
			
		}
		
		return p;
	}
	
	@Override
	public TransferProduct readByName(String marca, String tipo, String color) throws SQLException {
		TransferProduct p = null;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement consulta = conexion.prepareStatement(consultaProductoOtros);
			consulta.setString(1, marca);
			consulta.setString(2, tipo);
			consulta.setString(3, color);
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				
				p = new TransferProduct();
				p.setIDProducto(resultado.getInt("ID_Producto"));
				p.setMarca(resultado.getString("Marca"));
				p.setTipo(resultado.getString("Tipo"));
				p.setColor(resultado.getString("Color"));
				p.setActivo(resultado.getBoolean("Activo"));
				p.setStock(resultado.getInt("Stock"));
				p.setPrecio(resultado.getFloat("Precio"));
			}

		
			
		}
		catch (Exceptions e){
			
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error en la consulta del Producto");
			
		}
		
		return p;
	}


	@Override
	public ArrayList<TransferProduct> readAll() throws SQLException {
		TransferProduct p = null;
		ArrayList<TransferProduct> productos = new ArrayList<TransferProduct>();
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement lista = conexion.prepareStatement(listarProductos);
			ResultSet resultado = lista.executeQuery();
			
			
			while(resultado.next()) {
				
				p = new TransferProduct();
				p.setIDProducto(resultado.getInt("ID_Producto"));
				p.setMarca(resultado.getString("Marca"));
				p.setTipo(resultado.getString("Tipo"));
				p.setColor(resultado.getString("Color"));
				p.setActivo(resultado.getBoolean("Activo"));
				p.setStock(resultado.getInt("Stock"));
				p.setPrecio(resultado.getFloat("Precio"));
				
				productos.add(p); 
			}
			
		}
		catch (Exceptions e){
			
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error al listar los productos");
		}
		
		return productos;
	}


	@Override
	public TransferProduct productoMasVendido() throws SQLException { 
		TransferProduct p = null;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement consulta = conexion.prepareStatement(topProducto);
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) { 
				p = new TransferProduct();
				p.setIDProducto(resultado.getInt("ID_Producto"));
				p.setMarca(resultado.getString("Marca"));
				p.setTipo(resultado.getString("Tipo"));
				p.setColor(resultado.getString("Color"));
				p.setStock(resultado.getInt("Stock"));
				p.setPrecio(resultado.getFloat("Precio"));
				p.setActivo(resultado.getBoolean("Activo"));
			}
		}
		catch (Exceptions e){
			
			JdbcUtils.printSQLException(e);
			throw new Exceptions("Error en la consulta del topProducto");
			
		}
		
		return p;
	}
}
