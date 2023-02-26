/**
 * 
 */
package cementerio.app;


import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;



/**
 * @author alu
 *
 */
public class AgregarDatos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		

		//abrir base de datos
		ODB bd = ODBFactory.open("Cementerio.db", "miusuario", "Pass!123456");

		bd.close();
	}

}
