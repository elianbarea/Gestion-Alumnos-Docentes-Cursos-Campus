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
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale-1.0">
        <title>Agregar Alumno | Facultad Falsa</title>
        <link rel="stylesheet" href="css/campus.css">
        <link rel="stylesheet" href="css/admin.css">
        <link rel="shortcut icon" href="img/logo.png" class="icon">
        
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    
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
                        <a href="AlumnoCurso.jsp?Param=1">Cargar alumno a Curso</a>
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
                <h2>Agregar Alumno</h2>
                <p>Docente: <%= d.getApellido() %>, <%= d.getNombre() %> </p>
            </header>
<style>
table, td, th {
  border: 1px solid black;
}
table {
  width: 100%;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Alumno al Curso</title>
</head>
<body>

<div style="background: #FFFFFF">

<div style="background:#a7cfb5"; margin-bottom:0px ; display: flex; justify-content: space-around; align-items: center; ">

<br><br>


    <form action="ServletAlumnoCurso" method="post">
    <div style="backround-color:#FFFFFF; height: 33xp; width: 10%; float:left">
    Legajo curso: </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="txt_Curso">
    <div style="backround-color:#FFFFFF; height: 33xp; width: 90px; float:left">
          
    </div>
    
    <br><br>
    
    <div style="backround-color:#FFFFFF; height: 33xp; width: 11%; float:left">
    Legajo del Alumno: </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="txt_Alumno">
    <div style="backround-color:#FFFFFF; height: 33xp; width: 90%; float:left">
    
    </div>

    
    <br><br><br>

    <input type="submit" value="Aceptar" name="btn_Aceptar" style=" margin-bottom:20px; width:150px; height:30px; float:left">
    </form>
    
    
    <% if( request.getAttribute("reboto") == "verdadero" ) {%>
             <script> alert("Error en la carga"); </script>
            
              <%} else if (request.getAttribute("reboto") == "falso"){%>  <script> alert("Agregado con exito"); </script>  <%}%>
</div>
</body>
</html>