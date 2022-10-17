/**
 * 
 */
package Ejercicio_18;

import java.util.ArrayList;

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
				
				
				//  guarda las personas en el fichero secuencial
				// la primera persona estar� en la posici�n 1, la segunda en la posici�n 2
				// y as� sucesivamente....
				try {
					gestor.abrir();
					
					// escribir las personas
					Departamento d1 = new Departamento(1,"Fisica", "Zaragoza");
					Departamento d2 = new Departamento(2, "Quimica", "Zaragoza");
					Departamento d3 = new Departamento(3, "Matematicas", "Zaragoza");
					Departamento d4 = new Departamento(4, "Lengua", "Zaragoza");
					
					gestor.escribir(d1,1);
					gestor.escribir(d2,2);
					gestor.escribir(d3,3);
					gestor.escribir(d4,4);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
					

	

}
