package negocio;

import java.util.ArrayList;

import entidad.CursoAlu;

public interface CursoAluNeg {

	public int agregarCursoAlu(CursoAlu alu);
	public int subirNota(CursoAlu alu);
	public ArrayList<CursoAlu> obtenerCursoAlu(String curso);
	
}
