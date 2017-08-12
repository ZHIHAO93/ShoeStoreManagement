package integracion.transacciones.transaccion;


import integracion.transacciones.conexion.Conexion;
import integracion.transacciones.conexion.Excepciones;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

public class TransaccionMySQL implements Transaccion{

	private Connection conexion;
	private final String queryStartTransaction = "START TRANSACTION";
	private final String queryCommit = "COMMIT";
	private final String queryRollback = "ROLLBACK";
	
	@Override
	public void start() throws Excepciones{
		try{
			conexion = new Conexion().AbrirConexionDataSource();
			PreparedStatement startTransaction = (PreparedStatement)conexion.prepareStatement(queryStartTransaction);
			if(startTransaction.execute()){
			}
		}
		catch(Exception e){
			throw new Excepciones("Error al comenzar la conexion");
		}
	}

	@Override
	public void commit() throws Excepciones{
		try{
			PreparedStatement commit = (PreparedStatement)conexion.prepareStatement(queryCommit);
			commit.execute();
		}
		catch(Exception e){
			rollback();
			throw new Excepciones("Error al hacer commit");
		}
		
	}

	@Override
	public void rollback() throws Excepciones {
		try {
			PreparedStatement rollback = (PreparedStatement)conexion.prepareStatement(queryRollback);
			rollback.execute();
		} catch (Exception e) {
			throw new Excepciones("Error al hacer commit");
		}
		
	}

	@Override
	public Connection getResource() {
		return conexion;
	}

}
