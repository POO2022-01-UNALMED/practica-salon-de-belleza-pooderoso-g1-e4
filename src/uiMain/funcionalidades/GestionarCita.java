package uiMain.funcionalidades;

import java.time.LocalDateTime;

import gestorAplicacion.operacional.*;
import gestorAplicacion.organizacional.*;
import uiMain.gestorInterfaz;


public class GestionarCita {
	
	static {		
		Empleado empleado1 =new Empleado("Marlon", "Nivia", 1000349061, 21, 32088456, "Uñas");
		Empleado empleado2 =new Empleado("Julian", "Ospina", 525206530, 20, 3208844, "Pelo");//El numero no alcanza parce		
		//----------------------------
		Cliente c1 =new Cliente("Luisa", "Palacio", 12, 23, 301623697 , "ninguna");
		Cita Cita1= new Cita(empleado1, null, null, LocalDateTime.now() , LocalDateTime.of(2022, 5, 30, 14, 0) , 60);
		Factura Factura1= new Factura(Cita1, LocalDateTime.now() ,"QR");
		empleado1.getServiciosRealizados().add(Factura1);		
	}
	
	public static void reservarCita() {
		
		//Es un nuevo Cliente?
		gestorInterfaz.escribir("                         ");
		gestorInterfaz.escribir("1.Cliente ya existente");
		gestorInterfaz.escribir("2.Nuevo Cliente");
		gestorInterfaz.escribir("Digite Opcion: ");
		
		
		int TipoCliente=gestorInterfaz.leerEntero();
		
		if (TipoCliente==1){
						
			gestorInterfaz.escribir("");					

			int cedulaCliente=gestorInterfaz.leerEntero("Digite la identificación del cliente");				
			Cliente clienteaAsignar=devuelveCliente(cedulaCliente);
			
			while(clienteaAsignar==null) {					
				cedulaCliente=gestorInterfaz.leerEntero("Cliente no encontrado, digite nuevamente");				
				clienteaAsignar=devuelveCliente(cedulaCliente);										
			}
			
			gestorInterfaz.escribir(" ");
			gestorInterfaz.escribir(clienteaAsignar);
			gestorInterfaz.escribir(" ");				
			mostrarEmpleados();
			gestorInterfaz.escribir(" ");
			int cedulaEmpleado=gestorInterfaz.leerEntero("Dijite la identificacion del empleado al cual se le asignará la cita: ");
			gestorInterfaz.escribir(" ");
			gestorInterfaz.escribir("---------------------------------------------");
			Empleado e=GestionarCita.devuelveEmpleado(cedulaEmpleado);
			gestorInterfaz.escribir(e);
			gestorInterfaz.escribir(" ");
			int mes=gestorInterfaz.leerEntero("Digite mes: ");
			int dia=gestorInterfaz.leerEntero("Digite dia: ");
			gestorInterfaz.escribir(" ");
			GestionarCita.mostrarCitas(e,mes,dia);
			//mostrar las citas de ese dia de ese empleado
			//Ingresar fecha
			//verificar disponibilida				 
			//en esa fecha se muestra la disponibilidad horaria del empleado
			//asignar cita si se puede 
			//Interfaz.escogerServicios();
		}
		else {

			Cliente nuevoCliente= crearNuevoCliente();
			
		}
					
	}
	

	//Muestra la lista de empleados asignados al administrador
	public static void mostrarEmpleados() {		
		gestorInterfaz.escribir("------ Lista de empleados ------");
		gestorInterfaz.escribir(" ");
		for(Empleado e : Administrador.empleadosAsigandos) {
			gestorInterfaz.escribir(e);
		}
	}
	
	//Devuelve un nuevo Cliente
	
	public static Cliente crearNuevoCliente() {
		
		gestorInterfaz.escribir("Por favor ingrese los datos del cliente");
		gestorInterfaz.escribir("");
		String nombre=gestorInterfaz.leer("Por favor ingrese nombre del cliente: ");	
		String apellido=gestorInterfaz.leer("Por favor ingrese apellido del cliente: ");
		int id=gestorInterfaz.leerEntero("Por favor ingrese identificaión del cliente: ");
		int edad=gestorInterfaz.leerEntero("Por favor ingrese edad del cliente: ");
		int numero=gestorInterfaz.leerEntero("Por favor ingrese numero del cliente: ");
		String anotaciones=gestorInterfaz.leer("Por favor ingrese anotaciones del cliente: ");
		
		Cliente nuevoCliente = new Cliente(nombre, apellido, id, edad, numero, anotaciones);
		return nuevoCliente;
		
	}
	
	//Traer un empleado segun su cedula
	
	public static Empleado devuelveEmpleado(int cedula) {
					
		
		for(Empleado e: Administrador.empleadosAsigandos) {
			if (e.getId()==cedula) {
				return e;
			}
			
		}
		return null;
	}
	
	//Traer un cliente segun su cedula
	
	public static Cliente devuelveCliente(int cedula) {
		
		for(Cliente c: Administrador.clientes) {
			if (c.getId()==cedula) {
				return c;
			}
			
		}
		return null;
	}
	
	//Mostrar una cita
	
	public static void mostrarCitas(Empleado p, int mes, int dia) {
		
		gestorInterfaz.escribir("------- Citas Asignadas el dia: "+ dia+ " del mes: "+ mes+"----------");
		gestorInterfaz.escribir(" ");
		boolean citasAsignadas = false;
		for(Factura factura : p.getServiciosRealizados()) {	//Recorrer citas del empleado
			
			int mesComparacion=factura.getCita().getFechaCita().getMonthValue(); //Mes cita
			int diaComparacion=factura.getCita().getFechaCita().getDayOfMonth(); //Dia cita
			
			if((mes == mesComparacion)  && (dia == diaComparacion)) { //comparamos la cita
				gestorInterfaz.escribir(factura.getCita());//Mostrar cita
			    gestorInterfaz.escribir(" ");
			    citasAsignadas = true;
			}							
		}
		
		if(citasAsignadas==false) {
			
			gestorInterfaz.escribir("No posee citas asignadas este día");
			int cambioDia=gestorInterfaz.leerEntero("Digite 0 para escoger otro día, de lo contrario 1");//Escoger otro día
			if (cambioDia==0){
				gestorInterfaz.escribir(" ");
				int NuevoMes=gestorInterfaz.leerEntero("Digite nuevo mes");//Escoger otro mes
				int nuevoDia=gestorInterfaz.leerEntero("Digite nuevo dia");//Escoger otro mes				
				mostrarCitas(p, NuevoMes, nuevoDia);
			}
			else {
				gestorInterfaz.escribir(" ");
				//validar hora
				int hora=gestorInterfaz.leerEntero("Digite la hora");
				int minuto=gestorInterfaz.leerEntero("Digite los minutos");
				LocalDateTime citaFinal=LocalDateTime.of(2022, mes, dia, hora, minuto); //crea la cita
			}
			
			//Devolver hora de la cita
		}
		
		
		int cambioDia=gestorInterfaz.leerEntero("Digite 0 para escoger otro día, de lo contrario 1");//Escoger otro día
		if (cambioDia==0){
			gestorInterfaz.escribir(" ");
			int NuevoMes=gestorInterfaz.leerEntero("Digite nuevo mes");//Escoger otro mes
			int nuevoDia=gestorInterfaz.leerEntero("Digite nuevo dia");//Escoger otro mes				
			mostrarCitas(p, NuevoMes, nuevoDia);
		}
		else {
			//validar hora
			int hora=gestorInterfaz.leerEntero("Digite la hora");
			int minuto=gestorInterfaz.leerEntero("Digite los minutos");	
			//devolver hora de la cita				
			LocalDateTime citaFinal=LocalDateTime.of(2022, mes, dia, hora, minuto); //crea la cita
		}
		
		
	}
	
	public void generarCita() {
		//generar cita y generar factura
		//una cita, tiene una factura
		
		
		//private int idCita; por (defecto) 
		//private String estado; se crea en proceso por (defecto)
		//private Empleado empleado; Recibe el empleado devuelto arriba (melo) 
		//private Cliente cliente; Recibe el cliente al que se le hace la cita (melo)
		//private ArrayList<Servicio> servicios = new ArrayList<Servicio>(); Servicios por consola (Buscar lo del enum)
		//private LocalDateTime fechaReserva; //aï¿½o, mes, dia, hora y minutos   get now() fecha de reserva
		//private LocalDateTime fechaCita;  Por consola 
		//private int duracion; //minutos Debe venir de la clase enum
		//private Factura factura; Debe pensarse bien porque se depbe generar una _________
		//public static int NumCitas=0; por defecto
	}
	
	
	public static boolean  validarHora(LocalDateTime hora) {
		if(hora.getHour() < Empleado.HoraInicio.getHour() || hora.getHour() > Empleado.HoraFinal.getHour() ) {
			gestorInterfaz.escribir("Recuer que los horaios de atención son de: 9 a 18 ");
			return false;
			
		}
		return false;
	}
	
	public static void escogerServicios() {
		
		gestorInterfaz.escribir("");
		gestorInterfaz.escribir("Escoja separado por espacios los servicos que requiere");
		gestorInterfaz.escribir("");
		gestorInterfaz.escribir("1. PEDICURE");
		gestorInterfaz.escribir("2. MANICURE");
		gestorInterfaz.escribir("3. ALIZADO");
		gestorInterfaz.escribir("4. CEPILLADO");
		gestorInterfaz.escribir("5. KERATINA");
		gestorInterfaz.escribir("6. CORTE_CABALLERO");
		gestorInterfaz.escribir("7. CORTE_DAMA");
		gestorInterfaz.escribir("8. EXFOLIACION_FACIAL");
		gestorInterfaz.escribir("9. CEJAS");
		gestorInterfaz.escribir("10. DEPILACION_LASER");
		
		String reservas =gestorInterfaz.leer("Ingrese los servicios requeridos");
		
		String[] ArregloReservas = reservas.split(" ");
		
		for (String servicio :ArregloReservas ) {
			int ser=Integer.parseInt(servicio);
			if (ser>=1 && ser<=10) {
				
			}
		}
	}	
	

}
