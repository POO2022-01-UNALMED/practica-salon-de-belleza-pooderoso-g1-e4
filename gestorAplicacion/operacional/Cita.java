package operacional;
import java.util.ArrayList;
import organizacional.*;
import java.time.*;

public class Cita {
	private int idCita;
	private Empleado empleado;
	private Cliente cliente;
	private ArrayList<Servicio> servicios = new ArrayList<Servicio>();
	private LocalDateTime fechaReserva; //año, mes, dia, hora y minutos
	private LocalDateTime fechaCita;
	private int duracion; //minutos
	private Factura factura;
	public static int NumCitas=0;
	
	
	public Cita(Empleado empleado, Cliente cliente, ArrayList<Servicio> servicios, LocalDateTime fechaReserva, LocalDateTime fechaCita, int duracion) {
		Cita.NumCitas ++;
		this.idCita = Cita.NumCitas;
		this.empleado = empleado; this.cliente = cliente; this.servicios = servicios;
		this.fechaReserva = fechaReserva; this.fechaCita = fechaCita; this.duracion = duracion; 
	}
	
	
	//Metodos get y set:
	public int getId() {
		return this.idCita;
	}
	public void setId(int id) {
		this.idCita = id;
	}
	
	public Empleado getEmpleado() {
		return this.empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<Servicio> getServicios(){
		return this.servicios;
	}
	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public LocalDateTime getFechaReserva() {
		return this.fechaReserva;
	}
	public void setFechaReserva(LocalDateTime fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public LocalDateTime getFechaCita() {
		return this.fechaCita;
	}
	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}
	
	public int getDuracion() {
		return this.duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public Factura getFactura() {
		return this.factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
}
