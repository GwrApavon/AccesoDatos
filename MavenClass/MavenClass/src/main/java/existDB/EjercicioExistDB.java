/**
 * 
 */
package existDB;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

/**
 * @author alu
 *
 */
public class EjercicioExistDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// driver que necesito para conectar existDB
		String driver  =  "org.exist.xmldb.DatabaseImpl";
				
		// cargar el driver
		Class cl;
		try {
			cl = Class.forName(driver);
					
			//instancia de la BD
			Database BD = (Database)cl.newInstance();
					
			// registrar el Driver
			DatabaseManager.registerDatabase(BD);
			        
			// La cadena de conexion
			String URI = "xmldb:exist://192.168.56.105:8080/exist/xmlrpc/db/pruebas";
			        
			Collection miDB = DatabaseManager.getCollection(URI, "miusuario", "Pass!123456");
			        
			XPathQueryService servicio = (XPathQueryService)miDB.getService("XPathQueryService", "1.0");
		
			Scanner sc = new Scanner(System.in);
			
			boolean salir = false;
			
			do {
			
				salir = menu(sc ,servicio);
			}while(!salir);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (XMLDBException e) {
			
			e.printStackTrace();
		}
	}

	public static boolean menu(Scanner sc, XPathQueryService srv) {
		int opcion = 0;
		System.out.println("Que quieres hacer: " 
							+ "\n1. Obtener los apellidos distintos de los autores" 
							+ "\n2. Obtener los nodos libro que tengan un nodo editor" 
							+ "\n3. Obtener los títulos de los libros cuyo precio esté por debajo de 50 euros." 
							+ "\n4. Por cada libro con autores, seleccionar el título del libro y sus autores. "
							+ "Si el libro no tiene autores, pero el editor sí,"
							+ " la consulta devolverá el título del libro y la afiliación del editor" 
							+ "\nElse. salir");

		opcion = sacarIntValido(sc);

		try {
			switch (opcion) {
			case 1:
				obtenerApellidos(srv);
				break;
			case 2:
				librosEditor(srv);
				break;
			case 3:
				libros50Mas(srv);
				break;	
			case 4:
				datosLibroAutor(srv);
				break;	
			default:
				System.out.println("Saliendo...");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	//Obtiene los diferentes apellidos de los autores
	public static void obtenerApellidos(XPathQueryService srv) {
		String query = "for $a in distinct-values(doc(\"/db/pruebas/libros.xml\")//libro/autor/apellido) return data($a)";
		ResourceSet resultado;
		try {
			resultado = srv.query(query);
		
        ResourceIterator itera = resultado.getIterator();
       
        System.out.println("=========================================");
        
        if (!itera.hasMoreResources()) {
        	System.out.println("No hay resultados");
        } else {
        	while (itera.hasMoreResources()) {
        		Resource elemento = itera.nextResource();
        		System.out.println(elemento.getContent());
        	}
        }
        
        System.out.println("=========================================");
		} catch (XMLDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Obtiene los datos del libro que tenga editor
	public static void librosEditor(XPathQueryService srv) {
		String query = "for $a in doc(\"/db/pruebas/libros.xml\")//libro where //editor return data($a)";
		ResourceSet resultado;
		try {
			resultado = srv.query(query);
		
        ResourceIterator itera = resultado.getIterator();
       
        System.out.println("=========================================");
        
        if (!itera.hasMoreResources()) {
        	System.out.println("No hay resultados");
        } else {
        	while (itera.hasMoreResources()) {
        		Resource elemento = itera.nextResource();
        		System.out.println(elemento.getContent());
        	}
        }
        
        System.out.println("=========================================");
		} catch (XMLDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void libros50Mas(XPathQueryService srv) {
		String query = "for $l in doc(\"/db/pruebas/libros.xml\")//libro where $l/precio < 50 return $l/titulo/text()";
		ResourceSet resultado;
		try {
			resultado = srv.query(query);
		
        ResourceIterator itera = resultado.getIterator();
        System.out.println("=========================================");
        
        if (!itera.hasMoreResources()) {
        	System.out.println("No hay resultados");
        } else {
        	while (itera.hasMoreResources()) {
        		Resource elemento = itera.nextResource();
        		System.out.println(elemento.getContent());
        	}
        }
        
        System.out.println("=========================================");
		} catch (XMLDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void datosLibroAutor(XPathQueryService srv) {
		String query = "for $l in doc(\"/pruebas/libros.xml\")//libro"
				+ "    return data(if (exists($l/autor))"
				+ "      then <libro>{"
				+ "                <li>"
				+ "                    <titulo>{data($l/titulo)}</titulo>,"
				+ "                     --Autor:\r\n"
				+ "                    <autor>{data($l//apellido)}</autor>"
				+ "                </li>"
				+ "           }</libro>"
				+ "       else <libro>{"
				+ "                <li>"
				+ "                    <titulo>{data($l/titulo)}</titulo>,"
				+ "                     --Afiliacion:"
				+ "                    <afiliacion>{data($l//afiliacion)}</afiliacion>"
				+ "                </li>"
				+ "       }"
				+ "       </libro>)";
		ResourceSet resultado;
		try {
			resultado = srv.query(query);
		
        ResourceIterator itera = resultado.getIterator();
        System.out.println("=========================================");
        
        if (!itera.hasMoreResources()) {
        	System.out.println("No hay resultados");
        } else {
        	while (itera.hasMoreResources()) {
        		Resource elemento = itera.nextResource();
        		System.out.println("+++++++++++++++++++++++++++++++++++++++");
        		System.out.println(elemento.getContent());
        	}
        	System.out.println("+++++++++++++++++++++++++++++++++++++++");
        }
        
        System.out.println("=========================================");
		} catch (XMLDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int sacarIntValido(Scanner sc) {
		boolean salir = false;
		int i = 0;
		while (!salir || i < 0) {
			try {
				i = sc.nextInt();
				sc.nextLine();
				salir = true;
			} catch (InputMismatchException ime) {
				System.err.println("Introduzca un número por favor");
			}
		}
		return i;
	}
}
