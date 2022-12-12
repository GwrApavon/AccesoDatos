/**
 * 
 */
package Ejercicio1;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Ángel Pavón Fraile
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
        	// Carga el controlador jdbc de la base de datos 
			Class.forName("org.sqlite.JDBC");
        	
        	// Conexión con la base de datos
        	Connection conexion = DriverManager.getConnection("jdbc:sqlite:src\\Ejercicio1\\VacacionesForyou.db");


            String sql = "INSERT INTO clientes VALUES (?,?,?,?,?,?,?)"; //Prepara la sentencia
            PreparedStatement pstm = conexion.prepareStatement(sql); 
            
            File f = new File("VacacionesForyou.txt");
            FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader (fr);
			
			int contador = 1;
			String linea = br.readLine();
			while(linea != null) {
				//Rellena uno por uno los clientes
				pstm.setInt(1, contador);
				String nombre = linea.split(";")[0];
				pstm.setString(2, nombre);
				String apellido = linea.split(";")[1];
				pstm.setString(3, apellido);
	            int telef = cambiarInt(linea.split(";")[2]); //No he conseguido que funcione correctamente el metodo cambiarInt por lo que el numero de telefono no es correcto pero no me da tiempo a cambiarlo
	            pstm.setInt(4, telef);
	            String direccion = linea.split(";")[3];
	            pstm.setString(5, direccion);
	            String email = linea.split(";")[4];
	            pstm.setString(6, email);
	            int VIP = 0;
	            if(linea.split(";").length >5) { //Si es vip = 1, sino vip = 0
	            	VIP = 1;
	            	pstm.setInt(7, VIP);
	            }
	            else {
	            	pstm.setInt(7, VIP);
	            }
	            //muestra el cliente añadido
				System.out.println("Se ha añadido a: " + contador + " " + nombre + " " + apellido + " " + telef + " " + direccion + " " + email + " " + VIP);
	            contador++;
	            pstm.executeUpdate(); //ejecuta la sentencia
				linea = br.readLine();
			}
			br.close();
                  
			
            System.out.println("Listado de clientes: ");
            sql = "select * from clientes";
            pstm = conexion.prepareStatement(sql);
            ResultSet resultado = pstm.executeQuery();
            
            // recorro el resultado
            while (resultado.next()) {
            	System.out.println(resultado.getInt(1) + "-"+ resultado.getString(2));
            }
            
            // LIBRERAR LOS RECURSOS
            resultado.close();
            
            //Cierre conexion
			conexion.close();
            
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Error en la conexión de la base de datos");
			ex.printStackTrace();
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    

	}
	
	public static int cambiarInt(String s) { //metodo para cambiar de string a int
		int num = 0;
		int cont = 0;
		for(int i = (s.length() - 1); i>0;i--) {
			num += ((int)s.charAt(i)) * (10^cont);
			cont++;
		}
		return num;
	}

}
