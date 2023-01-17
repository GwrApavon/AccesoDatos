/**
 * 
 */
package app;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import datos.Empleado;
import datos.Departamento;

/**
 * @author alu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		ODB bd = ODBFactory.open("D:\\Ángel Pavón\\BBDD\\NeonDatis\\NeoDatis DDBB\\personal.db", "miusuario", "Pass!123456");

		boolean salir = false;
		
		do {
			
			salir = menu(sc, bd);
		}while(!salir);
			
	}
	
	public static boolean menu(Scanner sc, ODB bd) {
		
		System.out.println("Que quieres hacer: "
							+ "\n1. Insertar departamento"
							+ "n\2. Insertar empleado"
							+ "n\3. Visualizar departamentos"
							+ "n\4. Visualizar emlpeados");
		int opc = sc.nextInt();
		sc.nextLine();
		
		switch(opc) {
			case 1: insertarDep(bd, sc);
				break;
			case 2: insertarEmp(bd, sc);
				break;
			case 3: mostrarDep(bd);
				break;
			case 4: mostrarEmp(bd);
				break;
			default: System.out.println("Saliendo...");
			return true;
		}
		
		return false;
	}
	
	public static void insertarDep(ODB bd, Scanner sc) {
		Departamento dep = crearDep(bd, sc);
		bd.store(dep);
	}
	public static void insertarEmp(ODB bd, Scanner sc) {
		System.out.println("Que quieres hacer: "
				+ "\n1. Insertar Empleado "
				+ "n\2. Insertar Encargado");
		int opc = sacarIntValido(sc);
		Empleado emp;
		switch(opc) {
		case 1: 
				emp = crearEmpleado(bd,sc);
				bd.store(emp);
			break;
		case 2: 
				emp = crearEncargado(bd,sc);
				bd.store(emp);
			break; 
		}
	}
	
	public static Departamento crearDep(ODB bd, Scanner sc) {
		Values val = bd.getValues(new ValuesCriteriaQuery(Departamento.class).max("id_dep"));
		BigDecimal id = (BigDecimal) val.nextValues();
		
		System.out.println("Introduce los siguientes datos del departamento:");
		System.out.print("- Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("- Localidad: ");
		String localidad = sc.nextLine();
		Departamento dep = new Departamento();
		return dep;
	}
	public static Empleado crearEmpleado(ODB bd, Scanner sc) {
		
		System.out.println("Introduce los siguientes datos del empleado:");
		System.out.print("- Apellido: ");
		String ap = sc.nextLine();
		System.out.print("- Oficio: ");
		String oficio = sc.nextLine();
		System.out.print("- Salario: ");
		float salario = sc.nextFloat();
		System.out.print("- Comision: ");
		float comision = sc.nextFloat();
		
		System.out.println("Lista de los Empleados disponibles: ");
		mostrarEncargados(bd);
		System.out.println("- Nombre del encargado: ");
		Empleado enc = getEmp(bd, sacarIntValido(sc));
		
		System.out.println("Lista de los departamentos disponibles:");
		mostrarDep(bd);		
		System.out.print("- id departamento: ");
		Departamento dep = getDep(bd, sacarIntValido(sc));
		
		Empleado emp = new Empleado(1, ap, oficio , null, salario, comision, enc, dep);
		return emp;
	}
	
	public static Empleado crearEncargado(ODB bd,Scanner sc) {
		
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
		mostrarDep(bd);		
		System.out.print("- id departamento: ");
		Departamento dep = getDep(bd, sacarIntValido(sc));
		
		Empleado emp = new Empleado(1, ap, oficio , null, salario, comision, null, dep);
		return emp;
	}
	
	public static void mostrarEmp(ODB bd){
		Objects <Empleado> emp = bd.getObjects(Empleado.class);
		
		int i = 0;
		for (Empleado e : emp) {
			if(e.getJefe() != null) {
				System.out.println((i + 1) + ". "+ e + " / Jefe: " + e.getJefe() + " / Departamento: " + e.getDepartamento().getNombre());
			}
			else {
				System.out.println((i + 1) + ". "+ e + "/ Departamento: " + e.getDepartamento().getNombre());
			}
            i++;
		}
	}
	public static void mostrarEncargados(ODB bd){
		Objects <Empleado> emp = bd.getObjects(Empleado.class);
		
		int i = 0;
		for (Empleado e : emp) {
			System.out.println((i + 1) + ". "+ e + "/ Departamento: " + e.getDepartamento().getNombre());
            i++;
		}
	}
	public static void mostrarDep(ODB bd){
		Objects <Departamento> dep = bd.getObjects(Departamento.class);
		
		int i = 0;
		while(dep.hasNext()) {
            System.out.println((i + 1) + ". "+ dep.next());
            i++;
        }
	}
	
	public static Departamento getDep(ODB bd, int ident) {
		
		IQuery query = new CriteriaQuery(Departamento.class, Where.equal("id_dep", ident));
		Departamento dep = (Departamento) bd.getObjects(query);
		
		return dep;
	}
	
	public static Empleado getEmp(ODB bd, int ident) {
		
		IQuery query = new CriteriaQuery(Empleado.class, Where.equal("id_emp", ident));
		Empleado emp = (Empleado) bd.getObjects(query);
		return emp;
	}
	
	//Método que devuelve un int valido (>0)
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
