package dao.transations.connection;



import java.sql.*;

public class Connec {
	public Connection AbrirConexionDataSource() throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		
		}

		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/MShoes?" + "user=mshoes&password=");
		conexion.setAutoCommit(false);
		conexion.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

		return conexion;
	}
}
