/**
 * 
 */
package RandomFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
		GestionaAgenda agenda = new GestionaAgenda("D:\\Ángel Pavón\\WS - Acceso a Datos\\AccesoDatos\\Fichero_02\\AgendaPersonas.dat");
		
		
		//  guarda las personas en el fichero secuencial
		// la primera persona estar� en la posici�n 1, la segunda en la posici�n 2
		// y as� sucesivamente....
		try {
			agenda.abrir();
			
			// escribir las personas
			Persona p1 = new Persona("Angela", 44, "angela@gmail.com");
			Persona p2 = new Persona("Pedro", 22, "pedro@gmail.com");
			Persona p3 = new Persona("Luis",33, "luis@gmail.com");
			Persona p4 = new Persona("Ana", 24, "ana@gmail.com");
			
			agenda.escribir(p1,1);
			agenda.escribir(p2,2);
			agenda.escribir(p3,3);
			agenda.escribir(p4,4);
			
			Persona pLeo = new Persona();
			pLeo = agenda.leer(2);
			System.out.println(pLeo);
			
			Persona pLeoTodo = new Persona();
			ArrayList <Persona> registro = new ArrayList<Persona>();
			registro = agenda.leerTodo();
			for (Persona persona : registro) {
				System.out.println(persona.toString());
			}
			
			
		} // COMPLETA CON LOS CATCH QUE HAGAN FALTA  
		catch (FileNotFoundException e) {
			System.out.println("Error, fichero no econtrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error, de escritura");
			e.printStackTrace();
		}
		
		// leer las personas
		/*try {
			
			System.out.println(agenda.leer(3));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
	}

}
