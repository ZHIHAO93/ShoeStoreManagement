package dao.transations.transactionFactory;

import dao.transations.transaction.Transaction;

public abstract class TransactionFactory {
	
	private static TransactionFactory instance;
	
	public abstract Transaction nuevaTransaccion();
	
	private synchronized static void createTransactionFactory()
	{
		if(instance == null)
			instance = new TransactionFactoryImp();
	}
	
	public static TransactionFactory getInstance()
	{
		createTransactionFactory();
		return instance;
	}
}
