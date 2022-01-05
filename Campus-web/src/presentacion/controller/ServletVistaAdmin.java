package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletVistaAdmin
 */
@WebServlet("/ServletVistaAdmin")
public class ServletVistaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVistaAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btn_Opcion") != null)
		{
			String opcion = request.getParameter("btn_Opcion");
			
			//System.out.println(opcion);
			
			switch(opcion)
			{
			case "Cursos":
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarCurso.jsp");
				dispatcher.forward(request, response);
				break;
			case "Docentes":
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("/Docente.jsp");
				dispatcher1.forward(request, response);
				break;
			case "Alumnos":
				RequestDispatcher dispatcher11 = request.getRequestDispatcher("/Alumno.jsp");
				dispatcher11.forward(request, response);
				break;
			}
		}
	}

}
