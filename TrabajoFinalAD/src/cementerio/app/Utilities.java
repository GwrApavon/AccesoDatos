/**
 * 
 */
package cementerio.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

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
}
