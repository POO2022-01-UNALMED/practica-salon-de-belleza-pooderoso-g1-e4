package uiMain;

import java.time.LocalDateTime;
import java.util.*;



import gestorAplicacion.organizacional.*;
import gestorAplicacion.operacional.*;
import uiMain.funcionalidades.*;

public class Interfaz {
	public static void main(String[] args) {
		Scanner entrada =new Scanner(System.in);
		Empleado empleado1 =new Empleado("Marlon", "Nivia", 1000349061, 21, 32088456, "U�as");
		Empleado empleado2 =new Empleado("Julian", "Ospina", 525206530, 20, 3208844, "Pelo");//El numero no alcanza parce
		Administrador SuperAdministador =new Administrador("Juan","Cuadrado",123,21,444444,"12-2",2222);
		int opcion = 0;
		do {
			
			
			
			gestorInterfaz.escribir("    Que desea realizar?");
			
			gestorInterfaz.escribir("                       ");
			gestorInterfaz.escribir("1.Reservar cita");
			gestorInterfaz.escribir("2.Cancelar cita");
			gestorInterfaz.escribir("3.Facturar");
			gestorInterfaz.escribir("4. Balance Contable");
			gestorInterfaz.escribir("5.Terminar");
			gestorInterfaz.escribir("                       ");
			gestorInterfaz.escribir("Digite Opcion: ");
			opcion = Integer.parseInt(entrada.nextLine());
			
			
			
			switch(opcion) {
			case 1: GestionarCita.reservarCita(); break;
			case 2: mi2(); break;
			case 3 : Facturacion.facturar(); break;
			//case 4: BalanceContable.calcularBalance();
			case 5: System.out.println("!!Gracias por usar nuestra aplicaci�n!!");break;
			
			}
			
			
		
		}while(opcion!=5);
		
		
		//entrada.close();
	}
	
		
	
	
	public static void mi2() {
		System.out.println("cancel�");
	}
	
	
	
	
}

