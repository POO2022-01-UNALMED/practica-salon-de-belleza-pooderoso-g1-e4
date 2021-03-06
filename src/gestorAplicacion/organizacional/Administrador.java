package gestorAplicacion.organizacional;
import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.operacional.Cita;
import gestorAplicacion.operacional.Servicio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.*;


public class Administrador extends Persona implements Serializable, Salario {  
	
	//-----------SERIALIZADOR-----------
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Administrador> administradores;
	static {
		administradores = new ArrayList<Administrador>();
	}
	
	
	public static ArrayList<Administrador> getAdministradores() {
		return administradores;
	}

	public static void setAdministradores(ArrayList<Administrador> administradores) {
		Administrador.administradores = administradores;
	}


	
	//-----------ATRIBUTOS DE INSTANCIA-----------
	private String horarioLaboral;
	private int nomina;
	private double sueldo;
	private final int duracionMesesSeguro = 1;
	private final String nivelARL = "II"; 
	
	
	//-----------ATRIBUTOS DE CLASE-----------
	public static ArrayList<Cliente> clientes =new ArrayList<Cliente>(); 
	public static ArrayList<Empleado> empleadosAsigandos= new ArrayList<Empleado>();
	
	
	//-----------CONSTRUCTOR-----------
	public Administrador(String nombre, String apellido, int id, int edad, int numero, String horarioLaboral, int nomina ) {
		super(nombre, apellido, id, edad, numero);
		this.horarioLaboral=horarioLaboral;
		this.nomina=nomina;
		this.empleadosAsigandos = empleadosAsigandos;	
		this.sueldo = Salario.SALARIO_BASE * 3;
		administradores.add(this);
	}
	
	
	//-----------GETTERS y SETTERS-----------
	public String getHorarioLaboral() {
		return horarioLaboral;
	}
	public void setHorarioLaboral(String horarioLaboral) {
		this.horarioLaboral = horarioLaboral;
	}
	public int getNomina() {
		return nomina;
	}


	public void setNomina(int nomina) {
		this.nomina = nomina;
	}
	public ArrayList<Empleado> getEmpleadosAsigandos() {
		return empleadosAsigandos;
	}
	public void setEmpleadosAsigandos(ArrayList<Empleado> empleadosAsigandos) {
		Administrador.empleadosAsigandos = empleadosAsigandos;
	}
	
	public double getSueldo(){
		return this.sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public void aumentarSueldo(double porcentaje) {
		setSueldo(this.sueldo*(1+porcentaje));
	}
	public double calcularPrima() {
		return this.sueldo*0.5;
	}
	
	
	
	
	//-----------METODO ABSTRACTOS-----------
	public String gestionSeguros() {
			
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		return "El administrador " + this.getNombre() + " " + this.getApellido() +  " con ARL " + this.nivelARL +  " esta asegurado de " + super.getInicioVinculacion().format(formato) + " a " + super.getInicioVinculacion().plusMonths(this.duracionMesesSeguro).format(formato);
			
	}

	
	//-----------OTROS METODOS-----------
	@Override
	public String toString() {
		return "Administrador [horarioLaboral=" + horarioLaboral + ", nomina=" + nomina + ", empleadosAsigandos="
				+ empleadosAsigandos + "fecha registro " + super.getInicioVinculacion() +"]";
	}

	//Metodo para crear nuevo cliente desde administrador
	public static Cliente NuevoCliente(String nombre, String apellido, int id, int edad, int numero, String anotaciones) {
		return new Cliente(nombre, apellido, id, edad, numero, anotaciones);
	}
	
	//Metodo para crear nuevo cliente desde administrador solo para datos obligatorios
	public static Cliente NuevoCliente(String nombre, String apellido, int id) {
		return new Cliente(nombre, apellido, id);
	}
	
	
	//Metodo para consilidar una nueva cita-
	public static Cita consolidarCita(Empleado empleado, Cliente cliente, ArrayList<Servicio> servicios, LocalDateTime fechaReserva, LocalDateTime fechaCita){
	    int duracion= Cita.duracionCita(servicios);
		Cita nuevaCita=new Cita( empleado,  cliente, servicios,fechaReserva, fechaCita, duracion);
		return nuevaCita;
	}
	
	public static void consolidarCancelacion(Cita cita) {
		cita.setEstado("Cancelada");
		
	}

	

	
}
