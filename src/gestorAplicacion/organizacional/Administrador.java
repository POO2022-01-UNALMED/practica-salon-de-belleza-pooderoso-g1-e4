package gestorAplicacion.organizacional;
import java.io.Serializable;
import java.util.ArrayList;



public class Administrador extends Persona implements Serializable {  
	
	//-----------SERIALIZADOR-----------
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


	
	//-----------ATRIBUTOS DE INSTANCIA-----------
	private String horarioLaboral;
	private int nomina;
	
	
	//-----------ATRIBUTOS DE CLASE-----------
	public static ArrayList<Cliente> clientes =new ArrayList<Cliente>(); 
	public static ArrayList<Empleado> empleadosAsigandos= new ArrayList<Empleado>();
	
	
	//-----------CONSTRUCTOR-----------
	public Administrador(String nombre, String apellido, int id, int edad, int numero, String horarioLaboral, int nomina ) {
		super(nombre, apellido, id, edad, numero);
		this.horarioLaboral=horarioLaboral;
		this.nomina=nomina;
		this.empleadosAsigandos=empleadosAsigandos;	
		administradores.add(this);
	}
	
	
	//-----------GETTERS y SETTERS-----------
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
		Administrador.empleadosAsigandos = empleadosAsigandos;
	}

	
	//-----------OTROS METODOS-----------
	@Override
	public String toString() {
		return "Administrador [horarioLaboral=" + horarioLaboral + ", nomina=" + nomina + ", empleadosAsigandos="
				+ empleadosAsigandos + "]";
	}

	public void venderProducto() {
	}
	
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
