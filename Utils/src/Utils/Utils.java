package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

	// Menú que devuelve un booleano para hacer repeticiones
	public static boolean menu(Scanner sc) {
		int opcion = 0;
		System.out.println("Que quieres hacer: " + "\n1. Accion1" + "\n2. Accion2" + "\n3. Accion3" + "\n4. Accion4"
				+ "\n5. Accion5" + "\n6. Commit" + "\nElse. salir");

		opcion = sacarIntValido(sc);

		try {
			switch (opcion) {
			case 1:
				System.out.println("Accion 1");
				break;
			case 2:
				System.out.println("Accion 2");
				break;
			case 3:
				System.out.println("Accion 3");
				break;
			case 4:
				System.out.println("Accion 4");
				break;
			case 5:
				System.out.println("Accion 5");
				break;
			case 6:
				System.out.println("Commit");
			default:
				System.out.println("Saliendo...");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("RollBack");
		}
		return false;

	}

	// Método que devuelve un int valido (>0)
	public static int sacarIntValido(Scanner sc) {
		boolean salir = false;
		int i = 0;
		while (!salir || i < 0) {
			try {
				i = sc.nextInt();
				sc.nextLine();
				salir = true;
			} catch (InputMismatchException ime) {
				System.err.println("Introduzca un número por favor");
			}
		}
		return i;
	}
}
