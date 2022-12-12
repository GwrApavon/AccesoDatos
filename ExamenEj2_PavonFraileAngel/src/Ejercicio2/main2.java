/**
 * 
 */
package Ejercicio2;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Ángel Pavón Fraile
 *
 */
public class main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
        	// Carga el controlador jdbc de la base de datos 
			Class.forName("org.sqlite.JDBC");
        	
        	// Conexión con la base de datos
        	Connection conexion = DriverManager.getConnection("jdbc:sqlite:src\\Ejercicio2\\VacacionesForyou.db");

        	//Scanner
			Scanner s = new Scanner(System.in);
			
			//Arraylist no vip
			ArrayList <String> nVip = new ArrayList<String>();
            String sql = ""; //Prepara la sentencia
            PreparedStatement pstm; 
            
            
			System.out.println("Que desea hacer: "
								+ "\n 1. Listar todos los clientes"
								+ "\n 2. Modificar el telefono de un cliente");
			
			int tel;

			int opcion = s.nextInt();
			s.nextLine();
			PreparedStatement pstm2;
			switch(opcion) {
			
				case 1: 
					System.out.println("Listado de clientes: ");
		            sql = "select * from clientes";
		            pstm = conexion.prepareStatement(sql);
		            ResultSet resultado = pstm.executeQuery();
		            
		            // recorro el resultado
		            while (resultado.next()) {
		            	if(resultado.getInt(7) == 1) {
		            		System.out.println(resultado.getInt(1) + "-"+ resultado.getString(2) + " " + resultado.getString(3)
		            					  	  + "; " + resultado.getInt(4) + "; " + resultado.getString(5) + "; " + resultado.getString(6) 
		            					  	  + "; " + resultado.getInt(7));
		            	}
		            	else {
		            		nVip.add(resultado.getInt(1) + "-"+ resultado.getString(2) + " " + resultado.getString(3)
		            					  	  + "; " + resultado.getInt(4) + "; " + resultado.getString(5) + "; " + resultado.getString(6) 
		            					  	  + "; " + resultado.getInt(7));
		            	}
		            }
		            for (String string : nVip) {
						System.out.println(string);
					}
		            
		            // LIBRERAR LOS RECURSOS
		            resultado.close();
					break;
				case 2:
					//OPCION TELEFONO
					System.out.println("Listado de clientes: ");
		            sql = "select * from clientes";
		            pstm = conexion.prepareStatement(sql);
		            resultado = pstm.executeQuery();
		            
		            // recorro el resultado
		            while (resultado.next()) {
		            	System.out.println(resultado.getInt(1) + "-"+ resultado.getString(2) + " " + resultado.getString(3));
		            }
		            
		            // LIBRERAR LOS RECURSOS
		            resultado.close();
		            
		            int id;
					//Comprobar si existe el socio  que se ha introducido
					boolean vacio = true;
					do {
						System.out.println("Introduce el id del cliente del que quieras cambiar el telefono:");
						id = s.nextInt();
						s.nextLine();
						//Sentencia SQL
						sql = "Select * from clientes where id = ?";
						
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
							System.out.println("Cliente no existente, introduzca un código válido");
						}
					}while(vacio);
					
					System.out.println("Introduzca el nuevo teléfono:");
					do {
						tel = s.nextInt();
						s.nextLine();
					}while(tel<0 && tel>999999999);
					
					//SENTENCIA SQL
					sql = "UPDATE clientes SET Telefono = ? WHERE clientes.id = ?";
					pstm2 = conexion.prepareStatement(sql);
					pstm2.setInt(1, tel);
					pstm2.setInt(2, id);
					pstm2.executeUpdate();
					System.out.println("Cambio realizado");
					break;
				default:
					System.out.println("Opcion no valida");
			}          
            
            //Cierre conexion
			conexion.close();
            s.close();
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Error en la conexión de la base de datos");
			ex.printStackTrace();
		} catch (InputMismatchException ime) {
			ime.printStackTrace();
		}
    

	}

}
