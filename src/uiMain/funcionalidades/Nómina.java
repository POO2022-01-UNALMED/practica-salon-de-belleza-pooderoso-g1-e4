package uiMain.funcionalidades;

import static java.util.Map.entry;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import gestorAplicacion.operacional.Cita;
import gestorAplicacion.operacional.Inventario;
import gestorAplicacion.operacional.Producto;
import gestorAplicacion.operacional.Servicio;
import gestorAplicacion.operacional.Venta;
import gestorAplicacion.organizacional.Administrador;
import gestorAplicacion.organizacional.Cliente;
import gestorAplicacion.organizacional.Empleado;


public class N�mina {
	

	public static void main(String[] args) {
		Empleado empleado1 =new Empleado("Marlon", "Nivia", 1000349061, 21, 32088456, "U�as");
/*>>>>>>> Stashed changes*/
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
		Cita cita22 = new Cita(empleado1, c2, s2,  LocalDateTime.of(2022, 5,10,12,0), LocalDateTime.of(2022, 5,31,14,0),60);
		Cita cita3 = new Cita(empleado1, c2, s3,  LocalDateTime.of(2022, 5,1,12,0), LocalDateTime.of(2022, 6,15,14,0),60);
		Cita cita4 = new Cita(empleado1, c1, s4,  LocalDateTime.of(2022, 5,3,12,0), LocalDateTime.of(2022, 8,21,14,0),60);
		
		Venta venta1 = new Venta(gomina, empleado1, LocalDateTime.of(2022, 5,10,12,0),5, inv);
		Venta venta2 = new Venta(keratina, empleado2, LocalDateTime.of(2022, 8,14,12,0),5, inv);
		Venta venta3 = new Venta(keratina, empleado1, LocalDateTime.of(2022, 5,14,12,0),5, inv);

		//---------------------------------------------
		
		System.out.println("Pago nómina mes vencido");
	

			SortedSet<Integer> fechas = new TreeSet<Integer>();
			for(Cita cita: Cita.getCitas()) {
				fechas.add(cita.getFechaCita().get(ChronoField.MONTH_OF_YEAR));
			}
			for (Venta venta: Venta.getVentas()) {
				fechas.add(venta.getFechaVenta().get(ChronoField.MONTH_OF_YEAR));
			}
		
		System.out.println("");
		System.out.println("Seleccione el mes a pagar:");
	
		//LOS MESES
			
			HashMap<Integer,String> meses = new HashMap<Integer,String>();
			meses.put(1,"Enero"); meses.put(2,"Febrero"); meses.put(3, "Marzo"); meses.put(4, "Abril"); meses.put(5, "Mayo"); meses.put(6,"Junio");
			meses.put(7, "Julio");meses.put(8, "Agosto"); meses.put(9, "Septiembre"); meses.put(10, "Octubre"); meses.put(11, "Noviembre"); meses.put(12, "Diciembre");
			Iterator value = fechas.iterator();
			int i= 1;
			while (value.hasNext()) {
				System.out.println(i+" "+meses.get(value.next()));
				i++;
			}
			
			System.out.print("Opción: ");
			Scanner texto =new Scanner(System.in);
			int opcion = texto.nextInt();
			
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
			
	
		//LOS EMPLEADOS
			System.out.println("");
			System.out.println("Seleccione el empleado a liquidar:");
		
			for(Empleado emp : Administrador.empleadosAsigandos) {
				System.out.println(emp);
			}

			System.out.print("Nombre: ");
			Scanner nombre =new Scanner(System.in);
			String empleado = nombre.next();
			
			
			
			//Citas que atendió el empleado
			ArrayList<Cita> citasMes = new ArrayList<Cita>();
			for(Cita cita: Cita.getCitas()) {
					if (cita.getFechaCita().get(ChronoField.MONTH_OF_YEAR) == mes_escogido) {
						
						if (cita.getEmpleado().getNombre().equals(empleado)) {
							citasMes.add(cita);
						}
					}
			}
			
			
			//Productos que vendió el empleado
			
			ArrayList<Venta> ventasMes = new ArrayList<Venta>();
			for(Venta venta: Venta.getVentas()) {
				if (venta.getFechaVenta().get(ChronoField.MONTH_OF_YEAR) == mes_escogido) {
					if (venta.getEmpleadoComision().getNombre().equals(empleado)) {
						ventasMes.add(venta);
				}
			}}
			double totalComi = 0;
				for(Venta venta: ventasMes) {
					totalComi+=(venta.getProductoVendido().getPrecioVenta()*Venta.porcentajeComision);
					}
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ================================================================== ");
			
		
			System.out.println("El empleado " +empleado+ " atendió "+ citasMes.size()+" citas en el mes");
			System.out.println("Tiene un sueldo base de:  "+ Empleado.sueldo);
			System.out.println(" ");
			
			System.out.println("Y vendió: "+ ventasMes.size()+ " producto(s) en el mes, correspondientes a:");
			System.out.println(" ");
			for(Venta venta: ventasMes) {
				System.out.println("  --> "+venta.getProductoVendido().getNombreProducto()+ " $ "+venta.getProductoVendido().getPrecioVenta());
				}
			System.out.println(" ");
			System.out.println("Por lo que recibe una comisión del 20% de cada producto, es decir: "+totalComi);
		
			System.out.println(" ");
			double totalTodo= Empleado.sueldo + totalComi;
			System.out.println("Confirmación:");
			System.out.println("El sueldo total a pagar debe ser: "+ totalTodo);
			
	}
}
	

