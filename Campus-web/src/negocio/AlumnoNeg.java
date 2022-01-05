package negocio;

import java.util.ArrayList;

import entidad.Alumno;

public interface AlumnoNeg {

	public int agregarAlumno(Alumno alumno);
	public int ocultarAlumno(int legajo);
	public int obtenerUltimoLegajoAlu();
	public int editar(Alumno alumno);
	public Alumno obtenerUno(int legajo);
	public ArrayList<Alumno> obtenerAlumnos();
	public boolean validarDni(String dni);
	
}
