package negocioImpl;

import java.util.ArrayList;

import datos.DocenteDao;
import datosImpl.DocenteDaoImpl;
import entidad.Docente;
import negocio.DocenteNeg;

public class DocenteNegImpl implements DocenteNeg{

	private DocenteDao docDao = new DocenteDaoImpl();

	@Override
	public int agregarDocente(Docente docente) {
		
		return docDao.agregarDocente(docente);
	}

	@Override
	public int ocultarDocente(int legajo) {
		
		return docDao.ocultarDocente(legajo);
	}

	@Override
	public int obtenerUltimoLegajoDoc() {
		
		return docDao.obtenerUltimoLegajoDoc();
	}
	@Override
	public int editar(Docente docente) {
		
		return docDao.editar(docente);
	}
	
	@Override
	public Docente obtenerUno(int legajo)
	{
		return docDao.obtenerUno(legajo);
	}
	
	@Override
	public ArrayList<Docente> obtenerDocentes() {
		
		return docDao.obtenerDocentes();
	}

	@Override
	public Docente existeDocente(String mail, String contra) {
		
		return docDao.existeDocente(mail, contra);
	}
	@Override
	public boolean validarDni(String dni)
	{
		return docDao.validarDni(dni);
	}
	
	
}
