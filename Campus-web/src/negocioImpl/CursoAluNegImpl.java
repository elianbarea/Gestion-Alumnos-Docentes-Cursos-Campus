package negocioImpl;

import java.util.ArrayList;

import datos.CursoAluDao;
import datosImpl.CursoAluDaoImpl;
import entidad.CursoAlu;
import negocio.CursoAluNeg;

public class CursoAluNegImpl implements CursoAluNeg{

	private CursoAluDao curAluDao = new CursoAluDaoImpl();
	
	@Override
	public int agregarCursoAlu(CursoAlu alu) {
		
		return curAluDao.agregarCursoAlu(alu);
	}

	@Override
	public int subirNota(CursoAlu alu) {

		return curAluDao.subirNota(alu);
	}

	@Override
	public ArrayList<CursoAlu> obtenerCursoAlu(String curso) {

		return curAluDao.obtenerCursoAlu(curso);
	}

}
