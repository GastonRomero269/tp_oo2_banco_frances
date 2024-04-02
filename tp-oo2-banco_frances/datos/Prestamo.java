package datos;

import java.time.LocalDate;
import java.util.Set;

public class Prestamo {
	private long idPrestamo;
	private LocalDate fecha;
	private double monto;
	private double intereses;
	private int cantCuotas;
	private Cliente cliente;
	private boolean cancelado;
	private Set<Cuota> cuotas;

	public Prestamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prestamo(LocalDate fecha, double monto, double intereses, int cantCuotas, Cliente cliente,
			boolean cancelado) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.intereses = intereses;
		this.cantCuotas = cantCuotas;
		this.cliente = cliente;
		this.cancelado = cancelado;
	}

	public long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getIntereses() {
		return intereses;
	}

	public void setIntereses(double intereses) {
		this.intereses = intereses;
	}

	public int getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public Set<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(Set<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", fecha=" + fecha + ", monto=" + monto + ", intereses="
				+ intereses + ", cantCuotas=" + cantCuotas + ", cancelado=" + cancelado + "]";
	}

}
