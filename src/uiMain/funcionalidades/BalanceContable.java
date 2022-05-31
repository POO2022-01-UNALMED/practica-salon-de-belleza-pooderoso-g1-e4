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





	public static void calcularBalance() {

		
		
		
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
		System.out.println(BalanceContable.calcularMes(mes_escogido, meses));

	}
	
	public static String calcularMes(int mes_escogido, HashMap<Integer,String> meses){
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
			if(cita.getEstado().equals("Pendiente") || cita.getEstado().equals("Exitosa")){
				for (Servicio servicio: cita.getServicios()) {
					totalCitas += servicio.getPrecio();
				}
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
		String s = "Balance Contable para el mes "+meses.get(mes_escogido)+" del 2022:" +
				"\n-------------------------------"+
				"\nValor total por Citas: "+totalCitas+
				"\nValor total por Ventas: "+totalVentas+
				"\nPago Comisiones de Productos: -"+pagoComisionesProductos+
				"\nPago mensual a Empleados: -"+pagoEmpleados+
				"\n-------------------------------"+
				"\n\nValor neto de este mes: "+valorNeto;
		
		
		
		
		
		return s;
	}
	
	//}
}
