package gestorAplicacion.operacional;

import java.util.*;



import java.io.Serializable;


public class Inventario implements Serializable {
	//-----------SERIALIZADOR-----------
			private static final long serialVersionUID = 1L;
			
			private static HashMap<Producto, Integer> inventario;
			private static ArrayList<Inventario> inventarios;
			static {
				inventario = new HashMap<Producto, Integer>();
				inventarios = new ArrayList<Inventario>();
			}
			

			public static HashMap<Producto, Integer> getInventario() {
					return inventario;
				}
			public static ArrayList<Inventario> getInventarios(){
				return inventarios;
			}
			
			
	//-----------ATRIBUTOS-----------
	private HashMap<Producto, Integer> listaProductos = new HashMap<Producto, Integer>();
	
	
	//-----------CONSTRUCTOR-----------
	public Inventario(HashMap<Producto, Integer> lista) {
		this.listaProductos = lista;
		Inventario.inventario = lista;
		Inventario.inventarios.add(this);
	}
	
	//-----------GETTERS y SETTERS-----------
	public HashMap<Producto, Integer> getListaProductos(){
		return this.listaProductos;
	}
	public void setListaProductos(HashMap<Producto, Integer> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
	//-----------OTROS METODOS-----------
	public void agregarProducto(Producto producto, int existencias) {
		this.listaProductos.put(producto, existencias);
		//Inventario.inventario.put(producto, existencias);
	}
	public float calcularPatrimonio() {
		float total = 0;
		for(Map.Entry<Producto, Integer> set : listaProductos.entrySet()) {
			total += set.getKey().getPrecioVenta()*set.getValue();
		}
		return total;
	}
	
	public void actualizarExistencias(Producto producto, int cantidad) {
		if(sePuedeVender(producto, cantidad)) {
			Integer oldValue = this.listaProductos.get(producto);
			this.listaProductos.put(producto,  oldValue - cantidad);
			//Inventario.inventario.put(producto, oldValue - cantidad);
		}		
	}
	
	public boolean sePuedeVender(Producto producto, int cantidad) {
		
		if(this.listaProductos.get(producto) >= cantidad) {
			return true;
		}
		
		return false;
	}
	
	public String mostrarExistencias() {
		String texto = "";
		for(Producto p: this.listaProductos.keySet()) {
			
			texto = texto + p.getNombreProducto() + " " + this.listaProductos.get(p) + " ";
			
		}
		return texto;
	}
	
	public String toString() {
		return "Cantidades= "+ this.listaProductos.values();
		
	}
}
