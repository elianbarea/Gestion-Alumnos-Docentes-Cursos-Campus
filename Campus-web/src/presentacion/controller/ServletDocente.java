package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Curso;
import entidad.CursoAlu;
import entidad.Docente;
import negocio.CursoAluNeg;
import negocio.CursoNeg;
import negocio.DocenteNeg;
import negocioImpl.DocenteNegImpl;
import negocioImpl.CursoAluNegImpl;
import negocioImpl.CursoNegImpl;

/**
 * Servlet implementation class ServletDocente
 */
@WebServlet("/ServletDocente")
public class ServletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletDocente() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( request.getParameter("Param") != null)
		{
			Docente d = (Docente) request.getSession().getAttribute("Usuario");
			CursoNeg cNeg = new CursoNegImpl();
			ArrayList<Curso> list = cNeg.obtenerCursos(d.getLegajo());
			
			request.setAttribute("CursosDocente", list);
			RequestDispatcher rd = request.getRequestDispatcher("/CursosDocente.jsp");
			
			rd.forward(request, response);	
		}
		
		
		if(request.getParameter("btn_curso") != null)
		{
			
			String curso = request.getParameter("btn_curso");
			System.out.println(curso);
			CursoAluNeg caNeg = new CursoAluNegImpl();
			ArrayList<CursoAlu> list = caNeg.obtenerCursoAlu(curso);
			System.out.println("1");
			request.setAttribute("ListAlumnos", list);
			System.out.println("2");
			
			RequestDispatcher rd = request.getRequestDispatcher("/Curso.jsp");
			System.out.println("3");
			rd.forward(request, response);
		}
		
		int filas = 0;
		String Dni = "";
		if(request.getParameter("btn_aceptar2")!=null)
		{
			
			Docente d = new Docente();
			DocenteNeg ad = new DocenteNegImpl();
			
			d.setLegajo(ad.obtenerUltimoLegajoDoc());
			
			Dni = request.getParameter("txt_dniD");
			
			if(ad.validarDni(Dni) == false) {
			
			d.setDni(Dni);
			d.setNombre(request.getParameter("txt_nombreD"));
			d.setApellido(request.getParameter("txt_apellidoD"));
			d.setNacimiento(request.getParameter("date_fnacimientoD"));
			d.setDireccion(request.getParameter("txt_direccionD"));
			d.setLocalidad(request.getParameter("txt_localidadD"));
			d.setNacionalidad(request.getParameter("txt_nacionalidadD"));
			d.setMail(request.getParameter("emailD"));
			d.setTelefono(request.getParameter("telefonoD"));
			d.setPassDoc(request.getParameter("passD"));
			filas = ad.agregarDocente(d);
			}
			else 
			{
				filas = 0;
			}
		}
		request.setAttribute("cantFilas", filas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/Docente.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		if(request.getParameter("btn_mostrartodos")!=null) {
			
			DocenteNeg neg = new DocenteNegImpl();
			ArrayList<Docente> lista = neg.obtenerDocentes();
			
			request.setAttribute("lista", lista);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Docente.jsp");
			dispatcher.forward(request, response);
			
			}
		
		if(request.getParameter("btn_eliminar2")!=null) {
			
			int legajo = Integer.parseInt(request.getParameter("legajoDocente").toString());
			DocenteNeg neg = new DocenteNegImpl();
			
			neg.ocultarDocente(legajo);
			
			ArrayList<Docente> lista = neg.obtenerDocentes();
			
			request.setAttribute("lista", lista);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Docente.jsp");
			dispatcher.forward(request, response);
			}
		
		if(request.getParameter("btn_modificar2")!=null) {
			
			int legajo = Integer.parseInt(request.getParameter("legajoDocente").toString());
			String Dni = request.getParameter("dniDocente");
			String Nombre = request.getParameter("nombreDocente");
			String Apellido = request.getParameter("apellidoDocente");
			String Nacimiento = request.getParameter("nacimientoDocente");
			String Direccion = request.getParameter("direccionDocente");
			String Localidad = request.getParameter("localidadDocente");
			String Nacionalidad = request.getParameter("nacionalidadDocente");
			String Mail = request.getParameter("mailDocente");
			String Telefono = request.getParameter("telefonoDocente");
			String Pass = request.getParameter("passDocente");
			
			request.setAttribute("legajo", legajo);
			request.setAttribute("dni", Dni);
			request.setAttribute("nombre", Nombre);
			request.setAttribute("apellido", Apellido);
			request.setAttribute("nacimiento", Nacimiento);
			request.setAttribute("direccion", Direccion);
			request.setAttribute("localidad", Localidad);
			request.setAttribute("nacionalidad", Nacionalidad);
			request.setAttribute("mail", Mail);
			request.setAttribute("telefono", Telefono);
			request.setAttribute("passD", Pass);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarDocente.jsp");
			dispatcher.forward(request, response);
		}
		
		//int filas = 0;
	    String Dni = "";
		if(request.getParameter("btn_guardar2")!=null) {
			
			DocenteNeg ad = new DocenteNegImpl();
			
			int legajo = Integer.parseInt(request.getParameter("legajo"));
			
			Docente doc = ad.obtenerUno(legajo);
			
			doc.setLegajo(legajo);
			
			Dni = request.getParameter("txt_dniD");
			
			doc.setDni(Dni);
			doc.setNombre(request.getParameter("txt_nombreD"));
			doc.setApellido(request.getParameter("txt_apellidoD"));
			doc.setNacimiento(request.getParameter("date_fnacimientoD"));
			doc.setDireccion(request.getParameter("txt_direccionD"));
			doc.setLocalidad(request.getParameter("txt_localidadD"));
			doc.setNacionalidad(request.getParameter("txt_nacionalidadD"));
			doc.setMail(request.getParameter("emailD"));
			doc.setTelefono(request.getParameter("telefonoD"));
			doc.setPassDoc(request.getParameter("contraseñaD"));
			
			ad.editar(doc);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Docente.jsp");
			dispatcher.forward(request, response);
		}
	}
}
