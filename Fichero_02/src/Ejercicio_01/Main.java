/**
 * 
 */
package Ejercicio_01;

import java.io.File;

/**
 * @author alu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File mifichero1 = new File("Existe.txt");
		File mifichero2 = new File("Noexiste.txt");
		File midirectorio1 = new File("Existe");
		File midirectorio2 = new File("NoExiste");
		
		
		System.out.println("El fichero Existe.txt " + cExiste(mifichero1));
		System.out.println("El fichero Noexiste.txt " + cExiste(mifichero2));
		System.out.println("El directorio Existe " + cExiste(midirectorio1));
		System.out.println("El directorio Existe " + cExiste(midirectorio2));
	}
	
	public static String cExiste(File f) {
		
		if(f.exists()) {
			return " si existe";
		}
		
		return " no existe";
		
	}
}
