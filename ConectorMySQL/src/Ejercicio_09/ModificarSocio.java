/**
 * 
 */
package Ejercicio_09;

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
public class ModificarSocio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
try {
			//Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Conexión con la base de datos
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.105:3306/biblioteca", "miusuario", "Pass!123456");
			
			//Scanner
			Scanner s = new Scanner(System.in);
			
			
			PreparedStatement pstm;
			String sql;
			
			//Mostrar los socios existentes
			sql = "Select Codigo, Nombre from Socio";
			
			pstm = conexion.prepareStatement(sql);
			
			ResultSet resultado = pstm.getResultSet();
			
			while (resultado.next()) {
            	System.out.println(resultado.getInt(1) + "-"+ resultado.getString(2));
            }
			
			//Comprobar si existe el socio  que se ha introducido
//			do {
//				System.out.println("Introduce el Socio que quieras editar:");
//				//Sentencia SQL
//				sql = "Select * from Socio where nombre = ?";
//				
//				pstm = conexion.prepareStatement(sql);
//						
//			}while(pstm.getMaxRows()<=0);
			
			
			
			//int cantidad = pstm.executeUpdate();
			
			//System.out.println("Se han insertado " + cantidad + " socios");
			
			//conexion.commit();
			

			s.close();
			}catch (SQLException | ClassNotFoundException ex) {
				
				 System.out.println("Error en la conexión de la base de datos");
		         ex.printStackTrace();
			}
			


	}

}
