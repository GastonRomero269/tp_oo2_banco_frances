package negocio;

import java.util.List;

import dao.PrestamoDAO;
import datos.Prestamo;

public class PrestamoABM {
	private static PrestamoABM instance;
	
	private PrestamoABM() { }
	
	public static PrestamoABM getInstance() {
		if(instance == null) {
			instance = new PrestamoABM();
		}
		return instance;
	}
	
	public int agregar(Prestamo objeto) {
		return PrestamoDAO.getInstance().agregar(objeto);
	}
	
	public void modificar(Prestamo objeto) {
		PrestamoDAO.getInstance().modificar(objeto);
	}
	
	public void eliminar(Prestamo objeto) {
		PrestamoDAO.getInstance().eliminar(objeto);
	}
	
	public Prestamo traer(long id) {
		return PrestamoDAO.getInstance().traer(id);
	}

	public Prestamo traerPrestamoCuotas(long id) {
		return PrestamoDAO.getInstance().traerPrestamoCuotas(id);
	}
	
	public List<Prestamo> traer() {
		return PrestamoDAO.getInstance().traer();
	}
}
