package negocio;

import java.util.ArrayList;

import entidad.Curso;
import entidad.Materia;

public interface CursoNeg {

	public int agregarCurso(Curso curso);
	public int obtenerUltimoLegajoCur();
	public ArrayList<Curso> obtenerCursos(int docente);
	public Materia obtenerMat(String curso);
	
}
