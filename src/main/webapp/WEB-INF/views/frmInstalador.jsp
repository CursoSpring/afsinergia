<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>

<body>
	<div class="modal-header"><!-- modal-body -->
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		 <h4 class="modal-title"><spring:message code="instalador.frmInstalador.titulo"/></h4>
	</div><!-- /modal-header -->
	
	<div class="modal-body"><!-- modal-body -->

	
			<form id="instaladorForm" method="post" class="form-horizontal" action="setInstalador">

			<!-- Este campo sera util unicamente cuando se edita la instalador -->
			<div class="form-group">
				<div class="col-lg-5">
					<input type="hidden" id="idInstalador" name="idInstalador" value="<c:out value="${instalador.getIdInstalador()}"></c:out>"/>
				</div>
			</div>
			
			<!-- Este caso sera util unicamente cuando se da de alta un nuevo cliente -->
			<div class="form-group">
				<div class="col-lg-5">
					<input type="hidden" id="idCliente" name="idCliente" value="<c:out value="${idCliente}"></c:out>"/>
				</div>
			</div>
	
			<!-- Este campo es de texto para el usuario -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="generic.nombre"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="nombreInstalador" name="nombreInstalador" value="<c:out value="${instalador.getNombre()}"></c:out>"/>
				</div>
			</div>
	

			<div class="form-group">
				<div class="col-lg-9 col-lg-offset-3 col-md-9 col-md-offset-3 col-sm-9 col-sm-offset-3">
					<button class="btn btn-default fa fa-floppy-o" id="guardarInstalador"><spring:message code="generic.guardar"/></button>
				</div>
			</div>
		</form>
			
	</div><!-- /modal-body -->

	<div class="modal-footer"><!-- modal-footer -->
		<button type="button" id="closeModal" class="btn btn-default" data-dismiss="modal"><spring:message code="generic.cerrar"/></button>
	</div><!-- /modal-footer -->
	
	
	<script src="resources/js/instalador.js"></script>
	
</body>
</html>