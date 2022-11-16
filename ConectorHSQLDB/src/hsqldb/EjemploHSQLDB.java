package hsqldb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class EjemploHSQLDB {
    public static void main(String[] args) {
        try {
        	// CARGAR EL CONTROLADOR JDBC de la base de datos
        	Class.forName("org.hsqldb.jdbc.JDBCDriver");
        	
        	// ESTABLECER LA CONEXI�N con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:hsqldb:bd/biblioteca", "miusuario","Pass!123456");
            // parametro 1 = Driver que utilizamos y ruta y nombre de la base de datos
            //				jdbc:sqlite:C:\\Users\\Eva Royo\\Documents\\BBDD\\sqlite\\biblioteca.db
            // parametro 2 = nombre del usuario
            // parametro 3 = contrase�a del usuario
            
            
            // PREPARAMOS LA SENTENCIA SQL
            Statement sentencia = (Statement) conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from libro");
            
            // recorro el resultado
            while (resultado.next()) {
            	System.out.println(resultado.getString("TITULO"));
            }
            
            // LIBRERAR LOS RECURSOS
            resultado.close();
            sentencia.close();
            conexion.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexi�n de la base de datos");
            ex.printStackTrace();
        }
    }
}