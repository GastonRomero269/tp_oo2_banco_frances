package test;

import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;
import negocio.ClienteABM;

public class ClienteTest {
	public static void main(String[] args) {
		//Cliente cliente = new Cliente("a", "a", 1L, LocalDate.now(), false);
		//int id = ClienteABM.getInstance().agregar(cliente);
		//System.out.println(id);
		
		//Cliente cliente = ClienteABM.getInstance().traer(1L);
		//cliente.setApellido("b");
		//cliente.setNombre("b");
		//ClienteABM.getInstance().modificar(cliente);
		
		//Cliente cliente = ClienteABM.getInstance().traer(1L);
		//ClienteABM.getInstance().eliminar(cliente);
		
		//List<Cliente> clientes = ClienteABM.getInstance().traer();
		//System.out.println(clientes);
		
		Cliente cliente = ClienteABM.getInstance().traerClientePrestamos(2L);
		System.out.println("Cliente: " + cliente);
		for(Prestamo prestamo : cliente.getPrestamos()) {
			System.out.println("Prestamo: " + prestamo);
			for(Cuota cuota : prestamo.getCuotas()) {
				System.out.println("Cuota: " + cuota);
			}
		}
	}
}
