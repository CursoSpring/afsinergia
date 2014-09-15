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
		 <h4 class="modal-title"><spring:message code="usuarios.frmUsuario.titulo"/></h4>
	</div><!-- /modal-header -->
	
	<div class="modal-body"><!-- modal-body -->

	
			<form id="usuarioForm" method="post" class="form-horizontal" action="setUsuario">

			<!-- Este campo sera util unicamente cuando se edita el usuario -->
			<div class="form-group">
				<div class="col-lg-5">
					<input type="hidden" id="idUsuario" name="idUsuario" value="<c:out value="${usuario.getIdUsuario()}"></c:out>"/>
				</div>
			</div>
			
			<!-- Este caso sera util unicamente cuando se da de alta un nuevo contrato -->
			<div class="form-group">
				<div class="col-lg-5">
					<input type="hidden" id="idGrupoUsuario" name="idGrupoUsuario" value="<c:out value="${idGrupoUsuario}"></c:out>"/>
				</div>
			</div>
	
			<!-- Este campo es de texto para el usuario -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="usuarios.usuario"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="usuario" name="usuario" value="<c:out value="${usuario.getUsuario()}"></c:out>"/>
				</div>
			</div>
	
			<!-- Este campo es de texto para el clave -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="usuarios.clave"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="password" class="form-control" id="clave" name="clave" value="<c:out value="${usuario.getClave()}"></c:out>"/>
				</div>
			</div>
	
			<!-- Este campo es de texto para el clave -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="usuarios.confirma.clave"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="password" class="form-control" id="claveConfirm" name="claveConfirm" value="<c:out value="${usuario.getClave()}"></c:out>"/>
				</div>
			</div>
	
			<!-- Este campo es de texto para el nombre -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="generic.nombre"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="nombre" name="nombre" value="<c:out value="${usuario.getNombre()}"></c:out>"/>
				</div>
			</div>
	
			<!-- Este campo es de texto para el apePat -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="usuarios.app"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="apePat" name="apePat" value="<c:out value="${usuario.getApePat()}"></c:out>"/>
				</div>
			</div>
			
			<!-- Este campo es de texto para el apeMat -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="usuarios.apm"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="apeMat" name="apeMat" value="<c:out value="${usuario.getApeMat()}"></c:out>"/>
				</div>
			</div>
	
			<!-- Combo de grupos de usuarios -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="gpo.usuarios.gpo"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<select class="form-control" id="gpoUsu" data-toggle="dropdown">
					
						<!-- Set de los gruposDeUsuarios -->
						<!-- Si se esta en el modo de actualizacion, cargamos el grupo seleccionado previamente -->
						<c:if test="${gposUsuarios.size() > 0}">
							<c:forEach var="i" begin="0" end="${gposUsuarios.size()-1}">
								<c:choose>
								      <c:when test="${ usuario != null && usuario.getUsutGpousu().getIdGpousu() == gposUsuarios.get(i).getIdGpousu()}">
									  	<option value="<c:out value="${gposUsuarios.get(i).getIdGpousu()}"></c:out>" selected><c:out value="${gposUsuarios.get(i).getNombre()}"></c:out></option>
								      </c:when>
								
								      <c:otherwise>
									  	<option value="<c:out value="${gposUsuarios.get(i).getIdGpousu()}"></c:out>"><c:out value="${gposUsuarios.get(i).getNombre()}"></c:out></option>
								      </c:otherwise>
								</c:choose>
							</c:forEach>
						</c:if>
						
					</select>
				</div>
			</div>
			
		   <!-- Es un campo de Check donde se puede optar por subir las SIM Masivamente por un archivo -->
		   <div class="form-group" style="float:center">
		    <label class="col-lg-3 col-md-3 col-sm-3 control-label"></label>
		    <div class="col-lg-5 col-md-5 col-sm-5"> 
		    
    		<!-- Caso en que si hay usuario -->
			<c:if test="${usuario.getStatus() == 'ACTIVE'}">
			     <input type="checkbox" id="status" checked>
			</c:if>
			
			<c:if test="${usuario.getStatus() == 'INACTIVE'}">
			     <input type="checkbox" id="status" >
			</c:if>
			<spring:message code="generic.status.activo"/>
		    </div>
		   </div>

			<div class="form-group">
				<div class="col-lg-9 col-lg-offset-3 col-md-9 col-md-offset-3 col-sm-9 col-sm-offset-3">
					<button class="btn btn-default fa fa-floppy-o" id="guardarUsuario"><spring:message code="generic.guardar"/></button>
				</div>
			</div>
		</form>
			
	</div><!-- /modal-body -->

	<div class="modal-footer"><!-- modal-footer -->
		<button type="button" id="closeModal" class="btn btn-default" data-dismiss="modal"><spring:message code="generic.cerrar"/></button>
	</div><!-- /modal-footer -->
	
	
	<script src="resources/js/usuario.js"></script>
	
</body>
</html>