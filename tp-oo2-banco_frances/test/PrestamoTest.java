package test;

import datos.Cuota;
import datos.Prestamo;
import negocio.PrestamoABM;

public class PrestamoTest {
	public static void main(String[] args) {
		//Prestamo prestamo = new Prestamo(LocalDate.now(), 80.20, 5, 5, ClienteABM.getInstance().traer(2L), false);
		//int id = PrestamoABM.getInstance().agregar(prestamo);
		//System.out.println(id);
		
		//Prestamo prestamo = PrestamoABM.getInstance().traer(1L);
		//prestamo.setMonto(100000.55);
		//PrestamoABM.getInstance().modificar(prestamo);
		
		//Prestamo prestamo = PrestamoABM.getInstance().traer(1L);
		//PrestamoABM.getInstance().eliminar(prestamo);
		
		//List<Prestamo> prestamos = PrestamoABM.getInstance().traer();
		//System.out.println(prestamos);
		
		Prestamo prestamo = PrestamoABM.getInstance().traerPrestamoCuotas(2L);
		System.out.println("Prestamo: " + prestamo);
		for(Cuota cuota : prestamo.getCuotas()) {
			System.out.println("Cuota: " + cuota);
		}
	}
}
