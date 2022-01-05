package datos;

import java.util.ArrayList;

import entidad.Docente;

public interface DocenteDao {

	public int agregarDocente(Docente docente);
	public int ocultarDocente(int legajo);
	public int obtenerUltimoLegajoDoc();
	public Docente existeDocente(String mail, String contra);
	public int editar(Docente docente);
	public Docente obtenerUno(int legajo);
	public ArrayList<Docente> obtenerDocentes();
	public boolean validarDni(String dni);
	
}
