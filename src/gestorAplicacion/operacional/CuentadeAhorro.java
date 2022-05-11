package gestorAplicacion.operacional;

import java.util.ArrayList;

import gestorAplicacion.organizacional.Empleado;

public class CuentadeAhorro {

	//Atributos 
	Empleado titularCuenta;
	private long numeroCuenta;
	private String fechaCreacion;
	private ArrayList<CuentadeAhorro> cuentasRegistradas;
	
	
	//construtor
	public CuentadeAhorro (Empleado titular, long numeroCuenta) {
			this.titularCuenta=titular;
			this.numeroCuenta=numeroCuenta;
			cuentasRegistradas.add(this);
	}
	

	//getters y setters
	public Empleado getTitularCuenta() {
		return titularCuenta;
	}

	public void setTitularCuenta(Empleado titularCuenta) {
		this.titularCuenta = titularCuenta;
	}

	public long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	//poner que atributo del cliente
	public String toString() {
		return "El empleado "+ titularCuenta.getNombre() +" "+titularCuenta.getApellido()+" "+"tiene una cuenta de ahorros con número: "+ numeroCuenta + ", abierta el:_ " +fechaCreacion;
		
	}

	}

	
	
	

