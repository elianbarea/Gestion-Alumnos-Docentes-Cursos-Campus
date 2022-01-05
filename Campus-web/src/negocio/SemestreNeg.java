package negocio;

import java.util.ArrayList;

import entidad.Semestre;

public interface SemestreNeg {

	public Semestre obtenerUno(int legajo);
	public ArrayList<Semestre> obtenerSemestres();
	
}
