/**
 * 
 */
package cementerio.app;

import java.util.Scanner;

import com.controlador.DifuntoControler;
import com.modelo.Difunto;

/**
 * @author alu
 *
 */
public class GestorCementerio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static boolean menu(Scanner sc) {
	
		System.out.println("En que tipo de base de datos quieres trabajar:"
							+ "1. MySQL"
							+ "2. Neodatis"
							+ "3. ExistDB"
							+ "0. Salir");
		int opcion = sc.nextInt();
		sc.nextLine();
		String db;
		switch(opcion) {
			case 1: db = "MySQL";
				break;
			case 2: db = "Neodatis";
				break;
			case 3: db = "ExistDB";
				break;
			default: return true;
		}
		boolean salir = subMenu (sc, db);
		return salir;
	}
	
	private static boolean subMenu(Scanner sc, String db) {
		//Hacer bucle hasta que se quiera salir
		System.out.println("En que tabla de la base de datos quieres trabajar:"
							+ "1. Difunto"
							+ "2. Sepultura"
							+ "3. Responsable"
							+ "0. Atrás");
		int op = sc.nextInt();
		sc.nextLine();
		
		switch(op) {
			case 1:
					subMenuDifunto(sc, db);
			case 2:
					//subMenuSepultura
			case 3:
					//subMenuResponsable
			default: return true;
		}
	}
	
	private static boolean subMenuDifunto(Scanner sc, String db) {
		//Hacer bucle hasta que se quiera salir 
		System.out.println("En que tabla de la base de datos quieres trabajar:"
				+ "1. Crear Difunto"
				+ "2. Modificar Difunto"
				+ "3. Borrar Difunto"
				+ "4. Hacer Consulta"
				+ "0. Atrás");
		int opcion;
		opcion = sc.nextInt();
		sc.nextLine();
		
		DifuntoControler dif = new DifuntoControler(db);
		
		switch(opcion){
			case 1:
				dif.crearDifunto(pedirDatosDifunto(sc));
		}
		return false;
	}
	
	public static Difunto pedirDatosDifunto(Scanner sc) {
		Difunto dif = new Difunto();
		
		System.out.println("Introduce los siguientes datos del difunto:");
		System.out.print("\nNombre: ");
		String nombre = sc.nextLine();
		dif.setNombre(nombre);
		System.out.print("\nPrimer Apellido: ");
		String ap1 = sc.nextLine();
		dif.setApellido1(ap1);
		System.out.print("\nSegundo apellido: ");
		String ap2 = sc.nextLine();
		dif.setApellido2(ap2);
		System.out.println("El formato de las siguientes fechas debe ser MM/DD/YY");
		System.out.print("\nFecha de nacimiento:");
		dif.setFechaNacimiento(dif.getFechaNacimiento());
		System.out.print("\nFecha de defunción: ");
		dif.setFechaDefuncion(dif.getFechaDefuncion());
		System.out.print("\nFecha de enterramiento: ");
		dif.setFechaEnterramiento(dif.getFechaEnterramiento());
		System.out.print("\nSepultura:");
		dif.setSepultura(dif.getSepultura());
		
		return dif;
		
	}
}
