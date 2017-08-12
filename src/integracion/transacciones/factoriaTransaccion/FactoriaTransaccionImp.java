package integracion.transacciones.factoriaTransaccion;

import integracion.transacciones.transaccion.Transaccion;
import integracion.transacciones.transaccion.TransaccionMySQL;

public class FactoriaTransaccionImp extends FactoriaTransaccion{

	@Override
	public Transaccion nuevaTransaccion() {
		return new TransaccionMySQL();
	}
}
