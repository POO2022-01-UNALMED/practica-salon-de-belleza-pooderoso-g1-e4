package baseDatos;

import java.io.EOFException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.operacional.*;
import gestorAplicacion.organizacional.*;

public class Deserializador {
	public static <E> void deserializador(List<E> list, String className) {
		FileInputStream fileIn;
		try {
			// Creamos una cadena con la ruta del archivo que vamos a cargar
			String path = System.getProperty("user.dir") + "/src/baseDatos/temp/" + className + ".txt";
			System.out.println(path);
			// Utilizamos un file para crear este archivo si no existe aun
			File archivo = new File(path);
			archivo.createNewFile(); // Crea un nuevo archivo si no existe

			// Usamos un FileInputStream para poder saber de donde cargar el archivo
			fileIn = new FileInputStream(path);

			// Si el archivo esta vacio se lanza un throw EOFException y se muestra como un mensaje de vacio, pero si no se usa el objeto in para leer el archivo
			ObjectInputStream in = new ObjectInputStream(fileIn);

			// Lee el listado de elementos
			ArrayList<E> listado = (ArrayList<E>) in.readObject();

			// Recorro el ArrayList
			for (E el : listado) {
				list.add(el);
			}

			in.close();
			fileIn.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Esta vacio");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static <E, V> void deserializador(HashMap<E, Integer> diccicionario, String className) {
		FileInputStream fileIn;
		try {
			// Creamos una cadena con la ruta del archivo que vamos a cargar
			String path = System.getProperty("user.dir") + "/src/baseDatos/temp/" + className + ".txt";
			System.out.println(path);
			// Utilizamos un file para crear este archivo si no existe aun
			File archivo = new File(path);
			archivo.createNewFile(); // Crea un nuevo archivo si no existe

			// Usamos un FileInputStream para poder saber de donde cargar el archivo
			fileIn = new FileInputStream(path);

			// Si el archivo esta vacio se lanza un throw EOFException y se muestra como un mensaje de vacio, pero si no se usa el objeto in para leer el archivo
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			
			// Lee el listado de elementos
			HashMap<E, Integer>dicc = (HashMap) in.readObject();
			Set parejas = dicc.entrySet();
			Iterator iterator = parejas.iterator();
			while(iterator.hasNext()) {
				Map.Entry<E, Integer> entradas = (Map.Entry<E, Integer>)iterator.next();
				diccicionario.put(entradas.getKey(), entradas.getValue());
			}
			// Recorro el ArrayList
			
			in.close();
			fileIn.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Esta vacio");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/* Funcion para deserializar */
	public static void deserializarTodo() {
		Deserializador.deserializador(Cita.getCitas(), "citas");
		Deserializador.deserializador(Factura.getFacturas(), "facturas");
		Deserializador.deserializador(Producto.getProductos(), "productos");
		Deserializador.deserializador(Venta.getVentas(), "ventas");
		Deserializador.deserializador(Administrador.getAdministradores(), "administradores");
		Deserializador.deserializador(Cliente.getClientes(), "clientes");
		Deserializador.deserializador(Empleado.getEmpleados(), "empleados");
		Deserializador.deserializador(Persona.getPersonas(), "personas");
		Deserializador.deserializador(Inventario.getInventario(), "inventario");
	}
}