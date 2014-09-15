<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="resources/img/favicon.ico">
<title>
	<spring:message code="login.navegador.titulo"/>
</title>

<!-- Le styles -->
<link href="resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/login.css" rel="stylesheet">

</head>
<body>

	<div class="container">
		
	      <form class="form-signin" method="post">
	        <h3 class="form-signin-heading">
	        	<spring:message code="login.formulario.titulo"/>
	        </h3>
	        <input type="text" name="name" id="name" class="form-control" placeholder="<spring:message code="login.formulario.Usuario"/>">
	        <input type="password" name="pass" id="pass" class="form-control" placeholder="<spring:message code="login.formulario.Password"/>">
	        <label class="checkbox"> <input type="checkbox" value="remember-me"> 
	        	<spring:message code="login.formulario.recordarme"/> 
	        </label>
	        
			<div id="div_error" class="alert alert-danger" role="alert" style="display: none;">
				<spring:message code="login.formulario.errorLogin"/>
			</div>
			
	        <button class="btn btn-lg btn-primary btn-block" id="submit" type="button">
	        	<spring:message code="login.formulario.btnEntrar"/>
	        </button>
	      </form>
		
	</div>
	
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/login.js"></script>

</body>
</html>