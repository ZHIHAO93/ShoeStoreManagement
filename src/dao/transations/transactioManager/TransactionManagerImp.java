package dao.transations.transactioManager;

import java.util.concurrent.ConcurrentHashMap;

import dao.transations.connection.Exceptions;
import dao.transations.transaction.Transaction;
import dao.transations.transactionFactory.TransactionFactory;

public class TransactionManagerImp extends TransactionManager{
	
	private ConcurrentHashMap<Long, Transaction> mapaConcurrencia = new ConcurrentHashMap<Long, Transaction>();

	public Transaction nuevaTransaccion() throws Exceptions
	{
		Transaction t = null;
		Long idHilo = Thread.currentThread().getId();
		if(mapaConcurrencia.containsKey(idHilo)) {
			throw new Exceptions("Ya existe el thread");
		}
		else{
			t = TransactionFactory.getInstance().nuevaTransaccion();
			mapaConcurrencia.put(idHilo,t);
		}
		return t;
	}
	

	public Transaction getTransaction() throws Exceptions
	{
		Transaction t = null;
		Long idHilo = Thread.currentThread().getId();
		if(mapaConcurrencia.containsKey(idHilo))
			t = mapaConcurrencia.get(idHilo);
		else{
			throw new Exceptions("Error al obtener transaccion");
		}
		return t;
		
	}
	
	@Override
	public Boolean removeTransaction() throws Exceptions
	{
		Long threadId = Thread.currentThread().getId();
		boolean correcto;
		
		if (mapaConcurrencia.containsKey(threadId)) {
			Transaction t = mapaConcurrencia.get(threadId);
			
			t.commit();
			mapaConcurrencia.remove(threadId);
			
			correcto = true;
		}
		else
			correcto = false;
		
		return correcto;
	}
}
