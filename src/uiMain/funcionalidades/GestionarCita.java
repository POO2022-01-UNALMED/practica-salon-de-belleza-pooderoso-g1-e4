package uiMain.funcionalidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

import gestorAplicacion.operacional.*;
import gestorAplicacion.organizacional.*;
import uiMain.gestorInterfaz;


public class GestionarCita {
	
	/*
	static {		
		
		Empleado empleado1 =new Empleado("Marlon", "Nivia", 1000, 21, 32430847, "Uñas");		
		Empleado empleado2 =new Empleado("Julian", "Ospina", 525206530, 20, 3208845, "Pelo");//El numero no alcanza parce poner l de Long		
		//----------------------------
		Cliente c1 =new Cliente("Luisa", "Palacio", 12, 23, 301623697 , "Ninguna");
		Cita Cita1= new Cita(empleado1, c1, null, LocalDateTime.now() , LocalDateTime.of(2022, 5, 30, 14, 0) , 60);
		

	}	
	 */
	
	
    /**
     * Reune todos los parametros para poder generar una cita de manera correcta.
     *
     * @return Diferentes preguntas de confirmacion
     */	
	public static void reservarCita() {
		
		//Es un nuevo Cliente?
		gestorInterfaz.escribir("                         ");
		gestorInterfaz.escribir("1. Cliente ya existente");
		gestorInterfaz.escribir("2. Nuevo Cliente");
		gestorInterfaz.escribir("Digite Opcion: ");
		
		
		int TipoCliente=gestorInterfaz.leerEntero();
		
		Cliente clienteaAsignar;
		
		if (TipoCliente==1){
						
			gestorInterfaz.escribir("");					

			int cedulaCliente=gestorInterfaz.leerEntero("Digite la identificacion del cliente");				
			clienteaAsignar=devuelveCliente(cedulaCliente);
			
			while(clienteaAsignar==null) {					
				cedulaCliente=gestorInterfaz.leerEntero("Cliente no encontrado, digite nuevamente");				
				clienteaAsignar=devuelveCliente(cedulaCliente);	//Cliente									
			}
		}
		else {
			clienteaAsignar=GestionarCita.crearNuevoCliente();
		}
			
		gestorInterfaz.escribir(" ");
		gestorInterfaz.escribir(clienteaAsignar);
		gestorInterfaz.escribir(" ");				
		mostrarEmpleados();
		gestorInterfaz.escribir(" ");
		int cedulaEmpleado=gestorInterfaz.leerEntero("Digite la identificacion del empleado al cual se le asignara la cita: ");
		gestorInterfaz.escribir(" ");
		gestorInterfaz.escribir("---------------------------------------------");
		Empleado e=GestionarCita.devuelveEmpleado(cedulaEmpleado);//Empleado
		gestorInterfaz.escribir(e);
		gestorInterfaz.escribir(" ");
		//Escoger Servicios
		ArrayList<Servicio> servicios=GestionarCita.escogerServicios();//Servicio
		gestorInterfaz.escribir(" ");
		int mes=GestionarCita.ingresarMes();
		int dia=GestionarCita.ingresarDia(mes);
		gestorInterfaz.escribir(" ");
		boolean estado=GestionarCita.mostrarCitas(e,mes,dia);
		LocalDateTime fechaCita=GestionarCita.gestionarFecha(estado,e, mes, dia,servicios);//fecha
		GestionarCita.generarCita(e, clienteaAsignar, servicios, LocalDateTime.now() , fechaCita);
				
					
	}
	

    /**
     * Muestra la lista de empleados actuales del salon de belleza
     * 
     *
     * @return Muestra por consola los empleados
     */
	public static void mostrarEmpleados() {		
		gestorInterfaz.escribir("------ Lista de empleados ------");
		gestorInterfaz.escribir(" ");
		for(Empleado e : Empleado.getEmpleados()) {
			gestorInterfaz.escribir(e);
		}
	}
	
    /**
     * Crea un nuevo cliente
     * 
     *
     * @return Nuevo cliente del salon de belleza, verifica si ya existe otro igual.
     */
	public static Cliente crearNuevoCliente() {
		
		gestorInterfaz.escribir("Por favor ingrese los datos del cliente");
		gestorInterfaz.escribir("");
		String nombre=gestorInterfaz.leer("Por favor ingrese nombre del cliente: ");	
		String apellido=gestorInterfaz.leer("Por favor ingrese apellido del cliente: ");
		int id=gestorInterfaz.leerEntero("Por favor ingrese identificaión del cliente: ");
		for(Cliente cliente: Cliente.getClientes()) {
			if(cliente.getId()==id) {
				gestorInterfaz.escribir("");
				gestorInterfaz.escribir("----Cliente ya existente, verifique nuevamente la informacion----");
				GestionarCita.crearNuevoCliente();
			}
		}
		int edad=gestorInterfaz.leerEntero("Por favor ingrese edad del cliente: ");
		int numero=gestorInterfaz.leerEntero("Por favor ingrese numero del cliente: ");
		String anotaciones=gestorInterfaz.leer("Por favor ingrese anotaciones del cliente: ");
		
		Cliente nuevoCliente = new Cliente(nombre, apellido, id, edad, numero, anotaciones);
		
		gestorInterfaz.escribir("");
		gestorInterfaz.escribir("El nuevo cliente es: "+ nuevoCliente);
		
		return nuevoCliente;
		
	}
	

    /**
     * Devuelve un empleado 
     *
     * @param cedula, se ingresa la identificacion del empleado.
     * @return El empleado encontrado, a partir de la cedula
     */
	public static Empleado devuelveEmpleado(int cedula) {
					
		
		for(Empleado e: Empleado.getEmpleados()) {
			if (e.getId()==cedula) {
				return e;
			}			
		}
		
		int nuevaCedula=gestorInterfaz.leerEntero("Empledo no encontrado, por favor ingrese nuevamente la identificación del empleado:");
		return GestionarCita.devuelveEmpleado(nuevaCedula);
		
		 
	}
	
    /**
     * Devuelve un cliente 
     *
     * @param cedula, se ingresa la identificacion del cliente.
     * @return El cliente encontrado, a partir de la cedula
     */	
	public static Cliente devuelveCliente(int cedula) {
		
		for(Cliente c: Cliente.getClientes()) {
			if (c.getId()==cedula) {
				return c;
			}
			
		}
		return null;
	}
	
    /**
     * Muestra las citas de un empleado 
     *
     * @param empleado: El empleado al cual se le buscan las citas
     * 		  mes: mes de las citas
     * 		  dia: dia de las citas	
     * @return imprime por consola las citas del empleado  y
     * 		  devulve true or false si tiene o no citas
     */	
	public static boolean mostrarCitas(Empleado empleado, int mes, int dia) {
		
		gestorInterfaz.escribir("------- Citas asignadas al empleado "+ empleado.getNombre() +" el dia: "+ dia+ " del mes: "+ mes+"----------");
		gestorInterfaz.escribir(" ");
		boolean citasAsignadas = false;
		
		ArrayList<Cita> citasDelDia = new ArrayList<Cita> ();
		
		for(Cita cita : empleado.getCitasAsignadas()) {	//Recorrer citas del empleado
			
			int mesComparacion=cita.getFechaCita().getMonthValue(); //Mes cita
			int diaComparacion=cita.getFechaCita().getDayOfMonth(); //Dia cita
			
			if((mes == mesComparacion)  && (dia == diaComparacion) && cita.getEstado()!="Cancelada") { //comparamos la cita
				//gestorInterfaz.escribir(cita);//Mostrar cita
			    //gestorInterfaz.escribir(" ");
			    citasDelDia.add(cita);
			    
			    citasAsignadas = true;
			}							
		}
		
		Collections.sort(citasDelDia);
		for(Cita cita: citasDelDia) {
			gestorInterfaz.escribir(cita);//Mostrar cita
		    gestorInterfaz.escribir(" ");
			
		}
		
		return citasAsignadas;
		
		
	}

	   /**
     * Devuelve un fecha 
     *
     * @param citasAsigndas: si el empleado tine o no citas
     * 		  Empleado: empleado para verificar las citas
     * 		  mes: mes de las citas
     * 		  dia: dia de las citas
     * 		  servicios: los servicios que se quieren de una cita	
     * @return la fecha de la cita
     */	
	public static LocalDateTime gestionarFecha(boolean citasAsignadas,Empleado p, int mes, int dia, ArrayList<Servicio> servicios)  {
				
		
		if(citasAsignadas==false) {
			
			gestorInterfaz.escribir(p.getNombre()+" no sposee citas asignadas este día");
			int cambioDia=gestorInterfaz.leerEntero("Digite 0 para escoger otro día, de lo contrario 1");//Escoger otro día
			if (cambioDia==0){
				gestorInterfaz.escribir(" ");
				int NuevoMes=GestionarCita.ingresarMes();//Escoger otro mes
				int nuevoDia=GestionarCita.ingresarDia(NuevoMes);//Escoger otro mes
				boolean estado = mostrarCitas(p, NuevoMes, nuevoDia);
				gestionarFecha(estado,p, NuevoMes, nuevoDia,servicios);
			}
			else {
				gestorInterfaz.escribir(" ");
				boolean validar=false;
				LocalDateTime citaFinal = null;
				while(validar==false) {
					int hora=GestionarCita.ingresarHora();
					int minuto=GestionarCita.ingresarMinutos();			
					//devolver hora de la cita				
					citaFinal=LocalDateTime.of(2022, mes, dia, hora, minuto); //crea la cita
					validar=GestionarCita.validarHora(p, citaFinal, servicios);
					
				}
				return citaFinal;
				
			}
			
			//Devolver hora de la cita
		}
		else {
		
			int cambioDia=gestorInterfaz.leerEntero("Digite 0 para escoger otro dia, de lo contrario 1");//Escoger otro día
			if (cambioDia==0){
				gestorInterfaz.escribir(" ");
				int NuevoMes=GestionarCita.ingresarMes();//Escoger otro mes
				int nuevoDia=GestionarCita.ingresarDia(NuevoMes);//Escoger otro mes				
				boolean estado = mostrarCitas(p, NuevoMes, nuevoDia);
				LocalDateTime cita=gestionarFecha(estado,p, NuevoMes, nuevoDia,servicios);
			}
			else {
				//validar hora
				boolean validar=false;
				LocalDateTime citaFinal = null;
				while(validar==false) {
					int hora=GestionarCita.ingresarHora();
					int minuto=GestionarCita.ingresarMinutos();			
					//devolver hora de la cita				
					citaFinal=LocalDateTime.of(2022, mes, dia, hora, minuto); //crea la cita
					validar=GestionarCita.validarHora(p, citaFinal, servicios);
					
				}
				return citaFinal;
				
				
			}
		}
		
		return null;
		
	}	
	
	  /**
     * Verifica que una cita se pueda llevar a cabo 
     *
     * @param 
     * 		  Empleado: empleado para verificar las citas
     * 		  horaTentativa: posible hora a validar
     * 		  servicios: los servicios que se quieren de una cita	
     * @return true en caso de que se pueda generar una cita false de lo contrario
     */
	
	public static boolean  validarHora(Empleado p, LocalDateTime horaTentativa, ArrayList<Servicio> servicios) {
		
		boolean aceptada=false;
		int duracion=GestionarCita.duracionCita(servicios);
		LocalDateTime horaTentativaFin=horaTentativa.plusMinutes(duracion);
		
		if(horaTentativa.toLocalTime().isBefore(Empleado.HoraInicio)  || horaTentativa.toLocalTime().isAfter(Empleado.HoraFinal) ) {
			gestorInterfaz.escribir("Recuerde que los horarios de atencion son de: 9 a 18 ");
			return false;
			
		}
		
		for(Cita cita : p.getCitasAsignadas()) {	//Recorrer citas del empleado					
			int mesComparacion=cita.getFechaCita().getMonthValue(); //Mes cita
			int diaComparacion=cita.getFechaCita().getDayOfMonth(); //Dia cita
			LocalDateTime existenteInicial=cita.getFechaCita();//hora Inicial
			LocalDateTime existenteFinal=cita.getFechaCita().plusMinutes(cita.getDuracion());//hora Final
			if((horaTentativa.getMonthValue() == mesComparacion)  && (horaTentativa.getDayOfMonth() == diaComparacion) && cita.getEstado()!="Cancelada") { //comparamos la cita
				if((horaTentativa.isBefore(existenteInicial) &&  horaTentativaFin.isBefore(existenteFinal)) || (horaTentativa.isAfter(existenteInicial) &&  horaTentativaFin.isAfter(existenteFinal))) {
					gestorInterfaz.escribir(" ");
					gestorInterfaz.escribir("Es posible generar la cita");
					return true;
				}
				else {
					gestorInterfaz.escribir("Existen horas trocadas con la cita: "+cita);
					return false;
				}

			}							
		}

		
		return true;
	}

	  /**
     * Muestra y permite seleccionar los servicios que una persona quiere seleccionar
     *	
     * @return evuelve un arreglo de servicios escogidos por el cliente
     */
	public static ArrayList<Servicio> escogerServicios() {
		
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

	 /**     
	 * Devuelve la duracion de una cita a partir una cita	
     * @param servicios: lista de servicios 
     * 
     * @return la duracion de una cita a partir de los servicios escogidos
     */
	public static int duracionCita (ArrayList <Servicio> servicios) {
		
		int duracion=0;
		for(Servicio ser: servicios) {
			duracion += ser.getDuracion();
		}
		return duracion;
	}
	

	/**     
	* Genera una cita
     * @param Empleado: empleado al cual se le va a asignar una cita 
    *         cliente: cliente al cual se le va a gnerar una cita
    *         servicios: lista de servicios escogidos
    *         fechaReserva: fecha en la que se agendo la cita
    *         fechaCita: fecha en la cual se realizara la cita 
    *
    * @return la duracion de una cita a partir de los servicios escogidos
    */
	public static void generarCita(Empleado empleado, Cliente cliente, ArrayList<Servicio> servicios, LocalDateTime fechaReserva, LocalDateTime fechaCita){
	    int duracion= GestionarCita.duracionCita(servicios);
		Cita nuevaCita=new Cita( empleado,  cliente, servicios,fechaReserva, fechaCita, duracion);
		System.out.println(nuevaCita);
		
	}
	

	/**     
	* Gestiona la cancelacion de una cita
	* 
	* verifica si se desea cancelar a partir de un empleado o de un cliente 
	* hace una casteo a partir de lo que recibe de otros metodos
    */
	public static void  gestionCancelar() {
		int cedula =gestorInterfaz.leerEntero("Ingrese la identificación del cliente o del empleado al cual se le quiere cancelar la cita: ");
		
		
		Persona persona =devolverPersona(cedula);
		
		while (persona==null) {
			cedula=gestorInterfaz.leerEntero("Verifique la identificacion de la persona");
			gestorInterfaz.escribir(" ");
			persona =devolverPersona(cedula);
		}
		
		
		if (persona instanceof Empleado) {
			GestionarCita.cancelarCita(((Empleado)persona));
			
		}
		else {
			GestionarCita.cancelarCita(((Cliente)persona));
		}		
	}

	/**     
	* Devuelve una persona a partir de su cedula
    * @param cedula: cedula de la persona a la cual se le quiere cancelar la cita  
    *
    * @return La persona a la cual se le quiere cancelar la cita
    */
	public static Persona devolverPersona(int cedula) {		
		Persona persona;
		for(Empleado empleado : Empleado.getEmpleados() ) {
			if(empleado.getId()==cedula) {
				gestorInterfaz.escribir("Empleado encontrado: " + empleado);
				return empleado;
			}
		}
		
		for(Cliente cliente : Cliente.getClientes()) {
			if(cliente.getId()==cedula) {
				gestorInterfaz.escribir("Cliente encontrado: " + cliente);
				return cliente;
			}
		}		
		return null;						
	}
	
	/**     
	* Se cancela la cita de un Empleado
    * @param Emplead: objeto de tipo empleado  
    *
    * @return un mensaje consola de la cita del empleado cancelada 
    */	
	public static void cancelarCita(Empleado empleado) {
		
		gestorInterfaz.escribir(" ");
		gestorInterfaz.escribir("=== Se muestra las citas ordenadas por fecha ===");
		gestorInterfaz.escribir(" ");
		Collections.sort(empleado.getCitasAsignadas());
		for (Cita cita : empleado.getCitasAsignadas()) {
			if(cita.getEstado()!="Cancelada") {
				gestorInterfaz.escribir("id de la cita: "+cita.getId()+" - "+cita);
				gestorInterfaz.escribir(" ");				
			}
			
		}
		
		int id=gestorInterfaz.leerEntero("Digite el id de la cita que desea cancelar: ");
		
		for (Cita cita : empleado.getCitasAsignadas()) {
			if(id==cita.getId()) {
				cita.setEstado("Cancelada");
				gestorInterfaz.escribir(cita+". **Estado de la cita:" + cita.getEstado()+"**");
				break;
			}					
		}
		
	}

	/**     
	* Se cancela la cita de un Cliente
    * @param cliento: objeto de tipo cliente  
    *
    * @return un mensaje consola de la cita del cliente cancelada 
    */		
	public static void cancelarCita(Cliente cliente) {
		
		gestorInterfaz.escribir(" ");
		gestorInterfaz.escribir("=== Se muestra las citas ordenadas por fecha ===");
		gestorInterfaz.escribir(" ");
		Collections.sort(cliente.getCitasGeneradas());
		for (Cita cita : cliente.getCitasGeneradas()) {
			if(cita.getEstado()!="Cancelada") {
				gestorInterfaz.escribir("id de la cita: "+cita.getId()+" - "+cita);
				gestorInterfaz.escribir(" ");
			}

		}
		
		int id=gestorInterfaz.leerEntero("Digite el id de la cita que desea cancelar: ");
		
		for (Cita cita : cliente.getCitasGeneradas()) {
			if(id==cita.getId()) {
				cita.setEstado("Cancelada");
				gestorInterfaz.escribir(cita+". **Estado de la cita:" + cita.getEstado()+"**");
				break;
			}					
		}
		
		
	}

	/**     
	* Verifica que se pueda escoger un mes  
    *
    * @return un entero con un mes correcto 
    */
	public static int ingresarMes() {
		
		int mes=gestorInterfaz.leerEntero("Digite el mes de la cita:");
		if(mes<LocalDateTime.now().getMonthValue()) {
			gestorInterfaz.escribir("El mes debe ser mayor o igual al actual");
			return GestionarCita.ingresarMes();
		}
		else if(mes<=0 || mes >12){
			gestorInterfaz.escribir("El mes debe estar entre 0 y 12");
			return GestionarCita.ingresarMes();
		}
		else {
			return mes;
		}
				
	}

	/**     
	* Verifica que se pueda escoger un dia  
    *
    * @return un entero con un dia correcto 
    */	
	public static int ingresarDia(int mes) {
		
		int dia=gestorInterfaz.leerEntero("Digite el dia de la cita:");
		int diaActual= LocalDateTime.now().getDayOfMonth();
		int mesActual= LocalDateTime.now().getMonthValue();
		
		if( dia< diaActual  && mes <= mesActual ) {
			gestorInterfaz.escribir("El dia debe estar ser mayor al actuañ");
			return GestionarCita.ingresarDia(mes);
		}
		else if(dia<=0 || dia >31){
			gestorInterfaz.escribir("El dia debe estar entre 0 y 31");
			return GestionarCita.ingresarDia(mes);
		}
		else {
			return dia;
		}

	}
	
	/**     
	* Verifica que se pueda escoger una hora  
    *
    * @return un entero con una hora correcta 
    */	
	public static int ingresarHora() {		
		int hora=gestorInterfaz.leerEntero("Digite la hora de la cita:");		
		if(hora<=0 || hora >24){
			gestorInterfaz.escribir("La hora debe estar entre 0 y 24");
			return GestionarCita.ingresarHora();
		}
		else {
			return hora;
		}
		
	}

	/**     
	* Verifica que se puedan escoger unos minutos  
    *
    * @return un entero con los minutos correctos 
    */	
	public static int ingresarMinutos() {		

		int minutos=gestorInterfaz.leerEntero("Digite los minutos de la cita:");		
		if(minutos<0 || minutos >60){
			gestorInterfaz.escribir("Los minutos deben estar entre 0 y 60");
			return GestionarCita.ingresarMinutos();
		}
		else {
			return minutos;
		}
		
	}	
	
	
}
