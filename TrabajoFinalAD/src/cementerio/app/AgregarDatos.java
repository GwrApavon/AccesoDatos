/**
 * 
 */
package cementerio.app;


import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import com.modelo.Difunto;
import com.modelo.Responsable;
import com.modelo.Sepultura;


/**
 * @author alu
 *
 */
public class AgregarDatos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Difunto dif = new Difunto (0,null,null,null,null,null,null,null);
		Sepultura sep = new Sepultura (0,null,null,null,0,null,null,null,null,null,null);
		Responsable res = new Responsable (0,null,null,null,null,null);
		
		//abrir base de datos
		ODB bd = ODBFactory.open("Cementerio.db");
		bd.store(dif);
		bd.store(sep);
		bd.store(res);
		bd.close();
	}

}
