package negocio;

import java.util.ArrayList;

import entidad.Materia;

public interface MateriaNeg {

	public Materia obtenerUno(int legajo);
	public ArrayList<Materia> obtenerMaterias();
	
}
