<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title><spring:message code="admin.title"/></title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap/bootstrap.min.css"/>

    <!-- jansy-bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/jansy-bootstrap/jasny-bootstrap.min.css"/>

    <!-- jquery -->
	<!-- <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script> -->
	<script type='text/javascript' src="resources/js/jquery/jquery-1.11.1.min.js"></script>

	<!-- Include FontAwesome CSS if you want to use feedback icons provided by FontAwesome -->
    <link href="resources/css/font-awesome/font-awesome.min.css" rel="stylesheet">
	
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.2/html5shiv.js"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.2.0/respond.js"></script>
    <![endif]-->
	
    <!-- BootstrapValidator CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap-validator/bootstrapValidator.min.css"/>

</head>
<body>

     <div class="container-fluid" >

	  <div class="row">
	  
		<div class="col-xs-12" style="background-color:#FFF; layer-background-color#FFF;">
		
			<div class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header" >
						<button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle close" >
							
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							
						</button>
					</div>
					
					<!-- Collection of nav links and other content for toggling -->
					<div id="navbarCollapse" class="collapse navbar-collapse">

						<!-- Logout -->					
						<a class="btn pull-right fa fa-sign-out fa-2x" style="color:black; padding-top: 12px;" href="logout" role="button" data-toggle="tooltip" data-placement="top" title="<spring:message code="logout"/>"></a>
						<a class="navbar-brand" href="#"><spring:message code="admin.msg.bienvenida"/> <c:out value="${nombreDeUsuario}"></c:out></a>
						<a href="./?language=es">Español</a> | <a href="./?language=en">English</a>
						
						<ul class="nav navbar-nav navbar-left">

							<!-- falta la validacion de si no vienen datos size()=0 -->
							
							<c:set var="idModulo" value="${privilegiosUsuario.get(0).getPtlcModulo().getIdModulo()}"/>
									
							<c:forEach var="i" begin="0" end="${privilegiosUsuario.size()-1}">
								
								<c:if test="${i == 0}">
									<!-- crea dropdown -->
									<li class="dropdown">
									    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><c:out value="${privilegiosUsuario.get(i).getPtlcModulo().getNomMod()}"></c:out><span class="caret"></span></a>
									    
									    <ul class="dropdown-menu" role="menu">
									<!-- /crea dropdown -->    
								</c:if>
								
								<c:if test="${idModulo == privilegiosUsuario.get(i).getPtlcModulo().getIdModulo()}">
								
								<!-- llena dropdown -->
								<li><button type="button" class="btn btn-link ${privilegiosUsuario.get(i).getPtlcFuncion().getIcono()}" id="${privilegiosUsuario.get(i).getPtlcFuncion().getUrlControlador()}"><c:out value="   ${privilegiosUsuario.get(i).getPtlcFuncion().getNomFun()}"></c:out></button></li>
								<!-- /llena dropdown -->
								
									<c:if test="${i == privilegiosUsuario.size()-1}">
										<!-- cierra dropdown -->
										  </ul>
										</li>
										<!-- /cierra dropdown -->
									</c:if>
								</c:if>

								<c:if test="${idModulo != privilegiosUsuario.get(i).getPtlcModulo().getIdModulo()}">
									<!-- cierra dropdown -->
									  </ul>
									</li>
									<!-- /cierra dropdown -->
									
									<c:set var="idModulo" value="${privilegiosUsuario.get(i).getPtlcModulo().getIdModulo()}"/>
									
									<c:if test="${i < privilegiosUsuario.size()}">
										
										<!-- crea dropdown -->
										<li class="dropdown">
									     <a href="#" class="dropdown-toggle" data-toggle="dropdown"><c:out value="${privilegiosUsuario.get(i).getPtlcModulo().getNomMod()}"></c:out><span class="caret"></span></a>
										  <ul class="dropdown-menu" role="menu">
										<!-- /crea dropdown -->
										
											<!-- llena dropdown -->
											<li><button type="button" class="btn btn-link ${privilegiosUsuario.get(i).getPtlcFuncion().getIcono()}" id="${privilegiosUsuario.get(i).getPtlcFuncion().getUrlControlador()}"><c:out value="   ${privilegiosUsuario.get(i).getPtlcFuncion().getNomFun()}"></c:out></button></li>
											<!-- /llena dropdown -->
									</c:if>
									<c:if test="${i == privilegiosUsuario.size()-1}">
										<!-- cierra dropdown -->
										  </ul>
										</li>
										<!-- /cierra dropdown -->
									</c:if>
									
								</c:if>
								
							</c:forEach>
							
						</ul>
						
						
					</div>
				</div>		
			</div>
		
		</div>
		
		<div id="camino" class="col-xs-12">
			<ol id="listCamino" class="breadcrumb">
			  
			</ol>
		</div>
		
		<div id="pruebaDivContenedor" class="col-xs-12" >
		</div>
		
	  </div>
	  
     </div><!-- /.container -->
		  
  	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			</div> <!-- /.modal-content -->
		</div> <!-- /.modal-dialog -->
	</div> <!-- /.modal -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>
    <!-- jansy-bootstrap CSS -->
    <script type="text/javascript" src="resources/js/jansy-bootstrap/jasny-bootstrap.min.js"></script>
        <!-- BootstrapValidator JS -->
    <script type="text/javascript" src="resources/js/bootstrap-validator/bootstrapValidator.min.js"></script>
    <!-- administracion JS -->
    <script type="text/javascript" src="resources/js/administracion.js"></script>
    <!-- setGeneric JS -->
    <script type="text/javascript" src="resources/js/setGeneric.js"></script>
    <!-- redirectGeneric JS -->
    <script type="text/javascript" src="resources/js/redirectGeneric.js"></script>
    <!-- variablesGlobales JS -->
    <script type="text/javascript" src="resources/js/variablesGlobales.js"></script>

</body>
</html>