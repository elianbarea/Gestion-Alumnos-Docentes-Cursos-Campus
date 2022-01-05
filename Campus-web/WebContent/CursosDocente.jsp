<%@ page import="entidad.Curso" %>
<%@ page import="entidad.Docente" %>
<%@ page import="entidad.Materia" %>
<%@ page import="negocio.MateriaNeg" %>
<%@ page import="negocioImpl.MateriaNegImpl" %>
<%@ page import="entidad.Semestre" %>
<%@ page import="negocio.SemestreNeg" %>
<%@ page import="negocioImpl.SemestreNegImpl" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale-1.0">
		<title>Mis cursos | Facultad Falsa</title>
		<link rel="stylesheet" href="css/campus.css">
		<link rel="shortcut icon" href="img/logo.png" class="icon">
		
		<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
		
		<script>
			$(document).ready(function() {
			    $('#tbl_alumnos').DataTable();
			} );
		</script>
	</head>
	<body>
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
						<img src="img/avatar_doc.png" alt="FD avatar" class="nav-marc">
					</li>
				</ul>
			</nav>
			<hr>
			
			<%
			Docente d = null;
			if(request.getSession().getAttribute("Usuario") != null)
			{
				d =  (Docente) request.getSession().getAttribute("Usuario");
			}
			%>
			
			<header class="cabecera">
				<h2>Mis Cursos</h2>
				<p>Docente: <%= d.getApellido() %>, <%= d.getNombre() %> </p>
			</header>
			
			<form action="ServletDocente" method="get">
				<table id="tbl_alumnos" class="tabla">
					<thead>
						<tr>
							<th>Curso</th>
							<th>Materia</th>
							<th>Año</th>
							<th>Semestre</th>
						</tr>
					</thead>
										
					<tbody>
					<%
					if(request.getAttribute("CursosDocente") != null)
					{
						ArrayList<Curso> list = (ArrayList<Curso>) request.getAttribute("CursosDocente"); 
						for(Curso c : list)
						{
						
						/*
							MateriaNeg mNeg = new MateriaNegImpl();
							Materia m = mNeg.obtenerUno(c.getMateria().getLegajo() );
							
							
							SemestreNeg sNeg = new SemestreNegImpl();
							Semestre s = sNeg.obtenerUno(c.getSem().getLegajo());*/
					%>
						<tr>
							<td> <input type="submit" value="<%= c.getLegajo() %>" name="btn_curso"> </td>
							<td><%= c.getMateria().getNombre() %></td>
							<td><%= c.getAño() %></td>
							<td><%= c.getSem().getNombre() %></td>
						</tr>
					<%
						}
					}
					%>
					</tbody>
				</table>
			</form>
		</div>
	</body>
</html>