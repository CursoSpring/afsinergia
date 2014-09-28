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

        <h4 class="text-primary"><spring:message code="usuarios.tabla.titulo"/></h4>
		
		<!-- Caso en que si hay usuario -->
		<c:if test="${usuarios.size() > 0}">

			<!-- Llenamos la tabla con los clientes provenientes de la bd -->
			<div class="table-responsive" id="divTableUsuarios">
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr>
							<th class="text-primary"><spring:message code="usuarios.usuario"/></th><th class="text-primary"><spring:message code="usuarios.clave"/></th><th class="text-primary"><spring:message code="generic.nombre"/></th><th class="text-primary"><spring:message code="usuarios.app"/></th><th class="text-primary"><spring:message code="usuarios.apm"/></th><th class="text-primary"><spring:message code="gpo.usuarios.gpo"/></th><th class="text-primary"><spring:message code="generic.status"/></th><th class="text-primary"><spring:message code="generic.editar"/></th><th class="text-primary"><spring:message code="generic.eliminar"/></th>
						</tr>
					</thead>

					<!-- los data-link="row" class="rowlink" permiten hacer el onclick de la fila y el del link de la fila, junto con la ref de jasny-bootstrap -->
					<tbody>
							<c:forEach var="i" begin="0" end="${usuarios.size()-1}">
								<tr>
									<td><c:out value="${usuarios.get(i).getUsuario()}"></c:out></td><td><c:out value="${usuarios.get(i).getClave()}"></c:out></td><td><c:out value="${usuarios.get(i).getNombre()}"></c:out></td><td><c:out value="${usuarios.get(i).getApePat()}"></c:out></td><td><c:out value="${usuarios.get(i).getApeMat()}"></c:out></td><td><c:out value="${usuarios.get(i).getUsutGpousu().getNombre()}"></c:out></td><td><c:out value="${usuarios.get(i).getStatus()}"></c:out></td>
									<td><a id="edita<c:out value="${usuarios.get(i).getIdUsuario()}"></c:out>" data-toggle="modal" href="getUsuarioById/<c:out value="${usuarios.get(i).getIdUsuario()}"></c:out>" data-target="#myModal" class="btn btn-default btn-link <spring:message code="icono.editar"/>"></a></td>
									<td><a id="elimina<c:out value="${usuarios.get(i).getIdUsuario()}"></c:out>" class="btn btn-default btn-link <spring:message code="icono.eliminar"/>"></a></td>
								</tr>
								
							</c:forEach>
							
							<!-- Obtenemos el idGpousu ya que lo necesitamos para hacer el insert de un usuario-->
							<c:set var="idGrupoUsuario" value="${usuarios.get(0).getUsutGpousu().getIdGpousu()}"/>
												
					</tbody>
					
					<!--<tfoot>
							<td>-- foot</td><td>-- foot</td><td>-- foot</td><td>-- foot</td>
					</tfoot>-->
				</table>
			</div>
		
		</c:if>
		
		<!-- Caso en que no hay usuario -->
		<c:if test="${usuarios.size() < 1}">

			<!-- En este caso no es necesario mandar forzozamente el idGrupoUsuario y que en el frUsuario hay cbo de grupos de usuarios-->
			<c:set var="idGrupoUsuario" value="0"/>
		
			<div id="div_error" class="alert alert-danger" role="alert" style="display: block;">
				<spring:message code="resultados.vacio"/>
			</div>						
		</c:if>
		

		<!-- Boton para invocar la modal, pasandole el idUsuario -->
		<button class="btn btn-default btn-link btn-lg pull-right" data-toggle="modal" class="btn btn-info" href="usuario/<c:out value="${idGrupoUsuario}"></c:out>" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span></button>

    </div>

</body>
</html>