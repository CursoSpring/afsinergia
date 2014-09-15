<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><spring:message code="frmCliente.titulo"/></title>  
</head>

<body>
	<div class="modal-header"><!-- modal-body -->
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		 <h4 class="modal-title"><spring:message code="frmCliente.titulo"/></h4>
	</div><!-- /modal-header -->
	
	<div class="modal-body"><!-- modal-body -->

		<form id="clienteForm" method="post" class="form-horizontal" action="setCliente">

			<!-- Este campo sera util unicamente cuando se edita el cliente -->
			<div class="form-group">
				<div class="col-lg-5">
					<input type="hidden" id="idCliente" name="idCliente" value="<c:out value="${cliente.getIdCliente()}"></c:out>"/>
				</div>
			</div>
			
			<!-- Este caso sera util unicamente cuando se da delata un nuevo cliente -->
			<div class="form-group">
				<div class="col-lg-5">
					<input type="hidden" id="idGpoemp" name="idGpoemp" value="<c:out value="${IdGpoemp}"></c:out>"/>
				</div>
			</div>
		
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="frmCliente.nombre"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="nombre" name="nombre" value="<c:out value="${cliente.getNombre()}"></c:out>"/>
				</div>
			</div>

			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="frmCliente.contacto"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="contacto" name="contacto" value="<c:out value="${cliente.getContacto()}"></c:out>"/>
				</div>
			</div>

			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="frmCliente.telefono"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="telefono" name="telefono" value="<c:out value="${cliente.getTelefono()}"></c:out>"/>
				</div>
			</div>

			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="frmCliente.movil"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="movil" name="movil" value="<c:out value="${cliente.getMovil()}"></c:out>"/>
				</div>
			</div>

			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="frmCliente.mail"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="mail" name="mail" value="<c:out value="${cliente.getMail()}"></c:out>"/>
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-9 col-lg-offset-3 col-md-9 col-md-offset-3 col-sm-9 col-sm-offset-3">
					<button class="btn btn-default fa fa-floppy-o" id="guardarCliente"><spring:message code="generic.guardar"/></button>
				</div>
			</div>
		</form>
			
	</div><!-- /modal-body -->
	
	<div class="modal-footer"><!-- modal-footer -->
		<button type="button" id="closeModal" class="btn btn-default" data-dismiss="modal"><spring:message code="generic.cerrar"/></button>
	</div><!-- /modal-footer -->
	
	<script src="resources/js/cliente.js"></script>
	
</body>

</body>
</html>