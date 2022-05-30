package gestorAplicacion.operacional;

 import java.io.Serializable;
import java.util.ArrayList;
 
public class Producto implements Serializable {  
	
	//-----------SERIALIZADOR-----------
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
	
	
	//-----------ATRIBUTOS-----------
	public static int numProducto = 0;
	private int productoId;
	private String nombreProducto;
	private float precioVenta;
	
	//-----------CONSTRUCTOR-----------
	public Producto(String nombreProducto, float precioVenta){
		this.productoId = Producto.numProducto;
		//this.existencias = existencias;
		this.nombreProducto = nombreProducto;
		this.precioVenta = precioVenta;
		Producto.numProducto++;
		productos.add(this);
	}
	
	//-----------GETTERS y SETTERS-----------
	public int getProductoId() {
		return productoId;
	}
	public void setProductoId(int productoId) {
		this.productoId = productoId;
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
	
	//-----------OTROS METODOS-----------
	public String toString() {
		return "El producto= "+ nombreProducto +" "+ "tiene un precio de venta de = " + precioVenta;
		
	}

	
}
