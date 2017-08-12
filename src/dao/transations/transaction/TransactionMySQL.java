package dao.transations.transaction;


import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

import dao.transations.connection.Connec;
import dao.transations.connection.Exceptions;

public class TransactionMySQL implements Transaction{

	private Connection conexion;
	private final String queryStartTransaction = "START TRANSACTION";
	private final String queryCommit = "COMMIT";
	private final String queryRollback = "ROLLBACK";
	
	@Override
	public void start() throws Exceptions{
		try{
			conexion = new Connec().AbrirConexionDataSource();
			PreparedStatement startTransaction = (PreparedStatement)conexion.prepareStatement(queryStartTransaction);
			if(startTransaction.execute()){
			}
		}
		catch(Exception e){
			throw new Exceptions("Error al comenzar la conexion");
		}
	}

	@Override
	public void commit() throws Exceptions{
		try{
			PreparedStatement commit = (PreparedStatement)conexion.prepareStatement(queryCommit);
			commit.execute();
		}
		catch(Exception e){
			rollback();
			throw new Exceptions("Error al hacer commit");
		}
		
	}

	@Override
	public void rollback() throws Exceptions {
		try {
			PreparedStatement rollback = (PreparedStatement)conexion.prepareStatement(queryRollback);
			rollback.execute();
		} catch (Exception e) {
			throw new Exceptions("Error al hacer commit");
		}
		
	}

	@Override
	public Connection getResource() {
		return conexion;
	}

}
