package uiMain.funcionalidades;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import gestorAplicacion.operacional.*;
import gestorAplicacion.organizacional.*;

public class Otras {
	
	public static void mostrarInventario() {
		
		String ch = " ";
		
		HashMap<Producto, Integer> inventarioDisponible = Inventario.getInventarios().get(0).getListaProductos();
		
		//HashMap<Producto, Integer> inventarioDisponible = Inventario.getInventario();
		System.out.println("|         Producto           | Cant.|");
		for(Map.Entry<Producto, Integer> productos : inventarioDisponible.entrySet()) {
			String nombreProducto = productos.getKey().getNombreProducto();
			System.out.println("|----------------------------|------|");
			System.out.println("|" + nombreProducto + ch.repeat(28 - nombreProducto.length()) +  "|" + productos.getValue() + ch.repeat(6 - String.valueOf(productos.getValue()).length()) + "|");
		}
		System.out.println("|----------------------------|------|");
		
	}
	
	public static void gestionarSeguros() {
		
		ArrayList<Persona> listaPersonas = Persona.getPersonas();
		
		
		for(Persona p: listaPersonas) {
			
			System.out.println(p.gestionSeguros());
			
		}
		

	}
	
	

}
