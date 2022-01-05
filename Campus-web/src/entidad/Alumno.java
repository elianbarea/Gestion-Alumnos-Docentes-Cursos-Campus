package entidad;

public class Alumno {

	private int legajo;
	private String nombre;
	private String apellido;
	private String dni;
	private String nacimiento;
	private String mail;
	private String telefono;
	private String provincia;
	private String direccion;
	private String nacionalidad;
	private boolean estado = true;
	
	public Alumno()
	{
		
	}
	
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Persona [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", nacimiento=" + nacimiento + ", mail=" + mail + ", telefono=" + telefono + ", provincia="
				+ provincia + ", direccion=" + direccion + ", nacionalidad=" + nacionalidad + ", estado=" + estado
				+ "]";
	}
	
}
