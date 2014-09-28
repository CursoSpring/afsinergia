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

        <h4 class="text-primary"><spring:message code="instaladores.tabla.titulo"/></h4>

		<!-- Caso en que si hay instaladores -->
		<c:if test="${instaladores.size() > 0}">
		
			<!-- Llenamos la tabla con los instaladores provenientes de la bd -->
			<div class="table-responsive" id="divTableinstaladores">
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr>
							<th class="text-primary"><spring:message code="generic.nombre"/></th><th class="text-primary"><spring:message code="usuarios.app"/></th><th class="text-primary"><spring:message code="usuarios.apm"/></th><th class="text-primary"><spring:message code="generic.correo"/></th><th class="text-primary"><spring:message code="generic.editar"/></th><th class="text-primary"><spring:message code="generic.eliminar"/></th>
						</tr>
					</thead>

					<!-- los data-link="row" class="rowlink" permiten hacer el onclick de la fila y el del link de la fila, junto con la ref de jasny-bootstrap -->
					<tbody>
							<c:forEach var="i" begin="0" end="${instaladores.size()-1}">
								<tr data-href="getUnidadesByIdFlotilla/<c:out value="${instaladores.get(i).getIdInstalador()}"></c:out>">
									<td><c:out value="${instaladores.get(i).getNombre()}"></c:out></td>
									<td><c:out value="${instaladores.get(i).getPaterno()}"></c:out></td>
									<td><c:out value="${instaladores.get(i).getMaterno()}"></c:out></td>
									<td><c:out value="${instaladores.get(i).getCorreo()}"></c:out></td>
									<td><a id="edita<c:out value="${instaladores.get(i).getIdInstalador()}"></c:out>" data-toggle="modal" href="getInstaladorById/<c:out value="${instaladores.get(i).getIdInstalador()}"></c:out>" data-target="#myModal" class="btn btn-default btn-link <spring:message code="icono.editar"/>"></a></td>
									<td><a id="elimina<c:out value="${instaladores.get(i).getIdInstalador()}"></c:out>" class="btn btn-default btn-link <spring:message code="icono.eliminar"/>"></a></td>
								</tr>
								
							</c:forEach>
							
							<!-- Obtenemos el idCliente ya que lo necesitamos para hacer el insert de un instalador-->
							<c:set var="idCliente" value="${instaladores.get(0).getAfstCliente().getIdCliente()}"/>
												
					</tbody>
					
					<!--<tfoot>
							<td>-- foot</td><td>-- foot</td><td>-- foot</td><td>-- foot</td>
					</tfoot>-->
				</table>
			</div>
		
		</c:if>
		
		<!-- Caso en que no hay instaladores -->
		<c:if test="${instaladores.size() < 1}">

			<c:set var="idCliente" value="${idCliente_}"/>
		
			<div id="div_error" class="alert alert-danger" role="alert" style="display: block;">
				<spring:message code="resultados.vacio"/>
			</div>						
		</c:if>
	
		<!-- Boton para invocar la modal, pasandole el idCliente -->		
		<button class="btn btn-default btn-link btn-lg pull-right" data-toggle="modal" class="btn btn-info" href="instalador/<c:out value="${idCliente}"></c:out>" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span></button>
		

    </div>

	<script src="resources/js/redirectGeneric.js"></script>
	
</body>
</html>