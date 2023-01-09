/**
 * 
 */
package app;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import controlador.HibernateUtil;

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
		// ------------------UTILIZAMOS LO DEFINIDO ANTES-------------
		//obtener la f�brica de la conexi�n actual para crear una sesi�n
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		//------------------------------------------------------------
		// creamos la sesi�n
		Session sesion = fabrica.openSession();	
		// creamos la transacci�n de la sesi�n
		Transaction tx = sesion.beginTransaction();
		
		boolean salir = false;
		do {
			
			System.out.println("Recuerda guardar los cambios usando \"Commit\"");
			salir = menu(s,sesion,tx);
			
		}while(!salir);
		
		
		sesion.close();
		fabrica.close();
		s.close();
		System.exit(0);	

	}
	
	public static boolean menu(Scanner s, Session sesion, Transaction tx) {
		int opcion = 0;
		System.out.println("Que quieres hacer: "
							+ "\n1. Modificar un departamento"
							+ "\n2. Insertar un empleado"
							+ "\n3. Commit"
							+ "\nElse. salir");

		
		opcion = sacarIntValido(s);
		
		try {
		switch(opcion) {
			case 1:
				//modificarDep(s, sesion);
				break;
			case 2:
				//insertarEmpleado(s,sesion);
				break;
			case 3:
				tx.commit();
			default:
				System.out.println("Saliendo...");
				return true;
		}
		}catch(Exception e) {
			tx.rollback();
		}
		return false;
		
	}
	
	private static void modificarPrecioConIVA(Scanner sc, Session s) {
		String sentencia = "Update precio from producto";
	}
	private static int sacarIntValido(Scanner s){
		 boolean salir = false;
		 int i = 0;
		 while(!salir || i < 0) {
			 try {
				 i = s.nextInt();
				 s.nextLine();
				 salir = true;
			 }catch(InputMismatchException ime) {
				 System.err.println("Introduzca un número por favor");
			 }
		 }
		 return i;
	 }

}
