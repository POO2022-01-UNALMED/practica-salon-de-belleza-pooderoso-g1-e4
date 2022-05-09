package operacional;

import operacional.Producto;
import organizacional.Empleado;

public class Venta {

	Producto productoVendido;
	Empleado empleadoComision;
	private String fechaVenta;
	private double comision;
	public final static double porcentajeComision = 0.2;
	
	
	public Venta(Producto productoVendido, Empleado empleadoComision, String fechaVenta) {
		this.productoVendido = productoVendido;
		this.empleadoComision = empleadoComision;
		this.fechaVenta = fechaVenta;
	}
	
	//cálculo comisión
	public double calcularComision(Producto productoVendido) {
		comision= this.productoVendido.costo * porcentajeComision;
		return comision;
	}    //crear lista de comisiones de cada empleado, en la clase empleado
	

	public Producto getProductoVendido() {
		return productoVendido;
	}

	public void setProductoVendido(Producto productoVendido) {
		this.productoVendido = productoVendido;
	}

	public Empleado getEmpleadoComision() {
		return empleadoComision;
	}

	public void setEmpleadoComision(Empleado empleadoComision) {
		this.empleadoComision = empleadoComision;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	public String toString() {
		return "El empleado "+ empleadoComision.nombre +" "+empleadoComision.apellido+" "+""
				+ " realizó una venta de "+ productoVendido.nombre + " el día"+ fechaVenta+" y recibirá una comisión de: " 
				+ calcularComision(productoVendido);
		
	}
}
