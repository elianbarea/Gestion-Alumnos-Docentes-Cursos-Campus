<%@ page import="entidad.Administrador" %>
<%@ page import="entidad.Docente" %>
<%@ page import="datos.DocenteDao" %>
<%@ page import="datosImpl.DocenteDaoImpl" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale-1.0">
		<title>Agregar docente | Facultad Falsa</title>
		<link rel="stylesheet" href="css/campus.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="shortcut icon" href="img/logo.png" class="icon">
		
		<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
		
		<script>
			$(document).ready(function() {
			    $('#table_D').DataTable();
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

			<div class="bx_padre">
				<div class="bx_alumno">
					<h1>Agregar Docente</h1>			
				    <%
					ArrayList<Docente> listaT = null;
					if(request.getAttribute("lista")!=null)
					{
						listaT = (ArrayList<Docente>)request.getAttribute("lista");
					}
					DocenteDao sd = new DocenteDaoImpl();
					
					//System.out.println(sd.obtenerUltimoLegajoDoc());
					%>
					
					<form method="get" action="ServletDocente"> 
					
						<label>Legajo</label><br>
						<label name="lbl_legajo"><%=sd.obtenerUltimoLegajoDoc() %></label>
						
						<label>DNI</label>
						<input type="number" required pattern= "\d{8}" required name="txt_dniD" placeholder="Ingrese DNI">
						
						<label>Nombre</label>
						<input type="text" required name="txt_nombreD" placeholder="Ingrese Nombre">
						
						<label>Apellido</label>
						<input type="text" required name="txt_apellidoD" placeholder="Ingrese Apellido">
						
						<label>Fecha de nacimiento</label>
						<input type="text" required pattern="\d{1,2}/\d{1,2}/\d{4}" required name="date_fnacimientoD" placeholder ="DD/MM/YYYY">
						
						<label>Dirección</label>
						<input type="text" required name="txt_direccionD" placeholder="Ingrese Dirección">
						
						<label>Localidad</label>
						<input type="text" required name="txt_localidadD" placeholder="Ingrese Localidad">
						
						<label>Nacionalidad</label>
						<input type="text" required name="txt_nacionalidadD" placeholder="Ingrese Nacionalidad">
						
						<label>E-mail</label>
						<input type="text" required pattern= "^[^@\s]+@[^@\s]+\.[^@\s]+$"  required name="emailD" placeholder="Ingrese su E-mail">
						
						<label>Teléfono</label>
						<input type="number" required pattern= "\d{10}" required name="telefonoD" placeholder="Ingrese Telefono">
						
						<label>Contraseña</label>
						<input type="text"  required name="passD" placeholder="Ingrese Contraseña">
								
						<br>
						
						<input type="submit" value="Aceptar" name="btn_aceptar2">
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
						<script> alert("Docente agregado con exito"); </script>
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
			
			<h1>Listado de Docentes</h1>
		
			<form method="post" action="ServletDocente">
				<input type="submit" value="Mostrar Todos" name="btn_mostrartodos">  
			</form>
			<br>
			
			
			<table id="table_D" class="tabla">	
		  
			  	<thead> 
			  		<tr >
					    <th>LEG.</th>
					    <th>DNI</th>
					    <th>NOMBRE</th>
					    <th>APELLIDO</th>
					    <th>FECHA DE NACIMIENTO</th>
					    <th>DIRECCION</th>
					    <th>LOCALIDAD</th>
					    <th>NACIONALIDAD</th>
					    <th>EMAIL</th>
					    <th>TEL.</th>
					    <th>CLAVE</th>
					    <th>ACCIONES</th>
					</tr>
			  
				</thead>  
				
			   		
				<tbody>
				<%
				ArrayList<Docente> listaDocentes = null;
				if(request.getAttribute("lista")!=null)
				{
					listaDocentes = (ArrayList<Docente>) request.getAttribute("lista");
							
					for(Docente s : listaDocentes)
					{
				%>
					<tr>  	
						<form action= "ServletDocente" method="post">
						    <td><%= s.getLegajo() %> <input type="hidden" name="legajoDocente" value="<%= s.getLegajo() %>"> </td>
						    <td><%= s.getDni() %>  <input type="hidden" name="dniDocente" value="<%= s.getDni() %>"> </td>
						    <td><%= s.getNombre() %> <input type="hidden" name="nombreDocente" value="<%= s.getNombre() %>"> </td>
						    <td><%= s.getApellido() %> <input type="hidden" name="apellidoDocente" value="<%= s.getApellido() %>"> </td>
						    <td><%= s.getNacimiento() %> <input type="hidden" name="nacimientoDocente" value="<%= s.getNacimiento() %>"> </td>
						    <td><%= s.getDireccion() %> <input type="hidden" name="direccionDocente" value="<%= s.getDireccion() %>"> </td>
						    <td><%= s.getLocalidad() %> <input type="hidden" name="localidadDocente" value="<%= s.getLocalidad() %>"> </td>
						    <td><%= s.getNacionalidad() %> <input type="hidden" name="nacionalidadDocente" value="<%= s.getNacionalidad() %>"> </td>
						    <td><%= s.getMail() %> <input type="hidden" name="mailDocente" value="<%= s.getMail() %>"> </td>
						    <td><%= s.getTelefono() %> <input type="hidden" name="telefonoDocente" value="<%= s.getTelefono() %>"> </td>
						    <td><%= s.getPassDoc() %> <input type="hidden" name="passDocente" value="<%= s.getPassDoc() %>"> </td>
						    <td>
				    			<input type="submit" value="Modificar" name="btn_modificar2" style="width: 100%; margin-bottom: 20px;"> 
				    			<input type="submit" value="Eliminar" name="btn_eliminar2" onclick = "return(confirm('Seguro que desea eliminar?'))" style="width: 100%; margin-bottom: 20px;">
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