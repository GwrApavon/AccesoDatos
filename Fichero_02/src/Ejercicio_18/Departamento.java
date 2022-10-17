package Ejercicio_18;

public class Departamento {

	private String nombre;
	private int num;
	private String localidad;
	
	public Departamento() {
		// no hace nada
	}

	
	/**
	 * @param nombre
	 * @param num
	 * @param localidad
	 */
	public Departamento( int num, String nombre, String localidad) {
		super();
		this.nombre = nombre;
		this.num = num;
		this.localidad = localidad;
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "Departamento [num=" + num + ", nombre=" + nombre + ", localidad=" + localidad + "]";
	}
	
}
