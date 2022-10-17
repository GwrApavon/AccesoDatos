package Ejercicio_18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import Ejercicio_18.Departamento;

public class GestorDepartamento {

	private int dimensionNombre = 60;
	private int dimensionLocalidad = 30;
	// nombre de una persona ocupa 10 characteres --> 10 *2 = 20 bytes para almacenar el nombre 
	// 4 bytes para almacenar el entero de edad
	// el email del due�o de la persona ocupa 50 caracteres --> 30*2 = 60 bytes para almacenar el email
	// en total 20 + 4 + 60 = 84
	public final static int TAMAGNOREGISTRO = 84;
	private RandomAccessFile fichero;
	private String nombreFich;
	
	public GestorDepartamento(String nombreFich) {
		this.nombreFich = nombreFich;
	}
	
	/**
	 * Abrir el fichero con los contactos para leer y escribir
	 * @throws FileNotFoundException
	 */
	public void abrir() throws FileNotFoundException {
		fichero = new RandomAccessFile(nombreFich, "rw");
	}
	
	/**
	 * Cerrar el fichero de las personas
	 * @throws IOException
	 */
	public void cerrar() throws IOException {
		if (fichero != null) {
			fichero.close();
		}
	}
	
	/**
	 * Escribir una persona en mi agenda en la posici�n indicada
	 * @param registro la persona que quiero escribir
	 * @param pos la posici�n donde quiero escribir
	 * @throws IOException
	 */
	public void escribir (Departamento registro, int pos) throws IOException {
		if (fichero != null) {
			// posiciono el puntero en el sitio que quiero ...
			fichero.seek(calculaposicion(pos));
			this.escribir(registro);
		}
	}
	
	/**
	 * Escribir una persona en la posici�n en la que actualmente est� el cursor 
	 * @param registro la persona que se quiere escribir en el fichero
	 * @throws IOException
	 */
	public void escribir (Departamento registro) throws IOException {
		if (fichero != null) {

			// nombre de una persona ocupa 10 characteres --> 10 *2 = 20 bytes para almacenar el nombre 
			// 4 bytes para almacenar el entero de edad
			// el email del due�o de la persona ocupa 50 caracteres --> 30*2 = 60 bytes para almacenar el email 
			
			// escribir la EDAD
			fichero.writeInt(registro.getNum());
			
			// PARA ESCRIBIR EL NOMBRE
			StringBuffer bufferN= new StringBuffer();
			if (registro.getNombre() != null) {
				bufferN.append(registro.getNombre());
			}
			bufferN.setLength(dimensionNombre);
			fichero.writeChars(bufferN.toString());
			
			// PARA ESCRIBIR EL EMAIL
			StringBuffer bufferE= new StringBuffer();
			if (registro.getLocalidad() != null) {
				bufferE.append(registro.getLocalidad());
			}
			bufferE.setLength(dimensionLocalidad);
			fichero.writeChars(bufferE.toString());
		}
		
	}
	/**
	 * Calcula la posici�n en la que tendr� que situarse el cursor
	 * dentro del fichero
	 * 
	 * @param pos -se considera que la primera posici�n es la 1 (no la 0)
	 * @return la posici�n
	 */
	private int calculaposicion(int pos) {
		return (pos-1)* TAMAGNOREGISTRO;
	}

}
