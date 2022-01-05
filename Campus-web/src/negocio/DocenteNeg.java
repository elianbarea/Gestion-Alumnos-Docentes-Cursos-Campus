package negocio;

import java.util.ArrayList;

import entidad.Docente;

public interface DocenteNeg {

	public int agregarDocente(Docente docente);
	public int ocultarDocente(int legajo);
	public int obtenerUltimoLegajoDoc();
	public Docente existeDocente(String mail, String contra);
	public int editar(Docente alumno);
	public Docente obtenerUno(int legajo);
	public ArrayList<Docente> obtenerDocentes();
	public boolean validarDni(String dni);
	
}
