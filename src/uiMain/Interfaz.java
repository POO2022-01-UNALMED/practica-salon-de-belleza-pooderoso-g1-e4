package uiMain;
import gestorAplicacion.operacional.*;
import gestorAplicacion.organizacional.*;
import java.util.Scanner;

public class Interfaz {
	

	public static void main(String[] args) {
		
		
		Producto gomina = new Producto(101, 21, "Gomina", 2500);
		Producto keratina = new Producto(102, 18, "Keratina", 35000);
		Producto decolorante = new Producto(103, 8, "decolorante", 21000);
	
		String bandera = "";
		do {
			
			System.out.println("Por favor ingrese una opción");
			Scanner sc = new Scanner (System.in);
			
			
			switch(sc.next()) {
			case "1":
				System.out.println("Seleccione el producto");
				Scanner codProducto = new Scanner (System.in);
				
				
				
			}
			
		}while(!"exit".equals(bandera));
			
	}

}
