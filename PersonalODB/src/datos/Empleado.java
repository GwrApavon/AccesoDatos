package datos;

import java.util.Date;

public class Empleado {

	private int id_empleado;
	private String apellido;
	private String oficio;
	private Date fecha_alta;
	private float sueldo;
	private float comision;
	private Empleado jefe;
	private Departamento departamento;
	
	
	
	/**
	 * 
	 */
	public Empleado() {
		super();
	}
	/**
	 * @param id_empleado
	 * @param apellido
	 * @param oficio
	 * @param fecha_alta
	 * @param sueldo
	 * @param comision
	 * @param jefe
	 * @param departamento
	 */
	public Empleado(int id_empleado, String apellido, String oficio, Date fecha_alta, float sueldo, float comision,
			Empleado jefe, Departamento departamento) {
		super();
		this.id_empleado = id_empleado;
		this.apellido = apellido;
		this.oficio = oficio;
		this.fecha_alta = fecha_alta;
		this.sueldo = sueldo;
		this.comision = comision;
		this.jefe = jefe;
		this.departamento = departamento;
	}
	/**
	 * @return the id_empleado
	 */
	public int getId_empleado() {
		return id_empleado;
	}
	/**
	 * @param id_empleado the id_empleado to set
	 */
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the oficio
	 */
	public String getOficio() {
		return oficio;
	}
	/**
	 * @param oficio the oficio to set
	 */
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	/**
	 * @return the fecha_alta
	 */
	public Date getFecha_alta() {
		return fecha_alta;
	}
	/**
	 * @param fecha_alta the fecha_alta to set
	 */
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	/**
	 * @return the sueldo
	 */
	public float getSueldo() {
		return sueldo;
	}
	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	/**
	 * @return the comision
	 */
	public float getComision() {
		return comision;
	}
	/**
	 * @param comision the comision to set
	 */
	public void setComision(float comision) {
		this.comision = comision;
	}
	/**
	 * @return the jefe
	 */
	public Empleado getJefe() {
		return jefe;
	}
	/**
	 * @param jefe the jefe to set
	 */
	public void setJefe(Empleado jefe) {
		this.jefe = jefe;
	}
	/**
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}
	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	@Override
	public String toString() {
		return "Empleado [id_empleado=" + id_empleado + ", " + (apellido != null ? "apellido=" + apellido + ", " : "")
				+ (oficio != null ? "oficio=" + oficio + ", " : "")
				+ (fecha_alta != null ? "fecha_alta=" + fecha_alta + ", " : "") + "sueldo=" + sueldo + ", comision="
				+ comision + ", " + (jefe != null ? "jefe=" + jefe.getApellido() + ", " : "")
				+ (departamento != null ? "departamento=" + departamento.getNombre() : "") + "]";
	}
	
	
	
}
