<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale-1.0">
		<title>Login | Facultad Falsa</title>
		<link rel="stylesheet" href="css/campus.css">
		<link rel="shortcut icon" href="img/logo.png" class="icon">
		<link rel="stylesheet" href="css/login.css">
		
	</head>
	<body>
		<div class="bx_login">
			<img class="logo" alt="logoFacultadFalsa" src="img/logo.png">
			<h1>Iniciar sesi�n</h1><br>
			<form action="ServletLogin" method="post" >
                <!-- usuario -->
                <label for="usernom">Usuario</label>
                <input type="text" name="txtUsuario" placeholder="Usuario" required>
                <!-- contrase�a -->
                <label for="passnom">Contrase�a</label>
                <input type="password" name="txtContrasegna" placeholder="Contrase�a" required>

                <input type="submit" name="btn_ingreso" value="Ingresar">

                <a href="#"> Usuario/Contrase�a extraviada</a>
			</form>
            <%
            if( request.getAttribute("reboto") == "falso" ) 
            {
            %>
     	 	<label style="color: red;">Email o Contrase�a incorrecta.</label>
       	  	<%
       	  	}
       	  	%>
		</div>
	
	</body>
</html>