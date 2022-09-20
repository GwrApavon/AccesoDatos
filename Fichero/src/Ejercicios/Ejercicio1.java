/**
 * 
 */
package Ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Ángel Pavón Fraile
 *
 */
public class Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Creo dos objetos File para el fichero de lectura y el de escritura
		File mifichero = new File ("datos.txt");
		File mifichero2 = new File ("tarjetas.txt");
		
		//variable 
		
		String word = "";
		int select = 1;
		
		try {
			
			FileReader lector = new FileReader(mifichero);
						
			FileWriter escritor=new FileWriter(mifichero2,true); 
			
			int caracter = lector.read();
			while (caracter > 0) {
				
				word += ((char)caracter);
				caracter = lector.read();	
					
				if(word.length()>4 && (char)caracter == ',' || (char)caracter == ' ') {
					switch(select) {
					case 1: escritor.write("Nombre: ");
					break;
					case 2: escritor.write("Apellidos: ");
					break;
					case 3: escritor.write("Fecha de nacimiento: ");
					break;
					case 4: escritor.write("Teléfono: ");
					}
					escritor.write(word);
					escritor.write(' ');
					word = "";
				}
				if((char)caracter == ',') {
					select += 1;
				}
				if((char)caracter == ' ') {
					
					select = 0;
				}
			}
			lector.close();
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
