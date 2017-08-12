package integracion.transacciones.transaccion;

import integracion.transacciones.conexion.Excepciones;

import java.sql.Connection;

public interface Transaccion {
	public void start() throws Excepciones;
	public void commit() throws Excepciones;
	public void rollback() throws Excepciones;
	public Connection getResource();
}
