package com.modelo;
import java.util.HashSet;
import java.util.Set;

/**
 * Responsable generated by hbm2java
 */
public class Responsable implements java.io.Serializable {

	private int idResponsable;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String cuentaDomiciliacion;
	private Set sepulturas = new HashSet(0);

	public Responsable() {
	}

	public Responsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}

	public Responsable(int idResponsable, String nombre, String apellido1, String apellido2, String cuentaDomiciliacion,
			Set sepulturas) {
		this.idResponsable = idResponsable;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.cuentaDomiciliacion = cuentaDomiciliacion;
		this.sepulturas = sepulturas;
	}

	public int getIdResponsable() {
		return this.idResponsable;
	}

	public void setIdResponsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCuentaDomiciliacion() {
		return this.cuentaDomiciliacion;
	}

	public void setCuentaDomiciliacion(String cuentaDomiciliacion) {
		this.cuentaDomiciliacion = cuentaDomiciliacion;
	}

	public Set getSepulturas() {
		return this.sepulturas;
	}

	public void setSepulturas(Set sepulturas) {
		this.sepulturas = sepulturas;
	}

}