<%@ page import="entidad.Administrador" %>
<%@ page import="entidad.Alumno" %>
<%@ page import="datos.AlumnoDao" %>
<%@ page import="datosImpl.AlumnoDaoImpl" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale-1.0">
		<title>Editar alumno | Facultad Falsa</title>
		<link rel="stylesheet" href="css/campus.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="shortcut icon" href="img/logo.png" class="icon">
	</head>
	<body>
	
	<%
	Administrador a = null;
	if(request.getSession().getAttribute("Administrador") != null)
	{
		a =  (Administrador) request.getSession().getAttribute("Administrador");
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
						<a href="ServletAlumno?Param=1">Alumnos</a>
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
	
			<h1>Alumnos </h1>
			
			<h2>Editar Alumno</h2>
			
			<form method="post" action="ServletAlumno"> 
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Legajo: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text" readonly="true" name="legajo" value= "${legajo}">
			</div>
			 
		    <br><br>
		    
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			DNI: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="number"   name="txt_dniA" placeholder="Ingrese su Nro de DNI" value= "${dni}">
			</div>
			
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Nombre: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"   name="txt_nombreA" placeholder="Ingrese su Nombre" value= "${nombre}">
			</div>
			
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Apellido: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="txt_apellidoA" placeholder="Ingrese su Apellido" value= "${apellido}">
			</div>
			
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 11%; float:left">
			Fecha de Nacimiento: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 89%; float:left">
			<input type="text"  pattern="\d{1,2}/\d{1,2}/\d{4}"  name="date_fnacimientoA" placeholder ="dd/mm/yyyy" value= "${nacimiento}">
			</div>
			
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Direccion: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="txt_direccionA" placeholder="Ingrese Direccion" value= "${direccion}">
			</div>
			
			<br><br>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Provincia: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="txt_provinciaA" placeholder="Ingrese Provincia" value= "${provincia}">
			</div>
			
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Nacionalidad: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="txt_nacionalidadA" placeholder="Ingrese su Nacionalidad" value= "${nacionalidad}">
			</div>
			
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			E-mail: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="emailA" placeholder="Ingrese su E-mail" value= "${mail}">
			</div>
		
			<br><br>	
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Telefono: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="telefonoA" placeholder="Ingrese Nro de Telefono" value= "${telefono}">
			</div>
				
			<br><br>
			
			<input type="submit" value="Guardar Cambios" name="btn_guardar" style=" margin-bottom:20px; width:150px; height:30px; float:left">	
		
			</form>
		</div>
	</body>
</html>