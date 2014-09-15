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

        <h4 class="text-primary"><spring:message code="getClientes.tabla.titulo"/></h4>

		<!-- Caso en que si hay clientes -->
		<c:if test="${clientes.size() > 0}">
		
			<!-- Llenamos la tabla con los clientes provenientes de la bd -->
			<div class="table-responsive" id="divTableClientes">
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr>
							<th class="text-primary"><spring:message code="getClientes.tabla.nombre"/></th><th class="text-primary"><spring:message code="getClientes.tabla.contacto"/></th><th class="text-primary"><spring:message code="getClientes.tabla.telefono"/></th><th class="text-primary"><spring:message code="getClientes.tabla.movil"/></th><th class="text-primary"><spring:message code="getClientes.tabla.email"/></th><th class="text-primary"><spring:message code="generic.editar"/></th><th class="text-primary"><spring:message code="generic.eliminar"/></th>
						</tr>
					</thead>

					<tbody>
							<c:forEach var="i" begin="0" end="${clientes.size()-1}">
								<tr data-href="getContratos/<c:out value="${clientes.get(i).getIdCliente()}"></c:out>">
									<td><c:out value="${clientes.get(i).getNombre()}"></c:out></td><td><c:out value="${clientes.get(i).getContacto()}"></c:out></td><td><c:out value="${clientes.get(i).getTelefono()}"></c:out></td><td><c:out value="${clientes.get(i).getMovil()}"></c:out></td><td><c:out value="${clientes.get(i).getMail()}"></c:out></td>
									<td><a id="edita<c:out value="${clientes.get(i).getIdCliente()}"></c:out>" data-toggle="modal" href="getClienteByid/<c:out value="${clientes.get(i).getIdCliente()}"></c:out>" data-target="#myModal" class="btn btn-default btn-link">Eidtar</a></td>
									<td><a id="elimina<c:out value="${clientes.get(i).getIdCliente()}"></c:out>" class="btn btn-default btn-link">Eliminar</a></td>
								</tr>
								
							</c:forEach>
							
							<!-- Obtenemos el IdGpoemp ya que lo necesitamos para hacer el insert de un cliente-->
							<c:set var="idGpoemp" value="${clientes.get(0).getAfstGpoemp().getIdGpoemp()}"/>
												
					</tbody>
					
					<!--<tfoot>
							<td>-- foot</td><td>-- foot</td><td>-- foot</td><td>-- foot</td>
					</tfoot>-->
				</table>
			</div>
		
		</c:if>
		
		<!-- Caso en que no hay clientes -->
		<c:if test="${clientes.size() < 1}">

			<c:set var="idGpoemp" value="0"/>
		
			<div id="div_error" class="alert alert-danger" role="alert" style="display: block;">
				<spring:message code="resultados.vacio"/>
			</div>						
		</c:if>
	
		<!-- Boton para invocar la modal, pasandole el idGpoemp -->
		<button class="btn btn-default btn-link btn-lg pull-right" data-toggle="modal" class="btn btn-info" href="cliente/<c:out value="${idGpoemp}"></c:out>" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span></button>
		
    </div>

	<script src="resources/js/redirectGeneric.js"></script>

</body>
</html>