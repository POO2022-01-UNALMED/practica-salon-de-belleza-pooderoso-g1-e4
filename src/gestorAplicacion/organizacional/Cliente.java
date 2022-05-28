package gestorAplicacion.organizacional;
import java.io.Serializable;
import java.util.*;

import gestorAplicacion.operacional.Cita;
import gestorAplicacion.operacional.Factura;


public class Cliente extends Persona implements Serializable {  //implements del serializable
	
	//todo esto es del serializador
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
	}
	

	//también en cada constructor se debe poner el add al array
	// ahora si el codigo{
	
	

	// Atributos
	private String anotaciones;
	private ArrayList<Cita>  citasGeneradas=new ArrayList<Cita> () ;
	private ArrayList<Factura> facturas = new  ArrayList<Factura> ();
	
	private boolean ClientePremiun;//Revisar

	// constructor base
	public Cliente(String nombre, String apellido, int id, int edad, int numero, String anotaciones) {
		super(nombre, apellido, id, edad, numero);
		this.anotaciones = anotaciones;
		this.citasGeneradas = null;
		this.facturas = null;
		ClientePremiun = false;
		Administrador.clientes.add(this);
		clientes.add(this);
	}
	
	//Getters y Setters

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

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public boolean isClientePremiun() {
		return ClientePremiun;
	}

	public void setClientePremiun(boolean clientePremiun) {
		ClientePremiun = clientePremiun;
	}

	//toSring
	@Override
	public String toString() {
		return "Cliente: "+ this.getNombre() +" "+ this.getApellido()+", anotaciones: "+ anotaciones;
		
	}
	
	
	

}
