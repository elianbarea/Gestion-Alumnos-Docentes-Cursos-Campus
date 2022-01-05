package negocioImpl;

import java.util.ArrayList;

import datos.AlumnoDao;
import datosImpl.AlumnoDaoImpl;
import entidad.Alumno;
import negocio.AlumnoNeg;

public class AlumnoNegImpl implements AlumnoNeg{

	public AlumnoDao aluDao = new AlumnoDaoImpl();

	@Override
	public int agregarAlumno(Alumno alumno) {
		
		return aluDao.agregarAlumno(alumno);
	}

	@Override
	public int ocultarAlumno(int legajo) {
		
		return aluDao.ocultarAlumno(legajo);
	}

	@Override
	public int obtenerUltimoLegajoAlu() {
		
		return aluDao.obtenerUltimoLegajoAlu();
	}
	
	@Override
	public int editar(Alumno alumno) {
		
		return aluDao.editar(alumno);
	}
	
	@Override
	public Alumno obtenerUno(int legajo)
	{
		return aluDao.obtenerUno(legajo);
	}

	@Override
	public ArrayList<Alumno> obtenerAlumnos() {
	
		return aluDao.obtenerAlumnos();
	}

	@Override
	public boolean validarDni(String dni)
	{
		return aluDao.validarDni(dni);
	}
}
