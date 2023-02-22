package com.modelo;
import java.util.Date;

/**
 * Difunto generated by hbm2java
 */
public class Difunto implements java.io.Serializable {

	private int idDifunto;
	private Sepultura sepultura;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fechaNacimiento;
	private Date fechaDefuncion;
	private Date fechaEnterramiento;

	public Difunto() {
	}
	
	public Difunto(String nombre, String apellido1, Sepultura sepultura) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.sepultura = sepultura;
	}
	public Difunto(Sepultura sepultura, String nombre, String apellido1, String apellido2,
			Date fechaNacimiento, Date fechaDefuncion, Date fechaEnterramiento) {
		this.sepultura = sepultura;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaDefuncion = fechaDefuncion;
		this.fechaEnterramiento = fechaEnterramiento;
	}
	
	public Difunto(int id, Sepultura sepultura, String nombre, String apellido1, String apellido2,
			Date fechaNacimiento, Date fechaDefuncion, Date fechaEnterramiento) {
		this.idDifunto = id;
		this.sepultura = sepultura;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaDefuncion = fechaDefuncion;
		this.fechaEnterramiento = fechaEnterramiento;
	}
	public int getIdDifunto() {
		return this.idDifunto;
	}

	public void setIdDifunto(int idDifunto) {
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
		return "Difunto [idDifunto=" + idDifunto + ", " + (sepultura != null ? "sepultura=" + sepultura.getIdSepultura() + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (apellido1 != null ? "apellido1=" + apellido1 + ", " : "")
				+ (apellido2 != null ? "apellido2=" + apellido2 + ", " : "")
				+ (fechaNacimiento != null ? "fechaNacimiento=" + fechaNacimiento.toString() + ", " : "")
				+ (fechaDefuncion != null ? "fechaDefuncion=" + fechaDefuncion.toString() + ", " : "")
				+ (fechaEnterramiento != null ? "fechaEnterramiento=" + fechaEnterramiento.toString() : "") + "]";
	}

}
