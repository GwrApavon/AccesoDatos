package EjerciciosEmpleados;

public class Empleado {
	
	private String nombre;
	private String apellidos;
	private double sueldo;
	private double s_base;
	private double complementos;
	private double irpf;
	private String dni;
	
	public Empleado() {
		
	}
	
	/**
	 * @param nombre
	 * @param apellidos
	 * @param sueldo
	 * @param s_base
	 * @param complementos
	 * @param irpf
	 * @param dni
	 */
	public Empleado(String dni, String nombre, String apellidos,double s_base, double complementos, double irpf) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = s_base + complementos - (s_base*(irpf/100));
		this.s_base = s_base;
		this.complementos = complementos;
		this.irpf = irpf;
		this.dni = dni;
	}
	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the sueldo
	 */
	public double getSueldo() {
		return sueldo;
	}
	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	/**
	 * @return the s_base
	 */
	public double getS_base() {
		return s_base;
	}
	/**
	 * @param s_base the s_base to set
	 */
	public void setS_base(double s_base) {
		this.s_base = s_base;
	}
	/**
	 * @return the complementos
	 */
	public double getComplementos() {
		return complementos;
	}
	/**
	 * @param complementos the complementos to set
	 */
	public void setComplementos(double complementos) {
		this.complementos = complementos;
	}
	/**
	 * @return the irpf
	 */
	public double getIrpf() {
		return irpf;
	}
	/**
	 * @param irpf the irpf to set
	 */
	public void setIrpf(double irpf) {
		this.irpf = irpf;
	}

	@Override
	public String toString() {
		return "Empleado [dni= " + dni + "nombre=" + nombre + ", apellidos=" + apellidos + ", sueldo=" + sueldo + ", s_base=" + s_base
				+ ", complementos=" + complementos + ", irpf=" + irpf + "]";
	}
	
}
