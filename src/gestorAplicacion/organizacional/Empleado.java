package gestorAplicacion.organizacional;

import java.util.ArrayList;
import java.io.Serializable;
import java.time.*;

import gestorAplicacion.operacional.Factura;
import gestorAplicacion.operacional.Producto;

public class Empleado extends Persona implements Serializable {  //implements del serializable
	
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
	private ArrayList<Producto> productosVendidos = new ArrayList<Producto>();
	private double sueldo;
	
	//Constantes de tiempos de atenci�n de los empleados (9 am - 6 pm)
	
	public final static LocalTime HoraInicio = LocalTime.of(9, 0,0,0);
	public final static LocalTime HoraFinal = LocalTime.of(18, 0,0,0);
	
	
	public Empleado(String nombre, String apellido, int id, int edad, int numero, String especialidad) {
		super(nombre, apellido, id, edad, numero);		
		this.especialidad = especialidad;
		Administrador.empleadosAsigandos.add(this);//Cardinalidad de clases
		empleados.add(this);
	}
	
	public void calcularSueldo() {//poner metodo en nomina
		double montoServicios = 0;
		for(Factura factura : serviciosRealizados) {
			montoServicios = montoServicios + factura.getPrecioTotal();
		}
		
		this.sueldo = montoServicios;
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
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	@Override
	public String toString() {
		return "nombre= " + super.getNombre() + ", especialista= " + this.getEspecialidad() + ", sueldo = "  + this.getSueldo() + ", productos vendidos= " + this.getProductosVendidos() + ", servicios realizados= " + this.getServiciosRealizados();
	}
	
	public String getIdEmpleado() {
		return idEmpleado;
	}
	
}
