package entidad;

public class Estado {

	private int legajo;
	private String nombre;
	
	public Estado()
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
		return "Estado [legajo=" + legajo + ", nombre=" + nombre + "]";
	}
	
}
