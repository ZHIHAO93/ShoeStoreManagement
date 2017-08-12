package dao.transations.transactioManager;

import dao.transations.connection.Exceptions;
import dao.transations.transaction.Transaction;

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
	
	public abstract Transaction nuevaTransaccion() throws Exceptions;
	public abstract Transaction getTransaction() throws Exceptions;
	public abstract Boolean eliminaTransaccion() throws Exceptions;
}
