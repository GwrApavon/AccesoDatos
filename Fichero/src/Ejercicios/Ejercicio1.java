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
						
			FileWriter escritor=new FileWriter(mifichero2,false); 
			
			int caracter = lector.read();
			while (caracter > 0) {
				
				if((char)caracter != ',' && (char)caracter != '\n') {
					word += ((char)caracter);
				}
				caracter = lector.read();	
				System.out.println(caracter);
				if(word.length()>4 && (char)caracter == ',' || (char)caracter == '\n' || caracter < 0) {
					switch(select) {
					case 1: 
						escritor.write("Nombre: ");
						escritor.write(word);
						escritor.write("\n");
					break;
					case 2:
						escritor.write("Apellidos: ");
						escritor.write(word);
						escritor.write("\n");
					break;
					case 3: 
						escritor.write("Fecha de nacimiento: ");
						escritor.write(word);
						escritor.write("\n");
					break;
					case 4: 
						escritor.write("Teléfono:");
						escritor.write(word);
						escritor.write("\n");
					}
					
					word = "";
					if((char)caracter == ',') {
						select += 1;
					}
					if((char)caracter == '\n') {
						escritor.write("\n");
						select = 1;
					}
				}
				else if ((char)caracter == ',' || (char)caracter == '\n'){
					word = "";
				}
				
				
			}
			lector.close();
			escritor.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
