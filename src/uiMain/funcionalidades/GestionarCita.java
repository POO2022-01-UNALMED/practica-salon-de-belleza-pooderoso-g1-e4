package uiMain.funcionalidades;

import java.time.LocalDateTime;
import java.util.ArrayList;

import gestorAplicacion.operacional.*;
import gestorAplicacion.organizacional.*;
import uiMain.gestorInterfaz;


public class GestionarCita {
	
	static {		
		Empleado empleado1 =new Empleado("Marlon", "Nivia", 1000, 21, 32088456, "Uñas");
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
			int cedulaEmpleado=gestorInterfaz.leerEntero("Digite la identificacion del empleado al cual se le asignará la cita: ");
			gestorInterfaz.escribir(" ");
			gestorInterfaz.escribir("---------------------------------------------");
			Empleado e=GestionarCita.devuelveEmpleado(cedulaEmpleado);
			gestorInterfaz.escribir(e);
			gestorInterfaz.escribir(" ");
			//Escoger Servicios
			ArrayList<Servicio> servicios=GestionarCita.escogerServicios();
			gestorInterfaz.escribir(" ");
			int mes=gestorInterfaz.leerEntero("Digite mes: ");
			int dia=gestorInterfaz.leerEntero("Digite dia: ");
			gestorInterfaz.escribir(" ");
			GestionarCita.mostrarCitas(e,mes,dia,servicios);
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
	
	public static void mostrarCitas(Empleado p, int mes, int dia, ArrayList<Servicio> servicios) {
		
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
			
			gestorInterfaz.escribir(p.getNombre()+" no sposee citas asignadas este día");
			int cambioDia=gestorInterfaz.leerEntero("Digite 0 para escoger otro día, de lo contrario 1");//Escoger otro día
			if (cambioDia==0){
				gestorInterfaz.escribir(" ");
				int NuevoMes=gestorInterfaz.leerEntero("Digite nuevo mes");//Escoger otro mes
				int nuevoDia=gestorInterfaz.leerEntero("Digite nuevo dia");//Escoger otro mes				
				mostrarCitas(p, NuevoMes, nuevoDia,servicios);
			}
			else {
				gestorInterfaz.escribir(" ");
				boolean validar=false;
				while(validar==false) {
					int hora=gestorInterfaz.leerEntero("Digite la hora");
					int minuto=gestorInterfaz.leerEntero("Digite los minutos");			
					//devolver hora de la cita				
					LocalDateTime citaFinal=LocalDateTime.of(2022, mes, dia, hora, minuto); //crea la cita
					validar=GestionarCita.validarHora(p, citaFinal, servicios);
				}
				
			}
			
			//Devolver hora de la cita
		}
		else {
		
			int cambioDia=gestorInterfaz.leerEntero("Digite 0 para escoger otro día, de lo contrario 1");//Escoger otro día
			if (cambioDia==0){
				gestorInterfaz.escribir(" ");
				int NuevoMes=gestorInterfaz.leerEntero("Digite nuevo mes");//Escoger otro mes
				int nuevoDia=gestorInterfaz.leerEntero("Digite nuevo dia");//Escoger otro mes				
				mostrarCitas(p, NuevoMes, nuevoDia,servicios);
			}
			else {
				//validar hora
				boolean validar=false;
				while(validar==false) {
					int hora=gestorInterfaz.leerEntero("Digite la hora");
					int minuto=gestorInterfaz.leerEntero("Digite los minutos");			
					//devolver hora de la cita				
					LocalDateTime citaFinal=LocalDateTime.of(2022, mes, dia, hora, minuto); //crea la cita
					validar=GestionarCita.validarHora(p, citaFinal, servicios);
				}
				
				
			}
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
	
	
	public static boolean  validarHora(Empleado p, LocalDateTime horaTentativa, ArrayList<Servicio> servicios) {
		
		boolean aceptada=false;
		int duracion=GestionarCita.duracionCita(servicios);
		LocalDateTime horaTentativaFin=horaTentativa.plusMinutes(duracion);
		
		if(horaTentativa.toLocalTime().isBefore(Empleado.HoraInicio)  || horaTentativa.toLocalTime().isAfter(Empleado.HoraFinal) ) {
			gestorInterfaz.escribir("Recuer que los horaios de atención son de: 9 a 18 ");
			return false;
			
		}
		
		for(Factura factura : p.getServiciosRealizados()) {	//Recorrer citas del empleado					
			int mesComparacion=factura.getCita().getFechaCita().getMonthValue(); //Mes cita
			int diaComparacion=factura.getCita().getFechaCita().getDayOfMonth(); //Dia cita
			LocalDateTime existenteInicial=factura.getCita().getFechaCita();//hora Inicial
			LocalDateTime existenteFinal=factura.getCita().getFechaCita().plusMinutes(factura.getCita().getDuracion());//hora Final
			if((horaTentativa.getMonthValue() == mesComparacion)  && (horaTentativa.getDayOfMonth() == diaComparacion)) { //comparamos la cita
				if((horaTentativa.isBefore(existenteInicial) &&  horaTentativaFin.isBefore(existenteFinal)) || (horaTentativa.isAfter(existenteInicial) &&  horaTentativaFin.isAfter(horaTentativaFin))) {
					gestorInterfaz.escribir(" ");
					gestorInterfaz.escribir("Es posible generar la cita");
					return true;
				}
				else {
					gestorInterfaz.escribir("Existen horas trocadas con la cita: "+factura.getCita());
					return false;
				}

			}							
		}

		
		return true;
	}
	
	public static ArrayList<Servicio> escogerServicios() {//Devuelve un arreglo de servicios
		
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
		gestorInterfaz.escribir("");
		
		String reservas =gestorInterfaz.leer("Ingrese separado por espacios los servicos que requiere"); //Ingresa los servicios
		
		String[] ArregloReservas = reservas.split(" ");//convierte String en arreglo
		
		ArrayList<Servicio> serviciosEscogidos = new ArrayList<Servicio>();//Se crea un arreglo de servicios
		
		for (String servicio :ArregloReservas ) {//Se recorre el arreglo y se agregan a la lista de serviciosEscogidos
			int ser=Integer.parseInt(servicio);
			if (ser>=1 && ser<=10) {
				switch (ser) {
				case 1:
					if (!serviciosEscogidos.contains(Servicio.PEDICURE)){
						serviciosEscogidos.add(Servicio.PEDICURE);
					}
										
					break;
					
				case 2:
					if (!serviciosEscogidos.contains(Servicio.MANICURE)){
						serviciosEscogidos.add(Servicio.MANICURE);
					}					
					break;
					
				case 3:
					if(!serviciosEscogidos.contains(Servicio.ALIZADO)) {
						serviciosEscogidos.add(Servicio.ALIZADO);
					}
					
					break;
					
				case 4:
					if(!serviciosEscogidos.contains(Servicio.CEPILLADO)) {
						serviciosEscogidos.add(Servicio.CEPILLADO);
					}
					
					break;
					
				case 5:
					if(!serviciosEscogidos.contains(Servicio.KERATINA)) {
						serviciosEscogidos.add(Servicio.KERATINA);
					}
					
					break;
					
				case 6:
					if(!serviciosEscogidos.contains(Servicio.CORTE_CABALLERO)) {
						serviciosEscogidos.add(Servicio.CORTE_CABALLERO);
					}
					break;
					
				case 7:
					if(!serviciosEscogidos.contains(Servicio.CORTE_DAMA)) {
						serviciosEscogidos.add(Servicio.CORTE_DAMA);
					}
					break;
					
				case 8:
					if(!serviciosEscogidos.contains(Servicio.EXFOLIACION_FACIAL)) {
						serviciosEscogidos.add(Servicio.EXFOLIACION_FACIAL);
					}
					
					break;
					
				case 9:
					if(!serviciosEscogidos.contains(Servicio.CEJAS)) {
						serviciosEscogidos.add(Servicio.CEJAS);
					}
					
					break;
					
				case 10:
					if(!serviciosEscogidos.contains(Servicio.DEPILACION_LASER)) {
						serviciosEscogidos.add(Servicio.DEPILACION_LASER);
					}
					break;

				default:
					break;
				}
			}
		}
		gestorInterfaz.escribir("");
		gestorInterfaz.escribir("Servicios escogidos");
		gestorInterfaz.escribir(serviciosEscogidos);
		
		return serviciosEscogidos;
	}	
	
	public static int duracionCita (ArrayList <Servicio> servicios) {
		
		int duracion=0;
		for(Servicio ser: servicios) {
			duracion += ser.getDuracion();
		}
		return duracion;
	}
	

}
