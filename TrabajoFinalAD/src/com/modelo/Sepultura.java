package com.modelo;
import java.util.HashSet;
import java.util.Set;

/**
 * Sepultura generated by hbm2java
 */
public class Sepultura implements java.io.Serializable {

	private int idSepultura;
	private Responsable responsable;
	private String codigoContable;
	private String calle;
	private Short numSepultura;
	private String nombreTitular;
	private String apellido1Titular;
	private String apellido2Titular;
	private String tipoContrato;
	private String observaciones;
	private Set difuntos = new HashSet(0);

	public Sepultura() {
	}

	public Sepultura(int idSepultura) {
		this.idSepultura = idSepultura;
	}

	public Sepultura(int idSepultura, Responsable responsable, String codigoContable, String calle, Short numSepultura,
			String nombreTitular, String apellido1Titular, String apellido2Titular, String tipoContrato,
			String observaciones, Set difuntos) {
		this.idSepultura = idSepultura;
		this.responsable = responsable;
		this.codigoContable = codigoContable;
		this.calle = calle;
		this.numSepultura = numSepultura;
		this.nombreTitular = nombreTitular;
		this.apellido1Titular = apellido1Titular;
		this.apellido2Titular = apellido2Titular;
		this.tipoContrato = tipoContrato;
		this.observaciones = observaciones;
		this.difuntos = difuntos;
	}

	public int getIdSepultura() {
		return this.idSepultura;
	}

	public void setIdSepultura(int idSepultura) {
		this.idSepultura = idSepultura;
	}

	public Responsable getResponsable() {
		return this.responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public String getCodigoContable() {
		return this.codigoContable;
	}

	public void setCodigoContable(String codigoContable) {
		this.codigoContable = codigoContable;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Short getNumSepultura() {
		return this.numSepultura;
	}

	public void setNumSepultura(Short numSepultura) {
		this.numSepultura = numSepultura;
	}

	public String getNombreTitular() {
		return this.nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getApellido1Titular() {
		return this.apellido1Titular;
	}

	public void setApellido1Titular(String apellido1Titular) {
		this.apellido1Titular = apellido1Titular;
	}

	public String getApellido2Titular() {
		return this.apellido2Titular;
	}

	public void setApellido2Titular(String apellido2Titular) {
		this.apellido2Titular = apellido2Titular;
	}

	public String getTipoContrato() {
		return this.tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set getDifuntos() {
		return this.difuntos;
	}

	public void setDifuntos(Set difuntos) {
		this.difuntos = difuntos;
	}

}