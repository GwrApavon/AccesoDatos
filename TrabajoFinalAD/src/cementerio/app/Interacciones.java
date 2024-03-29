/**
 *  Interacciones que puede tener con la base de datos
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
 * @author Angel Pavon Fraile
 *
 */
public class Interacciones {
	
	//Scanner
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Pedir datos del difunto
	 * Pide los datos del difunto para insertarlo en la base de datos
	 * 
	 * @param sc Scanner Input
	 * @return dif Difunto creado
	 */
	public static Difunto pedirDatosDifunto(String db) {
		Difunto dif = new Difunto();
		
		String nombre = Utilities.pedirNombre(sc);
		dif.setNombre(nombre);
		String apellido1 = Utilities.pedirApellido1(sc);
		dif.setApellido1(apellido1);
		String apellido2 = Utilities.pedirApellido2(sc);
		dif.setApellido2(apellido2);
		
		System.out.println("El formato de las siguientes fechas debe ser YY/MM/DD");
		Date bDate = Utilities.pedirBDate(sc);
		dif.setFechaNacimiento(bDate);
		Date fechaDef = Utilities.pedirFechaDef(sc);
		dif.setFechaDefuncion(fechaDef);
		Date fechaEntr = Utilities.pedirFechaEntr(sc);
		dif.setFechaEnterramiento(fechaEntr);
		
		Sepultura sepultura = Utilities.pedirSepultura(sc,db);
		dif.setSepultura(sepultura);
		
		return dif;	
	}
	
	/**
	 * Pedir datos del responsable
	 * Pide los datos del responsable para insertarlo en la base de datos
	 * 
	 * @param sc Scanner Input
	 * @return res Responsable creado
	 */
	public static Responsable pedirDatosResponsable() {
		Responsable  res = new Responsable();
		
		String nombre = Utilities.pedirNombre(sc);
		res.setNombre(nombre);
		String apellido1 = Utilities.pedirApellido1(sc);
		res.setApellido1(apellido1);
		String apellido2 = Utilities.pedirApellido2(sc);
		res.setApellido2(apellido2);		
		String cuentaDomiciliacion = Utilities.pedirCuentaDomiciliacion(sc);
		res.setCuentaDomiciliacion(cuentaDomiciliacion);
		
		return res;	
	}
	
	/**
	 * Pedir datos de la sepultura
	 * Pide los datos de la sepultura para insertarlo en la base de datos
	 * @param db 
	 * 
	 * @param sc Scanner Input
	 * @return dif Sepultura creada
	 */
	public static Sepultura pedirDatosSepultura(String db) {
		Sepultura sep = new Sepultura();
		
		sep.setNombreTitular(Utilities.pedirNombre(sc));
		sep.setApellido1Titular(Utilities.pedirApellido1(sc));
		sep.setApellido1Titular(Utilities.pedirApellido2(sc));
		
		sep.setNumSepultura(Utilities.pedirNumSepultura(sc));
		sep.setCalle(Utilities.pedirCalle(sc));
		sep.setCodigoContable(Utilities.pedirCodContable(sc));
		sep.setTipoContrato(Utilities.pedirTipoContrato(sc));
		sep.setObservaciones(Utilities.pedirObservaciones(sc));
		
		sep.setResponsable(Utilities.pedirResponsable(sc,db));
		
		
		return sep;	
	}
	
	/**
	 * Metodo para modificar un difunto 
	 * Recibe un difunto y pregunta al usuario 1 por 1 el campo que quire cambiar
	 * @param db
	 * @return difunto modificado
	 */
	public static Difunto modificarDifunto(String db) {
		boolean salir = false;
		Difunto dif = mostrarDifuntos(db);
		
		do {
			Menu.eleccionModi(1);
			int op = 0;
			op = sc.nextInt();
			sc.nextLine();
			
			switch(op) {
				case 1: String nombre = Utilities.pedirNombre(sc);
						dif.setNombre(nombre);
					break;
				case 2: dif.setApellido1(Utilities.pedirApellido1(sc));
					break;
				case 3: dif.setApellido2(Utilities.pedirApellido2(sc));
					break;
				case 4: dif.setFechaNacimiento(Utilities.pedirBDate(sc));
					break;
				case 5: dif.setFechaDefuncion(Utilities.pedirFechaDef(sc));
					break;
				case 6: dif.setFechaEnterramiento(Utilities.pedirFechaEntr(sc));
					break;
				case 7: dif.setSepultura(Utilities.pedirSepultura(sc,db));
					break;
				default: System.out.println("Saliendo...");
						 salir = true;
			}
		}while(!salir);
		return dif;	
	}
	
	/**
	 * Metodo para modificar un responsable 
	 * Recibe un responsable y pregunta al usuario 1 por 1 el campo que quire cambiar
	 * @param db
	 * @return responsable modificado
	 */
	public static Responsable modificarResponsable(String db) {
		boolean salir = false;
		Responsable res = mostrarResponsable(db);
		
		do {
			Menu.eleccionModi(2);
			int op = 0;
			op = sc.nextInt();
			sc.nextLine();
			
			switch(op) {
				case 1: res.setNombre(Utilities.pedirNombre(sc));
					break;
				case 2: res.setApellido1(Utilities.pedirApellido1(sc));
					break;
				case 3: res.setApellido2(Utilities.pedirApellido2(sc));
					break;
				case 4: res.setCuentaDomiciliacion(Utilities.pedirCuentaDomiciliacion(sc));
					break;
				//TODO
				case 5: res.setSepulturas(null);;
					break;
				default: System.out.println("Saliendo...");
						 salir = true;
			}
		}while(!salir);
		return res;	
	}
	
	/**
	 * Metodo para modificar una sepultura 
	 * Recibe una sepultura y pregunta al usuario 1 por 1 el campo que quire cambiar
	 * @param db
	 * @return sepultura modificado
	 */
	public static Sepultura modificarSepultura(String db) {
		boolean salir = false;
		Sepultura sep = mostrarSepulturas(db);
		
		do {
			Menu.eleccionModi(3);
			int op = 0;
			op = sc.nextInt();
			sc.nextLine();
			
			switch(op) {
				case 1: sep.setNumSepultura(Utilities.pedirNumSepultura(sc));
					break;
				case 2: sep.setCalle(Utilities.pedirCalle(sc));
					break;
				case 3: sep.setNombreTitular(Utilities.pedirNombre(sc));
					break;
				case 4: sep.setApellido1Titular(Utilities.pedirApellido1(sc));
					break;
				case 5: sep.setApellido2Titular(Utilities.pedirApellido1(sc));
					break;
				case 6: sep.setCodigoContable(Utilities.pedirCodContable(sc));
					break;
				case 7: sep.setTipoContrato(Utilities.pedirTipoContrato(sc));
					break;
				case 8: sep.setObservaciones(Utilities.pedirObservaciones(sc));
					break;
				case 9:
						sep.setDifuntos(null);
					break;
				default: System.out.println("Saliendo...");
						 salir = true;
			}
		}while(!salir);
		return sep;	
	}
	
	/**
	 * Mostrar todos los valores de cada tabla
	 * Pregunta el valor que quieres leer de la tabla y devuelve el objeto
	 * @param db Base de datos que se utiliza
	 * @return objeto del tipo que se utilice (Difunto, Responsable, Sepultura)
	 */
	//Difunto
	public static Difunto mostrarDifuntos(String db) {
		DifuntoControler difc = new DifuntoControler(db);
		ArrayList<Difunto> adif = (ArrayList<Difunto>) difc.listarTodos();
		for (Difunto d : adif) {
			System.out.println(d.toString());
		}
		
		System.out.println("Que difunto quieres modificar(id): ");
		int election = Utilities.sacarIntValido(sc);
		
		Difunto dif = difc.devolverUno(election);
		
		return dif;
	}
	//Sepultura
	public static Sepultura mostrarSepulturas(String db) {
		SepulturaControler sepc = new SepulturaControler(db);
		ArrayList<Sepultura> asep = (ArrayList<Sepultura>) sepc.listarTodos();
		
		for (Sepultura s : asep) {
			System.out.println(s.toString());
		}
		System.out.println("Que sepultura quieres modificar(id): ");
		int election = Utilities.sacarIntValido(sc);
		
		Sepultura sep = sepc.devolverUno(election);
		
		return sep;
		
	}
	//Responsable
	public static Responsable mostrarResponsable(String db) {
		ResponsableControler resc = new ResponsableControler(db);
		ArrayList<Responsable> ares = (ArrayList<Responsable>) resc.listarTodos();
		
		for (Responsable r : ares) {
			System.out.println(r.toString());
		}
		
		System.out.println("Que responsable quieres modificar(id): ");
		int election = Utilities.sacarIntValido(sc);
		
		Responsable res = resc.devolverUno(election);
		
		return res;
	}

	/**
	 * Prepara las consultas 
	 * @param i --> Consulta 1 o 2
	 * @param db
	 */
	public static void prepararConsulta(int i, String db) {
		if(i == 1) {
			DifuntoControler difc = new DifuntoControler(db);			
			difc.query();
		}
		else {
			SepulturaControler sepc = new SepulturaControler(db);			
			sepc.query();
		}
	}
	
}
