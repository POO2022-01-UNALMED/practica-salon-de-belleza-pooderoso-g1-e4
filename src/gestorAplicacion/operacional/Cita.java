package gestorAplicacion.operacional;

import java.util.ArrayList;


import gestorAplicacion.organizacional.Cliente;
import gestorAplicacion.organizacional.Empleado;

import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Cita implements Serializable {  
	
	//-----------SERIALIZADOR-----------
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Cita> citas;
	static {
		citas = new ArrayList<Cita>();
	}
	
	public static ArrayList<Cita> getCitas() {
		return citas;
	}


	public static void setCitas(ArrayList<Cita> citas) {
		Cita.citas = citas;
		
	}
	
	
	//-----------ATRIBUTOS-----------
	private int idCita;
	private String estado;
	private Empleado empleado;
	private Cliente cliente;
	private ArrayList<Servicio> servicios = new ArrayList<Servicio>();
	private LocalDateTime fechaReserva; //a�o, mes, dia, hora y minutos
	private LocalDateTime fechaCita;
	private int duracion; //minutos
	private Factura factura;
	public static int NumCitas=0;
	
	
	//-----------CONSTRUCTOR-----------
	public Cita(Empleado empleado, Cliente cliente, ArrayList<Servicio> servicios, LocalDateTime fechaReserva, LocalDateTime fechaCita, int duracion) {
		Cita.NumCitas ++;
		this.idCita = Cita.NumCitas;
		this.estado="Pendiente";
		this.empleado = empleado; this.cliente = cliente; this.servicios = servicios;
		this.fechaReserva = fechaReserva; 
		this.fechaCita = fechaCita; 
		this.duracion = duracion; 
		cliente.addCita(this);

		empleado.getCitasAsignadas().add(this);//Se le anade una a la lista de citas el empleado

		
		
		citas.add(this);//del Serializador
	}
	
	
	//-----------GETTERS Y SETTERS-----------
	public int getId() {
		return this.idCita;
	}
	public void setId(int id) {
		this.idCita = id;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public void setEstado(String estado) {
		this.estado=estado;
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

	
	
	//-----------OTROS METODOS-----------
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");	
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");	
		return  cliente + ", fecha de la cita: " + fechaCita.format(format) + ", duracion:" + duracion + ". Termina a las "+ fechaCita.plusMinutes(duracion).format(formatter)+". "+ estado;
	}
	
	
	
}
