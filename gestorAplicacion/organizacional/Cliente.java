package organizacional;

import operacional.*;
import java.util.*;

public class Cliente extends Persona {
	
	// Atributos
	private String anotaciones;
	private ArrayList<Cita> citasGeneradas;
	private ArrayList<Factura> facturas;
	private boolean ClientePremiun;

	// constructor base
	public Cliente(String nombre, String apellido, int id, int edad, int numero, String anotaciones,
			ArrayList<Cita> citasGeneradas, ArrayList<Factura> facturas, boolean clientePremiun) {
		super(nombre, apellido, id, edad, numero);
		this.anotaciones = anotaciones;
		this.citasGeneradas = citasGeneradas;
		this.facturas = facturas;
		ClientePremiun = clientePremiun;
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
		return "Cliente [anotaciones=" + anotaciones + ", citasGeneradas=" + citasGeneradas + ", facturas=" + facturas
				+ ", ClientePremiun=" + ClientePremiun + "]";
	}
	
	
	

}