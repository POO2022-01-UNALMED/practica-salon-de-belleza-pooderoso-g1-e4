package gestorAplicacion.operacional;

import gestorAplicacion.organizacional.Empleado;

import java.io.Serializable;
import java.util.ArrayList;


public class CuentadeAhorro implements Serializable {  //implements del serializable
	
	//todo esto es del serializador
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<CuentadeAhorro> cuentasdeAhorro;
	static {
		cuentasdeAhorro = new ArrayList<CuentadeAhorro>();
	}
	
	public static ArrayList<CuentadeAhorro> getCuentasdeAhorro() {
		return cuentasdeAhorro;
	}


	public static void setCuentasdeAhorro(ArrayList<CuentadeAhorro> cuentasdeAhorro) {
		CuentadeAhorro.cuentasdeAhorro = cuentasdeAhorro;
	}
		
	
	//también en cada constructor se debe poner el add al array
	// ahora si el codigo{

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
			cuentasdeAhorro.add(this);
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

	
	
	

