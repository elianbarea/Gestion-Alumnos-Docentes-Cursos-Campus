package datos;

import java.util.ArrayList;

import entidad.CursoAlu;

public interface CursoAluDao {

	public int agregarCursoAlu(CursoAlu alu);
	public int subirNota(CursoAlu alu);
	public ArrayList<CursoAlu> obtenerCursoAlu(String curso);
	
}
