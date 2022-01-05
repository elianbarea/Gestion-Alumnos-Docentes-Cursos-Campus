package negocio;

import java.util.ArrayList;

import entidad.Estado;

public interface EstadoNeg {

	public Estado obtenerUno(int legajo);
	public ArrayList<Estado> obtenerEstados();
	
}
