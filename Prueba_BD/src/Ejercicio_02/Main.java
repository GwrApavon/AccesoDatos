/**
 * 
 */
package Ejercicio_02;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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
			
			Class.forName("org.sqlite.JDBC");
			
			//Establecer conexión con BBDD 
			
			Connection conexion = DriverManager.getConnection("jdbc:sqlite:src\\bbdd_conexion\\biblioteca.sql");
			
			Scanner teclado = new Scanner(System.in);
			
			//Preparamos la sentencia SQL
			
			String sql = "INSERT INTO libros VALUES(?,?,?,?,?)";
			
			PreparedStatement pstm = conexion.prepareStatement(sql);
			
			String res = "sigue";
			
			while (res.startsWith(res, 's')) {
				
				//ISBN es único ---> obtenerlo de la BD
				
				int Codigo = obtenerCodigoValido(conexion);
				
				System.out.println("Introduzca título del libro: ");
				String titulo = teclado.nextLine();
				
				System.out.println("Introduzca fecha de lanzamiento del libro: ");
				int fecha_lanzamiento = teclado.nextInt();
				
				//Comprobación de que fecha de lanzamiento sea un año en realidad
				
				if (fecha_lanzamiento < 0 || fecha_lanzamiento > 2022) fecha_lanzamiento = 2022;
					
				System.out.println("Introduzca el autor del libro: ");
				String autor = teclado.nextLine();
				
				System.out.println("Introduzca el número de ejemplares del libro: ");
				int num_ejemplares = teclado.nextInt();
				
				//Comprobación de que el número de ejemplares será mayor que 0
				
				if (num_ejemplares < 0) num_ejemplares = 1;
				
				System.out.println("Introduzca las páginas del libro: ");
				int paginas = teclado.nextInt();
				
				//Comprobación de que el número de páginas será mayor que 0
				
				if (paginas < 0) paginas = 1;
				
				
				pstm.setInt(1,Codigo);
				pstm.setString(2,titulo);
				pstm.setInt(3,fecha_lanzamiento);
				pstm.setString(4,autor);
				pstm.setInt(5,num_ejemplares);
				pstm.setInt(6,paginas);
				
				int cantidad = pstm.executeUpdate();
				System.out.println("Se ha introducido " + cantidad + " libro correctamente");
				
				System.out.println("¿Desea introducir otro libro? (s/n)");
				res = teclado.nextLine();
			
			}
			
			conexion.close();
			
			
		} catch (SQLException | ClassNotFoundException ex) {
			
			 System.out.println("Error en la conexi�n de la base de datos");
	         ex.printStackTrace();
		}
			


	}

	private static int obtenerCodigoValido(Connection conexion) {
		
		
		int Codigo = -1;
		
		Statement sentencia;
		try {
			sentencia = (Statement) conexion.createStatement();
			ResultSet resultado = ((java.sql.Statement) sentencia).executeQuery("select max(ISBN) from libros");
			
			while (resultado.next()) {
				
				Codigo = resultado.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return Codigo + 1;
	}

}

