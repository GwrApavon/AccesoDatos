/**
 * 
 */
package Ejercicio_18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import RandomFile.GestionaAgenda;
import RandomFile.Persona;

/**
 * @author alu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				GestorDepartamento gestor = new GestorDepartamento("departamentos.dat");
				Scanner s = new Scanner(System.in);
				
				try {
					gestor.abrir();
					
					// escrribe los primeros departamentos
					// EN CASO DE ERROR CON EL FICHERO: BORRAR FICHERO Y QUITAR COMENTARIO DEBAJO
					/*
					Departamento d1 = new Departamento(1,"Fisica", "Zaragoza");
					Departamento d2 = new Departamento(2, "Quimica", "Zaragoza");
					Departamento d3 = new Departamento(3, "Matematicas", "Zaragoza");
					Departamento d4 = new Departamento(4, "Lengua", "Zaragoza");
					
					gestor.escribir(d1,1);
					gestor.escribir(d2,2);
					gestor.escribir(d3,3);
					gestor.escribir(d4,4);
					*/
					Persona pLeoTodo = new Persona();
					ArrayList <Departamento> registro = new ArrayList<Departamento>();
					registro = gestor.leerTodo();
					for (Departamento dep : registro) {
						System.out.println(dep.toString());
					}	
					System.out.println("\n Quiere modificar alguno de los departamentos?");
					String respuesta = s.nextLine();
					
					if(respuesta.equalsIgnoreCase("si")) {
						System.out.println("Introduzca el número del departamento: ");
						int numDep = 0;
						do {
							numDep = s.nextInt();
							if(numDep <= 0) System.err.println("Numero no valido");
						}while(numDep <= 0);
						s.nextLine();
						System.out.println("Introduce el nombre del departamento");
						String nombre = s.nextLine();
						System.out.println("Introduce la localidad del departamento");
						String loc = s.nextLine();
						
						gestor.editarDepartamento(numDep, nombre, loc);
						
					}
				/*
					System.out.println("\nQuiere añadir algun departamento?");
					respuesta = s.nextLine();
					
					if(respuesta.equalsIgnoreCase("si")) {
						System.out.println("Introduce el nombre del departamento");
						String nombre = s.nextLine();
						System.out.println("Introduce la localidad del departamento");
						String loc = s.nextLine();
						
						gestor.añadirDep(nombre, loc);
						
					}
				*/	
				}catch (FileNotFoundException e) {
						System.out.println("Error, fichero no econtrado");
						e.printStackTrace();
				} catch (IOException e) {
						System.out.println("Error, de escritura");
						e.printStackTrace();
				}
	}	

}
