package negocio;

import java.util.List;

import dao.ClienteDAO;
import datos.Cliente;

public class ClienteABM {
	private static ClienteABM instance;
	
	private ClienteABM() { }
	
	public static ClienteABM getInstance() {
		if(instance == null) {
			instance = new ClienteABM();
		}
		return instance;
	}
	
	public int agregar(Cliente objeto) {
		return ClienteDAO.getInstance().agregar(objeto);
	}
	
	public void modificar(Cliente objeto) {
		ClienteDAO.getInstance().modificar(objeto);
	}
	
	public void eliminar(Cliente objeto) {
		ClienteDAO.getInstance().eliminar(objeto);
	}
	
	public Cliente traer(long id) {
		return ClienteDAO.getInstance().traer(id);
	}
	
	public Cliente traerClientePrestamos(long id) {
		return ClienteDAO.getInstance().traerClientePrestamos(id);
	}
	
	public List<Cliente> traer() {
		return ClienteDAO.getInstance().traer();
	}
}
