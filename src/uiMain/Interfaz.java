package uiMain;

import java.time.LocalDateTime;
import java.util.*;
import static java.util.Map.entry; 


import gestorAplicacion.organizacional.*;
import gestorAplicacion.operacional.*;
import uiMain.funcionalidades.*;

public class Interfaz {
	public static void main(String[] args) {
		Scanner entrada =new Scanner(System.in);
		Empleado empleado1 =new Empleado("Marlon", "Nivia", 1000349061, 21, 32088456, "U�as");
		Empleado empleado2 =new Empleado("Julian", "Ospina", 525206530, 20, 3208844, "Pelo");//El numero no alcanza parce
		Administrador SuperAdministador =new Administrador("Juan","Cuadrado",123,21,444444,"12-2",2222);
				
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
				
		Cita cita1 = new Cita(empleado1, c1, s1,  LocalDateTime.of(2022, 5,1,12,0), LocalDateTime.of(2022, 5,30,14,0),60);
		Cita cita2 = new Cita(empleado2, c1, s2,  LocalDateTime.of(2022, 5,10,12,0), LocalDateTime.of(2022, 5,31,14,0),60);
		Cita cita3 = new Cita(empleado1, c2, s3,  LocalDateTime.of(2022, 5,1,12,0), LocalDateTime.of(2022, 6,15,14,0),60);
		Cita cita4 = new Cita(empleado1, c1, s4,  LocalDateTime.of(2022, 5,3,12,0), LocalDateTime.of(2022, 8,21,14,0),60);
			
		Venta venta1 = new Venta(gomina, empleado1, LocalDateTime.of(2022, 5,10,12,0),5, inv);
		Venta venta2 = new Venta(keratina, empleado2, LocalDateTime.of(2022, 8,14,12,0),5, inv);
		
		int opcion = 0;
		do {
			
			
			
			gestorInterfaz.escribir("    Que desea realizar?");
			
			gestorInterfaz.escribir("                       ");
			gestorInterfaz.escribir("1.Reservar cita");
			gestorInterfaz.escribir("2.Cancelar cita");
			gestorInterfaz.escribir("3.Facturar");
			gestorInterfaz.escribir("4.Balance Contable");
			gestorInterfaz.escribir("5.Terminar");
			gestorInterfaz.escribir("                       ");
			gestorInterfaz.escribir("Digite Opcion: ");
			opcion = Integer.parseInt(entrada.nextLine());
			
			
			
			switch(opcion) {
			case 1: GestionarCita.reservarCita(); break;
<<<<<<< Updated upstream
			case 2: mi2(); break;
			case 3 : Facturacion.facturar(); break;
			//case 4: BalanceContable.calcularBalance();
=======
			case 2: GestionarCita.gestionCancelar(); break;
			case 3 : facturar(); break;
			case 4: BalanceContable.calcularBalance();
>>>>>>> Stashed changes
			case 5: System.out.println("!!Gracias por usar nuestra aplicaci�n!!");break;
			
			}
			
			
		
		}while(opcion!=5);
		
		
		//entrada.close();
	}
	
		
	
<<<<<<< Updated upstream
	
	public static void mi2() {
		System.out.println("cancel�");
	}
	
	
	
	
=======
	public static void facturar() {
		
		Producto gomina = new Producto("Gomina", 2500);
		Producto keratina = new Producto("keratina", 30000);
		Producto colagenoCapilar = new Producto("Colageno Capilar", 3000);
		Producto balsamo = new Producto("Balsamo", 1500);
		Producto esmalte = new Producto("Esmalte", 4000);
		Producto removedor = new Producto("Removedor", 5500);
		Producto acondicionador  = new Producto("Acondicionador", 700);
		
		Scanner entradasVenta = new Scanner(System.in);
		System.out.println("1. Factura de producto ");
		System.out.println("2. Factura de servicio ");
		System.out.println("Qu� desea facturar? ");
		int tipoFactura = entradasVenta.nextInt();
		
		
		if(tipoFactura == 1) {
			System.out.println("Por favor ingrese el id del Empleado que vende el producto ");
			int idEmpleado = entradasVenta.nextInt();
			System.out.println("                       ");
			System.out.println("Presione 1 para ingresar un producto ");
			
			int bandera = entradasVenta.nextInt();
			HashMap<Producto, Integer> productosVendidos = new HashMap<Producto, Integer>();
			
			while(bandera != 0) {
				if(bandera == 1) {
					System.out.println("Ingrese el codigo del producto");
					int productoId = entradasVenta.nextInt();
					System.out.println("Ingrese la cantidad del producto");
					int cantidadProducto = entradasVenta.nextInt();
					Producto productoAsociado = Producto.getProductos().get(productoId);
					if(productoAsociado.sePuedeVender(cantidadProducto)) {
						productoAsociado.actualizarExistencias(cantidadProducto);
					}else {
						System.out.println("No hay existencias suficientes para el producto " + productoAsociado.getNombreProducto());
					}
			
					productosVendidos.put(productoAsociado, cantidadProducto);
						
				}
						
				System.out.println("Presione 1 para ingresar m�s productos � 0 para continuar ");
				bandera = entradasVenta.nextInt();
				
			}
			
			
			System.out.println("1. Efectivo");
			System.out.println("2. QR");
			System.out.println("3. Transferencia");
			System.out.println("Cual es el m�todo de pago?");
			String metodoPago="";
			int tipoMetodoPago = entradasVenta.nextInt();
			
			switch(tipoMetodoPago){
				case 1:
					metodoPago = "Efectivo";break;
				case 2:
					metodoPago = "QR";break;
				case 3: 
					metodoPago = "Transferencia";break;
					
			}
						
			LocalDateTime horaVenta = LocalDateTime.now();
			
			Factura facturaProductos = new Factura(productosVendidos, horaVenta, metodoPago);	
			facturaProductos.precioTotalProductos();
			System.out.println("===============================");
			System.out.println("El valor a pagar es de " + facturaProductos.getPrecioTotal());
			System.out.println("===============================");
			Empleado empleado = null;
			
			for(Empleado emp : Empleado.getEmpleados()) {
				
				if(emp.getId() == idEmpleado) {
					empleado = emp;
				}
			}
			
			for(Map.Entry<Producto, Integer> productos : productosVendidos.entrySet()) {
				new Venta(productos.getKey(),empleado, horaVenta, productos.getValue());
			}
			
			System.out.println(Venta.getVentas());
			System.out.println(Producto.getProductos());
			System.out.println("                                ");
			System.out.println("                                ");
			
		}
		else if(tipoFactura == 2) {
			System.out.println("Factura de un servicio");
		}
		
		
		
		
	}
	

>>>>>>> Stashed changes
}

