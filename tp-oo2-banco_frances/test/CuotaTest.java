package test;

import java.util.List;

import datos.Cuota;
import negocio.CuotaABM;

public class CuotaTest {
	public static void main(String[] args) {
		//Cuota cuota = new Cuota(LocalDate.now(), 60.20, 20.20, 20.20, 20.20, 20.20, false, LocalDate.now(), 20.20, PrestamoABM.getInstance().traer(2L));
		//int id = CuotaABM.getInstance().agregar(cuota);
		//System.out.println(id);
		
		//Cuota cuota = CuotaABM.getInstance().traer(1L);
		//cuota.setSaldoPendiente(200000.20);
		//CuotaABM.getInstance().modificar(cuota);
		
		//Cuota cuota = CuotaABM.getInstance().traer(1L);
		//CuotaABM.getInstance().eliminar(cuota);
		
		List<Cuota> cuotas = CuotaABM.getInstance().traer();
		System.out.println(cuotas);
	}
}
