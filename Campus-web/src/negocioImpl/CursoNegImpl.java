package negocioImpl;

import java.util.ArrayList;

import datos.CursoDao;
import datosImpl.CursoDaoImpl;
import entidad.Curso;
import entidad.Materia;
import negocio.CursoNeg;

public class CursoNegImpl implements CursoNeg{

	private CursoDao curDao = new CursoDaoImpl();
	
	@Override
	public int agregarCurso(Curso curso) {
		

		return curDao.agregarCurso(curso);
	}

	@Override
	public int obtenerUltimoLegajoCur() {
	
		return curDao.obtenerUltimoLegajoCur();
	}

	@Override
	public ArrayList<Curso> obtenerCursos(int docente) {
		
		return curDao.obtenerCursos(docente);
	}

	@Override
	public Materia obtenerMat(String curso) {
		return curDao.obtenerMat(curso);
	}
	
}
