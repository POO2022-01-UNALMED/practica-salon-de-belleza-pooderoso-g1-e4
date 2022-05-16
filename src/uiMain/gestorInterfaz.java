package uiMain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.operacional.Factura;
import gestorAplicacion.operacional.Servicio;
import gestorAplicacion.organizacional.Administrador;
import gestorAplicacion.organizacional.Cliente;
import gestorAplicacion.organizacional.Empleado;

public class gestorInterfaz {
	
	//metodos de entrada y salida por consola
	
	private static Scanner input = new Scanner(System.in);
	
    /**
     * Imprime un objeto en la consola y salta una línea
     *
     * @param x El objeto a ser impreso.
     */ 
	public static void escribir(Object x) {
	       System.out.println(x);
	   }
	
    /**
     * Retorna un dato colocado por el usuario en la consola como String
     *
     * @return El dato colocado por el usuario en la consola como String
     */
	public static String leer() {
        return input.nextLine();
    }
	
    /**
     * Muestra al usuario un mensaje y luego retorna un dato colocado por el
     * usuario en la consola como String
     *
     * @param mensaje El mensaje que el usuario verá antes de ingresar un dato.
     * @return El dato colocado por el usuario en la consola como String
     */
    public static String leer(String mensaje) {
    	gestorInterfaz.escribir(mensaje);
        return input.nextLine();
    }	
	
    /**
     * Muestra al usuario un mensaje y luego retorna un dato colocado por el
     * usuario en la consola como entero
     *
     * @return El dato colocado por el usuario en la consola como entero
     * @throws NumberFormatException si el dato ingresado no representa un
     * entero.
     */
    public static int leerEntero() {
        return Integer.parseInt(gestorInterfaz.leer());
    }   
    
    /**
     * Muestra al usuario un mensaje y luego retorna un dato colocado por el
     * usuario en la consola como entero
     *
     * @param mensaje El mensaje que el usuario verá antes de ingresar un dato.
     * @return El dato colocado por el usuario en la consola como entero
     * @throws NumberFormatException si el dato ingresado no representa un
     * entero.
     */
    public static int leerEntero(String mensaje) {
        return Integer.parseInt(gestorInterfaz.leer(mensaje));
    }
    
	
	

}
