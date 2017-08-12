package negocio.cliente;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SACliente {
	public boolean altaCliente(TransferCliente c) throws SQLException;
	public boolean bajaCliente(int IDCliente) throws SQLException;
	public boolean modificarCliente(TransferCliente c) throws SQLException;
	public TransferCliente consultarUnCliente(int IDCliente) throws SQLException;
	public ArrayList<TransferCliente> listarClientes() throws SQLException;
	public ArrayList<TransferCliente> topTenClientes(TransferQuery topCli) throws SQLException;
}