package app;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
		
		boolean salir = false;
		do {
			
			salir = menu(s,sesion);
			
		}while(!salir);
		tx.commit();
		
		
		
		sesion.close();
		fabrica.close();
		s.close();
		System.exit(0);	
		
	}
	
	public static boolean menu(Scanner s, Session sesion) {
		int opcion = 0;
		System.out.println("Que quieres hacer: "
							+ "\n1. Modificar un departamento"
							+ "\n2. Insertar un empleado"
							+ "\n3. Leer un empleado, y además, su departamento correspondiente"
							+ "\n4. Eliminar un empleado"
							+ "\n5. Eliminar un departamento"
							+ "\nElse. salir");
		try {
			opcion = s.nextInt();
			s.nextLine();
		}catch(InputMismatchException ime) {
			
		}
		switch(opcion) {
			case 1:
				modificarDep(s, sesion);
				break;
			case 2:
				insertarEmpleado(s,sesion);
				break;
			case 3:
				leerEmpleado(s,sesion);
				break;
			case 4:
				delEmpleado(s,sesion);
				break;
			case 5:
				delDepartamento(s,sesion);
				break;
			default:
				System.out.println("Saliendo...");
				return true;
		}
		return false;
		
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
			short lastID = lastID(s, true);
		
			System.out.println(lastID);
			System.out.println("Introduce los siguientes datos del empleado:");
			System.out.print("- Apellido: ");
			String ap = sc.nextLine();
			System.out.print("- Oficio: ");
			String oficio = sc.nextLine();
			System.out.print("- Salario: ");
			float salario = sc.nextFloat();
			System.out.print("- Comision: ");
			float comision = sc.nextFloat();
			System.out.println("Lista de los departamentos disponibles:");
			mostrarDep(s);
			
			int idDep;
			System.out.print("- id departamento: ");
			idDep = sc.nextInt();
			sc.nextLine();
			Departamento dep = (Departamento)s.get(Departamento.class, (byte)idDep);
			
			Empleado emp = new Empleado(lastID,dep,ap, oficio,stringToDate(sc), salario, comision);
			s.saveOrUpdate(emp);
		}catch(InputMismatchException ime) {
			ime.printStackTrace();
		}
	}
	
	public static void leerEmpleado( Scanner sc, Session s) {
		System.out.println("Elija el empleado del que quiere mostrar los datos:");
		mostrarEmp(s);
		short idEmp = sc.nextShort();
		sc.nextLine();
		
		Empleado emp = (Empleado)s.get(Empleado.class, idEmp);
		
		System.out.println(emp + "\n" + emp.getDepartamento());
	}
	
	public static void delEmpleado(Scanner sc, Session s) {
		System.out.println("Que empleado desea borrar: ");
		mostrarEmp(s);
		
		short idEmp = sc.nextShort();
		sc.nextLine();
		
		Empleado emp = (Empleado)s.get(Empleado.class, idEmp);
		
		if(emp != null) {
			System.out.println("Borrado: " + emp.getApellido());
			s.delete(emp);
		}
		else {
			System.err.println("Id de empleado no válido");
		}
		
	}
	
	
	public static void delEmpleado(Session s, short idEmp) {
		Empleado emp = (Empleado)s.get(Empleado.class, idEmp);
		
			System.out.println("Borrado: " + emp.getApellido());
			s.delete(emp);		
	}
	
	public static void delDepartamento(Scanner sc, Session s) {
		System.out.println("Que departamento desea borrar: ");
		mostrarDep(s);
		
		int idDep = sc.nextInt();
		sc.nextLine();
		Departamento dep = (Departamento)s.get(Departamento.class,(byte) idDep);
		if(dep != null) {
			Set empleados = dep.getEmpleados();
			
			for (Object e : empleados) {
				Empleado em = (Empleado)e;
				
				delEmpleado(s, em.getIdEmp());
			}
			System.out.println("Empleados borrados con exito");
		
			s.delete(dep);
		}
		else {
			System.err.println("Id de departamento no válida");
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
			System.out.println(dep.getIdDep() + ". " + dep.getNombre());		   
		}
	}
	
	public static short lastID(Session s, boolean choice) {
		if(choice) {
			Query<Short> q = s.createQuery("select max(id) from empleado");
			Short res = q.getSingleResult();
			short res1 = res.shortValue();
			res1++;
			return res1;
		}
		if(!choice) {
			Query<Short> q = s.createQuery("select max(id) from departamento");
			Short res = q.getSingleResult();
			short res1 = res.shortValue();
			res1++;
			return res1;
		}
		return 0;
	}
	public static void mostrarEmp(Session s) {
		
		Query<Empleado> q = s.createQuery("from Empleado");
		List <Empleado> lista = q.list();
		Iterator <Empleado> iter = lista.iterator();
		
		while (iter.hasNext())
		{
		   //extraer el objeto
			Empleado emp = (Empleado) iter.next(); 
			System.out.println(emp.getIdEmp() + ". " + emp.getApellido());		   
		}
	}
	
	 private static Date stringToDate(Scanner s){
		 boolean salir = false;
		 System.out.print("- Fecha de alta(AAAA/MM/DD): ");		 
		 SimpleDateFormat formato = new SimpleDateFormat("yyyy/mm/dd");
		 Date fechaDate = null;
		 
		 while(!salir) {
			 try {
			 fechaDate = formato.parse(s.nextLine());
			 salir = true;
			
			 }catch(ParseException pe) {
				 System.err.println("Error al convertir la fecha, repita por favor: ");
			 }catch(Exception e) {
				 System.err.println("Error al convertir la fecha, repita por favor: ");
			 }
		 }
		 return fechaDate;
		}

}