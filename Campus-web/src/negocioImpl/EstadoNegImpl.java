package negocioImpl;

import java.util.ArrayList;

import datos.EstadoDao;
import datosImpl.EstadoDaoImpl;
import entidad.Estado;
import negocio.EstadoNeg;

public class EstadoNegImpl implements EstadoNeg{

	private EstadoDao estDao = new EstadoDaoImpl();
	
	@Override
	public Estado obtenerUno(int legajo)
	{
		return estDao.obtenerUno(legajo);
	}
	
	@Override
	public ArrayList<Estado> obtenerEstados() {

		return estDao.obtenerEstados();
	}

}
