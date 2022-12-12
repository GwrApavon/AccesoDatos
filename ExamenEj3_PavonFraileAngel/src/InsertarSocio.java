import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author alu
 *
 */
public class InsertarSocio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.105:3306/biblioteca", "miusuario", "Pass!123456");
			
			Scanner teclado = new Scanner(System.in);
			
			
			String sql = "INSERT INTO socio VALUES(?,?,?,?,?,?)";
			
			PreparedStatement pstm = conexion.prepareStatement(sql);
			
			pstm.setInt(1,14);
			pstm.setString(2, "Pepe");
			pstm.setString(3, "Martinez");
			pstm.setDate(4, pasarStringDate("1970-11-09"));
			pstm.setString(5, "C/Patatin,33");
			pstm.setInt(6, 650766546);
			
			int cantidad = pstm.executeUpdate();
			
			System.out.println("Se han insertado " + cantidad + " socios");
			
			conexion.commit();
			

			
			}catch (SQLException | ClassNotFoundException ex) {
				
				 System.out.println("Error en la conexión de la base de datos");
		         ex.printStackTrace();
			}

	}

	private static Date pasarStringDate(String string) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd"); 
		//Date fecha = formato.parse(string);
		return null;
	}

}
