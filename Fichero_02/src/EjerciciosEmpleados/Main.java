/**
 * 
 */
package EjerciciosEmpleados;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
		GestorEmpleados gestor = new GestorEmpleados("empleados.dat");
		Scanner s = new Scanner(System.in);
		//int maxVal = 0;
		
		try {
			gestor.abrir();
			
			// escrribe los primeros departamentos (usar si no se tiene el documento con los departamentos)
			// EN CASO DE ERROR CON EL FICHERO: BORRAR FICHERO Y QUITAR COMENTARIO DEBAJO
			/*
			Empleado e1 = new Empleado("25359595Z","Jaime", "Palomares Carnicero", 1800.0, 300.0, 15.00 );
			Empleado e2 = new Empleado("64353637M","Nicole", "Olmos Menendez", 2010.0, 150.0, 15.00 );
			Empleado e3 = new Empleado("29059373T","Sabela", "Vilchez Mendez", 1960.0, 350.0, 15.00 );
			Empleado e4 = new Empleado("27814869A","Juan", "Ocabo Canario", 2100.0, 200.0, 15.00 );
			
			gestor.escribir(e1,1);
			gestor.escribir(e2,2);
			gestor.escribir(e3,3);
			gestor.escribir(e4,4);
			*/
			ArrayList <Empleado> registro = new ArrayList<Empleado>();
			registro = gestor.leerTodo();
			System.out.println("Empleados existentes: \n");

			for (Empleado emp : registro) {
				System.out.println(emp.toString());
				//maxVal++;
			}	
			/*System.out.println("\nQuiere modificar alguno de los departamentos?");
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
				gestor.editarEmpleaod(numDep, nombre, loc);
				
				System.out.println("Nuevos valores: \n");
				System.out.println(registro.get(numDep-1).toString());
				
			}*/

		}catch (FileNotFoundException fnfe) {

			fnfe.printStackTrace();
			
		}catch (IOException ioe) {
			
			ioe.printStackTrace();
		}
		s.close();

	}

}
