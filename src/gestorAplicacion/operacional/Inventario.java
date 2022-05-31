package gestorAplicacion.operacional;

import java.util.*;



import java.io.Serializable;


public class Inventario implements Serializable {
	//-----------SERIALIZADOR-----------
			private static final long serialVersionUID = 1L;
			
			private static HashMap<Producto, Integer> inventario;
			static {
				inventario = new HashMap<Producto, Integer>();
			}
			

			public static HashMap<Producto, Integer> getInventario() {
					return inventario;
				}
			
			
	//-----------ATRIBUTOS-----------
	private HashMap<Producto, Integer> listaProductos = new HashMap<Producto, Integer>();
	
	
	//-----------CONSTRUCTOR-----------
	public Inventario(HashMap<Producto, Integer> lista) {
		this.listaProductos = lista;
		Inventario.inventario = lista;	
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
		Inventario.inventario.put(producto, existencias);
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
			Inventario.inventario.put(producto, oldValue - cantidad);
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
	// Caso de uso:
	/*
	public static void main(String[] args) {
		Producto p1 = new Producto("Shampoo",15000), p2= new Producto("Gomina",12000), p3 = new Producto("Esmalte",10000);
		HashMap<Producto, Integer> listaInventario = new HashMap<Producto, Integer>();
		listaInventario.put(p1, 10);
		listaInventario.put(p2,15);
		listaInventario.put(p3,25);
		Inventario inv = new Inventario(listaInventario);
		System.out.println(inv.calcularPatrimonio());
		inv.actualizarExistencias(p1, 5);
		System.out.println(inv.getListaProductos());
		System.out.println(inv.calcularPatrimonio());
	}
	*/
}
