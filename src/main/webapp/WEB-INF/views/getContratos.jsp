<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

    <div class="container">

        <h4 class="text-primary"><spring:message code="getContratos.tabla.titulo"/></h4>

		<!-- Caso en que si hay contratos -->
		<c:if test="${contratos.size() > 0}">
		
			<!-- Llenamos la tabla con los clientes provenientes de la bd -->
			<div class="table-responsive" id="divTableContratos">
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr>
							<th class="text-primary"><spring:message code="getContratos.tabla.numerocontrato"/></th><th class="text-primary"><spring:message code="getContratos.tabla.nombrecontrato"/></th><th class="text-primary"><spring:message code="getContratos.tabla.iniciocontrato"/></th><th class="text-primary"><spring:message code="getContratos.tabla.plazocontrato"/></th><th class="text-primary"><spring:message code="getContratos.tabla.mumunidades"/></th><th class="text-primary"><spring:message code="generic.editar"/></th><th class="text-primary"><spring:message code="generic.eliminar"/></th>
						</tr>
					</thead>

					<!-- los data-link="row" class="rowlink" permiten hacer el onclick de la fila y el del link de la fila, junto con la ref de jasny-bootstrap -->
					<tbody>
							<c:forEach var="i" begin="0" end="${contratos.size()-1}">
								<tr data-href="<c:out value="${moduloSolicitado.getModulo()}"></c:out>/<c:out value="${contratos.get(i).getIdContrato()}"></c:out>">
									<td><c:out value="${contratos.get(i).getNoContrato()}"></c:out></td><td><c:out value="${contratos.get(i).getNomContrato()}"></c:out></td><td><c:out value="${contratos.get(i).getInicioContrato()}"></c:out></td><td><c:out value="${contratos.get(i).getPlazo()}"></c:out></td><td><c:out value="${contratos.get(i).getNoUnidades()}"></c:out></td>
									<td><a id="edita<c:out value="${contratos.get(i).getIdContrato()}"></c:out>" data-toggle="modal" href="getContratoByid/<c:out value="${contratos.get(i).getIdContrato()}"></c:out>" data-target="#myModal" class="btn btn-default btn-link">Eidtar</a></td>
									<td><a id="elimina<c:out value="${contratos.get(i).getIdContrato()}"></c:out>" class="btn btn-default btn-link">Eliminar</a></td>
								</tr>
								
							</c:forEach>
							
							<!-- Obtenemos el idContrato ya que lo necesitamos para hacer el insert de un contrato-->
							<c:set var="idCliente" value="${contratos.get(0).getAfstCliente().getIdCliente()}"/>
												
					</tbody>
					
					<!--<tfoot>
							<td>-- foot</td><td>-- foot</td><td>-- foot</td><td>-- foot</td>
					</tfoot>-->
				</table>
			</div>
		
		</c:if>
		
		<!-- Caso en que no hay clientes -->
		<c:if test="${contratos.size() < 1}">

			<c:set var="idCliente" value="${idCliente_}"/>
		
			<div id="div_error" class="alert alert-danger" role="alert" style="display: block;">
				<spring:message code="resultados.vacio"/>
			</div>						
		</c:if>
	
		<!-- Boton para invocar la modal, pasandole el idContrato -->		
		<button class="btn btn-default btn-link btn-lg pull-right" data-toggle="modal" class="btn btn-info" href="contrato/<c:out value="${idCliente}"></c:out>" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span></button>
		
    </div>

	<script src="resources/js/redirectGeneric.js"></script>
	
</body>
</html>