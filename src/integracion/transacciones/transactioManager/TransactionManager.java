package integracion.transacciones.transactioManager;

import integracion.transacciones.conexion.Excepciones;
import integracion.transacciones.transaccion.Transaccion;

public abstract class TransactionManager {

	private static TransactionManager transactionManagerInstance;
	
	private synchronized static void createTransactionManager()
	{
		if(transactionManagerInstance == null)
			transactionManagerInstance = new TransactionManagerImp();
	}
	
	public static TransactionManager getInstance()
	{
		createTransactionManager();
		return transactionManagerInstance;
	}
	
	public abstract Transaccion nuevaTransaccion() throws Excepciones;
	public abstract Transaccion getTransaction() throws Excepciones;
	public abstract Boolean eliminaTransaccion() throws Excepciones;
}
