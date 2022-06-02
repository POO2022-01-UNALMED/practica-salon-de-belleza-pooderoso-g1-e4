package gestorAplicacion.organizacional;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import gestorAplicacion.operacional.Cita;
import gestorAplicacion.operacional.Factura;
import uiMain.gestorInterfaz;


public class Cliente extends Persona implements Serializable {  
	
	//-----------SERIALIZADOR-----------
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Cliente> clientes;
	static {
		clientes = new ArrayList<Cliente>();
	}
	
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(ArrayList<Cliente> clientes) {
		Cliente.clientes = clientes;
		Administrador.clientes=clientes;
	}
	
	
	
	//-----------ATRIBUTOS-----------
	private String anotaciones;
	private ArrayList<Cita>  citasGeneradas=new ArrayList<Cita> () ;
	private ArrayList<Factura> facturas = new  ArrayList<Factura> ();
	
	private boolean ClientePremiun;//Revisar

	//-----------CONSTRUCTORES-----------
	public Cliente(String nombre, String apellido, int id, int edad, int numero, String anotaciones) {
		super(nombre, apellido, id, edad, numero);
		this.anotaciones = anotaciones;
		this.citasGeneradas = new ArrayList<Cita> ();
		this.facturas = null;
		ClientePremiun = false;
		Administrador.clientes.add(this);
		clientes.add(this);
	}
	
	public Cliente(String nombre, String apellido, int id, int edad, int numero, String anotaciones, boolean clientePremiun) {
		super(nombre, apellido, id, edad, numero);
		this.anotaciones = anotaciones;
		ClientePremiun = clientePremiun;
		Administrador.clientes.add(this);
		clientes.add(this);
	
	}
	
	public Cliente(String nombre, String apellido, int id) {
		this(nombre,apellido,id,0,0," No posee anotaciones");
	}
	
	//----------METODO ABSTRACTO-----------
	public String gestionSeguros() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		ArrayList<Cita> citasCliente = this.getCitasGeneradas();
		String cadena = "";
		
		for(Cita c : citasCliente ) {
			
			LocalDateTime fechaCita = c.getFechaCita();
			LocalDateTime fechaFinalizacionCita = c.getFechaCita().plusMinutes(c.getDuracion());
			
			if( LocalDateTime.now().isAfter(fechaFinalizacionCita)) {
				
				cadena = cadena + "El cliente " + super.getNombre() + " " + super.getApellido() + " estuvo asegurado en la cita No. " + c.getId() +  " del "  + fechaCita.format(formato) + " a " + fechaFinalizacionCita.format(formato) + "\n";
			}else {
				
				cadena = cadena + "El cliente " + super.getNombre() + " " + super.getApellido() + " estará asegurado en la cita No. " + c.getId() +  " del "  + fechaCita.format(formato) + " a " + fechaFinalizacionCita.format(formato) + "\n";
			}
		}
		
		return cadena;
		
	}
	
	
	//-----------GETTERS Y SETTERS-----------
	public String getAnotaciones() {
		return anotaciones;
	}
	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	public ArrayList<Cita> getCitasGeneradas() {
		return citasGeneradas;
	}
	public void setCitasGeneradas(ArrayList<Cita> citasGeneradas) {
		this.citasGeneradas = citasGeneradas;
	}
	public void addCita(Cita cita) {
		this.citasGeneradas.add(cita);
	}
	

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	public void addFactura(Factura factura) {
		this.facturas.add(factura);
	}

	public boolean isClientePremiun() {
		return ClientePremiun;
	}
	public void setClientePremiun(boolean clientePremiun) {
		ClientePremiun = clientePremiun;
	}

	//-----------OTROS METODOS-----------
	@Override
	public String toString() {
		return "Cliente: "+ this.getNombre() +" "+ this.getApellido()+", anotaciones: "+ anotaciones;	
	}
	
	public static String digitarServicio() {
		return gestorInterfaz.leer();
		
	}
}
