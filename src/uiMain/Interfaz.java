package uiMain;

import java.util.Scanner;

import gestorAplicacion.organizacional.Administrador;
import gestorAplicacion.organizacional.Cliente;
import gestorAplicacion.organizacional.Empleado;

public class Interfaz {
	public static void main(String[] args) {
		Scanner entrada =new Scanner(System.in);
		Empleado empleado1 =new Empleado("Marlon", "Nivia", 1000349061, 21, 32088456, "Uñas", null, null);
		Empleado empleado2 =new Empleado("Julian", "Ospina", 525206530, 20, 3208844, "Pelo", null, null);//El numero no alcanza parce
		Administrador SuperAdministador =new Administrador("Juan","Cuadrado",123,21,444444,"12-2",2222);
		int opcion;
		do {
			System.out.println("    Que desea realizar?");
			System.out.println("                       ");
			System.out.println("1.Reservar cita");
			System.out.println("2.Cancelar cita");
			System.out.println("3.Terminar");
			System.out.println("                       ");
			System.out.print("Digite Opcion: ");
			opcion=entrada.nextInt();
			
			switch(opcion) {
			//case 1: greservarCita(SuperAdministador); break;
			//case 2: mi2(); break;
			case 3: System.out.println("!!Gracias por usar nuestra aplicación!!");break;
			}
		
		}while(opcion!=3);
				
	}
	
}

