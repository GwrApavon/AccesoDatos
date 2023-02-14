
/**
 * 
 */
package cementerio.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
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
		int id, opcion;
		//Hacer bucle hasta que se quiera salir 
		System.out.println("En que tabla de la base de datos quieres trabajar:"
				+ "1. Crear Difunto"
				+ "2. Modificar Difunto"
				+ "3. Borrar Difunto"
				+ "4. Hacer Consulta"
				+ "0. Atrás");
		
		opcion = sc.nextInt();
		sc.nextLine();
		
		DifuntoControler dif = new DifuntoControler(db);
		
		switch(opcion){
			case 1:
				dif.crearDifunto(pedirDatosDifunto(sc, dif.lastID()));
				break;
			case 2: 
				id = sacarIntValido(sc);
				//dif.modificarDifunto(,id);
				break;
			case 3:
				break;
			case 4:
				break;
			default:
		}
		return false;
	}
	
	public static Difunto pedirDatosDifunto(Scanner sc, int lastID) {
		Difunto dif = new Difunto();
		
		System.out.println("Introduce los siguientes datos del difunto:");
		dif.setIdDifunto(lastID);
		System.out.print("\nNombre: ");
		String nombre = sc.nextLine();
		dif.setNombre(nombre);
		System.out.print("\nPrimer Apellido: ");
		String ap1 = sc.nextLine();
		dif.setApellido1(ap1);
		System.out.print("\nSegundo apellido: ");
		String ap2 = sc.nextLine();
		dif.setApellido2(ap2);
		
		System.out.println("El formato de las siguientes fechas debe ser YY/MM/DD");
		System.out.print("\nFecha de nacimiento:");
		Date fNacimiento = stringToDate(sc);
		dif.setFechaNacimiento(fNacimiento);
		System.out.print("\nFecha de defunción: ");
		Date fDefuncion = stringToDate(sc);
		dif.setFechaDefuncion(fDefuncion);
		System.out.print("\nFecha de enterramiento: ");
		Date fEnterramiento = stringToDate(sc);
		dif.setFechaEnterramiento(fEnterramiento);
		
		System.out.print("\nSepultura:");
		//pedir sepultura
		dif.setSepultura(dif.getSepultura());
		
		return dif;
		
	}
	
	private static int sacarIntValido(Scanner s){
		 boolean salir = false;
		 int i = 0;
		 while(!salir || i < 0) {
			 try {
				 i = s.nextInt();
				 s.nextLine();
				 salir = true;
			 }catch(InputMismatchException ime) {
				 System.err.println("Introduzca un número por favor");
			 }
		 }
		 return i;
	 }
	
	private static Date stringToDate(Scanner s){
		 boolean salir = false; 
		 SimpleDateFormat formato = new SimpleDateFormat("yyyy/mm/dd");
		 Date fechaDate = null;
		 
		 while(!salir) {
			 try {
			 fechaDate = formato.parse(s.nextLine());
			 salir = true;
			
			 }catch(ParseException pe) {
				 System.err.println("Error al convertir la fecha, repita por favor: ");
			 }catch(Exception e) {
				 System.err.println("Error al convertir la fecha, repita por favor: ");
			 }
		 }
		 return fechaDate;
		}
}
