package gestorAplicacion.organizacional;

import java.util.ArrayList;
import java.io.Serializable;
import java.time.*;

import gestorAplicacion.operacional.*;



public class Empleado extends Persona implements Serializable,Comparable<Empleado>, Salario {  //implements del serializable

	
	//todo esto es del serializador
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Empleado> empleados;
	static {
		empleados = new ArrayList<Empleado>();
	}
	
	public static ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public static void setEmpleados(ArrayList<Empleado> empleados) {
		Empleado.empleados = empleados;
	}


	//también en cada constructor se debe poner el add al array
	// ahora si el codigo


	private String idEmpleado;
	private String especialidad;
	private ArrayList<Factura> serviciosRealizados = new ArrayList<Factura>();
	private ArrayList<Cita> citasAsignadas = new ArrayList<Cita>();//---------------------------
	private ArrayList<Producto> productosVendidos = new ArrayList<Producto>();
	private double sueldo;
	
	//Constantes de tiempos de atenci�n de los empleados (9 am - 6 pm)
	
	public final static LocalTime HoraInicio = LocalTime.of(9, 0,0,0);
	public final static LocalTime HoraFinal = LocalTime.of(18, 0,0,0);
	
	
	public Empleado(String nombre, String apellido, int id, int edad, int numero, String especialidad) {
		super(nombre, apellido, id, edad, numero);		
		this.especialidad = especialidad;
		this.sueldo =  Salario.SALARIO_BASE;
		
		Administrador.empleadosAsigandos.add(this);//Cardinalidad de clases
		empleados.add(this);
	}
	

	
	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public ArrayList<Factura> getServiciosRealizados() {
		return serviciosRealizados;
	}

	public void setServiciosRealizados(Factura servicio) {
		this.serviciosRealizados.add(servicio);
	}

	public ArrayList<Producto> getProductosVendidos() {
		return productosVendidos;
	}

	public void setProductosVendidos(Producto producto) {
		this.productosVendidos.add(producto);
	}

	public double getSueldo() {
		return this.sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public void aumentarSueldo(double porcentaje) {
		setSueldo(this.sueldo*(1+porcentaje));
	}
	
	
	public ArrayList<Cita> getCitasAsignadas() {
		return citasAsignadas;
	}

	public void setCitasAsignadas(ArrayList<Cita> citasAsignadas) {
		this.citasAsignadas = citasAsignadas;
	}

	@Override
	public String toString() {
		return "nombre= " + super.getNombre() + ", especialista= " + this.getEspecialidad()+ ", id: "+this.getId();
	}
	
	public String getIdEmpleado() {
		return idEmpleado;
	}

	@Override
	public int compareTo(Empleado o) {
		
		return 0;
	}
	
}
