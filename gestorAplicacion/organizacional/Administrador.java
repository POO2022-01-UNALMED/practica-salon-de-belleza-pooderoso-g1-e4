package organizacional;
import java.util.ArrayList;


public class Administrador extends Persona{
	//atributos
	private String horarioLaboral;
	private int nomina;
	private ArrayList<Empleado> empleadosAsigandos;
	
	
	//constructor base
	public Administrador(String nombre, String apellido, int id, int edad, int numero, String horarioLaboral, int nomina,ArrayList<Empleado> empleadosAsigandos ) {
		super(nombre, apellido, id, edad, numero);
		this.horarioLaboral=horarioLaboral;
		this.nomina=nomina;
		this.empleadosAsigandos=empleadosAsigandos;		
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
		System.out.println("nomina Pagada");		
	}
	
	public void ventaProductos() {
		System.out.println("venta Productos");		
	}	
	
	
	
	
	
	
	

	
	

}
