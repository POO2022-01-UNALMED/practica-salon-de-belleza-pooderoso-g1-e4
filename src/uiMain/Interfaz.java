package uiMain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.*;

import baseDatos.*;

import static java.util.Map.entry; 


import gestorAplicacion.organizacional.*;
import gestorAplicacion.operacional.*;
import uiMain.funcionalidades.*;

public class Interfaz {
	public static void main(String[] args) {
		

		// Deserializar todos los objetos.
		Deserializador.deserializarTodo();
			
		Scanner entrada =new Scanner(System.in);
		
		if (Administrador.getAdministradores().isEmpty()) {
			
			
		Administrador superAdministador =new Administrador("Juan","Cuadrado",123,21,444444,"12-2",2222);
	
		
		Producto gomina = new Producto("Gomina", 2500);
		Producto keratina = new Producto("keratina", 30000);
		Producto colagenoCapilar = new Producto("Colageno Capilar", 3000);
		Producto balsamo = new Producto("Balsamo", 1500);
		Producto esmalte = new Producto("Esmalte", 4000);
		Producto removedor = new Producto("Removedor", 5500);
		Producto acondicionador  = new Producto("Acondicionador", 700);
		
		Map<Producto, Integer> cantidadProductos = Map.ofEntries(entry(gomina, 10), entry(keratina, 15),
				entry(colagenoCapilar, 20), entry(balsamo,10),
				entry(esmalte,100),entry(removedor,12),entry(acondicionador,30)
				);
		HashMap<Producto, Integer> cantidadHash = new HashMap<>(cantidadProductos);
	
		Inventario inv = new Inventario(cantidadHash);

				
		Cliente c1 = new Cliente("Julian", "Londono",10013,21,3212345,"Ninguna",true), c2 = new Cliente("Pepito","Martinez",5234,24,32156778,"Ninguna", false);
		ArrayList<Servicio> s1 = new ArrayList<>(List.of(Servicio.ALIZADO, Servicio.CEJAS, Servicio.CORTE_CABALLERO));
		ArrayList<Servicio> s2 = new ArrayList<>(List.of(Servicio.CEJAS));
		ArrayList<Servicio> s3 = new ArrayList<>(List.of(Servicio.DEPILACION_LASER, Servicio.EXFOLIACION_FACIAL));
		ArrayList<Servicio> s4 = new ArrayList<>(List.of(Servicio.CORTE_DAMA));
		
		Empleado empleado1 =new Empleado("Marlon", "Nivia", 1000349061, 21, 32088456, "U�as");
		Empleado empleado2 =new Empleado("Julian", "Ospina", 525206530, 20, 3208844, "Pelo");
	
		
		Cita cita1 = new Cita(empleado1, c1, s1,  LocalDateTime.of(2022, 5,1,12,0), LocalDateTime.of(2022, 5,30,14,0),60);
		Cita cita2 = new Cita(empleado2, c1, s2,  LocalDateTime.of(2022, 5,10,12,0), LocalDateTime.of(2022, 5,31,14,0),60);
		Cita cita3 = new Cita(empleado1, c2, s3,  LocalDateTime.of(2022, 5,1,12,0), LocalDateTime.of(2022, 6,15,14,0),60);
		Cita cita4 = new Cita(empleado1, c1, s4,  LocalDateTime.of(2022, 5,3,12,0), LocalDateTime.of(2022, 8,21,14,0),60);
		
		
		Venta venta1 = new Venta(gomina, empleado1, LocalDateTime.of(2022, 5,10,12,0),5, inv);
		Venta venta2 = new Venta(keratina, empleado2, LocalDateTime.of(2022, 8,14,12,0),5, inv);
		
		HashMap<Producto, Integer> stockInicial = new HashMap<Producto, Integer>();
		stockInicial.put(gomina, 23);
		stockInicial.put(keratina, 11);
		stockInicial.put(colagenoCapilar, 34);
		stockInicial.put(balsamo, 21);
		stockInicial.put(esmalte, 34);
		
		//Inventario
		Inventario inventario = new Inventario(stockInicial);
		}
		

		
		int opcion = 0;
		
		do {
			
			try {		
				gestorInterfaz.escribir("              ");
				gestorInterfaz.escribir("              ");
				gestorInterfaz.escribir("    ========== BIENVENIDO A EL SOFTWARE ADMINISTRADOR ========== ");
				gestorInterfaz.escribir("                     SALON DE BELLEZA POODEROSO   ");
				gestorInterfaz.escribir("    ===========================================================");
				gestorInterfaz.escribir("              ");
				gestorInterfaz.escribir(" Que desea realizar?");
				gestorInterfaz.escribir(" =====================");
				gestorInterfaz.escribir("                       ");
				gestorInterfaz.escribir("1.Reservar cita");
				gestorInterfaz.escribir("2.Cancelar cita");
				gestorInterfaz.escribir("3.Facturar");
				gestorInterfaz.escribir("4.Balance Contable");
				gestorInterfaz.escribir("5.Pagar nomina");
				gestorInterfaz.escribir("6.Guardar y salir");
				gestorInterfaz.escribir("7.Guardar y continuar");
				gestorInterfaz.escribir("8.Mostrar clientes");
				gestorInterfaz.escribir("9.Gestionar seguros");
				gestorInterfaz.escribir("10.Mostrar inventario");
				


				gestorInterfaz.escribir("                       ");
				gestorInterfaz.escribir(" Digite Opcion: ");
				opcion = Integer.parseInt(entrada.nextLine());
			
			
				switch(opcion) {
				case 1: GestionarCita.reservarCita(); break;
				case 2: GestionarCita.gestionCancelar(); break;
				case 3: Facturacion.facturar(); break;				
				case 4: BalanceContable.calcularBalance();break;
				case 5: Nomina.calcularNomina();break;
				case 6: Serializador.serializarTodo();break;
				case 7: Serializador.serializarTodo();break;
				case 8: mostrarClientes();break;
				case 9: Otras.gestionarSeguros();
				case 10: Otras.mostrarInventario();break;

				}

			}
			catch(Exception e) {
				
				
				gestorInterfaz.escribir("----Upps, hemos vuelto al menu principal----");
				gestorInterfaz.escribir(" ");
				opcion=5555;
			}

			
		}while(opcion!=6 );
		

	}
	
	public static void mostrarClientes() {
		
		gestorInterfaz.escribir("=========================================");
		gestorInterfaz.escribir("=============== Clientes ===============");
		gestorInterfaz.escribir("=========================================");
		
		for (Cliente clientes: Cliente.getClientes()) {
			
			System.out.println(clientes);
			
		}
		
		gestorInterfaz.escribir("=========================================");
		gestorInterfaz.escribir("=============== Empleados ===============");
		gestorInterfaz.escribir("=========================================");
		for (Empleado clientes: Empleado.getEmpleados()) {
			
			System.out.println(clientes);
			
		}
		gestorInterfaz.escribir("=========================================");
		gestorInterfaz.escribir("================= Citas =================");
		gestorInterfaz.escribir("=========================================");
		gestorInterfaz.escribir(Cita.getCitas().size());
		for (Cita clientes: Cita.getCitas()) {
			
			System.out.println(clientes);
			
		}
		
		gestorInterfaz.escribir("=========================================");
		gestorInterfaz.escribir("================= Ventas =================");
		gestorInterfaz.escribir("=========================================");
		
		for (Venta ventas: Venta.getVentas()) {
			
			System.out.println(ventas);
			
		}
		
		gestorInterfaz.escribir("=========================================");
		gestorInterfaz.escribir("================ Producto ================");
		gestorInterfaz.escribir("=========================================");
		
		for (Producto productos: Producto.getProductos()) {
		
		System.out.println(productos);
		
		}
		
		gestorInterfaz.escribir("=========================================");
		gestorInterfaz.escribir("================ Factura ================");
		gestorInterfaz.escribir("=========================================");		
		
		
 	for (Factura fac: Factura.getFacturas()) {
		
		System.out.println(fac);
		
	}
	}

}
