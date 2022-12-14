package app;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import controlador.HibernateUtil;

import tablas.*;

public class Main {

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
	
		menu(s);
		System.out.println("FUNCIONO!!");
		
		tx.commit();
		
		
		
		sesion.close();
		fabrica.close();
		s.close();
		System.exit(0);	
		
	}
	
	public static void menu(Scanner s) {
		int opcion = 0;
		System.out.println("Que quieres hacer: "
							+ "\n1. Modificar un departamento"
							+ "\n2. Insertar un empleado"
							+ "\n3. Leer un empleado, y además, su departamento correspondiente"
							+ "\n4. Eliminar un empleado"
							+ "\n5. Eliminar un departamento");
		try {
			opcion = s.nextInt();
		}catch(InputMismatchException ime) {
			
		}
		switch(opcion) {
			case 1:
				//modificarDep();
				break;
			case 2:
				//InsertarEmp();
				break;
			case 3:
				//LeerEmp();
				break;
			case 4:
				//EliminarEmp();
				break;
			case 5:
				//EliminarDep();
				break;
			default:
				System.out.println("Opcion no valida.");
		}
		
	}
	
	public static void modificarDep() {
		 	String qryString = "update departamento d set d.address='Hyderabad' where s.studentId=5";
	        Query query = session.createQuery(qryString);
	        int count = query.executeUpdate();
	}

}