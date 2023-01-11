/**
 * 
 */
package CreateDB;

import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import datos.*;

/**
 * @author alu
 *
 */
public class AgregarDatos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Departamento dep = new Departamento(0, "Informatica", "Zaragoza");
		Departamento dep1 = new Departamento(1, "Matemáticas", "Huesca");
		Departamento dep2 = new Departamento(2, "Física", "Teruel");
		Departamento dep3 = new Departamento(3, "Filosofía", "Zaragoza");		
		
		ArrayList <Departamento> deps = new ArrayList<Departamento>();
		deps.add(dep);
		deps.add(dep1);
		deps.add(dep2);
		deps.add(dep3);
		
		//jefe informática
		Empleado emp = new Empleado(1, "Martinez", "profesor", null, 14000, 12, null, dep);
		// -----
		Empleado emp1 = new Empleado(2, "Rodriguez", "profesor", null, 13000, 12, emp, dep);
		Empleado emp2 = new Empleado(3, "Muñoz", "profesor", null, 12500, 12, emp, dep);
		Empleado emp3 = new Empleado(4, "Roy", "profesor", null, 10500, 12, emp, dep);
		Empleado emp4 = new Empleado(5, "Abdelcarim", "profesor", null, 11500, 12, emp, dep);
		//jefe matemáticas
		Empleado emp5 = new Empleado(6, "Jimeno", "profesor", null, 14000, 12, null, dep1);
		// ------
		Empleado emp6 = new Empleado(7, "Pérez", "profesor", null, 13000, 12, emp5, dep1);
		Empleado emp7 = new Empleado(8, "Lopez", "profesor", null, 11500, 12, emp5, dep1);
		Empleado emp8 = new Empleado(9, "Ramirez", "profesor", null, 11000, 12, emp5, dep1);
		
		ArrayList <Empleado> emps = new ArrayList<Empleado>();
		emps.add(emp);
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		emps.add(emp5);
		emps.add(emp6);
		emps.add(emp7);
		emps.add(emp8);
		

		//abrir base de datos
		ODB bd = ODBFactory.open("D:\\Ángel Pavón\\BBDD\\NeonDatis\\NeoDatis DDBB\\personal.db", "miusuario", "Pass!123456");
		
		for (Empleado empleado : emps) {
			bd.store(empleado);
		}
		
		for (Departamento d : deps) {
			bd.store(d);
		}
		
		bd.close();
	}

}
