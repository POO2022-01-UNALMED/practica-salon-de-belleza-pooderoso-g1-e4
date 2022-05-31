package uiMain.funcionalidades;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import gestorAplicacion.operacional.*;
import gestorAplicacion.organizacional.*;

public class Otras {
	
	public static void mostrarInventario() {
		
		String ch = " ";

		HashMap<Producto, Integer> inventarioDisponible = Inventario.getInventario();
		System.out.println("|         Producto           | Cant.|");
		for(Map.Entry<Producto, Integer> productos : inventarioDisponible.entrySet()) {
			String nombreProducto = productos.getKey().getNombreProducto();
			System.out.println("|----------------------------|------|");
			System.out.println("|" + nombreProducto + ch.repeat(28 - nombreProducto.length()) +  "|" + productos.getValue() + "    |");
		}
		System.out.println("|----------------------------|------|");
		
	}
	

}
