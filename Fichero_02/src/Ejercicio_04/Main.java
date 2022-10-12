/**
 * Escribe un programa Java que pida una serie de frases por teclado hasta que se inserte como frase la palabra “fin”.
 * Dichas frases deberán guardarse en un fichero de texto. A continuación, el programa visualizará el contenido del fichero, frase por frase.
 * Cada vez que se ejecute el programa, se tienen que descartar las frases que ya estaban escritas en el fichero. 
 * Realiza este ejercicio sin usar la clase BufferedReader.
 */
package Ejercicio_04;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author angel
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Array donde se van a guardar todas las frases introducidas para comprobarlas
		ArrayList <String> added = new ArrayList<String>();
		
		//frase que se va a introducir 
		String frase = ""; 
		
		//Scanner
		Scanner s = new Scanner(System.in);
		
		//Ficheros
		File miFichero = new File("File.txt");
		
		//Leer
		try(FileReader fr = new FileReader(miFichero)){
			leerFich(added, frase, fr);
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		//Visualización del fichero
		System.out.println("Fichero:");
		for (String string : added) {
			System.out.println(string);
		}
		System.out.println("\n");
		
		//Escribir
		try(FileWriter fw = new FileWriter(miFichero,true)){
			
			escribirFich(added, s, fw);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		

	}

	/** Metodo para leer el fichero
	 * @param added
	 * @param frase
	 * @param fr
	 * @throws IOException
	 */
	public static void leerFich(ArrayList<String> added, String frase, FileReader fr) throws IOException {
		int caracter = fr.read();
		while(caracter > 0) {
			
			if((char)caracter != '\n') {
				frase += (char)caracter;
			}
			else {
				added.add(frase);
				frase = "";
			}
			caracter = fr.read();
			
		}
	}

	/**
	* Metodo para escribir en el fichero
	* @param added
	* @param s
	* @param fw
	* @throws IOException
	*/
	public static void escribirFich(ArrayList<String> added, Scanner s, FileWriter fw) throws IOException {
		String frase;
		do {
			System.out.println("Introduzca una frase: ");
			frase = s.nextLine();
			if(!comprobarAñadido(frase, added) && !comprobarFin(frase)) {
				fw.write(frase + "\n");
				added.add(frase);
			}
			else if(comprobarAñadido(frase, added)){
				System.out.println("Esa frase ya está añadida");
			}
			
			
		}while(!comprobarFin(frase));
	}
	
	/**
	 * Comprueba si la frase introducida es "fin" para terminar de escribir
	 * @param frase
	 * @return
	 */
	public static boolean comprobarFin(String frase) {
		
		return frase.equalsIgnoreCase("fin");
	}
	
	
	/**
	 * Comprueba si la frase que se va a introducir está ya dentro del fichero
	 * @param frase
	 * @param a
	 * @return
	 */
	public static boolean comprobarAñadido(String frase,  ArrayList <String> a) {
		Iterator <String> it = a.iterator();
		for (String string : a) {
			if(string.equals(frase)) { //Cambiar a equalsIgnoreCase si se quiere no repetir ninguna frase independientemente de las mayusculas
				return true;
			}
		}
		return false;
	}

}
