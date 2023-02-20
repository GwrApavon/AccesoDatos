/**
 * 
 */
package cementerio.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.controlador.DifuntoControler;
import com.controlador.ResponsableControler;
import com.controlador.SepulturaControler;
import com.modelo.Difunto;
import com.modelo.Responsable;
import com.modelo.Sepultura;

/**
 * @author alu
 *
 */
public class Interacciones {
	
	/*
	 * Pedir datos del difunto
	 * Pide los datos del difunto para insertarlo en la base de datos
	 * 
	 * @param sc Scanner Input
	 * @return dif Difunto creado
	 */
	public static Difunto pedirDatosDifunto(Scanner sc) {
		Difunto dif = new Difunto();
		
		System.out.print("\nNombre: ");
		String nombre = sc.nextLine();
		dif.setNombre(nombre);
		System.out.print("\nPrimer Apellido: ");
		String ap1 = sc.nextLine();
		dif.setApellido1(ap1);
		System.out.print("\nSegundo apellido: ");
		String ap2 = sc.nextLine();
		dif.setApellido2(ap2);
		
		System.out.println("El formato de las siguientes fechas debe ser YY/MM/DD");
		System.out.print("\nFecha de nacimiento:");
		Date fNacimiento = Utilities.stringToDate(sc);
		dif.setFechaNacimiento(fNacimiento);
		System.out.print("\nFecha de defunción: ");
		Date fDefuncion = Utilities.stringToDate(sc);
		dif.setFechaDefuncion(fDefuncion);
		System.out.print("\nFecha de enterramiento: ");
		Date fEnterramiento = Utilities.stringToDate(sc);
		dif.setFechaEnterramiento(fEnterramiento);
		
		System.out.print("\nSepultura:");
		//pedir sepultura
		dif.setSepultura(dif.getSepultura());
		
		return dif;	
	}
	
	/*
	 * 
	 */
	public static Difunto modificarDifunto(Scanner sc) {
		Difunto dif = new Difunto();
		
		return dif;	
	}
	
	
	/*
	 * Mostrar todos los valores de cada tabla
	 * @param db Base de datos que se utiliza
	 */
	public static void mostrarDifuntos(String db) {
		DifuntoControler difc = new DifuntoControler(db);
		ArrayList<Difunto> adif = (ArrayList<Difunto>) difc.listarTodos();
		
		for (Difunto d : adif) {
			System.out.println(d.toString());
		}
		
	}
	public static void mostrarSepulturas(String db) {
		SepulturaControler sepc = new SepulturaControler(db);
		ArrayList<Sepultura> asep = (ArrayList<Sepultura>) sepc.listarTodos();
		
		for (Sepultura s : asep) {
			System.out.println(s.toString());
		}
		
	}
	public static void mostrarResponsable(String db) {
		ResponsableControler resc = new ResponsableControler(db);
		ArrayList<Responsable> ares = (ArrayList<Responsable>) resc.listarTodos();
		
		for (Responsable r : ares) {
			System.out.println(r.toString());
		}
		
	}
	
}
