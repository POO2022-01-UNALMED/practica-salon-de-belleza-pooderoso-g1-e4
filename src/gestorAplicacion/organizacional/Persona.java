package gestorAplicacion.organizacional;
import java.io.Serializable;
import java.util.ArrayList;

public class Persona implements Serializable {  
	
	//-----------SERIALIZADOR-----------
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
	
	
	//-----------ATRIBUTOS-----------
	private String nombre;
	private String apellido;
	private int id;
	private int Edad;
	private int Numero;

	//-----------CONSTRUCTOR-----------
	public Persona(String nombre, String apellido, int id, int edad, int numero) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		Edad = edad;
		Numero = numero;
		personas.add(this);
	}

	
	//-----------GETTERS y SETTERS-----------
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

	//-----------OTROS METODOS-----------
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", Edad=" + Edad + ", Numero="
				+ Numero + "]";
	}
	
	
	
	

}
