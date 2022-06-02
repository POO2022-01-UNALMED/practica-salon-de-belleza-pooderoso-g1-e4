package gestorAplicacion.organizacional;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Persona implements Serializable {  
	
	//-----------SERIALIZADOR-----------
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<Persona> personas;
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
	private LocalDateTime fechaRegistro;

	//-----------CONSTRUCTOR-----------
	public Persona(String nombre, String apellido, int id, int edad, int numero) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		this.fechaRegistro = LocalDateTime.now();
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
	
	public LocalDateTime getInicioVinculacion() {
		return this.fechaRegistro;
	}
	
	public void setFechaRegistro(LocalDateTime nuevaFechaRegistro) {
		
		this.fechaRegistro = nuevaFechaRegistro;
		
	}
	
	//-----------METODO ABSTRACTOS-----------
	
	public abstract String gestionSeguros();

	//-----------OTROS METODOS-----------
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", Edad=" + Edad + ", Numero="
				+ Numero + "]";
	}
	
	
	
	

}
