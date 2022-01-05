package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import negocio.AlumnoNeg;
import negocioImpl.AlumnoNegImpl;

@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ServletAlumno() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int filas = 0;
		String Dni = "";
		
		if(request.getParameter("btn_aceptar")!=null){
			
			Alumno a = new Alumno();
			AlumnoNeg ad = new AlumnoNegImpl();
			
			a.setLegajo(ad.obtenerUltimoLegajoAlu());
			
			Dni = request.getParameter("txt_dniA");
			
			if(ad.validarDni(Dni) == false) {
			
			a.setDni(Dni);
			a.setNombre(request.getParameter("txt_nombreA"));
			a.setApellido(request.getParameter("txt_apellidoA"));
			a.setNacimiento(request.getParameter("date_fnacimientoA"));
			a.setDireccion(request.getParameter("txt_direccionA"));
			a.setProvincia(request.getParameter("txt_provinciaA"));
			a.setNacionalidad(request.getParameter("txt_nacionalidadA"));
			a.setMail(request.getParameter("emailA"));
			a.setTelefono(request.getParameter("telefonoA"));
			
			filas = ad.agregarAlumno(a);
			}else {
				filas = 0;
			}
		}
		
		request.setAttribute("cantFilas", filas);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Alumno.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btn_mostrartodos")!=null) {
			
			AlumnoNeg neg = new AlumnoNegImpl();
			ArrayList<Alumno> lista = neg.obtenerAlumnos();
			
			request.setAttribute("lista", lista);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Alumno.jsp");
			dispatcher.forward(request, response);
			
			}
		
		if(request.getParameter("btn_eliminar")!=null) {
			
			int legajo = Integer.parseInt(request.getParameter("legajoAlumno").toString());
			AlumnoNeg neg = new AlumnoNegImpl();
			
			neg.ocultarAlumno(legajo);
			
			ArrayList<Alumno> lista = neg.obtenerAlumnos();
			
			request.setAttribute("lista", lista);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Alumno.jsp");
			dispatcher.forward(request, response);
			}
		
		if(request.getParameter("btn_modificar")!=null) {
			
			int legajo = Integer.parseInt(request.getParameter("legajoAlumno").toString());
			String Dni = request.getParameter("dniAlumno");
			String Nombre = request.getParameter("nombreAlumno");
			String Apellido = request.getParameter("apellidoAlumno");
			String Nacimiento = request.getParameter("nacimientoAlumno");
			String Direccion = request.getParameter("direccionAlumno");
			String Provincia = request.getParameter("provinciaAlumno");
			String Nacionalidad = request.getParameter("nacionalidadAlumno");
			String Mail = request.getParameter("mailAlumno");
			String Telefono = request.getParameter("telefonoAlumno");
			
			request.setAttribute("legajo", legajo);
			request.setAttribute("dni", Dni);
			request.setAttribute("nombre", Nombre);
			request.setAttribute("apellido", Apellido);
			request.setAttribute("nacimiento", Nacimiento);
			request.setAttribute("direccion", Direccion);
			request.setAttribute("provincia", Provincia);
			request.setAttribute("nacionalidad", Nacionalidad);
			request.setAttribute("mail", Mail);
			request.setAttribute("telefono", Telefono);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarAlumno.jsp");
			dispatcher.forward(request, response);
		}
		
		//int filas = 0;
	    String Dni = "";
		if(request.getParameter("btn_guardar")!=null) {
			
			AlumnoNeg ad = new AlumnoNegImpl();
			
			int legajo = Integer.parseInt(request.getParameter("legajo"));
			
			Alumno alu = ad.obtenerUno(legajo);
			
			alu.setLegajo(legajo);
			
			//System.out.println(legajo);
			
			Dni = request.getParameter("txt_dniA");
			
			alu.setDni(Dni);
			alu.setNombre(request.getParameter("txt_nombreA"));
			alu.setApellido(request.getParameter("txt_apellidoA"));
			alu.setNacimiento(request.getParameter("date_fnacimientoA"));
			alu.setDireccion(request.getParameter("txt_direccionA"));
			alu.setProvincia(request.getParameter("txt_provinciaA"));
			alu.setNacionalidad(request.getParameter("txt_nacionalidadA"));
			alu.setMail(request.getParameter("emailA"));
			alu.setTelefono(request.getParameter("telefonoA"));
			
			ad.editar(alu);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Alumno.jsp");
			dispatcher.forward(request, response);
		}
	}
}