package gestorAplicacion.operacional;


import gestorAplicacion.organizacional.Empleado;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venta implements Serializable {  
		
		//-----------SERIALIZADOR-----------
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
		
	
		

	//-----------ATRIBUTOS-----------
	private Producto productoVendido;
	private int idVenta;
	private int cantidadVendida;
	private Empleado empleadoComision;
	private LocalDateTime fechaVenta;
	private double comision;
	private Inventario inventario;
	public final static double porcentajeComision = 0.2;
	public static int numVenta;
	
	
	//-----------CONSTRUCTOR-----------
	public Venta(Producto productoVendido, Empleado empleadoComision, LocalDateTime fechaVenta, int cantidadVendida, Inventario inventario) {
		this.productoVendido = productoVendido;
		this.empleadoComision = empleadoComision;
		this.empleadoComision.setProductosVendidos(productoVendido);
		this.fechaVenta = fechaVenta;
		this.cantidadVendida = cantidadVendida;
		Venta.numVenta++;
		this.idVenta = Venta.numVenta;
		this.inventario = inventario;
		this.inventario.actualizarExistencias(productoVendido, cantidadVendida);
		
		ventas.add(this); //del serializador
	}
	
	

	//-----------GETTERS y SETTERS-----------
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

	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	public int getCantidadVendida() {
		return this.cantidadVendida;
	}
	
	//-----------OTROS METODOS-----------
	public String toString() {
		return "El empleado "+ empleadoComision.getNombre() +" "+empleadoComision.getApellido()+" "+""
				+ " realiza una venta de "+ productoVendido.getNombreProducto() + " en la fecha "+ fechaVenta+" y recibe una comisión de: " 
				+ calcularComision(productoVendido);
	}
	public double calcularComision(Producto productoVendido) {
		comision= this.productoVendido.getPrecioVenta() * porcentajeComision;
		
		return comision;
	}    
}
