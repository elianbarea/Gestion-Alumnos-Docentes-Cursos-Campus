<%@ page import="entidad.Administrador" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale-1.0">
		<title>Admin | Facultad Falsa</title>
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
			<div class=bx_padre>
				<div class="bx_admin">
					
					<h1>Inicio</h1> <br>
					
					<form action = "ServletVistaAdmin" method = "post">
					
						<input type="submit" name="btn_Opcion" value="Cursos">
						<input type="submit" name="btn_Opcion" value="Docentes">
						<input type="submit" name="btn_Opcion" value="Alumnos">
						
					</form>
					
				</div>
			</div>
		</div>

	</body>
</html>