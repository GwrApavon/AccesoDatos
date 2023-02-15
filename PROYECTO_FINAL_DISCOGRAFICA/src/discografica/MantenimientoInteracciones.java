package discografica;

import java.util.Scanner;

import com.dao.implementacion.CantanteDAOImpHibernate;
import com.modelo.Cantante;

public class MantenimientoInteracciones {
	Scanner sc = new Scanner(System.in);
	MantenimientoMenus mm = new MantenimientoMenus();
	private static String reset  = "\u001B[0m";
	private static String purple = "\033[35m";
	private static String cyan   = "\033[36m";
	private static String green  = "\033[32m";
	private static String yellow = "\u001B[33m";
	
	public Cantante insertarNuevoCantante(String base) {
		System.out.println("\n");
		String color = mm.obtenerColorSegunBase(base);
		colorearMensajeSalto(color,"Se va a insertar un nuevo Cantante en la base de datos "+base);
		Cantante c;
		String nombre = null;
		String nacionalidad = null;
		String respuesta = "";
		boolean bienEdad = false;
		int edad = 0;
		int numero_discos = 0;
		boolean bienDiscos = false;
		do {
			System.out.println("Dime el nombre del cantante");
			nombre = sc.nextLine();
		}while(nombre == null);
		
		do {
			System.out.println("Dime la edad del cantante");
			try {
				edad = Integer.parseInt(sc.nextLine());
				bienEdad = true;
			} catch(NumberFormatException ex) {
				System.err.println("Se debe introducir un número!");
			}		
		}while(!bienEdad);
		
		System.out.println("¿Desea añadirle la nacionalidad? Escribe: Yes");
		respuesta = sc.nextLine();
		if(respuesta.equalsIgnoreCase("yes")) {
			System.out.println("Dime su nacionalidad");
			nacionalidad = sc.nextLine();
		}
		
		do {
			System.out.println("Dime el número de discos platinos que posee el cantante");
			try {
				numero_discos = Integer.parseInt(sc.nextLine());
				bienDiscos = true;
			} catch(NumberFormatException ex) {
				System.err.println("Se debe introducir un número!");
			}		
		}while(!bienDiscos);
		
		c = new Cantante(nombre, edad, nacionalidad, numero_discos);

		return c;	
	}
	
	
	public Integer eliminarCantante(String base) {
		System.out.println("\n");
		String color = mm.obtenerColorSegunBase(base);
		colorearMensajeSalto(color,"Se va a eliminar un cantante según el id en la base: "+base);
		int id = 0;
		Integer idint = 0;
		boolean bienId = false;
		
		do {
			System.out.println("Dime el id del cantante que desea eliminar");
			try {
				id = Integer.parseInt(sc.nextLine());
				idint = id;
				bienId = true;
			} catch(NumberFormatException ex) {
				System.err.println("Se debe introducir un número!");
			}		
		}while(!bienId);
		
		return idint;	
	}
	
	public Integer preguntarIdModifica(String base) {
		String color = mm.obtenerColorSegunBase(base);
		colorearMensajeSalto(color,"Se va a modificar un cantante según el id en la base: "+base);
		boolean bienId = false;
		int id = 0;
		Integer idint = 0;
		
		do {
			System.out.println("Dime el id del cantante que desea modificar");
			try {
				id = Integer.parseInt(sc.nextLine());
				idint = id;
				bienId = true;
			} catch(NumberFormatException ex) {
				System.err.println("Se debe introducir un número!");
			}		
		}while(!bienId);
		
		return idint;
	}
	
	public void modificarCantante(String base, Cantante c) {
		System.out.println("\n");
		String respuesta = "";
		boolean bienEdad = false;
		boolean bienDiscos = false;
		int numero_discos = 0;
		int nuevaEdad = 0;
		
		
		System.out.println("¿Desea modificar el nombre?; Escribir 'YES'");
		respuesta = sc.nextLine();
		if(respuesta.equalsIgnoreCase("YES")) {
			System.out.println("Dime el nuevo nombre");
			String nuevoNombre = sc.nextLine();
			c.setNombre(nuevoNombre);
		}
		
		System.out.println("¿Desea modificar la edad?; Escribir 'YES'");
		respuesta = sc.nextLine();
		if(respuesta.equalsIgnoreCase("YES")) {
			do {
				System.out.println("Dime la edad del cantante");
				try {
					nuevaEdad = Integer.parseInt(sc.nextLine());
					bienEdad = true;
				} catch(NumberFormatException ex) {
					System.err.println("Se debe introducir un número!");
				}		
			}while(!bienEdad);
			c.setEdad(nuevaEdad);
		}
		
		System.out.println("¿Desea modificar la nacionalidad?; Escribir 'YES'");
		respuesta = sc.nextLine();
		if(respuesta.equalsIgnoreCase("YES")) {
			System.out.println("Dime la nueva nacionalidad");
			String nuevaNacionalidad = sc.nextLine();
			c.setNacionalidad(nuevaNacionalidad);
		}
		
		
		System.out.println("¿Desea modificar el número de discos?; Escribir 'YES'");
		respuesta = sc.nextLine();
		if(respuesta.equalsIgnoreCase("YES")) {
			do {
				System.out.println("Dime el número de discos platinos que posee el cantante");
				try {
					numero_discos = Integer.parseInt(sc.nextLine());
					bienDiscos = true;
				} catch(NumberFormatException ex) {
					System.err.println("Se debe introducir un número!");
				}		
			}while(!bienDiscos);
			c.setNumeroDiscosPlatinos(numero_discos);
		}		
	}
	
	
	private static void colorearMensajeSalto(String color, String mensaje) {
		System.out.println(color + mensaje + reset);
	}
	
	private static void colorearMensaje(String color, String mensaje) {
		System.out.print(color + mensaje + reset);
	}
}
