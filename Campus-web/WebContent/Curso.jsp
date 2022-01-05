<%@ page import="negocio.CursoNeg" %>
<%@ page import="negocioImpl.CursoNegImpl" %>
<%@ page import="entidad.CursoAlu" %>
<%@ page import="entidad.Alumno" %>
<%@ page import="negocio.AlumnoNeg" %>
<%@ page import="negocioImpl.AlumnoNegImpl" %>
<%@ page import="entidad.Materia" %>
<%@ page import="negocio.MateriaNeg" %>
<%@ page import="negocioImpl.MateriaNegImpl" %>
<%@ page import="entidad.Estado" %>
<%@ page import="negocio.EstadoNeg" %>
<%@ page import="negocioImpl.EstadoNegImpl" %>
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
		
		<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->
		<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
		
		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
		
		<!-- 
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
		-->
		
		<script>
			$(document).ready(function() {
			    var table = $('#tbl_alumnos').DataTable();
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
			if(request.getAttribute("ListAlumnos") != null)
			{
				String curso = request.getParameter("btn_curso");
				
				CursoNeg cNeg = new CursoNegImpl();
				Materia m = cNeg.obtenerMat(curso);
			%>
			
			<header class="cabecera">
				<h2>Materia</h2>
				<p><%= m.getNombre() %></p>
			</header>
			
			
			<table id="tbl_alumnos" class="tabla">
				<thead>
					<tr>
						<th>Alumno</th>
						<th>Parcial 1</th>
						<th>Parcial 2</th>
						<th>Recuperatorio 1</th>
						<th>Recuperatorio 2</th>
						<th>Estado</th>
						<th> </th>
					</tr>
				</thead>
				<tbody>
				<%
				ArrayList<CursoAlu> list = (ArrayList<CursoAlu>) request.getAttribute("ListAlumnos");
				for(CursoAlu cA : list)
				{
					AlumnoNeg aNeg = new AlumnoNegImpl();
					Alumno a = new Alumno();
					a = aNeg.obtenerUno(cA.getAlumno());
					System.out.println("Alumno "+cA.getAlumno());
					
					EstadoNeg eNeg = new EstadoNegImpl();
					Estado e = eNeg.obtenerUno(cA.getEstado());
				%>
					<tr>
					<form action="ServletCurso" method="post">
						<td><input type="hidden" value="<%= cA.getAlumno() %>" name="txt_alumno"><%= a.getApellido() %>, <%= a.getNombre() %></td>
						<td><%= cA.getNt1() %></td>
						<td><%= cA.getNt2() %></td>
						<td><%= cA.getNt3() %></td>
						<td><%= cA.getNt4() %></td>
						<td><input type="hidden" value="<%= curso %>" name="txt_curso"><%= e.getNombre() %></td>
			
						<td><input type="submit" value="Calificar" name="btn_nota"></td>
					</form>
					</tr>
				<%
					}
				}
				%>
				</tbody>
				
			</table>
			
			<br>
			<!-- VENTANA MODAL PARA LA CARGA DE NOTAS 
			<div class="modal fade" id="ventanaModal" tabindex="-1" role="dialog" aria-labelledby="tituloVent" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="color: #000">
						<div class="modal-header">
							<h5 id="tituloVent">Carga de notas</h5>
							<button class="close" data-dismiss="modal" aria-label="Cerrar">
								<samp aria-hidden="true">&times;</samp>
							</button>
						</div>
						<div class="modal-body">
							<label style="display: block; margin: 0; padding: 0;">Alumno</label>
							<label style="display: block; margin: 0; padding: 0;">Parcial 1</label>
							<label style="display: block; margin: 0; padding: 0;">Parcial 2</label>
							<label style="display: block; margin: 0; padding: 0;">Recuperatorio 1</label>
							<label style="display: block; margin: 0; padding: 0;">Recuperatorio 2</label>
						</div>
						<div class="modal-footer">
							<button class="btn btn-warning" type="button" data-dismiss="modal">
								Cerrar
							</button>
							<button class="btn btn-warning" type="button">
								Aceptar
							</button>
						</div>
					</div>
				</div>			
			</div> -->
			
		</div>
		
	</body>
</html>