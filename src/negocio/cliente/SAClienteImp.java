package negocio.cliente;

import integracion.cliente.DAOCliente;
import integracion.factoriaDAO.FactoriaDAO;
import integracion.transacciones.conexion.Excepciones;
import integracion.transacciones.transaccion.Transaccion;
import integracion.transacciones.transactioManager.TransactionManager;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SAClienteImp implements SACliente{

	@Override
	public boolean altaCliente(TransferCliente c) throws SQLException {
	
		boolean correcto = false;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOCliente daoCli = FactoriaDAO.getInstance().generaDAOCliente();
		
		transaccion.start();
		
		
		try {
			
			TransferCliente cDao = daoCli.readByDNI(c.getDNI());
			
			if(( cDao != null)) {
				
				if(cDao.getActivo()) {
					transaccion.rollback();
					throw new Excepciones("Ya existe cliente");
				}
				//Si no esta activo lo reactivamos
				else {
					c.setIDCliente(cDao.getIDCliente());
					correcto = daoCli.update(c);
					transaccion.commit();
				}
			}
			else if(c.getNombre().equals("") || c.getApellidos().equals("")){
				transaccion.rollback();
				throw new Excepciones("Es necesario introducir Nombre y Apellidos");
			}
			//Socio
			else if (c.getLimiteCredito() > 0){
				
				if(c.getNewsletter()) {
					transaccion.rollback();
					throw new Excepciones("Un Socio no puede tener Newsletter");
				}
				else {
					correcto = daoCli.create(c);
					transaccion.commit();
				}
			}
			//No socio
			else {
				correcto = daoCli.create(c);
				transaccion.commit();
			}
		}
		catch (Excepciones e){
			transaccion.rollback();
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return correcto;
	}

	@Override
	public boolean bajaCliente(int IDCliente) throws SQLException {

		boolean correcto = false;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOCliente daoCli = FactoriaDAO.getInstance().generaDAOCliente();
		
		transaccion.start();
		
		try {
			TransferCliente c = daoCli.readById_Cliente(IDCliente);
			if(c == null) {
				throw new Excepciones("El cliente no existe");
			}
			else {
				if(c.getActivo()) {
					correcto = daoCli.bajaCliente(IDCliente);
					transaccion.commit();
				}
				else {
					transaccion.rollback();
					throw new Excepciones("El cliente ya esta dado de baja");
				}
			}
			
		}
		catch (Excepciones e){
			transaccion.rollback();
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return correcto;
		
	}

	@Override
	public boolean modificarCliente(TransferCliente c) throws SQLException {
		
		boolean correcto = false;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOCliente daoCli = FactoriaDAO.getInstance().generaDAOCliente();
		
		transaccion.start();
		
		try {
			if(c == null) {
				transaccion.rollback();
				throw new Excepciones("El transfer es null");
			}
			else if((daoCli.readById_Cliente(c.getIDCliente()) == null)) {
				transaccion.rollback();
				throw new Excepciones("No existe cliente");
			}
			else if(c.getNombre().equals("") || c.getApellidos().equals("")){
				transaccion.rollback();
				throw new Excepciones("Es necesario introducir Nombre y Apellidos");
			}
			//Socio
			else if (c.getLimiteCredito() > 0){
				
				if(c.getNewsletter()) {
					transaccion.rollback();
					throw new Excepciones("Un Socio no puede tener Newsletter");
				}
				else {
					correcto = daoCli.update(c);
					transaccion.commit();
				}
			}
			//No socio
			else {
				correcto = daoCli.update(c);
				transaccion.commit();
			}
			
		}
		catch (Excepciones e){
			transaccion.rollback();
			throw e;
			
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return correcto;
	}

	
	public TransferCliente consultarUnCliente(int IDCliente) throws SQLException {
		
		TransferCliente c = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOCliente daoCli = FactoriaDAO.getInstance().generaDAOCliente();
		
		transaccion.start();
		
		try {
			c = daoCli.readById_Cliente(IDCliente);
		}
		catch (Excepciones e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return c;
	}
	


	@Override
	public ArrayList<TransferCliente> listarClientes() throws SQLException {

		ArrayList<TransferCliente> listaClientes = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOCliente daoCli = FactoriaDAO.getInstance().generaDAOCliente();
		
		transaccion.start();
		
		try {
			listaClientes = daoCli.readAll();
		}
		catch (Excepciones e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return listaClientes;
	}

	@Override
	public ArrayList<TransferCliente> topTenClientes(TransferQuery topCli) throws SQLException {

		ArrayList<TransferCliente> listaTopClientes = null;
		TransactionManager t = TransactionManager.getInstance();
		Transaccion transaccion = t.nuevaTransaccion();
		DAOCliente daoCli = FactoriaDAO.getInstance().generaDAOCliente();


		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaIni = null;
        Date fechaFin = null;
        try {
            fechaIni = formato.parse(topCli.getFechaInicio());
            fechaFin = formato.parse(topCli.getFechaFin());
            
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
		
		
		transaccion.start();
		
		try {
			if(topCli.getnEuros() <= 0) {
				throw new Excepciones("La cantidad de euros debe ser mayor que 0");
			}
			//Comprobar que la fecha inicial es anterior a la final
			else if(!fechaIni.before(fechaFin)) {
				throw new Excepciones("La fecha inicial es posterior a la final");
			}
			else {
				listaTopClientes = daoCli.top10Clientes(topCli);
				if(listaTopClientes.isEmpty()) {
					transaccion.rollback();
					throw new Excepciones("La lista esta vacia");
				}	
			}	
		}
		catch (Excepciones e){
			throw e;
		}
		finally {
			t.eliminaTransaccion();
		}
		
		
		return listaTopClientes;
	}

}
