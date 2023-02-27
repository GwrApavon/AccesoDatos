package com.modelo;
// Generated 26 feb 2023 13:26:26 by Hibernate Tools 5.4.12.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Sepultura generated by hbm2java
 */
public class Sepultura implements java.io.Serializable {

	private Integer idSepultura;
	private Responsable responsable;
	private String codigoContable;
	private String calle;
	private int numSepultura;
	private String nombreTitular;
	private String apellido1Titular;
	private String apellido2Titular;
	private String tipoContrato;
	private String observaciones;
	private Set difuntos = new HashSet(0);

	public Sepultura() {
	}

	public Sepultura(Responsable responsable, String codigoContable, String calle, int numSepultura,
			String nombreTitular, String apellido1Titular, String tipoContrato) {
		this.responsable = responsable;
		this.codigoContable = codigoContable;
		this.calle = calle;
		this.numSepultura = numSepultura;
		this.nombreTitular = nombreTitular;
		this.apellido1Titular = apellido1Titular;
		this.tipoContrato = tipoContrato;
	}
	public Sepultura(int id, Responsable responsable, String codigoContable, String calle, int numSepultura,
			String nombreTitular, String apellido1Titular, String tipoContrato) {
		this.idSepultura = id;
		this.responsable = responsable;
		this.codigoContable = codigoContable;
		this.calle = calle;
		this.numSepultura = numSepultura;
		this.nombreTitular = nombreTitular;
		this.apellido1Titular = apellido1Titular;
		this.tipoContrato = tipoContrato;
	}

	public Sepultura(Responsable responsable, String codigoContable, String calle, int numSepultura,
			String nombreTitular, String apellido1Titular, String apellido2Titular, String tipoContrato,
			String observaciones, Set difuntos) {
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

	public Integer getIdSepultura() {
		return this.idSepultura;
	}

	public void setIdSepultura(Integer idSepultura) {
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

	public int getNumSepultura() {
		return this.numSepultura;
	}

	public void setNumSepultura(int numSepultura) {
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

	@Override
	public String toString() {
		return "Sepultura [" + (idSepultura != null ? "idSepultura=" + idSepultura + ", " : "")
				+ (codigoContable != null ? "codigoContable=" + codigoContable + ", " : "")
				+ (calle != null ? "calle=" + calle + ", " : "") + "numSepultura=" + numSepultura + ", "
				+ (nombreTitular != null ? "nombreTitular=" + nombreTitular + ", " : "")
				+ (apellido1Titular != null ? "apellido1Titular=" + apellido1Titular + ", " : "")
				+ (apellido2Titular != null ? "apellido2Titular=" + apellido2Titular + ", " : "")
				+ (tipoContrato != null ? "tipoContrato=" + tipoContrato + ", " : "")
				+ (observaciones != null ? "observaciones=" + observaciones : "") + "]";
	}

}
