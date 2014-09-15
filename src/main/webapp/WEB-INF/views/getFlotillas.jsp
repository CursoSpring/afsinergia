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

        <h4 class="text-primary"><spring:message code="flotillas.tabla.titulo"/></h4>

		<!-- Caso en que si hay flotillas -->
		<c:if test="${flotillas.size() > 0}">
		
			<!-- Llenamos la tabla con los flotillas provenientes de la bd -->
			<div class="table-responsive" id="divTableflotillas">
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr>
							<th class="text-primary"><spring:message code="generic.nombre"/></th><th class="text-primary"><spring:message code="generic.editar"/></th><th class="text-primary"><spring:message code="generic.eliminar"/></th>
						</tr>
					</thead>

					<!-- los data-link="row" class="rowlink" permiten hacer el onclick de la fila y el del link de la fila, junto con la ref de jasny-bootstrap -->
					<tbody>
							<c:forEach var="i" begin="0" end="${flotillas.size()-1}">
								<tr data-href="getUnidadesByIdFlotilla/<c:out value="${flotillas.get(i).getIdFlotilla()}"></c:out>">
									<td><c:out value="${flotillas.get(i).getNombre()}"></c:out></td>
									<td><a id="edita<c:out value="${flotillas.get(i).getIdFlotilla()}"></c:out>" data-toggle="modal" href="getFlotillaByid/<c:out value="${flotillas.get(i).getIdFlotilla()}"></c:out>" data-target="#myModal" class="btn btn-default btn-link">Eidtar</a></td>
									<td><a id="elimina<c:out value="${flotillas.get(i).getIdFlotilla()}"></c:out>" class="btn btn-default btn-link">Eliminar</a></td>
								</tr>
								
							</c:forEach>
							
							<!-- Obtenemos el idContrato ya que lo necesitamos para hacer el insert de un grupo usuario-->
							<c:set var="idContrato" value="${flotillas.get(0).getAfstContrato().getIdContrato()}"/>
												
					</tbody>
					
					<!--<tfoot>
							<td>-- foot</td><td>-- foot</td><td>-- foot</td><td>-- foot</td>
					</tfoot>-->
				</table>
			</div>
		
		</c:if>
		
		<!-- Caso en que no hay flotillas -->
		<c:if test="${flotillas.size() < 1}">

			<c:set var="idContrato" value="${idContrato_}"/>
		
			<div id="div_error" class="alert alert-danger" role="alert" style="display: block;">
				<spring:message code="resultados.vacio"/>
			</div>						
		</c:if>
	
		<!-- Boton para invocar la modal, pasandole el idContrato -->		
		<button class="btn btn-default btn-link btn-lg pull-right" data-toggle="modal" class="btn btn-info" href="flotilla/<c:out value="${idContrato}"></c:out>" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span></button>
		

    </div>

	<script src="resources/js/redirectGeneric.js"></script>
	
</body>
</html>