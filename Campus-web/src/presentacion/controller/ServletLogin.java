package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Administrador;
import entidad.Docente;
import negocio.AdministradorNeg;
import negocio.DocenteNeg;
import negocioImpl.AdministradorNegImpl;
import negocioImpl.DocenteNegImpl;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
    public ServletLogin() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Cerrar Sesión
		if(request.getParameter("LogOut") != null)
		{
			request.getSession().invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
	        rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DocenteNeg dNeg = new DocenteNegImpl();
	    AdministradorNeg aNeg = new AdministradorNegImpl();
	    Docente doc = null;
	    Administrador admin = null;

		if(request.getParameter("btn_ingreso")!=null)
		{
			String usuario = request.getParameter("txtUsuario");
			String contraseña = request.getParameter("txtContrasegna");
			
			//System.out.println(usuario);
			//System.out.println(contraseña);
			
			doc = dNeg.existeDocente(usuario, contraseña);
			System.out.println(doc.toString());
			
			if(doc.getMail() != null) 
			{
				request.getSession().setAttribute("Usuario", doc);
				
	            RequestDispatcher rd = request.getRequestDispatcher("/CursosDocente.jsp");
	            rd.forward(request, response);
			}
			else
			{
				admin = aNeg.existeAdmin(usuario, contraseña);
				System.out.println(admin.toString());
				
				if(admin.getUsuario() != null) 
				{
					request.getSession().setAttribute("Administrador", admin);
		            RequestDispatcher rd = request.getRequestDispatcher("/VistaAdmin.jsp");
		            rd.forward(request, response);
				}
				else {
					request.setAttribute("reboto", "falso");
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			        rd.forward(request, response);
				}
			}	
		}
	}
}
