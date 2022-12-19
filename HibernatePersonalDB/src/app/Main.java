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
	
		menu(s,sesion);
		
		tx.commit();
		
		
		
		sesion.close();
		fabrica.close();
		s.close();
		System.exit(0);	
		
	}
	
	public static void menu(Scanner s, Session sesion) {
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
				modificarDep(s, sesion);
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
	
	public static void modificarDep(Scanner sc, Session s) {
		try {
			mostrarDep(s);
			System.out.println("Introduce el codigo del departamento que quiers modificar:");
			int id = sc.nextInt();
			sc.nextLine();
			Departamento dep = (Departamento)s.get(Departamento.class, (byte)id);
			System.out.println("Que desea modificar: "
								+ "\n1. Nombre"
								+ "\n2. Localidad");
			int opcion = sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			
				case 1:
					System.out.print("Introduce el nuevo nombre que le quieras dar: ");
					String name = sc.nextLine();
					dep.setNombre(name);
					break;
				case 2: 
					System.out.print("Introduce la nueva localidad que le quieras dar: ");
					String loc = sc.nextLine();
					dep.setLocalidad(loc);
					break;
				default:
					System.err.println("Introduce un número válido");
			}
			s.update(dep);
		}catch(InputMismatchException ime) {
			ime.printStackTrace();
		}

	}
	
	public static void insertarEmpleado(Scanner sc, Session s) {
		try {
			short lastID = (short)lastID(s, true);
		
			System.out.println("Introduce los siguientes datos del empleado");
			System.out.print("Apellido: ");
			String ap = sc.nextLine();
			System.out.print("Oficio: ");
			String oficio = sc.nextLine();
			Empleado emp = new Empleado(lastID,ap,oficio);
			s.saveOrUpdate(emp);
		}catch(InputMismatchException ime) {
			ime.printStackTrace();
		}
	}
	public static void mostrarDep(Session s) {
		
		Query<Departamento> q = s.createQuery("from Departamento");
		List <Departamento> lista = q.list();
		Iterator <Departamento> iter = lista.iterator();
		
		while (iter.hasNext())
		{
		   //extraer el objeto
			Departamento dep = (Departamento) iter.next(); 
			System.out.println("ID = " + dep.getIdDep() + " Nombre =" + dep.getNombre());		   
		}
	}
	
	public static int lastID(Session s, boolean choice) {
		int n = 0;
		if(choice) {
			Query<Empleado> q = s.createQuery("from Empleado");
			n = q.getMaxResults();
			n++;
		}
		if(!choice) {
			Query<Empleado> q = s.createQuery("from Departamento");
			n = q.getMaxResults();
			n++;
		}
		return n;
	}
	public static void mostrarEmp(Session s) {
		
		Query<Empleado> q = s.createQuery("from Empleado");
		List <Empleado> lista = q.list();
		Iterator <Empleado> iter = lista.iterator();
		
		while (iter.hasNext())
		{
		   //extraer el objeto
			Empleado emp = (Empleado) iter.next(); 
			System.out.println("ID = " + emp.getIdEmp() + " Nombre =" + emp.getApellido());		   
		}
	}

}