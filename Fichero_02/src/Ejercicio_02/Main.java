/**
 * 
 */
package Ejercicio_02;

import java.io.*;
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
		
		
		
		System.out.println("Introduce el nombre del directorio que quieras leer:");
		String directorio = s.nextLine();
		File midirectorio = new File(directorio);
		
		String [] list;
		list = midirectorio.list();
		
		
		for( int cont = 0; cont < list.length; cont++) {
			System.out.println(list [cont]);
		}
		s.close();



	}

}
