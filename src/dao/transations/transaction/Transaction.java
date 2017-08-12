package dao.transations.transaction;

import java.sql.Connection;

import dao.transations.connection.Exceptions;

public interface Transaction {
	public void start() throws Exceptions;
	public void commit() throws Exceptions;
	public void rollback() throws Exceptions;
	public Connection getResource();
}
