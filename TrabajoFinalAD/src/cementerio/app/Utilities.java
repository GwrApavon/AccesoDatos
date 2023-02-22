/**
 *  Metodos utiles para ahorrar tiempo
 */
package cementerio.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.modelo.Responsable;
import com.modelo.Sepultura;

/**
 * @author Angel Pavon Fraile
 *
 */
public class Utilities {

	/**
	 * Pide un int y comprueba que sea mayor que 0 
	 * @param s
	 * @return int validado
	 * @exception InputMismatchException si lo que se introduce no es un numero
	 */
	public static int sacarIntValido(Scanner s){
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
	
	/**
	 * Pide una fecha en un formato en específico y devuelve un elemento Date
	 * @param s
	 * @return Date validado
	 * @exception ParseException si la fecha no tiene el formato correspondiente
	 */
	public static Date stringToDate(Scanner s){
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
	
	
	/**
	 * Pide una Cuenta Domiciliacion y la devuelve
	 * @param sc
	 * @return String 
	 */
	static String pedirCuentaDomiciliacion(Scanner sc) {
		System.out.print("Cuenta Domiciliacion: ");
		String cuentaDomiciliacion = sc.nextLine();
		return cuentaDomiciliacion;
	}
	/**
	 * @param sc
	 * @return
	 */
	static Sepultura pedirSepultura(Scanner sc) {
		//TODO
		System.out.print("Id Sepultura:");
		Sepultura sep = new Sepultura();
		return sep;
	}
	/**
	 * Pide la fecha de enterramiento y la devuelve
	 * @param sc
	 * @return Date
	 */
	static Date pedirFechaEntr(Scanner sc) {
		System.out.print("Fecha de enterramiento: ");
		Date fEnterramiento = stringToDate(sc);
		return fEnterramiento;
	}
	/**
	 * Pide la fecha de defuncion y la devuelve
	 * @param sc
	 * @return Date
	 */
	static Date pedirFechaDef(Scanner sc) {
		System.out.print("Fecha de defunción: ");
		Date fDefuncion = stringToDate(sc);
		return fDefuncion;
	}

	/**
	 * Pide la fecha de nacimiento y la devuelve
	 * @param sc
	 * @return Date
	 */
	static Date pedirBDate(Scanner sc) {
		System.out.print("Fecha de nacimiento:");
		Date fNacimiento = stringToDate(sc);
		return fNacimiento;
	}

	/**
	 * Pide el segundo apellido y lo devuelve
	 * @param sc
	 * @return String
	 */
	static String pedirApellido2(Scanner sc) {
		System.out.print("Segundo apellido: ");
		String ap2 = sc.nextLine();
		return ap2;
	}

	/**
	 * Pide el primer apellido y lo devuelve
	 * @param sc
	 * @return String
	 */
	static String pedirApellido1(Scanner sc) {
		System.out.print("Primer Apellido: ");
		String ap1 = sc.nextLine();
		return ap1;
	}

	/**
	 * Pide el nombre y lo devuelve 
	 * @param sc
	 * @return String
	 */
	static String pedirNombre(Scanner sc) {
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		return nombre;
	}

	/**
	 * Pide el numero de la sepultura y lo devuelve
	 * @param sc
	 * @return int
	 */
	static int pedirNumSepultura(Scanner sc) {
		System.out.print("Numero de sepultura: ");
		int num = sacarIntValido(sc);
		return num;
	}

	/**
	 * Pide la calle de la sepultura y lo devuelve
	 * @param sc
	 * @return String
	 */
	static String pedirCalle(Scanner sc) {
		System.out.print("Calle: ");
		String calle = sc.nextLine();
		return calle;
	}
	/**
	 * Pide el codigo del contable y lo devuelve
	 * @param sc
	 * @return String
	 */
	static String pedirCodContable(Scanner sc) {
		System.out.print("Codigo de contable: ");
		String cdContable = sc.nextLine();
		return cdContable;
	}
	
	/**
	 * Pide el tipo de contrato y lo devuelve
	 * @param sc
	 * @return String
	 */
	static String pedirTipoContrato(Scanner sc) {
		System.out.print("Tipo de Contrato: ");
		String contrato = sc.nextLine();
		return contrato;
	}
	
	/**
	 * Pide las observaciones y las devuelve
	 * @param sc
	 * @return String
	 */
	static String pedirObservaciones(Scanner sc) {
		System.out.print("Observaciones: ");
		String observaciones = sc.nextLine();
		return observaciones;
	}
	
	/**
	 * @param sc
	 * @return
	 */
	static Responsable pedirResponsable(Scanner sc) {
		//TODO
		System.out.print("Id Responsable:");
		Responsable res = new Responsable();
		return res;
	}
	
	/**
	 * Pide el id de un objeto y lo devuelve
	 * @param sc
	 * @param op identifica si es para modificar o borrar
	 * @return int 
	 */
	static int pedirIDObjeto(Scanner sc, int op) {
		if(op == 1) {
			System.out.println("Introduzca la id de lo que quiera modificar:");
			int id = sacarIntValido(sc);
			return id;
		}
		if(op == 2) {
			System.out.println("Introduzca la id de lo que quiera borrar:");
			int id = sacarIntValido(sc);
			return id;
		}
		return 0;
	}
}
