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
		
		
		System.out.println(mifichero1.getName() + cExiste(mifichero1) + extracted(mifichero1));
		System.out.println(mifichero2.getName() + cExiste(mifichero2) + extracted(mifichero2));
		System.out.println(midirectorio1.getName() + cExiste(midirectorio1) + extracted(midirectorio1));
		System.out.println(midirectorio2.getName() + cExiste(midirectorio2) + extracted(midirectorio2));
	}

	/**
	 * @param mifichero1
	 * @return
	 */
	private static String extracted(File file) {
		if(file.exists()) {
		if (file.isFile()) {
			return "y es un fichero";
		}
		
		return "y es un directorio";
		}
		return "";
	}
	
	public static String cExiste(File f) {
		
		if(f.exists()) {
			return " si existe";
		}
		
		return " no existe";
		
	}
}
