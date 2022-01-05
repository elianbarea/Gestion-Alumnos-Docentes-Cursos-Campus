package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.CursoAlu;
import negocioImpl.CursoAluNegImpl;
import negocio.CursoAluNeg;


@WebServlet("/ServletAlumnoCurso")
public class ServletAlumnoCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletAlumnoCurso() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		
		int filas=0;
		if(request.getParameter("btn_Aceptar")!=null)
		{
			CursoAlu cur = new CursoAlu();
			
			cur.setAlumno(Integer.parseInt((String) request.getParameter("txt_Alumno")));
			
			cur.setCurso((String) request.getParameter("txt_Curso"));
			
			CursoAluNeg CursoAl = new CursoAluNegImpl();
			filas = CursoAl.agregarCursoAlu(cur);
			
			if(filas > 0)
			{
				request.setAttribute("reboto", "falso");
				
				RequestDispatcher rd = request.getRequestDispatcher("/AlumnoCurso.jsp");
			
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("reboto", "verdadero");
				
				RequestDispatcher rd = request.getRequestDispatcher("/AlumnoCurso.jsp");
			
				rd.forward(request, response);
			}
		}			
	}
}
