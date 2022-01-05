package entidad;

public class Semestre {

	private int legajo;
	private String nombre;
	
	public Semestre()
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
		return "Semestre [legajo=" + legajo + ", nombre=" + nombre + "]";
	}
	
}
