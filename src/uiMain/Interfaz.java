package uiMain;

import java.time.LocalDateTime;
import java.util.*;


import gestorAplicacion.operacional.Producto;
import gestorAplicacion.organizacional.Administrador;
import gestorAplicacion.organizacional.Cliente;
import gestorAplicacion.organizacional.Empleado;
import gestorAplicacion.operacional.*;

public class Interfaz {
	public static void main(String[] args) {
		Scanner entrada =new Scanner(System.in);
		Empleado empleado1 =new Empleado("Marlon", "Nivia", 100349061, 21, 32088456, "Uï¿½as");
		Empleado empleado2 =new Empleado("Julian", "Ospina", 525206530, 20, 3208844, "Pelo");//El numero no alcanza parce
		Administrador SuperAdministador =new Administrador("Juan","Cuadrado",123,21,444444,"12-2",2222);
		int opcion = 0;
		do {
			
			System.out.println("    Que desea realizar?");
			System.out.println("                       ");
			System.out.println("1.Reservar cita");
			System.out.println("2.Cancelar cita");
			System.out.println("3.Facturar");
			System.out.println("4.Terminar");
			System.out.println("                       ");
			System.out.print("Digite Opcion: ");
			opcion = Integer.parseInt(entrada.nextLine());
			
			
			
			switch(opcion) {
			case 1: reservarCita(SuperAdministador); break;
			case 2: mi2(); break;
			case 3 : facturar(); break;
			case 4: System.out.println("!!Gracias por usar nuestra aplicación!!");break;
			
			}
			
			
		
		}while(opcion!=4);
		
		
		//entrada.close();
	}
	
	public static void reservarCita(Administrador SuperAdministador) {
		//Variable para la entrada de datos
		Scanner entrada = new Scanner(System.in);
		
		//Es un nuevo Cliente?
		System.out.println("1.Cliente ya existente");
		System.out.println("2.Nuevo Cliente");
		System.out.print("Digite Opcion: ");
		int TipoCliente=entrada.nextInt();
		
		if (TipoCliente==1){
			
			int cedulaEmpleado;
			System.out.println("                       ");
			//System.out.println("reservï¿½");
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
			System.out.println("Por favor ingrese identificaiï¿½n del cliente: ");
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
	
	
	public static void facturar() {
		
		Producto gomina = new Producto(20, "Gomina", 2500);
		Producto keratina = new Producto(53, "keratina", 30000);
		Producto colagenoCapilar = new Producto(15, "Colágeno Capilar", 3000);
		Producto balsamo = new Producto(5, "Balsamo", 1500);
		Producto esmalte = new Producto(10, "Esmalte", 4000);
		Producto removedor = new Producto(11, "Removedor", 5500);
		Producto acondicionador  = new Producto(5, "Acondicionador", 700);
		
		Scanner entradasVenta = new Scanner(System.in);
		System.out.println("1. Factura de producto ");
		System.out.println("2. Factura de servicio ");
		System.out.println("Qué desea facturar? ");
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
						
				System.out.println("Presione 1 para ingresar más productos ó 0 para continuar ");
				bandera = entradasVenta.nextInt();
				
			}
			
			
			System.out.println("1. Efectivo");
			System.out.println("2. QR");
			System.out.println("3. Transferencia");
			System.out.println("Cual es el método de pago?");
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
		System.out.println("cancelï¿½");
	}
	
	public static void mostrarEmpleados(Administrador SuperAdministador) {		
		for(Empleado e : SuperAdministador.empleadosAsigandos) {
			System.out.println(e);
		}
				
	}
	
	
	
	
}

