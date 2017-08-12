package dao.customer;

import java.sql.SQLException;
import java.util.ArrayList;

import business.customer.TransferCustomer;
import business.customer.TransferQuery;

public interface DAOCustomer {
	public boolean create(TransferCustomer c) throws SQLException;
	public boolean bajaCliente(int IDCliente) throws SQLException;
	public boolean update(TransferCustomer c) throws SQLException;
	public TransferCustomer readById_Cliente(int IDCliente) throws SQLException;
	public TransferCustomer readByDNI(String DNI) throws SQLException;
	public ArrayList<TransferCustomer> readAll() throws SQLException;
	public ArrayList<TransferCustomer> top10Clientes(TransferQuery topCli) throws SQLException;
}
