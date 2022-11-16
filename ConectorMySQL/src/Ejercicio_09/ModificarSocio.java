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
			conexion.setAutoCommit(false);
			//Scanner
			Scanner s = new Scanner(System.in);
			
			
			PreparedStatement pstm;
			String sql;
			
			//Mostrar los socios existentes
			sql = "Select Codigo, Nombre from socio";
			
			pstm = conexion.prepareStatement(sql);
			
			ResultSet resultado = pstm.executeQuery();
			
			if(resultado != null) {
				while (resultado.next()) {
	            	System.out.println(resultado.getInt(1) + "-"+ resultado.getString(2));
	            }
			}
			
			int id;
			//Comprobar si existe el socio  que se ha introducido
			boolean vacio = true;
			do {
				System.out.println("Introduce el codigo del socio que quieras editar:");
				id = s.nextInt();
				s.nextLine();
				//Sentencia SQL
				sql = "Select * from socio where Codigo = ?";
				
				pstm = conexion.prepareStatement(sql);
				pstm.setInt(1, id);
				resultado = pstm.executeQuery();
				
				while (resultado.next()) {
		            	vacio = false;
		            	System.out.println(resultado.getInt(1) + " " + resultado.getString(2) 
		            						+ " " + resultado.getString(3) + ": " + resultado.getString(4) + " - " 
		            						+ resultado.getString(5) + " - " + resultado.getString(6));
		            }
				if(vacio) {
					System.out.println("Socio no existente, introduzca un código válido");
				}
			}while(vacio);
			
			// Menu para modificar dependiendo de lo que quiera el usuario
			System.out.println("Que quieres hacer:\n"
								+ "1. Modificar Teléfono\n"
								+ "2. Modificar Domicilio\n"
								+ "3. Modificar ambos");
			//Datos a modificar
			int tel;
			String dom = null;
			
			//Menu UPDATE `socio` SET `Domicilio` = 'C- La manzana2' WHERE `socio`.`Codigo` = 1

			int opcion = s.nextInt();
			s.nextLine();
			PreparedStatement pstm2;
			switch(opcion) {
			
				case 1: 
					//OPCION TELEFONO
					System.out.println("Introduzca el nuevo teléfono:");
					do {
						tel = s.nextInt();
						s.nextLine();
					}while(tel<0 && tel>999999999);
					
					//SENTENCIA SQL
					sql = "UPDATE socio SET Telefono = ? WHERE socio.Codigo = ?";
					pstm2 = conexion.prepareStatement(sql);
					pstm2.setInt(1, tel);
					pstm2.setInt(2, id);
					pstm2.executeUpdate();
					System.out.println("Cambio realizado");
					break;
				case 2:
					//OPCION DOMICILIO
					System.out.println("Introduzca el nuevo domicilio");
					do {
						dom = s.nextLine();
					}while(dom.length()<=0);
					
					//SENTENCIA SQL
					sql = "UPDATE socio SET Domicilio = ? WHERE socio.Codigo = ?";
					pstm2 = conexion.prepareStatement(sql);
					pstm2.setString(1, dom);
					pstm2.setInt(2, id);
					pstm2.executeUpdate();
					System.out.println("Cambio realizado");
					break;
				case 3:
					// OPCION AMBAS 
					//TELEFONO
					System.out.println("Introduzca el nuevo teléfono:");
					do {
						tel = s.nextInt();
						s.nextLine();
					}while(tel<0 && tel>999999999);
					
					//DOMICILIO
					System.out.println("Introduzca el nuevo domicilio");
					do {
						dom = s.nextLine();
					}while(dom.length()<=0);
					
					sql = "UPDATE socio SET Domicilio = ?, Telefono = ? WHERE socio.Codigo = ?";
					pstm2 = conexion.prepareStatement(sql);
					pstm2.setString(1, dom);
					pstm2.setInt(2, tel);
					pstm2.setInt(3, id);
					pstm2.executeUpdate();
					System.out.println("Cambio realizado");
					break;
				default:
					//ELECCION NO VALIDA
					System.out.println("Opcion no valida");
			}
			conexion.commit();
			s.close();
			}catch (SQLException | ClassNotFoundException ex) {
				
				 System.out.println("Error en la conexión de la base de datos");
		         ex.printStackTrace();
			}
			


	}

}
