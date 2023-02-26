package com.modelo;
// Generated 26 feb 2023 13:26:26 by Hibernate Tools 5.4.12.Final

import java.util.Date;

/**
 * Difunto generated by hbm2java
 */
public class Difunto implements java.io.Serializable {

	private Integer idDifunto;
	private Sepultura sepultura;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fechaNacimiento;
	private Date fechaDefuncion;
	private Date fechaEnterramiento;

	public Difunto() {
	}

	public Difunto(Sepultura sepultura, String nombre, String apellido1) {
		this.sepultura = sepultura;
		this.nombre = nombre;
		this.apellido1 = apellido1;
	}

	public Difunto(Sepultura sepultura, String nombre, String apellido1, String apellido2, Date fechaNacimiento,
			Date fechaDefuncion, Date fechaEnterramiento) {
		this.sepultura = sepultura;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaDefuncion = fechaDefuncion;
		this.fechaEnterramiento = fechaEnterramiento;
	}

	public Integer getIdDifunto() {
		return this.idDifunto;
	}

	public void setIdDifunto(Integer idDifunto) {
		this.idDifunto = idDifunto;
	}

	public Sepultura getSepultura() {
		return this.sepultura;
	}

	public void setSepultura(Sepultura sepultura) {
		this.sepultura = sepultura;
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

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaDefuncion() {
		return this.fechaDefuncion;
	}

	public void setFechaDefuncion(Date fechaDefuncion) {
		this.fechaDefuncion = fechaDefuncion;
	}

	public Date getFechaEnterramiento() {
		return this.fechaEnterramiento;
	}

	public void setFechaEnterramiento(Date fechaEnterramiento) {
		this.fechaEnterramiento = fechaEnterramiento;
	}

	@Override
	public String toString() {
		return "Difunto [" + (idDifunto != null ? "idDifunto=" + idDifunto + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (apellido1 != null ? "apellido1=" + apellido1 + ", " : "")
				+ (apellido2 != null ? "apellido2=" + apellido2 + ", " : "")
				+ (fechaNacimiento != null ? "fechaNacimiento=" + fechaNacimiento + ", " : "")
				+ (fechaDefuncion != null ? "fechaDefuncion=" + fechaDefuncion + ", " : "")
				+ (fechaEnterramiento != null ? "fechaEnterramiento=" + fechaEnterramiento : "") + "]";
	}

}
