package gestorAplicacion.organizacional;
import java.io.Serializable;
import java.util.ArrayList;

public class Persona implements Serializable {  //implements del serializable
	
	//todo esto es del serializador
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Persona> personas;
	static {
		personas = new ArrayList<Persona>();
	}

	
	public static ArrayList<Persona> getPersonas() {
		return personas;
	}

	public static void setPersonas(ArrayList<Persona> personas) {
		Persona.personas = personas;
	}


	//también en cada constructor se debe poner el add al array
	// ahora si el codigo
	
	// Atributos
	private String nombre;
	private String apellido;
	private int id;
	private int Edad;
	private int Numero;

	// constructor base
	public Persona(String nombre, String apellido, int id, int edad, int numero) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		Edad = edad;
		Numero = numero;
		personas.add(this);
	}

	// getters y setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	//toString
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", Edad=" + Edad + ", Numero="
				+ Numero + "]";
	}
	
	
	
	

}
