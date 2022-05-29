package uiMain.funcionalidades;

import java.time.LocalDateTime;
import java.util.*;
import static java.util.Map.entry; 


import gestorAplicacion.operacional.Producto;
import gestorAplicacion.organizacional.Administrador;
import gestorAplicacion.organizacional.Cliente;
import gestorAplicacion.organizacional.Empleado;
import gestorAplicacion.operacional.*;
import java.time.temporal.ChronoField;  

public class BalanceContable {


	//public static void main(String[] args) {
		
	// Creacion de objetos para ensayar la funcionalidad
	//Empleado empleado1 =new Empleado("Marlon", "Nivia", 1000349061, 21, 32088456, "Uï¿½as");

	public static String calcularBalance(){
		return "Aqui iria";
	}
	/*
	public static void main(String[] args) {
		Empleado empleado1 =new Empleado("Marlon", "Nivia", 1000349061, 21, 32088456, "Uñas");
>>>>>>> Stashed changes
		Empleado empleado2 =new Empleado("Julian", "Ospina", 525206530, 20, 3208844, "Pelo");//El numero no alcanza parce
		Administrador SuperAdministador =new Administrador("Juan","Cuadrado",123,21,444444,"12-2",2222);
		
		Producto gomina = new Producto("Gomina", 2500);
		Producto keratina = new Producto("keratina", 30000);
		Producto colagenoCapilar = new Producto("Colageno Capilar", 3000);
		Producto balsamo = new Producto("Balsamo", 1500);
		Producto esmalte = new Producto("Esmalte", 4000);
		Producto removedor = new Producto("Removedor", 5500);
		Producto acondicionador  = new Producto("Acondicionador", 700);
		Map<Producto, Integer> cantidadProductos = Map.ofEntries(
				entry(gomina, 10), entry(keratina, 15),
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
		
		
		
		// Comienza la interaccion con el usuario
		System.out.println("Bienvenido al menu para calcular el balance contable!\n");
		System.out.println("A continuacion podra ver de cuales meses se tienen registros para el calculo:");
		
		//Aqui se buscan los meses de los cuales se tiene informacion en citas o productos vendidos
		SortedSet<Integer> fechas = new TreeSet<Integer>();
		for(Cita cita: Cita.getCitas()) {
			fechas.add(cita.getFechaCita().get(ChronoField.MONTH_OF_YEAR));
		}
		for (Venta venta: Venta.getVentas()) {
			fechas.add(venta.getFechaVenta().get(ChronoField.MONTH_OF_YEAR));
		}
		//System.out.println(fechas);
		HashMap<Integer,String> meses = new HashMap<Integer,String>();
		meses.put(1,"Enero"); meses.put(2,"Febrero"); meses.put(3, "Marzo"); meses.put(4, "Abril"); meses.put(5, "Mayo"); meses.put(6,"Junio");
		meses.put(7, "Julio");meses.put(8, "Agosto"); meses.put(9, "Septiembre"); meses.put(10, "Octubre"); meses.put(11, "Noviembre"); meses.put(12, "Diciembre");
		Iterator value = fechas.iterator();
		int i= 1;
		while (value.hasNext()) {
			System.out.println("["+i+"]"+" "+meses.get(value.next())+" de "+2022);
			i++;
		}
		
		//Tras mostrarle los meses disponibles, se le solicita al usuario que ingrese una opcion
		System.out.print("Por favor seleccione una opcion: ");
		Scanner entrada =new Scanner(System.in);
		int opcion = entrada.nextInt();
		
		value = fechas.iterator();
		i= 1;
		int mes_escogido=0;
		int valor = 0;
		while (value.hasNext()) {
			valor = (Integer)value.next();
			if (i==opcion) {
				mes_escogido = valor;
				break;
			}
			i++;
		}
		
		
		//Buscamos las Citas y Ventas que aplican al mes seleccionado
		System.out.println(BalanceContable.calcularBalance(mes_escogido, meses));

	}
	
	public static String calcularBalance(int mes_escogido, HashMap<Integer,String> meses){
		ArrayList<Cita> citasMes = new ArrayList<Cita>();
		ArrayList<Venta> ventasMes = new ArrayList<Venta>();
		for(Cita cita: Cita.getCitas()) {
			if (cita.getFechaCita().get(ChronoField.MONTH_OF_YEAR) == mes_escogido) {
				citasMes.add(cita);
			}
		}
		for(Venta venta: Venta.getVentas()) {
			if (venta.getFechaVenta().get(ChronoField.MONTH_OF_YEAR) == mes_escogido) {
				ventasMes.add(venta);
			}
		}
		
		double totalCitas = 0;
		for(Cita cita: citasMes) {
			for (Servicio servicio: cita.getServicios()) {
				totalCitas += servicio.getPrecio();
			}
		}
		double totalVentas = 0;
		for(Venta venta: ventasMes) {
				totalVentas += venta.getProductoVendido().getPrecioVenta() * venta.getCantidadVendida();
		}
		double pagoEmpleados = 0;
		for(Empleado empleado: Empleado.getEmpleados()) {
			pagoEmpleados += empleado.getSueldo();
		}
		double pagoComisionesProductos = totalVentas*Venta.porcentajeComision;
		//Faltaria lo del patrimonio... 
		double valorNeto = totalCitas+totalVentas - pagoEmpleados-pagoComisionesProductos;
		String s = "Balance Contable para el mes "+meses.get(mes_escogido)+" del 2022:"
				+ "\nValor total por Citas: "+totalCitas+
				"\nValor total por Ventas: "+totalVentas+
				"\nPago Comisiones de Productos: -"+pagoComisionesProductos+
				"\nPago mensual a Empleados: -"+pagoEmpleados+
				"\n-------------------------------"+
				"\n\nValor neto de este mes: "+valorNeto;
		
		
		
		
		
		return s;
	}
	*/
	//}
}
