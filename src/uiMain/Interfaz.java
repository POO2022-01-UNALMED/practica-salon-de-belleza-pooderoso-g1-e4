package uiMain;

import java.util.Scanner;

import gestorAplicacion.organizacional.Administrador;
import gestorAplicacion.organizacional.Cliente;
import gestorAplicacion.organizacional.Empleado;

public class Interfaz {
	public static void main(String[] args) {
		Scanner entrada =new Scanner(System.in);
		Empleado empleado1 =new Empleado("Marlon", "Nivia", 100349061, 21, 32088456, "U�as", null, null);
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
			case 1: reservarCita(SuperAdministador); break;
			case 2: mi2(); break;
			case 3: System.out.println("!!Gracias por usar nuestra aplicaci�n!!");break;
			}
		
		}while(opcion!=3);
				
	}
	
	public static void reservarCita(Administrador SuperAdministador) {
		//Variable para la entrada de datos
		Scanner entrada =new Scanner(System.in);
		
		//Es un nuevo Cliente?
		System.out.println("1.Cliente ya existente");
		System.out.println("2.Nuevo Cliente");
		System.out.print("Digite Opcion: ");
		int TipoCliente=entrada.nextInt();
		
		if (TipoCliente==1){
			
			int cedulaEmpleado;
			System.out.println("                       ");
			//System.out.println("reserv�");
			mostrarEmpleados( SuperAdministador);
			System.out.println("                       ");
			System.out.println("Dijite la identificacion del empleado de preferencia: ");
			cedulaEmpleado=entrada.nextInt();
		}
		else {
			System.out.println("Por favor ingrese los datos del cliente");
			System.out.println("                       ");
			System.out.println("Por favor ingrese nombre del cliente: ");
			String nombre=entrada.nextLine();
			System.out.println("Por favor ingrese apellido del cliente: ");
			String apellido=entrada.nextLine();			
			System.out.println("Por favor ingrese identificai�n del cliente: ");
			int id=entrada.nextInt();
			System.out.println("Por favor ingrese edad del cliente: ");			
			int edad=entrada.nextInt();
			System.out.println("Por favor ingrese numero del cliente: ");
			int numero=entrada.nextInt();
			System.out.println("Por favor ingrese anotaciones del cliente: ");
			String anotaciones=entrada.nextLine();
			
			Cliente nuevoCliente = new Cliente(nombre, apellido, id, edad, numero, anotaciones, null, null, false);
		}
		
		
		
	}
	public static void mi2() {
		System.out.println("cancel�");
	}
	
	public static void mostrarEmpleados(Administrador SuperAdministador) {		
		for(Empleado e : SuperAdministador.empleadosAsigandos) {
			System.out.println(e);
		}
	}	
	
}

