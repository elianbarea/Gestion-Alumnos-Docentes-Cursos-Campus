package negocioImpl;

import java.util.ArrayList;

import datos.MateriaDao;
import datosImpl.MateriaDaoImpl;
import entidad.Materia;
import negocio.MateriaNeg;

public class MateriaNegImpl implements MateriaNeg{

	private MateriaDao matDao = new MateriaDaoImpl();

	@Override
	public Materia obtenerUno(int legajo)
	{
		return matDao.obtenerUno(legajo);
	}
	
	@Override
	public ArrayList<Materia> obtenerMaterias() {
		
		return matDao.obtenerMaterias();
	}
	
	
}
