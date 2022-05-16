package gestorAplicacion.operacional;

import java.util.ArrayList;
import java.util.HashMap;

import java.io.Serializable;


public class Inventario {
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	public Inventario(ArrayList<Producto> lista) {
		this.listaProductos = lista;
	}
	
	public ArrayList<Producto> getListaProductos(){
		return this.listaProductos;
	}
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	public void agregarProducto(Producto producto) {
		this.listaProductos.add(producto);
	}
	public float calcularPatrimonio() {
		float total = 0;
		for(Producto p: this.listaProductos) {
			total += p.getPrecioVenta()*p.getExistencias();
		}
		return total;
	}
}
