package datos;

import java.util.ArrayList;

import entidad.Materia;

public interface MateriaDao {

	public Materia obtenerUno(int legajo);
	public ArrayList<Materia> obtenerMaterias();
	
}
