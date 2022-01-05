<%@ page import="entidad.Administrador" %>
<%@ page import="entidad.Docente" %>
<%@ page import="datos.DocenteDao" %>
<%@ page import="datosImpl.DocenteDaoImpl" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale-1.0">
		<title>Editar docente | Facultad Falsa</title>
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
						<a href="ServletDocente?Param=1">Docentes</a>
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
	
			<h1>Docentes </h1>
			
			<h2>Editar Docente</h2>
			
			<form method="post" action="ServletDocente"> 
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Legajo: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text" readonly="true" name="legajo" value= "${legajo}">
			</div>
			 
		    <br><br>
		    
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			DNI: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="number"   name="txt_dniD" placeholder="Ingrese su Nro de DNI" value= "${dni}">
			</div>
			
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Nombre: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"   name="txt_nombreD" placeholder="Ingrese su Nombre" value= "${nombre}">
			</div>
			
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Apellido: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="txt_apellidoD" placeholder="Ingrese su Apellido" value= "${apellido}">
			</div>
			
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 11%; float:left">
			Fecha de Nacimiento: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 89%; float:left">
			<input type="text"  pattern="\d{1,2}/\d{1,2}/\d{4}"  name="date_fnacimientoD" placeholder ="dd/mm/yyyy" value= "${nacimiento}">
			</div>
			
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Direccion: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="txt_direccionD" placeholder="Ingrese Direccion" value= "${direccion}">
			</div>
			
			<br><br>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Localidad: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="txt_localidadD" placeholder="Ingrese Localidad" value= "${localidad}">
			</div>
			
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Nacionalidad: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="txt_nacionalidadD" placeholder="Ingrese su Nacionalidad" value= "${nacionalidad}">
			</div>
			
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			E-mail: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="emailD" placeholder="Ingrese su E-mail" value= "${mail}">
			</div>
		
			<br><br>	
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Telefono: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="telefonoD" placeholder="Ingrese Nro de Telefono" value= "${telefono}">
			</div>
				
			<br><br>
			
			<div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
			Contraseña: </div>
			<div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
			<input type="text"  name="contraseñaD" placeholder="Ingrese Contraseña" value= "${passD}">
			</div>
			
			<br><br>
			
			<input type="submit" value="Guardar Cambios" name="btn_guardar2" style=" margin-bottom:20px; width:150px; height:30px; float:left">	
				
			</form>
		</div>
	</body>
</html>