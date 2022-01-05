<%@ page import="entidad.Administrador" %>
<%@ page import="entidad.Alumno" %>
<%@ page import="datos.AlumnoDao" %>
<%@ page import="datosImpl.AlumnoDaoImpl" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale-1.0">
		<title>Agregar alumno | Facultad Falsa</title>
		<link rel="stylesheet" href="css/campus.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="shortcut icon" href="img/logo.png" class="icon">
		
		<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
		
		<script>
			$(document).ready(function() {
			    $('#table_A').DataTable();
			} );
		</script>
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

			<div class="bx_padre">
				<div class="bx_alumno">
					<h1>Agregar Alumno</h1>			
				    <%
					ArrayList<Alumno> listaT = null;
					if(request.getAttribute("lista")!=null)
					{
						listaT = (ArrayList<Alumno>)request.getAttribute("lista");
					}
					AlumnoDao sd = new AlumnoDaoImpl();
					
					//System.out.println(sd.obtenerUltimoLegajoAlu());
					%>
					
					<form method="get" action="ServletAlumno"> 
					
						<label>Legajo</label><br>
						<label name="lbl_legajo"><%=sd.obtenerUltimoLegajoAlu() %></label>
						
						<label>DNI</label>
						<input type="number" required pattern= "\d{8}" required name="txt_dniA" placeholder="Ingrese DNI">
						
						<label>Nombre</label>
						<input type="text" required name="txt_nombreA" placeholder="Ingrese Nombre">
						
						<label>Apellido</label>
						<input type="text" required name="txt_apellidoA" placeholder="Ingrese Apellido">
						
						<label>Fecha de nacimiento</label>
						<input type="text" required pattern="\d{1,2}/\d{1,2}/\d{4}" required name="date_fnacimientoA" placeholder ="DD/MM/YYYY">
						
						<label>Dirección</label>
						<input type="text" required name="txt_direccionA" placeholder="Ingrese Dirección">
						
						<label>Provincia</label>
						<input type="text" required name="txt_provinciaA" placeholder="Ingrese Provincia">
						
						<label>Nacionalidad</label>
						<input type="text" required name="txt_nacionalidadA" placeholder="Ingrese Nacionalidad">
						
						<label>E-mail</label>
						<input type="text" required pattern= "^[^@\s]+@[^@\s]+\.[^@\s]+$"  required name="emailA" placeholder="Ingrese su E-mail">
						
						<label>Teléfono</label>
						<input type="number" required pattern= "\d{10}" required name="telefonoA" placeholder="Ingrese Telefono">
							
						<br>
						
						<input type="submit" value="Aceptar" name="btn_aceptar">
						<br><br>
					
						<!-- </fieldset> -->
						<%
						int filas = 0;
						if(request.getAttribute("cantFilas")!=null)
						{
							filas = (int) request.getAttribute("cantFilas");
						//}
							
							if(filas == 1)
							{
						%>
						<script> alert("Alumno agregado con exito"); </script>
						<!-- <h3 style= "color: green;">*Alumno agregado con exito.*</h3> -->
						<%
							} 
							else 
							{
						%>
						 <script> alert("Dni ya existente"); </script>  
						<%
							} 
						}
						%>
					
					</form>
				</div>
			</div>		
			
			<!--  -->	
			
			<h1>Listado de Alumnos</h1>
		
			<form method="post" action="ServletAlumno">
				<input type="submit" value="Mostrar Todos" name="btn_mostrartodos">  
			</form>
			<br>
			
			
			<table id="table_A" class="tabla">	
		  
			  	<thead> 
			  		<tr >
					    <th>LEG.</th>
					    <th>DNI</th>
					    <th>NOMBRE</th>
					    <th>APELLIDO</th>
					    <th>FECHA DE NACIMIENTO</th>
					    <th>DIRECCION</th>
					    <th>PROVINCIA</th>
					    <th>NACIONALIDAD</th>
					    <th>EMAIL</th>
					    <th>TEL.</th>
					    <th>ACCIONES</th>
					</tr>
			  
				</thead>  
				
			   		
				<tbody>
				<%
				ArrayList<Alumno> listaAlumnos = null;
				if(request.getAttribute("lista")!=null)
				{
					listaAlumnos = (ArrayList<Alumno>) request.getAttribute("lista");
							
					for(Alumno s : listaAlumnos)
					{
				%>
					<tr>  	
						<form action= "ServletAlumno" method="post">
						    <td><%= s.getLegajo() %> <input type="hidden" name="legajoAlumno" value="<%= s.getLegajo() %>"> </td>
						    <td><%= s.getDni() %>  <input type="hidden" name="dniAlumno" value="<%= s.getDni() %>"> </td>
						    <td><%= s.getNombre() %> <input type="hidden" name="nombreAlumno" value="<%= s.getNombre() %>"> </td>
						    <td><%= s.getApellido() %> <input type="hidden" name="apellidoAlumno" value="<%= s.getApellido() %>"> </td>
						    <td><%= s.getNacimiento() %> <input type="hidden" name="nacimientoAlumno" value="<%= s.getNacimiento() %>"> </td>
						    <td><%= s.getDireccion() %> <input type="hidden" name="direccionAlumno" value="<%= s.getDireccion() %>"> </td>
						    <td><%= s.getProvincia() %> <input type="hidden" name="provinciaAlumno" value="<%= s.getProvincia() %>"> </td>
						    <td><%= s.getNacionalidad() %> <input type="hidden" name="nacionalidadAlumno" value="<%= s.getNacionalidad() %>"> </td>
						    <td><%= s.getMail() %> <input type="hidden" name="mailAlumno" value="<%= s.getMail() %>"> </td>
						    <td><%= s.getTelefono() %> <input type="hidden" name="telefonoAlumno" value="<%= s.getTelefono() %>"> </td>
						    <td>
				    			<input type="submit" value="Modificar" name="btn_modificar" style="width: 100%; margin-bottom: 20px;"> 
				    			<input type="submit" value="Eliminar" name="btn_eliminar" onclick = "return(confirm('Seguro que desea eliminar?'))" style="width: 100%; margin-bottom: 20px;">
					    	</td>	
					    </form>
			    	</tr>
			 	<%
			  		}
				}
			 	%>
		 		</tbody> 
			</table> 
		</div>
	</body>
</html>