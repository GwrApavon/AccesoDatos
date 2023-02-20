
/**
 * 
 */
package cementerio.app;


import java.util.Scanner;
import com.controlador.DifuntoControler;
import com.controlador.ResponsableControler;
import com.controlador.SepulturaControler;


/**
 * @author alu
 *
 */
public class GestorCementerio {
	
	private static String db = "MySQL";
	private static Scanner sc = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean salir = false;
		System.out.println("/n/tBienvenido a la aplicación de Gestion de Cementerio");
		
		do {
			salir = menuPrincipal();
		}while(!salir);
		
		System.out.println("/n/tGracias por usar nuestro servicio");
	}

	/*
	 * Menu principal
	 * Se podrá elegir entre las siguientes opcines:
	 * 		- Cambiar de base de datos
	 * 		- Trabajar en la base de datos
	 * 		- Salir
	 * 
	 * @param sc Scanner para poder recibir input
	 */
	private static boolean menuPrincipal() {
		
		System.out.println("Que desea hacer:"
				
							+ "/n1. Cambiar base de datos utilizada (actual: " + db +")"
							
							+ "/n2. Trabajar en la base de datos"
							
							+ "/n/n0. Salir");
		
		int opcion = Utilities.sacarIntValido(sc);
		sc.nextLine();
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
	
		System.out.println("En que tipo de base de datos quieres trabajar:"
				
							+ "/n1. Hibernate"
				
							+ "/n2. Neodatis"
							
							+ "/n3. ExistDB"
							
							+ "/n/n0. Salir");
		
		int opcion = Utilities.sacarIntValido(sc);
		sc.nextLine();
		switch(opcion) {
			case 1: db = "Hibernate";
				break;
			case 2: db = "Neodatis";
				break;
			case 3: db = "ExistDB";
				break;
			default:
					System.out.println("Saliendo...");
					return true;
		}
		return false;
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
		
		System.out.println("En que tabla de la base de datos quieres trabajar:"
							
							+ "/n1. Difunto"
				
							+ "/n2. Sepultura"
							
							+ "/n3. Responsable"
							
							+ "/n/n0. Atrás");
		
		int op = Utilities.sacarIntValido(sc);
		sc.nextLine();
		
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
	private static boolean subMenuTabla(int option) {
		int id, op;
		
		//Diferentes controladores disponibles
		DifuntoControler dif = null;
		SepulturaControler sep = null;
		ResponsableControler res = null;
		//Hacer bucle hasta que se quiera salir 
		System.out.println("En que tabla de la base de datos quieres trabajar:"
				
				+ "/n1. Crear"
				
				+ "/n2. Modificar"
				
				+ "/n3. Borrar"
				
				+ "/n4. Hacer Consulta"
				
				+ "/n5. Hacer Consulta"
				
				+ "/n/n0. Atrás");
		
		op = Utilities.sacarIntValido(sc);
		sc.nextLine();
		
		switch(option) {
		
			case 1:
					dif = new DifuntoControler(db);
				break;
			case 2:
					sep = new SepulturaControler(db);
				break;
			case 3:
					res = new ResponsableControler(db);
				break;
		}
		
		switch(op){
			case 1:
					if(option == 1) {
						dif.crearDifunto(null);
					}
					if(option == 2) {
						//sep.crearSepultura(null);		
					}
					if(option == 3) {
						//res.crearResponsable(null);
					}
				break;
			case 2: 
//					if(option == 1) {
//						dif.modificarDifunto(id, null);
//					}
//					if(option == 2) {
//						sep.modificarSepultura(id, null);
//					}
//					if(option == 3) {
//						res.modificarResponsable(id, null);	
//					}
				break;
			case 3:
					if(option == 1) {
//						dif.modificarDifunto(id, null);
					}
					if(option == 2) {
//						sep.modificarSepultura(id, null);	
					}
					if(option == 3) {
//						res.modificarResponsable(id, null);
					}
				break;
			case 4:
					if(option == 1) {
//						dif.modificarDifunto(id, null);
					}
					if(option == 2) {
//						sep.modificarSepultura(id, null);	
					}
					if(option == 3) {
//						res.modificarResponsable(id, null);
					}
				break;
			case 5:
					if(option == 1) {
//						dif.modificarDifunto(id, null);
					}
					if(option == 2) {
//						sep.modificarSepultura(id, null);	
					}
					if(option == 3) {
//						res.modificarResponsable(id, null);
					}
				break;
			default: 
					System.out.println("Saliendo...");
					return true;
		}
		return false;
	}
}
