
/**
 * 
 */
package cementerio.app;

/**
 * @author alu
 *
 */
public class GestorCementerio {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean salir = false;
		System.out.println("/n/tBienvenido a la aplicación de Gestion de Cementerio");
		
		do {
			salir = Menu.menuPrincipal();
		}while(!salir);
		
		System.out.println("/n/tGracias por usar nuestro servicio");
	}
}
