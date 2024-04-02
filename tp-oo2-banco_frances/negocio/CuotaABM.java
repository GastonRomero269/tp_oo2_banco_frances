package negocio;

import java.util.List;

import dao.CuotaDAO;
import datos.Cuota;

public class CuotaABM {
	private static CuotaABM instance;
	
	private CuotaABM() { }
	
	public static CuotaABM getInstance() {
		if(instance == null) {
			instance = new CuotaABM();
		}
		return instance;
	}
	
	public int agregar(Cuota objeto) {
		return CuotaDAO.getInstance().agregar(objeto);
	}
	
	public void modificar(Cuota objeto) {
		CuotaDAO.getInstance().modificar(objeto);
	}
	
	public void eliminar(Cuota objeto) {
		CuotaDAO.getInstance().eliminar(objeto);
	}
	
	public Cuota traer(long id) {
		return CuotaDAO.getInstance().traer(id);
	}
	
	public List<Cuota> traer() {
		return CuotaDAO.getInstance().traer();
	}
}
