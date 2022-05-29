package uiMain.funcionalidades;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import gestorAplicacion.operacional.Factura;
import gestorAplicacion.operacional.Producto;
import gestorAplicacion.operacional.Venta;
import gestorAplicacion.organizacional.Empleado;
import gestorAplicacion.operacional.Inventario;

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
		
		
		//*INICIALIZACIÓN
		
		//Inventario
		HashMap<Producto, Integer> stockInicial = new HashMap<Producto, Integer>();
		Inventario inventario = new Inventario(stockInicial);
		
		//Productos que serán vendidos
		HashMap<Producto, Integer> productosVendidos = new HashMap<Producto, Integer>();
		
		//Empleado que venderá el producto
		Empleado empleado = null;
		
		//Producto que se venderá
		Producto productoAVender = null;
		
		//Ingreso de productos al inventario
		inventario.agregarProducto(gomina, 23);
		inventario.agregarProducto(keratina, 11);
		inventario.agregarProducto(colagenoCapilar, 34);
		inventario.agregarProducto(balsamo, 21);
		inventario.agregarProducto(esmalte, 34);
		
		
		//Menú principal de facturación
		Scanner entradasVenta = new Scanner(System.in);
		System.out.println("1. Factura de producto ");
		System.out.println("2. Factura de servicio ");
		System.out.println("Qué desea facturar? ");
		int tipoFactura = entradasVenta.nextInt();
		
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
			int idEmpleado = entradasVenta.nextInt();
			System.out.println("                       ");
			//System.out.println("Presione 1 para ingresar un producto ");
			//int bandera = entradasVenta.nextInt();
			int bandera = 1;
			
			while(bandera != 0) {
				//Mientras se quiera más productos
				if(bandera == 1) {
					//Menu de productos a vender
					System.out.println("Los productos disponibles son: ");
					System.out.println(" ");
					for(Producto p : inventario.getListaProductos().keySet()) {
						System.out.println(p.getNombreProducto() + " - id: " + p.getProductoId());
					}
					System.out.println(" ");
					System.out.println("Ingrese el codigo del producto");
					int productoId = entradasVenta.nextInt();
					System.out.println("Ingrese la cantidad del producto");
					int cantidadProducto = entradasVenta.nextInt();
					
					//Obtener el producto existente que se va a vender
					for (Producto producto : inventario.getListaProductos().keySet()){
						if(producto.getProductoId() == productoId) {
							productoAVender = producto;
						}
					}
					
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
				bandera = entradasVenta.nextInt();
				
			}
			
			LocalDateTime horaVenta = LocalDateTime.now();
			
			//Generar venta - Actualiza existencias y asigna producto a vendedor para comision
			for(Map.Entry<Producto, Integer> productos : productosVendidos.entrySet()) {
				System.out.println("Creando objetos de venta");
				new Venta(productos.getKey(), empleado, horaVenta, productos.getValue(), inventario);
			}
			//Menu método de pago
			System.out.println("1. Efectivo");
			System.out.println("2. QR");
			System.out.println("3. Transferencia");
			System.out.println("Cual es el mï¿½todo de pago?");
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
			//Generación de factura - Impresión monto a pagar
			LocalDateTime horaFactura = LocalDateTime.now();
			Factura facturaProductos = new Factura(productosVendidos, horaFactura, metodoPago);	
			facturaProductos.precioTotalProductos();
			System.out.println("===============================");
			System.out.println("El valor a pagar es de " + facturaProductos.getPrecioTotal());
			System.out.println("===============================");
			
			
			System.out.println(Venta.getVentas());
			System.out.println(inventario.mostrarExistencias());
			System.out.println("                                ");
			System.out.println("                                ");
			System.out.println(empleado);
		}
		else if(tipoFactura == 2) {
			System.out.println("Factura de un servicio");
		}
		
		
		
		
	}

}
