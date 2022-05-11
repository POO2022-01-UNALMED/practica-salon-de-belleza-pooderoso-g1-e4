package gestorAplicacion.operacional;


import gestorAplicacion.organizacional.Empleado;


import java.io.Serializable;
import java.util.ArrayList;

public class Venta implements Serializable {  //implements del serializable
		
		//todo esto es del serializador
		private static final long serialVersionUID = 1L;
		
		private static ArrayList<Venta> ventas;
		static {
			ventas = new ArrayList<Venta>();
		}
		

		public static ArrayList<Venta> getVentas() {
				return ventas;
			}

			public static void setVentas(ArrayList<Venta> ventas) {
				Venta.ventas = ventas;
			}
		
	
		//también en cada constructor se debe poner el add al array
		// ahora si el codigo

	
	private Producto productoVendido;
	private int idVenta;
	private int cantidadVendida;
	private Empleado empleadoComision;
	private String fechaVenta;
	private double comision;
	public final static double porcentajeComision = 0.2;
	public static int numVenta;
	
	
	public Venta(Producto productoVendido, Empleado empleadoComision, String fechaVenta, int cantidadVendida) {
		this.productoVendido = productoVendido;
		this.empleadoComision = empleadoComision;
		this.fechaVenta = fechaVenta;
		this.cantidadVendida = cantidadVendida;
		Venta.numVenta++;
		this.idVenta = Venta.numVenta;
		ventas.add(this);
	}
	
	//cálculo comisión
	public double calcularComision(Producto productoVendido) {
		comision= this.productoVendido.getPrecioVenta() * porcentajeComision;
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
	
	public int getCantidadVendida() {
		return this.cantidadVendida;
	}
	
	
	public String toString() {
		return "El empleado "+ empleadoComision.getNombre() +" "+empleadoComision.getApellido()+" "+""
				+ " realizó una venta de "+ productoVendido.getNombreProducto() + " el día"+ fechaVenta+" y recibirá una comisión de: " 
				+ calcularComision(productoVendido);
		
	}
}
