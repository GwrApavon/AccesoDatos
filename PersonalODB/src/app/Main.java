/**
 * 
 */
package app;

import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

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
			case 1: insertarDep(bd);
				break;
			case 2: insertarEmp(bd);
				break;
			case 3: visualizarDep();
				break;
			case 4: visualizarEmp();
				break;
			default: System.out.println("Saliendo...");
			return true;
		}
		
		return false;
	}
	
	public static void insertarDep(ODB bd) {
		
	}
	
	public static void insertarEmp(ODB bd) {
		
	}
	
	public static void visualizarDep() {
		
	}
	
	public static void visualizarEmp() {
		
	}

}
