package entidad;

public class Materia {

	private int legajo;
	private String nombre;
	
	public Materia()
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

	@Override
	public String toString() {
		return "Materia [legajo=" + legajo + ", nombre=" + nombre + "]";
	}
	
}
