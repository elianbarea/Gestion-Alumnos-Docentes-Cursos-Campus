<%@ page import="entidad.Administrador" %>
<%@ page import="entidad.Materia" %>
<%@ page import="entidad.Semestre" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale-1.0">
		<title>Agregar curso | Facultad Falsa</title>
		<link rel="stylesheet" href="css/campus.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="shortcut icon" href="img/logo.png" class="icon">
	</head>
	<body>
		
		<%
		Administrador a = null;
		if(request.getSession().getAttribute("Administrador") != null)
		{
			a = (Administrador) request.getSession().getAttribute("Administrador");
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
						<a href="VistaAdmin.jsp">Inicio</a>
					</li>
					<li>
						<a href="ServletCurso?Param=1">Agregar</a>
					</li>
					<li>
						<a href="ServletLogin?LogOut=1">Salir</a>
					</li>
				</ul>
				<ul class="nav-menu-der">
					<li>
						<a href="#"><%= a.getUsuario() %></a>
					</li>
					<li>
						<img src="img/avatar_admin.png" alt="FA avatar" class="nav-marc">
					</li>
				</ul>
			</nav>
			<hr>

			<div class="bx_padre">
				<div class="bx_curso">
					<h1>Agregar Curso</h1> <br>
					
					<form action="ServletCurso" method="post">
						<label>Materia</label>
						<select name="ddl_materia" class="ddl_admin">
						<%
						ArrayList<Materia> list = null;
						if(request.getAttribute("listaM") != null & request.getAttribute("listaS") != null)
						{
							list = (ArrayList<Materia>) request.getAttribute("listaM"); 	
							for(Materia m : list)
							{
						%>	
							<option value="<%= m.getLegajo() %>"><%= m.getNombre() %></option>
						<%
							}
						}
						%>
						</select>
						
						<label>Semestre</label>
						<select name="ddl_semestre" class="ddl_admin">
						<%
						ArrayList<Semestre> list2 = null;
						if(request.getAttribute("listaS") != null)
						{
							list2 = (ArrayList<Semestre>) request.getAttribute("listaS");
							for(Semestre s : list2)
							{
						%>
							<option value="<%= s.getLegajo() %>"><%= s.getNombre() %></option>
						<%
							}
						}
						%>
						</select>
						
						<label>Docente</label>
						<input type="text" name="txt_docente" required>						
						
						<label>Año</label>
						<input type="text" name="txt_año" required>
						

						
						<!--  
						<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
						Docente: </div>
						<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
							<input type="text" name="txt_docente">
						</div>
						-->
						
						<input type="submit" value="Aceptar" name="btn_aceptar">
					</form>
					<% 
					if( request.getAttribute("reboto") == "verdadero" ) 
					{
					%>
             		<script> alert("Error en la carga"); </script>
              		<%
              		} 
					else if (request.getAttribute("reboto") == "falso")
					{
					%>  
					<script> alert("Agregado con exito"); </script>  
					<%
					}
					%>
				</div>
			</div>
		</div>
	
	</body>
</html>