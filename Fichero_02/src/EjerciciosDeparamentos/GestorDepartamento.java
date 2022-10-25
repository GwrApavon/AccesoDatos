package EjerciciosDeparamentos;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


/**
 * Clase que gestiona un conjunto de departamentos en un fichero
 * de acceso aleatorio o directo
 * @author Eva Royo
 *
 */
/**
 * @author alu
 *
 */
public class GestorDepartamento {

	private static int TAMAGNONOMBRE = 32; // son los car�cteres 32*2 = 64 bytes
	private static int TAMAGNOLOCALIDAD = 20; // son los car�cteres 20*2 = 40 bytes
	// para almacenar el n�mero de departamento usamos un entero = 4 bytes
	private static int TAMAGNOREGISTO = TAMAGNONOMBRE*2 + TAMAGNOLOCALIDAD*2 + 4; // son los bytes 64 + 40 + 4(int)
	
	private String nombreFichero = "departamentos.dat";
	private RandomAccessFile fichero ;
	ArrayList <Departamento> dep= new ArrayList <Departamento>();
	/* ***** CONSTRUCTORES *****/
	/**
	 * Constructor
	 * @param nombreFichero	Nombre del fichero que contendra los departamentos
	 */
	public GestorDepartamento(String nombreFichero) {
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
	 * @param dep	El departamento que va a incluir en la posicion pos
	 * @param pos	La posicion dentro del fichero
	 * @throws IOException	Excepcion producida al intentar escribir en el fichero
	 */
	public void escribir(Departamento dep, int pos) throws IOException {
		
		// comprobaciones de error
		if (fichero != null) {
			// posicionar el cursor en el lugar adecuado
			fichero.seek(calculaPosicion(pos));
			
			// PARA ESCRIBIR UNA CADENA
			// primero escribo las cosas en un buffer
			StringBuffer bufferNombre= new StringBuffer();
			if (dep.getNombre() != null ) {
				bufferNombre.append(dep.getNombre());
			}
			bufferNombre.setLength(TAMAGNONOMBRE); // fijo un tamaño al buffer, para que todos los nombres tengan el mismo tamaño
			
			StringBuffer bufferLocalidad= new StringBuffer();
			if (dep.getLocalidad() != null ) {
				bufferLocalidad.append(dep.getLocalidad());
			}
			bufferLocalidad.setLength(TAMAGNOLOCALIDAD);

			// escribir el identificador
			fichero.writeInt(dep.getNum());
			// escribir el nombre
			fichero.writeChars(bufferNombre.toString());
			// escribir el localidad
			fichero.writeChars(bufferLocalidad.toString());
		}

		
	}

	/**
	 * Lee el departamento que esta en la posicion indicada
	 * @param pos Posicion en la que se encuentra el departamento que quiere leerse
	 * @return	El departamento leido o @NULL si el fichero no esta abierto
	 * @throws IOException	Si se podruce algun error de entrada/salida al leer
	 */
	public Departamento leer(int pos) throws IOException {
			
		Departamento dep = null;
		
		if (fichero != null) {
			dep = new Departamento();
			
			// situar el cursor donde quiero leer
			fichero.seek(calculaPosicion(pos));
			
			try {
				// ya se que el departamento tiene 3 campos y SU ORDEN
				
				// leer el identificador (numDepartamento)
				int numDepartamento = fichero.readInt();
						
				// leo caracter a caracter el nombre
				char campoNombre[] = new char[TAMAGNONOMBRE];
				for (int i = 0; i < TAMAGNONOMBRE; i++) {
					campoNombre[i] = fichero.readChar();
				}			
				
				// leo caracter a caracter la localidad
				char campoLocalidad[] = new char[TAMAGNOLOCALIDAD];
				for (int i = 0; i < TAMAGNOLOCALIDAD; i++) {
					campoLocalidad[i] = fichero.readChar();
				}			
				
				dep.setNum(numDepartamento);		
				dep.setNombre(new String(campoNombre));
				dep.setLocalidad(new String(campoLocalidad));				
				
			} catch (EOFException e) {
				// entrar� aqu� cuando haya llegado al final del fichero
				dep = null;
			}
		}
				
		return dep;
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
	 * @param numDep
	 * @param nuevoNombre
	 * @param nuevaLoc
	 */
	public void editarDepartamento(int numDep, String nuevoNombre, String nuevaLoc) {
		Departamento dep = new Departamento();
		
		try {
			dep = leer(numDep);	
			dep.setNombre(nuevoNombre);
			dep.setLocalidad(nuevaLoc);
			escribir(dep, numDep);
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			System.err.println("Introduce un número de departamento existente");
			ioe.printStackTrace();
		}
	}
	
	
	/**
	 * Lee todo el fichero 
	 * @return
	 */
	public ArrayList<Departamento> leerTodo(){
			
			Departamento d = new Departamento();
			
			if (fichero != null) {
				try {
					fichero.seek(0);
					int pos = 1;
					while(fichero.getFilePointer()< fichero.length()) {
						d = leer(pos);
						dep.add(d);
						pos++;
					}
				} catch (Exception e) {
					// entrara aqui cuando haya llegado al final del fichero
					d = null;
				}
			}
			return dep;
		}

}
