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
			case 3 : facturar(); break;
			case 4: BalanceContable.calcularBalance();
			case 5: System.out.println("!!Gracias por usar nuestra aplicaci�n!!");break;
			
			}
			
			
		
		}while(opcion!=5);
		
		
		//entrada.close();
	}
	
		
	
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
	
	
	public static void mi2() {
		System.out.println("cancel�");
	}
	
	
	
	
}

