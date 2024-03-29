/**
 *  Menu para la aplicacion
 */
package cementerio.app;

import java.util.Scanner;

import com.controlador.DifuntoControler;
import com.controlador.ResponsableControler;
import com.controlador.SepulturaControler;
import com.modelo.Difunto;
import com.modelo.Responsable;
import com.modelo.Sepultura;

/**
 * @author Angel Pavon Fraile
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
	 * 		- Consulta 1 
	 * 		- Consulta 2
	 * 		- Salir
	 * 
	 * @param sc Scanner para poder recibir input
	 */
	private static boolean subMenuTablas() {
		boolean salirSubMenuTabla = false;
		if (!db.equalsIgnoreCase("existDB")) {
			System.out.println("Que quieres hacer:\n"
								
								+ "\n\t1. Trabajar en Difunto"
					
								+ "\n\t2. Trabajar en Sepultura"
								
								+ "\n\t3. Trabajar en Responsable"
								
								+ "\n\t4. Consultar datos generales por fecha de defunción"
								
								+ "\n\t5. Consultar Sepultura y Responsable por datos del difunto"
								
								+ "\n\n0. Atrás");
			
			int op = Utilities.sacarIntValido(sc);
			
			switch(op) {
			
				case 1,2,3:
						do {
							salirSubMenuTabla = subMenuTabla(op);
						}while(!salirSubMenuTabla);
					break;
				case 4:
						Interacciones.prepararConsulta(1,db);
					break;
				case 5:
						Interacciones.prepararConsulta(2,db);
					break;
				default: 
						System.out.println("Saliendo...");
					return true;
			}
		}
		
		else {
			System.out.println("Que quieres hacer:\n"
					
								+ "\n\t1. Consultar todos los difuntos"
					
								+ "\n\t2. Consultar todas las sepulturas"
								
								+ "\n\n0. Atrás");
			
			int op = Utilities.sacarIntValido(sc);
			
			switch(op) {
				case 1:
						Interacciones.prepararConsulta(1,db);
					break;
				case 2:
						Interacciones.prepararConsulta(2,db);
					break;
				default: 
						System.out.println("Saliendo...");
					return true;
			}
		}
		return false;
	}
	
	/*
	 * Submenu acciones sobre la tabla
	 * Se podrá elegir entre las siguientes opcines:
	 * 		- Crear
	 * 		- Modificar
	 * 		- Borrar
	 * 		- Salir
	 * 
	 * @param sc Scanner para poder recibir input
	 */
	private static boolean subMenuTabla(int option) {
		int id, op;
		
		Responsable res;
		Difunto dif;
		Sepultura sep;
		//Diferentes controladores disponibles
		DifuntoControler difc = null;
		SepulturaControler sepc = null;
		ResponsableControler resc = null;
		//Hacer bucle hasta que se quiera salir 
		System.out.println("Que acción quieres hacer:\n"
				
				+ "\n\t1. Crear"
				
				+ "\n\t2. Modificar"
				
				+ "\n\t3. Borrar"
				
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
						dif = Interacciones.pedirDatosDifunto(db);
						difc.crearDifunto(dif);
					}
					else if(option == 2) {
						sep = Interacciones.pedirDatosSepultura(db);
						sepc.crearSepultura(sep);		
					}
					else if(option == 3) {
						res = Interacciones.pedirDatosResponsable();
						resc.crearResponsable(res);
					}
				break;
			//MODIFICAR
			case 2: 
					if(option == 1) {
						dif = Interacciones.modificarDifunto(db);
						difc.modificarDifunto(dif.getIdDifunto(), dif);
					}
					else if(option == 2) {
						sep = Interacciones.modificarSepultura(db);
						sepc.modificarSepultura(sep.getIdSepultura(), sep);
					}
					else if(option == 3) {
						res = Interacciones.modificarResponsable(db);
						resc.modificarResponsable(res.getIdResponsable(), res);	
					}
				break;
			//BORRAR
			case 3:
					if(option == 1) {
						id = Utilities.pedirIDObjeto(sc, 2);
						difc.borrarDifunto(id);
					}
					else if(option == 2) {
						id = Utilities.pedirIDObjeto(sc, 3);
						sepc.borrarSepultura(id);	
					}
					else if(option == 3) {
						id = Utilities.pedirIDObjeto(sc, 3);
						resc.borrarResponsable(id);
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
