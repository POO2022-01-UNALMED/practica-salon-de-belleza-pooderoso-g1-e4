 package gestorAplicacion.operacional;

 import java.io.Serializable;
import java.util.ArrayList;
 
public class Producto implements Serializable {  //implements del serializable
	
	//todo esto es del serializador
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Producto> productos;
	static {
		productos = new ArrayList<Producto>();
	}
	
	public static ArrayList<Producto> getProductos() {
		return productos;
	}
	public static void setProductos(ArrayList<Producto> productos) {
		Producto.productos = productos;
	}
	
	
	// ahora si el codigo
	
	private int productoId;
	private int existencias;
	private String nombreProducto;
	private float precioVenta;
	
	
	
	public Producto(int productoId, int existencias, String nombreProducto, float precioVenta){
		this.productoId = productoId;
		this.existencias = existencias;
		this.nombreProducto = nombreProducto;
		this.precioVenta = precioVenta;
		productos.add(this);
	}
	
	public int getProductoId() {
		return productoId;
	}
	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}
	public int getExistencias() {
		return existencias;
	}
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	public void actualizarExistencias(int cantidad) {
		if(this.existencias >= cantidad) {
			
			this.existencias = this.existencias - cantidad;
		}		
	}
	
	public boolean sePuedeVender(int cantidad) {
		if(this.existencias >= cantidad) {
			return true;
		}
		
		return false;
	}

	
}
