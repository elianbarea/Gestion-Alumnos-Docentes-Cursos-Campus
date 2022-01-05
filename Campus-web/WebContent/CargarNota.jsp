<%@ page import="entidad.CursoAlu" %>
<%@ page import="entidad.Docente" %>
<%@ page import="entidad.Materia" %>
<%@ page import="entidad.Semestre" %>
<%@ page import="entidad.Alumno" %>
<%@ page import="negocio.AlumnoNeg" %>
<%@ page import="negocioImpl.AlumnoNegImpl" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale-1.0">
		<title>Carga de notas | Facultad Falsa</title>
		<link rel="stylesheet" href="css/campus.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="shortcut icon" href="img/logo.png" class="icon">
	</head>
	<body>
		
		<%
			Docente d = null;
			if(request.getSession().getAttribute("Usuario") != null)
			{
				d =  (Docente) request.getSession().getAttribute("Usuario");
			}
		%>
		
		<div class="contenedor">
			<nav class="nav-pral">
				<img src="img/logo.png" alt="FF logo" class="nav-marc">
				<ul class="nav-menu">
					<li>
						<a href="#">Facultad Falsa</a>
					</li>
					<li>
						<a href="ServletDocente?Param=1">Mis cursos</a>
					</li>

					<li>
						<a href="ServletLogin?LogOut=1">Salir</a>
					</li>
				</ul>
				<ul class="nav-menu-der">
					<li>
						<a href="#"><%= d.getApellido() %>, <%= d.getNombre() %></a>
					</li>
					<li>
						<img src="img/avatar_doc.png" alt="FD avatar" class="nav-marc">
					</li>
				</ul>
			</nav>
			<hr>

			<%
			CursoAlu cA = null;
			Alumno a = new Alumno();
			if(request.getAttribute("alu") != null)
			{
				cA = (CursoAlu) request.getAttribute("alu");
				
				AlumnoNeg aNeg = new AlumnoNegImpl();
				a = aNeg.obtenerUno(cA.getAlumno());
			}
			%>

			<div class="bx_padre">
				<div class="bx_curso">
					<h1>Cargar notas</h1> <br>
					<h2><%= a.getApellido() %>, <%= a.getNombre() %></h2>
					<form action="ServletCurso" method="post">
						<label>Parcial 1</label>
						<input type="text" name="txt_P1" required>		
						
						<label>Parcial 2</label>
						<input type="text" name="txt_P2" required>		
						
						<label>Recuperatorio 1</label>
						<input type="text" name="txt_R1" >						

						<label>Recuperatorio 2</label>
						<input type="text" name="txt_R2" >						
						
						<input type="hidden" value="<%= cA.getCurso() %>" name="txt_curso2">
						<input type="hidden" value="<%= cA.getAlumno() %>" name="txt_alumno2">
						<input type="submit" value="Aceptar" name="btn_aceptar2">
					</form>

				</div>
			</div>
		</div>
	
	</body>
</html>