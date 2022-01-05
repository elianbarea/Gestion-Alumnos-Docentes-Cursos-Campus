package datos;

import java.util.ArrayList;

import entidad.Estado;

public interface EstadoDao {

	public Estado obtenerUno(int legajo);
	public ArrayList<Estado> obtenerEstados();
	
}
