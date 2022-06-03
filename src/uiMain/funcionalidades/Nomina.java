package uiMain.funcionalidades;

import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import gestorAplicacion.operacional.Cita;
import gestorAplicacion.operacional.Venta;
import gestorAplicacion.organizacional.Empleado;

public class Nomina {
////////////////////////////FUNCIONALIDAD NÓMINA ////////////////////////////////////////////////////////	

	public static void calcularNomina() {
		System.out.println("=============Pago nomina mes vencido=============");

		SortedSet<Integer> fechas = new TreeSet<Integer>();
		for (Cita cita : Cita.getCitas()) {
			fechas.add(cita.getFechaCita().get(ChronoField.MONTH_OF_YEAR));
		}
		for (Venta venta : Venta.getVentas()) {
			fechas.add(venta.getFechaVenta().get(ChronoField.MONTH_OF_YEAR));
		}

		System.out.println("");
		System.out.println("Seleccione el mes a pagar:");

		HashMap<Integer, String> meses = new HashMap<Integer, String>();
		meses.put(1, "Enero");
		meses.put(2, "Febrero");
		meses.put(3, "Marzo");
		meses.put(4, "Abril");
		meses.put(5, "Mayo");
		meses.put(6, "Junio");
		meses.put(7, "Julio");
		meses.put(8, "Agosto");
		meses.put(9, "Septiembre");
		meses.put(10, "Octubre");
		meses.put(11, "Noviembre");
		meses.put(12, "Diciembre");
		Iterator value = fechas.iterator();
		int i = 1;
		while (value.hasNext()) {
			System.out.println(i + " " + meses.get(value.next()));
			i++;
		}

		System.out.print("Opcionn: ");
		Scanner texto = new Scanner(System.in);
		int opcion = texto.nextInt();

		value = fechas.iterator();
		i = 1;
		int mes_escogido = 0;
		int valor = 0;
		while (value.hasNext()) {
			valor = (Integer) value.next();
			if (i == opcion) {
				mes_escogido = valor;
				break;
			}
			i++;
		}

//LOS EMPLEADOS
		System.out.println("");
		System.out.println("Seleccione el empleado a liquidar:");

		for (Empleado emp : Empleado.getEmpleados()) {
			System.out.println(emp);
		}

		System.out.print("Nombre: ");
		Scanner nombre = new Scanner(System.in);
		String empleado = nombre.next();

//Citas que atendió el empleado
		Empleado empleadoEscogido = null;
		for (Empleado emp : Empleado.getEmpleados()) {
			if (emp.getNombre().equals(empleado)) {
				empleadoEscogido = emp;

				break;
			}
		}
		ArrayList<Cita> citasMes = new ArrayList<Cita>();
		for (Cita cita : Cita.getCitas()) {
			if (cita.getFechaCita().get(ChronoField.MONTH_OF_YEAR) == mes_escogido) {

				if (cita.getEmpleado().getNombre().equals(empleado)) {
					citasMes.add(cita);

				}
			}
		}
//Productos que vendió el empleado

		ArrayList<Venta> ventasMes = new ArrayList<Venta>();
		for (Venta venta : Venta.getVentas()) {
			if (venta.getFechaVenta().get(ChronoField.MONTH_OF_YEAR) == mes_escogido) {
				if (venta.getEmpleadoComision().getNombre().equals(empleado)) {
					ventasMes.add(venta);
				}
			}
		}
		double totalComi = 0;
		for (Venta venta : ventasMes) {
			totalComi += (venta.getProductoVendido().getPrecioVenta() * Venta.porcentajeComision);
		}

		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ================================================================== ");
		System.out.println("                     Pago al empleado " + empleado);
		System.out.println(" ================================================================== ");
		System.out.println("  ");

		System.out.println("El empleado " + empleado + " atendio " + citasMes.size() + " citas en el mes");
		System.out.println("Tiene un sueldo base de:  " + empleadoEscogido.getSueldo());
		System.out.println(" ");

		System.out.println("Vendio: " + ventasMes.size() + " producto(s) en el mes, correspondientes a:");
		System.out.println(" ");
		for (Venta venta : ventasMes) {
			System.out.println("  --> " + venta.getProductoVendido().getNombreProducto() + " $ "
					+ venta.getProductoVendido().getPrecioVenta());
		}
		System.out.println(" ");
		System.out.println("Por lo que recibe una comision del 20% de cada producto, es decir: " + totalComi);

		System.out.println(" ");
		double totalTodo = empleadoEscogido.getSueldo() + totalComi;
		System.out.println("Confirmacion:");
		System.out.println("El sueldo total a pagar debe ser: " + totalTodo);

	}
}
