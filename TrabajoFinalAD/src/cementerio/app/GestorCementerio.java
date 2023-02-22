
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
		System.out.println("\n\t ========================================================");
		System.out.println("\n\t | Bienvenido a la aplicación de Gestion de Cementerio  |");
		System.out.println("\n\t ========================================================\n");
		
		do {
			salir = Menu.menuPrincipal();
		}while(!salir);
		
		System.out.println("\n\t ======================================");
		System.out.println("\n\t | Gracias por usar nuestro servicio  |");
		System.out.println("\n\t ======================================\n");
	}
}
