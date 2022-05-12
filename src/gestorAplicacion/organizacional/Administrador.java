package gestorAplicacion.organizacional;
import java.io.Serializable;
import java.util.ArrayList;



public class Administrador extends Persona implements Serializable {  //implements del serializable
	
	//todo esto es del serializador
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Administrador> administradores;
	static {
		administradores = new ArrayList<Administrador>();
	}
	
	
	public static ArrayList<Administrador> getAdministradores() {
		return administradores;
	}

	public static void setAdministradores(ArrayList<Administrador> administradores) {
		Administrador.administradores = administradores;
	}

	//también en cada constructor se debe poner el add al array
	// ahora si el codigo{
	
	//atributos
	
	private String horarioLaboral;
	private int nomina;
	
	
	//stributo clase
	public static ArrayList<Cliente> clientes =new ArrayList<Cliente>(); 
	public static ArrayList<Empleado> empleadosAsigandos= new ArrayList<Empleado>();
	
	
	//constructor base
	public Administrador(String nombre, String apellido, int id, int edad, int numero, String horarioLaboral, int nomina ) {
		super(nombre, apellido, id, edad, numero);
		this.horarioLaboral=horarioLaboral;
		this.nomina=nomina;
		this.empleadosAsigandos=empleadosAsigandos;	
		administradores.add(this);
	}
	
	//getter y setters

	public String getHorarioLaboral() {
		return horarioLaboral;
	}


	public void setHorarioLaboral(String horarioLaboral) {
		this.horarioLaboral = horarioLaboral;
	}


	public int getNomina() {
		return nomina;
	}


	public void setNomina(int nomina) {
		this.nomina = nomina;
	}


	public ArrayList<Empleado> getEmpleadosAsigandos() {
		return empleadosAsigandos;
	}


	public void setEmpleadosAsigandos(ArrayList<Empleado> empleadosAsigandos) {
		this.empleadosAsigandos = empleadosAsigandos;
	}

	//toString
	@Override
	public String toString() {
		return "Administrador [horarioLaboral=" + horarioLaboral + ", nomina=" + nomina + ", empleadosAsigandos="
				+ empleadosAsigandos + "]";
	}
	
	//Metodos
	
	public void generarFactura() {
		System.out.println("generamos la Fcatura");		
	}
	
	public void reservarCita() {
		System.out.println("cita reservada");		
	}
	
	public void cancelarCita() {
		System.out.println("cita reservada");		
	}
	
	public void generarBalance() {
		System.out.println("balance");		
	}
	
	public void pagarNomina() {
		//cuentaahorros
		//Factura
		//Empleados
		System.out.println("nomina Pagada");		
	}
	
	public void ventaProductos() {
		System.out.println("venta Productos");		
	}	
	
	
	
	
	
	
	

	
	

}
