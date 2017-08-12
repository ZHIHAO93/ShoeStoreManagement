package dao.transations.transactionFactory;

import dao.transations.transaction.Transaction;
import dao.transations.transaction.TransactionMySQL;

public class TransactionFactoryImp extends TransactionFactory{

	@Override
	public Transaction nuevaTransaccion() {
		return new TransactionMySQL();
	}
}
