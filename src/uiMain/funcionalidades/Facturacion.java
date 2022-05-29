package uiMain.funcionalidades;
import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import gestorAplicacion.operacional.Factura;
import gestorAplicacion.operacional.Producto;
import gestorAplicacion.operacional.Venta;
import gestorAplicacion.organizacional.Cliente;
import gestorAplicacion.organizacional.Empleado;
import gestorAplicacion.operacional.Inventario;
import gestorAplicacion.operacional.Cita;

public class Facturacion {
	
	static {
		
	}
	
	public static void facturar() {
		
		//Productos del salón de belleza POODEROSO
		Producto gomina = new Producto("Gomina", 2500);
		Producto keratina = new Producto("keratina", 30000);
		Producto colagenoCapilar = new Producto("Colageno Capilar", 3000);
		Producto balsamo = new Producto("Balsamo", 1500);
		Producto esmalte = new Producto("Esmalte", 4000);
		Producto removedor = new Producto("Removedor", 5500);
		Producto acondicionador  = new Producto("Acondicionador", 700);
		
		
		//*INICIALIZACIÓN PRODUCTOS
		
		//Inventario
		HashMap<Producto, Integer> stockInicial = new HashMap<Producto, Integer>();
		Inventario inventario = new Inventario(stockInicial);
		
		//Productos que serán vendidos
		HashMap<Producto, Integer> productosVendidos = new HashMap<Producto, Integer>();
		
		//Empleado que venderá el producto
		Empleado empleado = null;
		
		//Ingreso de productos al inventario
		inventario.agregarProducto(gomina, 23);
		inventario.agregarProducto(keratina, 11);
		inventario.agregarProducto(colagenoCapilar, 34);
		inventario.agregarProducto(balsamo, 21);
		inventario.agregarProducto(esmalte, 34);
		
		//Configuracion de formato de fecha
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		//Menú principal de facturación
		Scanner entradaFacturacion = new Scanner(System.in);
		System.out.println("1. Factura de producto ");
		System.out.println("2. Factura de servicio ");
		System.out.println("Qué desea facturar? ");
		int tipoFactura = entradaFacturacion.nextInt();
		
		
		//* INICIALIZACION SERVICIOS
		
		// Factura productos
		if(tipoFactura == 1) {
			//Menu factura servicios
			System.out.println("Los empleados son: ");
			System.out.println(" ");
			for(Empleado emp : Empleado.getEmpleados()) {
				System.out.println(emp.getNombre() + " id: " + emp.getId());
			}
			System.out.println(" ");
			System.out.println("Por favor ingrese el id del Empleado que vende el producto ");
			int idEmpleado = entradaFacturacion.nextInt();
			System.out.println("                       ");
			//System.out.println("Presione 1 para ingresar un producto ");
			//int bandera = entradaFacturacion.nextInt();
			int bandera = 1;
			
			while(bandera != 0) {
				//Inicializar cada producto a vender
				Producto productoAVender = null;
				
				//Mientras se quiera más productos
				if(bandera == 1) {
					//Menu de productos a vender
					System.out.println("Los productos disponibles son: ");
					System.out.println(" ");
					for(Producto p : inventario.getListaProductos().keySet()) {
						System.out.println(p.getNombreProducto() + " - id: " + p.getProductoId());
					}
					System.out.println(" ");
					
					//Verificar que un producto si exista: 
					while(productoAVender == null) {
						System.out.println("Ingrese el codigo del producto");
						int productoId = entradaFacturacion.nextInt();
						
						//Obtener el producto existente que se va a vender
						for (Producto producto : inventario.getListaProductos().keySet()){
							if(producto.getProductoId() == productoId) {
								productoAVender = producto;
							}
						}
						
						if(productoAVender == null) {
							System.out.println("No se encuentra el producto con id " + productoId);
						}
						
					}
					
					System.out.println("Ingrese la cantidad del producto");
					int cantidadProducto = entradaFacturacion.nextInt();
					
					//Obtener el empleado que venderá el producto
					for(Empleado emp : Empleado.getEmpleados()) {
						if(emp.getId() == idEmpleado) {
							empleado = emp;
						}
					}
					
					// Verificar si un producto se puede vender según sus existencias
					if(inventario.sePuedeVender(productoAVender, cantidadProducto)) {
						
						// Agregar producto a vender
						productosVendidos.put(productoAVender, cantidadProducto);
						
					}else {
						System.out.println("No hay existencias suficientes para el producto " + productoAVender.getNombreProducto());
					}
				}
						
				System.out.println("Presione 1 para ingresar mas productos o 0 para continuar ");
				bandera = entradaFacturacion.nextInt();
				
			}
			
			LocalDateTime horaVenta = LocalDateTime.now();
			
			//Generar venta - Actualiza existencias y asigna producto a vendedor para comision
			for(Map.Entry<Producto, Integer> productos : productosVendidos.entrySet()) {

				new Venta(productos.getKey(), empleado, horaVenta, productos.getValue(), inventario);
			}
			//Menu método de pago
			System.out.println("1. Efectivo");
			System.out.println("2. QR");
			System.out.println("3. Transferencia");
			System.out.println("Cual es el metodo de pago?");
			String metodoPago="";
			int tipoMetodoPago = entradaFacturacion.nextInt();
			
			switch(tipoMetodoPago){
				case 1:
					metodoPago = "Efectivo";break;
				case 2:
					metodoPago = "QR";break;
				case 3: 
					metodoPago = "Transferencia";break;
					
			}
			//Generación de factura - Impresión monto a pagar
			LocalDateTime horaFactura = LocalDateTime.now();
			Factura facturaProductos = new Factura(productosVendidos, horaFactura, metodoPago);	
			facturaProductos.precioTotalProductos();
			System.out.println("===============================");
			System.out.println("Factura # " + facturaProductos.getIdFactura());
			System.out.println("Fecha: " + facturaProductos.getFecha().format(formato));
			System.out.println("Vendido por " + empleado.getNombre() + " " + empleado.getApellido());
			for(Map.Entry<Producto, Integer> productosFactura : facturaProductos.getProductosVendidos().entrySet()) {
				System.out.println(productosFactura.getKey().getNombreProducto() + " - " + productosFactura.getValue() + " Unds");
			}
			System.out.println("El valor a pagar es de " + facturaProductos.getPrecioTotal());
			System.out.println("===============================");
			
		
			//System.out.println(Venta.getVentas());
			//System.out.println(inventario.mostrarExistencias());
			//System.out.println("                                ");
			//System.out.println("                                ");
			//System.out.println(empleado);
		}
		else if(tipoFactura == 2) {
			
			Cliente clienteCita = null;
			Cita citaAFacturar = null;
			System.out.println("Clientes registrados: ");
			for(Cliente cliente : Cliente.getClientes()) {
				
				System.out.println(cliente.getId() + " - " + cliente.getNombre() + " "+  cliente.getApellido());
				
			}
			
			System.out.println("   ");
			System.out.println("Por favor ingrese el id del cliente");
			
			int idCliente = entradaFacturacion.nextInt();
			ArrayList<Cliente> clientesRegistrados = Cliente.getClientes();
			ArrayList<Cita> citasTomadas = Cita.getCitas();
			
			while(clienteCita == null) {
				
				for(Cliente c : clientesRegistrados) {
					if(c.getId() == idCliente) {
						System.out.println("Cliente : " + c.getNombre() + " " + c.getApellido() + " " + c.getId());
						clienteCita = c;
					}
				}
				
				if(clienteCita == null) {
					System.out.println("Parece que el cliente no tiene una cita para cancelar");
					System.out.println("Por favor ingrese el id de un cliente registrado");
					idCliente = entradaFacturacion.nextInt();
				}
				
			}
			
			
			
			for(Cita c : citasTomadas) {
				if(c.getCliente().getId() == clienteCita.getId()) {
					
					System.out.println("las citas de este cliente son: ");
					System.out.println("   ");
					System.out.println("Cita Id #: " + c.getId() +  " realizada el: " + c.getFechaReserva().format(formato));
		
				}
				
			}
			
			System.out.println("Por favor ingrese el id de la cita que a cancelar: ");
			
			int idCita = entradaFacturacion.nextInt();


			for(Cita c : citasTomadas) {
				if(c.getId() == idCita) {
					
					citaAFacturar = c;
					
		
				}
				
			}
			
			LocalDateTime horaFacturaCita = LocalDateTime.now();
			
			System.out.println("1. Efectivo");
			System.out.println("2. QR");
			System.out.println("3. Transferencia");
			System.out.println("Cual es el metodo de pago?");
			String metodoPagoFactura ="";
			int tipoMetodoPago = entradaFacturacion.nextInt();
			
			switch(tipoMetodoPago){
				case 1:
					metodoPagoFactura = "Efectivo";break;
				case 2:
					metodoPagoFactura = "QR";break;
				case 3: 
					metodoPagoFactura = "Transferencia";break;
					
			}
			
			Factura facturaCita = new Factura(citaAFacturar, horaFacturaCita, metodoPagoFactura);
			
			System.out.println("===============================");
			System.out.println("Factura # " + facturaCita.getIdFactura());
			System.out.println("Fecha: " + facturaCita.getFecha().format(formato));
			System.out.println("Cliente id # " + facturaCita.getCita().getCliente().getId() +  " - " + facturaCita.getCita().getCliente().getNombre() + " " + facturaCita.getCita().getCliente().getApellido());
			System.out.println("Atendió " + facturaCita.getCita().getEmpleado().getNombre() +  " " + facturaCita.getCita().getEmpleado().getApellido() + " - id " + facturaCita.getCita().getEmpleado().getId());
			System.out.println("El valor a pagar es de " + facturaCita.precioTotalServicios()); 
			System.out.println("===============================");
			
		
			
			
		}
		
		
		
		
	}

}
