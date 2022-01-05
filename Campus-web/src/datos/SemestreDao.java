package datos;

import java.util.ArrayList;

import entidad.Semestre;

public interface SemestreDao {

	public Semestre obtenerUno(int legajo);
	public ArrayList<Semestre> obtenerSemestres();
	
}
