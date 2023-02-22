/**
 * 
 */
package cementerio.app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.controlador.DifuntoControler;
import com.controlador.ResponsableControler;
import com.controlador.SepulturaControler;
import com.modelo.Responsable;

/**
 * @author alu
 *
 */
public class Menu {

	/*
	 * Base de datos seleccionada 
	 * Default: MySQL
	 */
	private static String db = "Hibernate";
	
	//Scanner
	static Scanner sc = new Scanner(System.in);
	
	/*
	 * Menu principal
	 * Se podrá elegir entre las siguientes opcines:
	 * 		- Cambiar de base de datos
	 * 		- Trabajar en la base de datos
	 * 		- Salir
	 * 
	 * @param sc Scanner para poder recibir input
	 */
	static boolean menuPrincipal() {
		
		System.out.println("Que desea hacer:\n"
				
							+ "\n\t1. Cambiar base de datos utilizada (actual: " + db +")"
							
							+ "\n\t2. Trabajar en la base de datos"
							
							+ "\n\n0. Salir");
		
		int opcion = Utilities.sacarIntValido(sc);
		switch(opcion) {
			case 1: 
					if(subMenuDB()) System.out.println("Base de datos cambiada a " + db);
					else System.out.println("Error al cambiar de base de datos");
				break;
			case 2: 
					boolean salidaSubMenu = false;
					do {
						salidaSubMenu = subMenuTablas();
					}while(!salidaSubMenu);
				break;
			default: 
					System.out.println("Saliendo...");
					return true;
		}
		return false;		
	}
	
	/*
	 * Submenu Eleccion DB
	 * Se podrá elegir entre las siguientes opcines:
	 * 		- Cambiar db a Hibernate
	 * 		- Cambiar db a Neodatis
	 * 		- Cambiar db a ExistDB
	 * 		- Salir
	 * 
	 * @param sc Scanner para poder recibir input
	 */
	private static boolean subMenuDB() {
	
		System.out.println("En que tipo de base de datos quieres trabajar:\n"
				
							+ "\n\t1. Hibernate"
				
							+ "\n\t2. Neodatis"
							
							+ "\n\t3. ExistDB"
							
							+ "\n\n0. Salir");
		
		int opcion = Utilities.sacarIntValido(sc);
		switch(opcion) {
			case 1: db = "Hibernate";
				break;
			case 2: db = "Neodatis";
				break;
			case 3: db = "ExistDB";
				break;
			default:
					System.out.println("Saliendo...");
					return false;
		}
		return true;
	}
	
	/*
	 * Submenu Eleccion de tabla en la que trabajar
	 * Se podrá elegir entre las siguientes opcines:
	 * 		- Trabajar en Difunto
	 * 		- Trabajar en Sepultura
	 * 		- Trabajar en Responsable
	 * 		- Salir
	 * 
	 * @param sc Scanner para poder recibir input
	 */
	private static boolean subMenuTablas() {
		boolean salirSubMenuTabla = false;
		
		System.out.println("En que tabla de la base de datos quieres trabajar:\n"
							
							+ "\n\t1. Difunto"
				
							+ "\n\t2. Sepultura"
							
							+ "\n\t3. Responsable"
							
							+ "\n\n0. Atrás");
		
		int op = Utilities.sacarIntValido(sc);
		
		if(op == 0) {
			return true;
		}
		
		do {
			salirSubMenuTabla = subMenuTabla(op);
		}while(!salirSubMenuTabla);
		
		
		return false;
	}
	
	/*
	 * Submenu acciones sobre la tabla
	 * Se podrá elegir entre las siguientes opcines:
	 * 		- Crear
	 * 		- Modificar
	 * 		- Borrar
	 * 		- Consulta 1
	 * 		- Consulta 2
	 * 		- Salir
	 * 
	 * @param sc Scanner para poder recibir input
	 */
	@SuppressWarnings("unused")
	private static boolean subMenuTabla(int option) {
		int id, op;
		
		//Diferentes controladores disponibles
		DifuntoControler difc = null;
		SepulturaControler sepc = null;
		ResponsableControler resc = null;
		//Hacer bucle hasta que se quiera salir 
		System.out.println("Que acción quieres hacer:\n"
				
				+ "\n\t1. Crear"
				
				+ "\n\t2. Modificar"
				
				+ "\n\t3. Borrar"
				
				+ "\n\t4. Hacer Consulta"
				
				+ "\n\t5. Hacer Consulta"
				
				+ "\n\n0. Atrás");
		
		op = Utilities.sacarIntValido(sc);
		
		switch(option) {
		
			case 1:
					difc = new DifuntoControler(db);
				break;
			case 2:
					sepc = new SepulturaControler(db);
				break;
			case 3:
					resc = new ResponsableControler(db);
				break;
		}
		
		switch(op){
			//CREAR
			case 1:
					if(option == 1) {
						difc.crearDifunto(Interacciones.pedirDatosDifunto());
					}
					else if(option == 2) {
						sepc.crearSepultura(Interacciones.pedirDatosSepultura());		
					}
					else if(option == 3) {
						Responsable responsable = Interacciones.pedirDatosResponsable();
						resc.crearResponsable(responsable);
					}
				break;
			//MODIFICAR
			case 2: 
					if(option == 1) {
						difc.modificarDifunto(Utilities.pedirIDObjeto(sc, 1), Interacciones.modificarDifunto(db));
					}
					else if(option == 2) {
						sepc.modificarSepultura(Utilities.pedirIDObjeto(sc, 1), Interacciones.modificarSepultura(db));
					}
					else if(option == 3) {
						resc.modificarResponsable(Utilities.pedirIDObjeto(sc, 1), Interacciones.modificarResponsable(db));	
					}
				break;
			//BORRAR
			case 3:
					if(option == 1) {
						difc.borrarDifunto(Utilities.pedirIDObjeto(sc, 2));
					}
					else if(option == 2) {
						sepc.borrarSepultura(Utilities.pedirIDObjeto(sc, 2));	
					}
					else if(option == 3) {
						resc.borrarResponsable(Utilities.pedirIDObjeto(sc, 2));
					}
				break;
			//CONSULTA 1
			case 4:
					if(option == 1) {
//						dif.modificarDifunto(id, null);
					}
					else if(option == 2) {
//						sep.modificarSepultura(id, null);	
					}
					else if(option == 3) {
//						res.modificarResponsable(id, null);
					}
				break;
			//CONSULTA 2
			case 5:
					if(option == 1) {
//						dif.modificarDifunto(id, null);
					}
					else if(option == 2) {
//						sep.modificarSepultura(id, null);	
					}
					else if(option == 3) {
//						res.modificarResponsable(id, null);
					}
				break;
			default: 
					System.out.println("Saliendo...");
					return true;
		}
		return false;
	}
	
	/**
	 *  Muestra un menu con las opciones dependiendo de lo que se vaya a modificar
	 *  @param i:
	 *  	-> 1: Difunto
	 *		-> 2: Responsable
	 *		-> 3: Sepultura
	 */
	static void eleccionModi(int i) {
		switch(i) {
			case 1:
				System.out.println("Que deseas modificar del difunto:"
						+ "\n1. Nombre"
						+ "\n2. Primer Apellido"
						+ "\n3. Segundo Apellido"
						+ "\n4. Fecha de nacimiento"
						+ "\n5. Fecha de defuncion"
						+ "\n6. Fecha de enterramiento"
						+ "\n7. Sepultura"
						+ "\n0. Salir");
				break;
			case 2:
				System.out.println("Que deseas modificar del responsable:"
						+ "\n1. Nombre"
						+ "\n2. Primer Apellido"
						+ "\n3. Segundo Apellido"
						+ "\n4. Cuenta Domiciliacion"
						+ "\n5. Sepulturas Asignadas"
						+ "\n0. Salir");
				break;
			case 3:
				System.out.println("Que deseas modificar del difunto:"
						+ "\n1. Numero de Sepultura"
						+ "\n2. Calle de Sepultura"
						+ "\n3. Nombre del titular"
						+ "\n4. Primer apellido del titular"
						+ "\n5. Segundo apellido del titular"
						+ "\n6. Codigo de contable"
						+ "\n7. Tipo de contrato"
						+ "\n8. Observaciones"
						+ "\n9. Responsable a cargo"
						+ "\n10. Difuntos asignados"
						+ "\n0. Salir");
				break;
		}
		
	}
}
