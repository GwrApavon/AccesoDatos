/**
 * 
 */
package EjerciciosDeparamentos;
import java.io.*;
/**
 * @author alu
 *
 */
public class Main22 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			File myFile  = new File ("departamentos.xml");
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader (fr);
			
			String linea = br.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			br.close();

		}catch(FileNotFoundException fnfe) {
			
			fnfe.printStackTrace();
		
		}catch(IOException ioe) {
			
			ioe.printStackTrace();
		}
	}

}
