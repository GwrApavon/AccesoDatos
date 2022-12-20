package tablas;
// Generated 14 dic 2022 12:08:18 by Hibernate Tools 5.6.12.Final

import java.util.Date;

/**
 * Empleado generated by hbm2java
 */
public class Empleado implements java.io.Serializable {


	private short idEmp;
	private Departamento departamento;
	private String apellido;
	private String oficio;
	private Date fechaAlta;
	private Float salario;
	private Float comision;

	public Empleado() {
	}

	public Empleado(short idEmp) {
		this.idEmp = idEmp;
	}

	public Empleado(short idEmp, Departamento departamento, String apellido, String oficio, Date fechaAlta,
			Float salario, Float comision) {
		this.idEmp = idEmp;
		this.departamento = departamento;
		this.apellido = apellido;
		this.oficio = oficio;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.comision = comision;
	}

	public short getIdEmp() {
		return this.idEmp;
	}

	public void setIdEmp(short idEmp) {
		this.idEmp = idEmp;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return this.oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Float getSalario() {
		return this.salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public Float getComision() {
		return this.comision;
	}

	public void setComision(Float comision) {
		this.comision = comision;
	}

	@Override
	public String toString() {
		return "Empleado [idEmp=" + idEmp + ", departamento=" + departamento.getNombre() + ", apellido=" + apellido + ", oficio="
				+ oficio + ", fechaAlta=" + fechaAlta + ", salario=" + salario + ", comision=" + comision + "]";
	}	

}
