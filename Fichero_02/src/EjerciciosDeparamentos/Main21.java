/**
 * 
 */
package EjerciciosDeparamentos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
;

/**
 * @author alu
 *
 */
public class Main21 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				GestorDepartamento gestor = new GestorDepartamento("departamentos.dat");
				Scanner s = new Scanner(System.in);
				int maxVal = 0;
				
				try {
					gestor.abrir();
					
					// escrribe los primeros departamentos (usar si no se tiene el documento con los departamentos)
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
					ArrayList <Departamento> registro = new ArrayList<Departamento>();
					registro = gestor.leerTodo();
					System.out.println("Departamentos existentes: \n");
					for (Departamento dep : registro) {
						System.out.println(dep.toString());
						maxVal = dep.getNum();
					}	
					System.out.println("\nQuiere modificar alguno de los departamentos?");
					String respuesta = s.nextLine();
					
					if(respuesta.equalsIgnoreCase("si")) {
						System.out.println("Introduzca el número del departamento: ");
						int numDep = 0;
						do {
							numDep = s.nextInt();
							if(numDep <= 0) System.err.println("Numero no valido");
							else if(numDep > maxVal) System.err.println("Departamento inexistente"); 
						}while(numDep <= 0 || numDep > maxVal);
						s.nextLine();
						System.out.println("Introduce el nombre del departamento");
						String nombre = s.nextLine();
						System.out.println("Introduce la localidad del departamento");
						String loc = s.nextLine();
						
						System.out.println("Antiguos valores: \n");
						System.out.println(registro.get(numDep-1).toString());
						gestor.editarDepartamento(numDep, nombre, loc);
						
						System.out.println("Nuevos valores: \n");
						System.out.println(registro.get(numDep-1).toString());
						
					}

				}catch (FileNotFoundException fnfe) {

						fnfe.printStackTrace();
				}/* catch (IOException ioe) {

						ioe.printStackTrace();
				}*/
				
				s.close();
	}	

}
