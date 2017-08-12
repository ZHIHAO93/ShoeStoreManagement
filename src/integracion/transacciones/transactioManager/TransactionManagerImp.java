package integracion.transacciones.transactioManager;

import integracion.transacciones.conexion.Excepciones;
import integracion.transacciones.factoriaTransaccion.FactoriaTransaccion;
import integracion.transacciones.transaccion.Transaccion;

import java.util.concurrent.ConcurrentHashMap;

public class TransactionManagerImp extends TransactionManager{
	
	private ConcurrentHashMap<Long, Transaccion> mapaConcurrencia = new ConcurrentHashMap<Long, Transaccion>();

	public Transaccion nuevaTransaccion() throws Excepciones
	{
		Transaccion t = null;
		Long idHilo = Thread.currentThread().getId();
		if(mapaConcurrencia.containsKey(idHilo)) {
			throw new Excepciones("Ya existe el thread");
		}
		else{
			t = FactoriaTransaccion.getInstance().nuevaTransaccion();
			mapaConcurrencia.put(idHilo,t);
		}
		return t;
	}
	

	public Transaccion getTransaction() throws Excepciones
	{
		Transaccion t = null;
		Long idHilo = Thread.currentThread().getId();
		if(mapaConcurrencia.containsKey(idHilo))
			t = mapaConcurrencia.get(idHilo);
		else{
			throw new Excepciones("Error al obtener transaccion");
		}
		return t;
		
	}
	
	@Override
	public Boolean eliminaTransaccion() throws Excepciones
	{
		Long threadId = Thread.currentThread().getId();
		boolean correcto;
		
		if (mapaConcurrencia.containsKey(threadId)) {
			Transaccion t = mapaConcurrencia.get(threadId);
			
			t.commit();
			mapaConcurrencia.remove(threadId);
			
			correcto = true;
		}
		else
			correcto = false;
		
		return correcto;
	}
}
