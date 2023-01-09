package tablas;
// Generated 9 ene 2023 12:02:58 by Hibernate Tools 5.6.12.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Departamento generated by hbm2java
 */
public class Departamento implements java.io.Serializable {

	private byte idDep;
	private String nombre;
	private String localidad;
	private Set empleados = new HashSet(0);

	public Departamento() {
	}

	public Departamento(byte idDep) {
		this.idDep = idDep;
	}

	public Departamento(byte idDep, String nombre, String localidad, Set empleados) {
		this.idDep = idDep;
		this.nombre = nombre;
		this.localidad = localidad;
		this.empleados = empleados;
	}

	public byte getIdDep() {
		return this.idDep;
	}

	public void setIdDep(byte idDep) {
		this.idDep = idDep;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Set getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Set empleados) {
		this.empleados = empleados;
	}

}
