/**
 * 
 */
package Ejercicio_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author alu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	        try {
	        	// CARGAR EL CONTROLADOR JDBC de la base de datos
	        	Class.forName("org.sqlite.JDBC");
	        	
	        	// ESTABLECER LA CONEXI�N con la base de datos
	            Connection conexion = DriverManager.getConnection("jdbc:sqlite:src\\sqlite\\biblioteca.db");
	            // parametro 1 = Driver que utilizamos y ruta y nombre de la base de datos
	            //				jdbc:sqlite:C:\\Users\\Eva Royo\\Documents\\BBDD\\sqlite\\biblioteca.db
	            // parametro 2 = nombre del usuario
	            // parametro 3 = contrase�a del usuario
	            
	            
	            // PREPARAMOS LA SENTENCIA SQL
	            Statement sentencia = (Statement) conexion.createStatement();
	            ResultSet resultado = sentencia.executeQuery("Select titulo, Nombre from Prestamo, Socio, Libro "
		            											 + "where "
		            											 + "Libro.Codigo = Prestamo.Codigo_Libro AND "
		            											 + "Socio.Codigo = Prestamo.Codigo_Socio AND "
		            											 + "date(Prestamo.Fecha_Fin_Prestamo) > date(\"now\")");
	            
	            // recorro el resultado
	            System.out.println("Titulo:   |   Nombre:");
	            while (resultado.next()) {
	            	System.out.println(resultado.getString(1) + " -> " + resultado.getString(2));
	            	
	            }
	            System.out.println("\n-------------------------------------------------------------------------\n");
	            
	            resultado = sentencia.executeQuery("SELECT Nombre, count(Codigo_Libro) "
											            		+ "FROM Socio,Prestamo "
											            		+ "WHERE "
											            		+ "Prestamo.Codigo_Socio = Socio.Codigo AND 	"
											            		+ "Socio.Nombre = \'Rusaffa\' ");

	            // recorro el resultado
	            System.out.println("Nombre: | Numero Prestamos ");
	            while (resultado.next()) {
	            	System.out.println(resultado.getString(1) + "    ->    " + resultado.getInt(2));

	            }
	            System.out.println("\n-------------------------------------------------------------------------\n");
	            
	            resultado = sentencia.executeQuery("Select DISTINCT titulo from Prestamo, Libro "
																 + "where "
																 + "Libro.Codigo = Prestamo.Codigo_Libro AND "
																 + "date(Prestamo.Fecha_Fin_Prestamo) < date(\"now\")");

	            // recorro el resultado
	           System.out.println("Titulo: ");
	           while (resultado.next()) {
	        	   System.out.println(resultado.getString(1));
	            // LIBRERAR LOS RECURSOS
	            }
	            
	           System.out.println("\n-------------------------------------------------------------------------\n");
	            
	           resultado = sentencia.executeQuery("Select DISTINCT Nombre from Prestamo, Socio "
													 + "where "
													 + "Socio.Codigo = Prestamo.Codigo_Socio AND "
													 + "date(Prestamo.Fecha_Fin_Prestamo) < date(\"now\")");

	            // recorro el resultado
	            System.out.println("Nombre: ");
	            while (resultado.next()) {
	            	System.out.println(resultado.getString(1));
	            // LIBRERAR LOS RECURSOS
	            }
	            resultado.close();
	            sentencia.close();
	            conexion.close();
	            
	        } catch (SQLException | ClassNotFoundException ex) {
	            System.out.println("Error en la conexion de la base de datos");
	            ex.printStackTrace();
	        
	    }

	}

}
