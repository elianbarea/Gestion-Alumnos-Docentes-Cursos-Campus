package negocioImpl;

import java.util.ArrayList;

import datos.SemestreDao;
import datosImpl.SemestreDaoImpl;
import entidad.Semestre;
import negocio.SemestreNeg;

public class SemestreNegImpl implements SemestreNeg{

	private SemestreDao semDao = new SemestreDaoImpl();
	
	@Override
	public Semestre obtenerUno(int legajo)
	{
		return semDao.obtenerUno(legajo);
	}
	
	@Override
	public ArrayList<Semestre> obtenerSemestres() {
		
		return semDao.obtenerSemestres();
	}

}
