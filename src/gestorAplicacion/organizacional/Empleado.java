package gestorAplicacion.organizacional;

import java.util.ArrayList;

import gestorAplicacion.operacional.Factura;
import gestorAplicacion.operacional.Producto;
import operacional.*;

public class Empleado extends Persona {

	private String especialidad;
	private ArrayList<Factura> serviciosRealizados = new ArrayList<Factura>();
	private ArrayList<Producto> productosVendidos = new ArrayList<Producto>();
	private double sueldo;
	
	
	public Empleado(String nombre, String apellido, int id, int edad, int numero, String especialidad, Factura factura, Producto productoVendido) {
		super(nombre, apellido, id, edad, numero);
		this.especialidad = especialidad;
		//this.serviciosRealizados.add(factura);
		//this.productosVendidos.add(productoVendido);	
		Administrador.empleadosAsigandos.add(this);//Cardinalidad de clases
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
	
}
