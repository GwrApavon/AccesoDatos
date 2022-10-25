package EjerciciosEmpleados;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


/**
 * Clase que gestiona un conjunto de empleados en un fichero
 * de acceso aleatorio o directo
 * @author Eva Royo
 *
 */
/**
 * @author alu
 *
 */
public class GestorEmpleados {

	private static int TAMAGNONOMBRE = 32;
	private static int TAMAGNOAPELLIDOS = 64;
	private static int TAMAGNODNI = 10;
	private static int TAMAGNOREGISTO = TAMAGNODNI*2 + TAMAGNONOMBRE*2 + TAMAGNOAPELLIDOS*2 + (4*4);
	
	private String nombreFichero = "empleados.dat";
	private RandomAccessFile fichero ;
	ArrayList <Empleado> emp= new ArrayList <Empleado>();
	
	/* ***** CONSTRUCTORES *****/
	/**
	 * Constructor
	 * @param nombreFichero	Nombre del fichero que contendra los departamentos
	 */
	public GestorEmpleados(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	/* *************************/
	

	/**
	 * Devuelve el nombre del fichero con el que estamos a trabajando
	 * @return the nombreFichero
	 */
	public String getNombreFichero() {
		return nombreFichero;
	}


	/**
	 * Cambia el nombre del fichero con el que estamos trabajando, asi que
	 * TIENE QUE CERRAR EL FICHERO QUE TEN�A ACTIVO ANTERIORMENTE
	 * @param nombreFichero the nombreFichero to set
	 */
	public void setNombreFichero(String nombreFichero) {
		if (fichero != null)
			try {
				fichero.close();
			} catch (IOException e) {
				System.err.println("Error cuando cierro el fichero anterior, al cambiar de fichero");
				e.printStackTrace();
			}
		this.nombreFichero = nombreFichero;
	}


	/**
	 * A�ade un departamente en la posici�n indicada
	 * @param emp	El empleado que va a incluir en la posicion pos
	 * @param pos	La posicion dentro del fichero
	 * @throws IOException	Excepcion producida al intentar escribir en el fichero
	 */
	public void escribir(Empleado emp, int pos) throws IOException {
		
		// comprobaciones de error
		if (fichero != null) {
			// posicionar el cursor en el lugar adecuado
			fichero.seek(calculaPosicion(pos));
			
			// PARA ESCRIBIR UNA CADENA
			// primero escribo las cosas en un buffer
			StringBuffer bufferDni= new StringBuffer();
			if (emp.getDni() != null ) {
				bufferDni.append(emp.getDni());
			}
			bufferDni.setLength(TAMAGNODNI); // fijo un tamaño al buffer, para que todos los nombres tengan el mismo tamaño

			StringBuffer bufferNombre= new StringBuffer();
			if (emp.getNombre() != null ) {
				bufferNombre.append(emp.getNombre());
			}
			bufferNombre.setLength(TAMAGNONOMBRE); // fijo un tamaño al buffer, para que todos los nombres tengan el mismo tamaño
			
			StringBuffer bufferApellidos= new StringBuffer();
			if (emp.getApellidos() != null ) {
				bufferApellidos.append(emp.getApellidos());
			}
			bufferApellidos.setLength(TAMAGNOAPELLIDOS);

			// escribir el dni
			fichero.writeChars(bufferDni.toString());
			// escribir el nombre
			fichero.writeChars(bufferNombre.toString());
			// escribir el apellidos
			fichero.writeChars(bufferApellidos.toString());
			// escribir el sueldo
			fichero.writeDouble(emp.getSueldo());
			// escribir el sueldo base
			fichero.writeDouble(emp.getS_base());
			// escribir los complementos
			fichero.writeDouble(emp.getComplementos());
			// escribir el irpf
			fichero.writeDouble(emp.getIrpf());
		}

		
	}

	/**
	 * Lee el empelado que esta en la posicion indicada
	 * @param pos Posicion en la que se encuentra el empleado que quiere leerse
	 * @return	El empleado leido o @NULL si el fichero no esta abierto
	 * @throws IOException	Si se podruce algun error de entrada/salida al leer
	 */
	public Empleado leer(int pos) throws IOException {
			
		Empleado emp = null;
		
		if (fichero != null) {
			emp = new Empleado();
			
			// situar el cursor donde quiero leer
			fichero.seek(calculaPosicion(pos));
			
			try {
				// ya se que el departamento tiene 3 campos y SU ORDEN
				
				// leer el identificador caracter a caracter (dni)
				char campoDni[] = new char[TAMAGNODNI];
				for (int i = 0; i < TAMAGNODNI; i++) {
					campoDni[i] = fichero.readChar();
				}
						
				// leo caracter a caracter el nombre
				char campoNombre[] = new char[TAMAGNONOMBRE];
				for (int i = 0; i < TAMAGNONOMBRE; i++) {
					campoNombre[i] = fichero.readChar();
				}			
				
				// leo caracter a caracter la localidad
				char campoApellidos[] = new char[TAMAGNOAPELLIDOS];
				for (int i = 0; i < TAMAGNOAPELLIDOS; i++) {
					campoApellidos[i] = fichero.readChar();
				}			
				
				double sueldo = fichero.readDouble();
				double s_base = fichero.readDouble();
				double complementos = fichero.readDouble();
				double irpf = fichero.readDouble();
				
				emp.setDni(new String(campoDni));		
				emp.setNombre(new String(campoNombre));
				emp.setApellidos(new String(campoApellidos));
				emp.setSueldo(sueldo);
				emp.setS_base(s_base);
				emp.setComplementos(complementos);
				emp.setIrpf(irpf);
				
			} catch (EOFException e) {
				// entrar� aqu� cuando haya llegado al final del fichero
				emp = null;
			}
		}
				
		return emp;
	}

	/**
	 * Abrir el fichero con los contactos para leer y escribir
	 * @throws FileNotFoundException	Lanza la excepcion al intentar abrir en lectura/escritura
	 */
	public void abrir() throws FileNotFoundException {
		fichero = new RandomAccessFile(nombreFichero, "rw");
	}
	
	/**
	 * Cerrar el fichero de los contactos
	 * @throws IOException	Lanza excepcion al intentar cerrar el fichero
	 */
	public void cerrar() throws IOException {
		if (fichero != null) {
			fichero.close();
		}
	}
	
	/**
	 * Calcula el byte en el que tiene que situarse segun la posicion deseada
	 * @param pos Posicion dentro del fichero
	 * @return El byte en el que ha de situarse el fichero
	 */
	public int calculaPosicion(int pos) {
		return (pos-1)*TAMAGNOREGISTO;
	}
	
	/**
	 * Edita un departamento con los datos introducidos 
	 * @param pos
	 * @param nuevoNombre
	 * @param nuevosApellidos
	 */
	public void editarDepartamento(int pos,String nuevoDNI, String nuevoNombre, String nuevosApellidos, double nuevoSueldo,
								   double nuevoS_base ,double nuevoComplementos , double nuevoIRPF) 
	{
		Empleado emp = new Empleado();
		
		try {
			emp = leer(pos);
			
			emp.setDni(nuevoDNI);
			emp.setNombre(nuevoNombre);
			emp.setApellidos(nuevosApellidos);
			emp.setSueldo(nuevoSueldo);
			emp.setS_base(nuevoS_base);
			emp.setComplementos(nuevoComplementos);
			emp.setIrpf(nuevoIRPF);
			escribir(emp, pos);
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			System.err.println("Introduce un empleado existente");
			ioe.printStackTrace();
		}
	}
	
	
	/**
	 * Lee todo el fichero 
	 * @return
	 */
	public ArrayList<Empleado> leerTodo(){
			
		Empleado e = new Empleado();
			
			if (fichero != null) {
				try {
					fichero.seek(0);
					int pos = 1;
					while(fichero.getFilePointer()< fichero.length()) {
						e = leer(pos);
						emp.add(e);
						pos++;
					}
				} catch (Exception ex) {
					// entrara aqui cuando haya llegado al final del fichero
					e = null;
				}
			}
			return emp;
		}

}
