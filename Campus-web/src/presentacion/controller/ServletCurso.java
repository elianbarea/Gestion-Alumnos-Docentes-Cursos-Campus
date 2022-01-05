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
import entidad.Materia;
import entidad.Semestre;
import negocio.CursoAluNeg;
import negocio.CursoNeg;
import negocio.MateriaNeg;
import negocio.SemestreNeg;
import negocioImpl.CursoAluNegImpl;
import negocioImpl.CursoNegImpl;
import negocioImpl.MateriaNegImpl;
import negocioImpl.SemestreNegImpl;

/**
 * Servlet implementation class ServletCurso
 */
@WebServlet("/ServletCurso")
public class ServletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Param") != null)
		{
			MateriaNeg mNeg = new MateriaNegImpl();
			ArrayList<Materia> list = mNeg.obtenerMaterias();
			
			SemestreNeg sNeg = new SemestreNegImpl();
			ArrayList<Semestre> list2 = sNeg.obtenerSemestres();
			
			request.setAttribute("listaM", list);
			request.setAttribute("listaS", list2);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarCurso.jsp");
			
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int filas=0;
		if(request.getParameter("btn_aceptar")!=null)
		{
			
			Curso c = new Curso();
			c.setAño( request.getParameter("txt_año"));
			
			//c.setMateria(Integer.parseInt((String) request.getParameter("ddl_materia")));
			Materia m = new Materia();
			m.setLegajo(Integer.parseInt((String) request.getParameter("ddl_materia")));
			c.setMateria(m);
	
			Semestre s = new Semestre();
			s.setLegajo(Integer.parseInt((String) request.getParameter("ddl_semestre")));
			c.setSem(s)  ;
	
			Docente d = new Docente();
			d.setLegajo(Integer.parseInt((String) request.getParameter("txt_docente")));
			c.setDoc(d);
	
			CursoNeg neg = new CursoNegImpl();
			
			filas = neg.agregarCurso(c);
			
			if(filas > 0) 
			{
				request.setAttribute("reboto", "falso");
				RequestDispatcher rd = request.getRequestDispatcher("/AgregarCurso.jsp");
				
				rd.forward(request, response);
			}
			else 
			{
				request.setAttribute("reboto", "verdadero");
				RequestDispatcher rd = request.getRequestDispatcher("/AgregarCurso.jsp");
			
				rd.forward(request, response);
			}
		}
		
		if(request.getParameter("btn_nota") != null)
		{
			CursoAlu cA = new CursoAlu();
			cA.setAlumno(Integer.parseInt(request.getParameter("txt_alumno")));
			cA.setCurso(request.getParameter("txt_curso"));
			
			request.setAttribute("alu", cA);
			RequestDispatcher rd = request.getRequestDispatcher("/CargarNota.jsp");
			
			rd.forward(request, response);
		}
	
		if(request.getParameter("btn_aceptar2") != null)
		{

			CursoAlu cA = new CursoAlu();
			cA.setAlumno(Integer.parseInt(request.getParameter("txt_alumno2")));

			cA.setCurso(request.getParameter("txt_curso2"));

			cA.setNt1(Integer.parseInt(request.getParameter("txt_P1")));

			cA.setNt2(Integer.parseInt(request.getParameter("txt_P2")));
	
			cA.setNt3(Integer.parseInt(request.getParameter("txt_R1")));

			cA.setNt4(Integer.parseInt(request.getParameter("txt_R2")));

			
			
			CursoAluNeg cANeg = new CursoAluNegImpl();
			int fila = 0;
			fila = cANeg.subirNota(cA);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Curso.jsp");
			
			rd.forward(request, response);
		}
	}
}
