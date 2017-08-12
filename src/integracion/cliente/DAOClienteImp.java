package integracion.cliente;

import integracion.transacciones.conexion.Excepciones;
import integracion.transacciones.conexion.JdbcUtils;
import integracion.transacciones.transaccion.Transaccion;
import integracion.transacciones.transactioManager.TransactionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import negocio.cliente.TransferCliente;
import negocio.cliente.TransferQuery;

public class DAOClienteImp implements DAOCliente{

	private final String altaCliente = "INSERT INTO `mshoes`.`Cliente` (`DNI`,`NOMBRE`,`APELLIDOS`,`ACTIVO`) VALUES (?,?,?,?)";
	
	private final String insertarNoSocio = "INSERT INTO `mshoes`.`No_Socio` (`ID_CLIENTE`, `NEWSLETTER`) VALUES (?,?)";
	
	private final String altaNoSocio = "INSERT INTO `mshoes`.`No_Socio` (`ID_CLIENTE`, `NEWSLETTER`) VALUES (LAST_INSERT_ID(),?)";
	
	private final String insertarSocio = "INSERT INTO `mshoes`.`Socio` (`ID_CLIENTE`, `LIMITE_CREDITO`) VALUES (?,?)";
	
	private final String altaSocio = "INSERT INTO `mshoes`.`Socio` (`ID_CLIENTE`, `LIMITE_CREDITO`) VALUES (LAST_INSERT_ID(),?)";
	
	private final String consultaClienteID = "Select * from `mshoes`.`Cliente` where `ID_CLIENTE` = ? FOR UPDATE";
	
	private final String consultaSocioID = "Select `LIMITE_CREDITO` from `mshoes`.`Cliente`, `mshoes`.`Socio`"
			+ "where `mshoes`.`Cliente`.`ID_CLIENTE` = ? AND `mshoes`.`Cliente`.`ID_CLIENTE` = `mshoes`.`Socio`.`ID_CLIENTE` FOR UPDATE";
	
	private final String consultaNoSocioID = "Select `NEWSLETTER` from `mshoes`.`Cliente`, `mshoes`.`No_Socio`"
			+ "where `mshoes`.`Cliente`.`ID_CLIENTE` = ? AND `mshoes`.`Cliente`.`ID_CLIENTE` = `mshoes`.`No_Socio`.`ID_CLIENTE` FOR UPDATE";
	
	private final String consultaClienteDNI = "Select * from `mshoes`.`Cliente` where `DNI` = ? FOR UPDATE";
	
	private final String listarClientes = "Select * from `mshoes`.`Cliente` FOR UPDATE";
	
	private final String bajaCliente = "Update `mshoes`.`Cliente` set `ACTIVO`=0 WHERE `ID_CLIENTE`=?";
	
	private final String modificarCliente = "Update `mshoes`.`Cliente` set `DNI` = ?, `NOMBRE` = ?, `APELLIDOS` = ?, `ACTIVO` = 1 WHERE `ID_CLIENTE` = ? ";
	
	private final String modificarNoSocio = "Update `mshoes`.`No_Socio` set `NEWSLETTER` = ? WHERE `ID_CLIENTE` = ? ";
	
	private final String modificarSocio = "Update `mshoes`.`Socio` set `LIMITE_CREDITO`= ? WHERE `ID_CLIENTE` = ? ";
	
	private final String topTenClientes = "Select DISTINCT `mshoes`.`Cliente`.`ID_CLIENTE`, `mshoes`.`Cliente`.`DNI`,"
			+ "`mshoes`.`Cliente`.`NOMBRE`, `mshoes`.`Cliente`.`APELLIDOS` FROM `mshoes`.`Cliente` RIGHT OUTER JOIN " 
			+ "`mshoes`.`Venta` ON `mshoes`.`Cliente`.`ID_CLIENTE` = `mshoes`.`Venta`.`ID_CLIENTE` "
			+ "WHERE `mshoes`.`Venta`.`Total_Venta` > ? AND `mshoes`.`Venta`.`FECHA` BETWEEN ? AND ? AND `mshoes`.`Cliente`.`ACTIVO` = 1";
	
	public boolean create(TransferCliente c) throws SQLException {
		
		boolean correcto = false;
		Transaccion transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			
			PreparedStatement alta = conexion.prepareStatement(altaCliente);
			
			alta.setString(1, c.getDNI());
			alta.setString(2, c.getNombre());
			alta.setString(3, c.getApellidos());
			alta.setBoolean(4, true);
			
			if(alta.executeUpdate() == 1) {
				correcto = true;
			}
			else
				throw new SQLException();
			
			//No socio
			if(c.getLimiteCredito() == 0) {
				PreparedStatement noSocio = conexion.prepareStatement(altaNoSocio);
				
				noSocio.setBoolean(1, c.getNewsletter());
				
				if(noSocio.executeUpdate() == 1) { 
					correcto = true;
				}
				else
					throw new SQLException();
			}
			//Socio
			else {
				PreparedStatement socio = conexion.prepareStatement(altaSocio);
			
				socio.setFloat(1, c.getLimiteCredito());
				
				if(socio.executeUpdate() == 1) { 
					correcto = true;
				}
				else
					throw new SQLException();
			}
			
		}
		
		catch (Excepciones e){
			
			JdbcUtils.printSQLException(e);
			throw new Excepciones("Error en alta del cliente");
		}
		
		return correcto;
	}
	

	@Override
	public boolean bajaCliente(int IDCliente) throws SQLException {
		
		boolean correcto = false;
		Transaccion transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement baja = conexion.prepareStatement(bajaCliente);
			baja.setInt(1, IDCliente);
		
			if(baja.executeUpdate() == 1) {
				correcto = true;
			}
			else
				throw new SQLException();
			
		}
		catch (Excepciones e){
			
			JdbcUtils.printSQLException(e);
			throw new Excepciones("Error en baja del cliente");
		}
		
		return correcto;
	}

	
	
	
	public boolean update(TransferCliente c) throws SQLException {
		
		boolean correcto = false;
		Transaccion transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			
			PreparedStatement modifica = conexion.prepareStatement(modificarCliente);
			modifica.setString(1, c.getDNI());
			modifica.setString(2, c.getNombre());
			modifica.setString(3, c.getApellidos());
			modifica.setInt(4, c.getIDCliente());
			
			
			if(modifica.executeUpdate() == 1) {
				correcto = true;
			}
			else
				throw new SQLException();
			
			//No socio
			if(c.getLimiteCredito() == 0) {
				
				correcto = auxComprobarNoSocio(conexion, c);
				
			}
			//Socio
			else {
				correcto = auxComprobarSocio(conexion, c);
				
			}
			
		}
		catch (Excepciones e){
			
			JdbcUtils.printSQLException(e);
			throw new Excepciones("Error en modificacion del cliente");
		}
		
		return correcto;
	}
	
	

	public TransferCliente readByDNI(String DNI) throws SQLException {
		
		TransferCliente c = null;
		Transaccion transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement consulta = conexion.prepareStatement(consultaClienteDNI);
			consulta.setString(1, DNI);
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
			
				c = new TransferCliente();
				c.setIDCliente(resultado.getInt("ID_Cliente"));
				c.setDNI(resultado.getString("DNI"));
				c.setNombre(resultado.getString("Nombre"));
				c.setApellidos(resultado.getString("Apellidos"));
				c.setActivo(resultado.getBoolean("Activo"));			
			}
			
		}
		catch (Excepciones e){
			
			JdbcUtils.printSQLException(e);
			throw new Excepciones("Error en la consulta del cliente");
			
		}
		
		return c;
	}
	
	
	public TransferCliente readById_Cliente(int IDCliente) throws SQLException {
		
		TransferCliente c = null;
		Transaccion transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement consulta = conexion.prepareStatement(consultaClienteID);
			consulta.setInt(1, IDCliente);
			ResultSet resultado = consulta.executeQuery();
			
			PreparedStatement noSocio = conexion.prepareStatement(consultaNoSocioID);
			noSocio.setInt(1, IDCliente);
			ResultSet resultadoNoSocio = noSocio.executeQuery();
			
			PreparedStatement socio = conexion.prepareStatement(consultaSocioID);
			socio.setInt(1, IDCliente);
			ResultSet resultadoSocio = socio.executeQuery();
			
			while(resultado.next()) {
				
				c = new TransferCliente();
				c.setIDCliente(resultado.getInt("ID_Cliente"));
				c.setDNI(resultado.getString("DNI"));
				c.setNombre(resultado.getString("Nombre"));
				c.setApellidos(resultado.getString("Apellidos"));
				c.setActivo(resultado.getBoolean("Activo"));
				
				while(resultadoNoSocio.next()) {
					c.setNewsletter(resultadoNoSocio.getBoolean("Newsletter"));
				}
				
				while(resultadoSocio.next()) {
					c.setLimiteCredito(resultadoSocio.getFloat("Limite_Credito"));
				}
			}

		}
		catch (Excepciones e){
			
			JdbcUtils.printSQLException(e);
			throw new Excepciones("Error en la consulta del cliente");
			
		}
		
		return c;
	}

	@Override
	public ArrayList<TransferCliente> readAll() throws SQLException {
		
		TransferCliente c = null;
		ArrayList<TransferCliente> clientes = new ArrayList<TransferCliente>();
		Transaccion transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			
			PreparedStatement lista = conexion.prepareStatement(listarClientes);
			ResultSet resultado = lista.executeQuery();
			
			while(resultado.next()) {
				
				c = new TransferCliente();
				c.setIDCliente(resultado.getInt("ID_Cliente"));
				c.setDNI(resultado.getString("DNI"));
				c.setNombre(resultado.getString("Nombre"));
				c.setApellidos(resultado.getString("Apellidos"));
				c.setActivo(resultado.getBoolean("Activo"));
				
				PreparedStatement noSocio = conexion.prepareStatement(consultaNoSocioID);
				noSocio.setInt(1, c.getIDCliente());
				ResultSet resultadoNoSocio = noSocio.executeQuery();
				
				while(resultadoNoSocio.next()) {
					
					c.setNewsletter(resultadoNoSocio.getBoolean("Newsletter"));
				}
				
				PreparedStatement socio = conexion.prepareStatement(consultaSocioID);
				socio.setInt(1, c.getIDCliente());
				ResultSet resultadoSocio = socio.executeQuery();
				
				while(resultadoSocio.next()) {
					c.setLimiteCredito(resultadoSocio.getFloat("Limite_Credito"));
				}
				clientes.add(c);
			}
			
		}
		catch (Excepciones e){
			
			JdbcUtils.printSQLException(e);
			throw new Excepciones("Error al listar los clientes");
		}
		
		return clientes;
	}

	@Override
	public ArrayList<TransferCliente> top10Clientes(TransferQuery topCli) throws SQLException {
		
		TransferCliente c = null;
		ArrayList<TransferCliente> topClientes = new ArrayList<TransferCliente>();
		Transaccion transaccion = TransactionManager.getInstance().getTransaction();
		Connection conexion = transaccion.getResource();
		
		try {
			PreparedStatement top = conexion.prepareStatement(topTenClientes);
			top.setFloat(1, topCli.getnEuros());
			top.setString(2, topCli.getFechaInicio());
			top.setString(3, topCli.getFechaFin());
			ResultSet resultado = top.executeQuery();
			
			
			while(resultado.next()) {
				
				c = new TransferCliente();
				c.setIDCliente(resultado.getInt("ID_Cliente"));
				c.setDNI(resultado.getString("DNI"));
				c.setNombre(resultado.getString("Nombre"));
				c.setApellidos(resultado.getString("Apellidos"));
				topClientes.add(c);
			}
			
		}
		catch (Excepciones e){
			
			JdbcUtils.printSQLException(e);
			throw new Excepciones("Error al listar el top 10 de clientes");
		}
		
		return topClientes;
	
	}
	
	
	
	
	private boolean auxComprobarNoSocio(Connection conexion, TransferCliente c) throws SQLException {
		
		boolean correcto = false;
		
		PreparedStatement consulta = conexion.prepareStatement(consultaNoSocioID);
		consulta.setInt(1, c.getIDCliente());
		ResultSet resultadoSocio = consulta.executeQuery();
		try {
			//Si no existe el socio en la tabla de socios, insertamos
			if(!resultadoSocio.next()) {
				PreparedStatement nosocio = conexion.prepareStatement(insertarNoSocio);
				nosocio.setBoolean(2, c.getNewsletter());
				nosocio.setInt(1, c.getIDCliente());
				
				if(nosocio.executeUpdate() == 1) { 
					correcto = true;
				}
				else
					throw new SQLException();
				
			}
			//Si ya existia, actualizamos
			else {
				PreparedStatement nosocio = conexion.prepareStatement(modificarNoSocio);
				nosocio.setBoolean(1, c.getNewsletter());
				nosocio.setInt(2, c.getIDCliente());
				
				if(nosocio.executeUpdate() == 1) { 
					correcto = true;
				}
				else
					throw new SQLException();
			}
			
		}
		catch (Excepciones e){
		
			JdbcUtils.printSQLException(e);
			throw new Excepciones("Error en comprobacion del NoSocio");
		}
		
		return correcto;
	}

	
	private boolean auxComprobarSocio(Connection conexion, TransferCliente c) throws SQLException {
	
		boolean correcto = false;
		
		PreparedStatement consulta = conexion.prepareStatement(consultaSocioID);
		consulta.setInt(1, c.getIDCliente());
		ResultSet resultadoSocio = consulta.executeQuery();
		try {
			//Si no existe el socio en la tabla de socios, insertamos
			if(!resultadoSocio.next()) {
				PreparedStatement socio = conexion.prepareStatement(insertarSocio);
				socio.setFloat(2, c.getLimiteCredito());
				socio.setInt(1, c.getIDCliente());
				
				if(socio.executeUpdate() == 1) { 
					correcto = true;
				}
				else
					throw new SQLException();
				
			}
			//Si ya existia, actualizamos
			else {
				PreparedStatement socio = conexion.prepareStatement(modificarSocio);
				socio.setFloat(1, c.getLimiteCredito());
				socio.setInt(2, c.getIDCliente());
				
				if(socio.executeUpdate() == 1) { 
					correcto = true;
				}
				else
					throw new SQLException();
			}
			
		}
		catch (Excepciones e){
		
			JdbcUtils.printSQLException(e);
			throw new Excepciones("Error en comprobacion del Socio");
		}
		
		return correcto;
	}
}
