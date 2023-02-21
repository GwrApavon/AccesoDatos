/**
 * 
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
 * @author alu
 *
 */
public class Utilities {

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
	 * @param sc
	 * @return
	 */
	static String pedirCuentaDomiciliacion(Scanner sc) {
		System.out.print("\nCuenta Domiciliacion: ");
		String cuentaDomiciliacion = sc.nextLine();
		return cuentaDomiciliacion;
	}
	/**
	 * @param sc
	 * @return
	 */
	static Sepultura pedirSepultura(Scanner sc) {
		//TODO
		System.out.print("\n Id Sepultura:");
		Sepultura sep = new Sepultura();
		return sep;
	}
	/**
	 * @param sc
	 * @return
	 */
	static Date pedirFechaEntr(Scanner sc) {
		System.out.print("\nFecha de enterramiento: ");
		Date fEnterramiento = stringToDate(sc);
		return fEnterramiento;
	}
	/**
	 * @param sc
	 * @return
	 */
	static Date pedirFechaDef(Scanner sc) {
		System.out.print("\nFecha de defunción: ");
		Date fDefuncion = stringToDate(sc);
		return fDefuncion;
	}

	/**
	 * @param sc
	 * @return
	 */
	static Date pedirBDate(Scanner sc) {
		System.out.print("\nFecha de nacimiento:");
		Date fNacimiento = stringToDate(sc);
		return fNacimiento;
	}

	/**
	 * @param sc
	 * @return
	 */
	static String pedirApellido2(Scanner sc) {
		System.out.print("\nSegundo apellido: ");
		String ap2 = sc.nextLine();
		return ap2;
	}

	/**
	 * @param sc
	 * @return
	 */
	static String pedirApellido1(Scanner sc) {
		System.out.print("\nPrimer Apellido: ");
		String ap1 = sc.nextLine();
		return ap1;
	}

	/**
	 * @param sc
	 * @return
	 */
	static String pedirNombre(Scanner sc) {
		System.out.print("\nNombre: ");
		String nombre = sc.nextLine();
		return nombre;
	}

	/**
	 * @param sc
	 * @return
	 */
	static int pedirNumSepultura(Scanner sc) {
		System.out.print("\nNumero de sepultura: ");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	/**
	 * @param sc
	 * @return
	 */
	static String pedirCalle(Scanner sc) {
		System.out.print("\nCalle: ");
		String calle = sc.nextLine();
		return calle;
	}
	/**
	 * @param sc
	 * @return
	 */
	static String pedirCodContable(Scanner sc) {
		System.out.print("\nCodigo de contable: ");
		String cdContable = sc.nextLine();
		return cdContable;
	}
	
	/**
	 * @param sc
	 * @return
	 */
	static String pedirTipoContrato(Scanner sc) {
		System.out.print("\nTipo de Contrato: ");
		String contrato = sc.nextLine();
		return contrato;
	}
	
	/**
	 * @param sc
	 * @return
	 */
	static String pedirObservaciones(Scanner sc) {
		System.out.print("\nObservaciones: ");
		String observaciones = sc.nextLine();
		return observaciones;
	}
	
	/**
	 * @param sc
	 * @return
	 */
	static Responsable pedirResponsable(Scanner sc) {
		//TODO
		System.out.print("\n Id Sepultura:");
		Responsable res = new Responsable();
		return res;
	}
	
	
}
