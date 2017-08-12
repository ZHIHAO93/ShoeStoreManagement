package integracion.cliente;

import java.sql.SQLException;
import java.util.ArrayList;

import negocio.cliente.TransferCliente;
import negocio.cliente.TransferQuery;

public interface DAOCliente {
	public boolean create(TransferCliente c) throws SQLException;
	public boolean bajaCliente(int IDCliente) throws SQLException;
	public boolean update(TransferCliente c) throws SQLException;
	public TransferCliente readById_Cliente(int IDCliente) throws SQLException;
	public TransferCliente readByDNI(String DNI) throws SQLException;
	public ArrayList<TransferCliente> readAll() throws SQLException;
	public ArrayList<TransferCliente> top10Clientes(TransferQuery topCli) throws SQLException;
}
