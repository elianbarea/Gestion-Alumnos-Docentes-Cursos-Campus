package entidad;

public class Docente {

	private int legajo;
	private String dni;
	private String nombre;
	private String apellido;
	private String nacimiento;
	private String direccion;
	private String localidad;
	private String nacionalidad;
	private String mail;
	private String telefono;
	
	private boolean estado = true;
	
    private String passDoc;
	
	public Docente()
	{
		
	}

	public String getPassDoc() {
		return passDoc;
	}

	public void setPassDoc(String passDoc) {
		this.passDoc = passDoc;
	}

	public String toStringPass() {
		return "Docente [passDoc=" + passDoc + "]";
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
    public String toString() {
        return "Docente [legajo=" + legajo + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
                + ", nacimiento=" + nacimiento + ", direccion=" + direccion + ", localidad=" + localidad + ", nacionalidad="
                + nacionalidad + ", mail=" + mail + ", telefono=" + telefono + ", passDoc=" + passDoc + ",estado=" + estado
                + "]";
    }	
}
