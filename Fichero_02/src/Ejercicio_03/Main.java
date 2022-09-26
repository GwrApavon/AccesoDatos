/**
 * 
 */
package Ejercicio_03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author alu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce el nombre del fichero que quieras visualizar");
		String fichero = s.nextLine() + ".txt";
		File mifichero = new File (fichero);
		try {
			FileReader lector = new FileReader(mifichero);
			
			// ahora voy a leer utilizando un buffer
			BufferedReader br = new BufferedReader(lector);
			
			String linea = br.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			
			br.close();
			s.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
