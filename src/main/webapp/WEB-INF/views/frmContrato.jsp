<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><spring:message code="frmContrato.titulo"/></title>  

</head>

<body>
	<div class="modal-header"><!-- modal-body -->
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		 <h4 class="modal-title"><spring:message code="frmContrato.titulo"/></h4>
	</div><!-- /modal-header -->
	
	<div class="modal-body"><!-- modal-body -->


			<c:if test="${idCliente != null && idCliente != '' && idCliente > 0}">
				<c:set var="id_Cliente" value="${idCliente}"/>
			</c:if>
			
			<c:if test="${contrato.getAfstCliente().getIdCliente() != null && contrato.getAfstCliente().getIdCliente() != '' && contrato.getAfstCliente().getIdCliente() > 0}">
				<c:set var="id_Cliente" value="${contrato.getAfstCliente().getIdCliente()}"/>
			</c:if>			
	
			<form id="contratoForm" method="post" class="form-horizontal" action="setContrato">

			<!-- Este campo sera util unicamente cuando se edita el contrato -->
			<div class="form-group">
				<div class="col-lg-5">
					<input type="hidden" id="idContrato" name="idContrato" value="<c:out value="${contrato.getIdContrato()}"></c:out>"/>
				</div>
			</div>
			
			<!-- Este caso sera util unicamente cuando se da de alta un nuevo contrato -->
			<div class="form-group">
				<div class="col-lg-5">
				
					<input type="hidden" id="idCliente" name="idCliente" value="<c:out value="${id_Cliente}"></c:out>"/>
				</div>
			</div>
	
			<!-- Este campo es fijo, solo se muestra el numero de contrato -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3  control-label"><spring:message code="frmContrato.numerocontrato"/></label>
				<label class="col-lg-offset-3 control-label"><c:out value="${contrato.getNoContrato()}"></c:out></label>
			</div>
			
			<!-- Este campo es de texto para el nombre del contrato  -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="frmContrato.nombrecontrato"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="nombre_contrato" name="nombre_contrato" value="<c:out value="${contrato.getNomContrato()}"></c:out>"/>
				</div>
			</div>
			
			<!-- Es un campo de combo indica plazos de intervalos de 6 meses  -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="frmContrato.plazocontrato"/></label>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
					<select class="form-control" id="plazo_contrato" data-toggle="dropdown">
					
						<!-- Si se esta en el modo de actualizacion, cargamos el plazo seleccionado previamente -->
						<c:forEach var="i" begin="6" end="36" step="6">
							<c:choose>
							      <c:when test="${contrato.getPlazo() == i}">
								  	<option value="${i*6}" selected>${i}</option>
							      </c:when>
							
							      <c:otherwise>
								  	<option value="${i}">${i}</option>
							      </c:otherwise>
							</c:choose>
						</c:forEach>
						
					</select>
				</div>	
				<div><label class="col-lg-1 control-label">Meses</label></div>			
			</div>
		
			<!-- Es un campo de combo indica los tipos de productos -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="frmContrato.productocontrato"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<select class="form-control" id="producto" >
						<option>Avanzado</option>
						<option>Estandar</option>
						<option>Basico</option>
					</select>
				</div>
			</div>	
		
			<!-- Es un campo de fecha para indicar el inicio del contrato -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="frmContrato.iniciocontrato"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<div class='input-group date' id='iniciocontrato'>
						<input type='text' class="form-control" placeholder=<spring:message code="generic.date.format"/> disabled />
						<span class="input-group-addon"><span class="fa fa-calendar"></span>
						</span>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-lg-9 col-lg-offset-3 col-md-9 col-md-offset-3 col-sm-9 col-sm-offset-3">
					<button class="btn btn-default fa fa-floppy-o" id="guardarContrato"><spring:message code="generic.guardar"/></button>
				</div>
			</div>
		</form>
			
	</div><!-- /modal-body -->
	
	<div class="modal-footer"><!-- modal-footer -->
		<button type="button" id="closeModal" class="btn btn-default" data-dismiss="modal"><spring:message code="generic.cerrar"/></button>
	</div><!-- /modal-footer -->
	
	<script src="resources/js/contrato.js"></script>
	
</body>
</html>