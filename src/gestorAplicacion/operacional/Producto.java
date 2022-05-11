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
	
	//también en cada constructor se debe poner el add al array
	// ahora si el codigo
	
	
	//falta el constructor.
	
	private String productoId;
	private int existencias;
	private String nombreProducto;
	private float precioVenta;
	

	
	public String getProductoId() {
		return productoId;
	}
	public void setProductoId(String productoId) {
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
	
	//metodo de vendido
	
	
	
	
}
