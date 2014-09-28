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
		 <h4 class="modal-title"><spring:message code="privilegios.editar"/></h4>
	</div><!-- /modal-header -->
	
	<div class="modal-body"><!-- modal-body -->

		<c:if test="${privilegios.size() > 0}">
		
			<input type="hidden" id="idGpoUsuPrivilegios" name="idGpoUsuPrivilegios" value="<c:out value="${privilegios.get(0).getUsutGpousu().getIdGpousu()}"></c:out>"/>
		
			<ul>
				<li><a href="#">Modulos</a>
					<ul>
						
						<c:set var="idModulo" value="${privilegios.get(0).getPtlcModulo().getIdModulo()}"/>
							
						<c:forEach var="i" begin="0" end="${privilegios.size()-1}">
						
							<c:if test="${i == 0}">
								<!-- crea modulo -->
								<li><a href="#"><c:out value="${privilegios.get(i).getPtlcModulo().getNomMod()}"></c:out></a>
									<ul>
								<!-- /crea modulo -->    
							</c:if>
							
							<c:if test="${idModulo == privilegios.get(i).getPtlcModulo().getIdModulo()}">
							
							<!-- llena modulo -->
								<li><a href="#"><c:out value="${privilegios.get(i).getPtlcFuncion().getNomFun()}"></c:out></a>
									<ul>
									
										<!-- alta -->
										<c:if test="${privilegios.get(i).getAlta()}">
											<li><input type="checkbox" data-operacion="1" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>" checked/><a href="#"><spring:message code="generic.guardar"/></a></li>
										</c:if>
									
										<c:if test="${!privilegios.get(i).getAlta()}">
											<li><input type="checkbox" data-operacion="1" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>"/><a href="#"><spring:message code="generic.guardar"/></a></li>
										</c:if>

										<!-- baja -->
										<c:if test="${privilegios.get(i).getBaja()}">
											<li><input type="checkbox" data-operacion="2" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>" checked/><a href="#"><spring:message code="generic.eliminar"/></a></li>
										</c:if>	

										<c:if test="${!privilegios.get(i).getBaja()}">
											<li><input type="checkbox" data-operacion="2" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>"/><a href="#"><spring:message code="generic.eliminar"/></a></li>
										</c:if>

										<!-- cambio -->
										<c:if test="${privilegios.get(i).getCambio()}">
											<li><input type="checkbox" data-operacion="3" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>" checked/><a href="#"><spring:message code="generic.editar"/></a></li>
										</c:if>	

										<c:if test="${!privilegios.get(i).getCambio()}">
											<li><input type="checkbox" data-operacion="3" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>"/><a href="#"><spring:message code="generic.editar"/></a></li>
										</c:if>

										<!-- consulta -->
										<c:if test="${privilegios.get(i).getConsulta()}">
											<li><input type="checkbox" data-operacion="4" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>" checked/><a href="#"><spring:message code="generic.consultar"/></a></li>
										</c:if>	

										<c:if test="${!privilegios.get(i).getConsulta()}">
											<li><input type="checkbox" data-operacion="4" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>"/><a href="#"><spring:message code="generic.consultar"/></a></li>
										</c:if>
										
									</ul>
								</li>			
							<!-- /llena modulo -->
							
								<c:if test="${i == privilegios.size()-1}">
									<!-- cierra modulo -->
										</ul>
									</li>									
									<!-- /cierra modulo -->
								</c:if>
							</c:if>	
						
							<c:if test="${idModulo != privilegios.get(i).getPtlcModulo().getIdModulo()}">
								<!-- cierra modulo -->
									</ul>
								</li>									
								<!-- /cierra modulo -->
								
								<c:set var="idModulo" value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"/>
								
								<c:if test="${i < privilegios.size()}">
									
									<!-- crea modulo -->
									<li><a href="#"><c:out value="${privilegios.get(i).getPtlcModulo().getNomMod()}"></c:out></a>
										<ul>									
									<!-- /crea modulo -->
									
										<!-- llena modulo -->
											<li><a href="#"><c:out value="${privilegios.get(i).getPtlcFuncion().getNomFun()}"></c:out></a>
												<ul>
									
													<!-- alta -->
													<c:if test="${privilegios.get(i).getAlta()}">
														<li><input type="checkbox" data-operacion="1" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>" checked/><a href="#"><spring:message code="generic.guardar"/></a></li>
													</c:if>
												
													<c:if test="${!privilegios.get(i).getAlta()}">
														<li><input type="checkbox" data-operacion="1" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>"/><a href="#"><spring:message code="generic.guardar"/></a></li>
													</c:if>
			
													<!-- baja -->
													<c:if test="${privilegios.get(i).getBaja()}">
														<li><input type="checkbox" data-operacion="2" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>" checked/><a href="#"><spring:message code="generic.eliminar"/></a></li>
													</c:if>	
			
													<c:if test="${!privilegios.get(i).getBaja()}">
														<li><input type="checkbox" data-operacion="2" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>"/><a href="#"><spring:message code="generic.eliminar"/></a></li>
													</c:if>
			
													<!-- cambio -->
													<c:if test="${privilegios.get(i).getCambio()}">
														<li><input type="checkbox" data-operacion="3" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>" checked/><a href="#"><spring:message code="generic.editar"/></a></li>
													</c:if>	
			
													<c:if test="${!privilegios.get(i).getCambio()}">
														<li><input type="checkbox" data-operacion="3" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>"/><a href="#"><spring:message code="generic.editar"/></a></li>
													</c:if>
			
													<!-- consulta -->
													<c:if test="${privilegios.get(i).getConsulta()}">
														<li><input type="checkbox" data-operacion="4" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>" checked/><a href="#"><spring:message code="generic.consultar"/></a></li>
													</c:if>	
			
													<c:if test="${!privilegios.get(i).getConsulta()}">
														<li><input type="checkbox" data-operacion="4" data-modulo="<c:out value="${privilegios.get(i).getPtlcModulo().getIdModulo()}"></c:out>" data-funcion="<c:out value="${privilegios.get(i).getPtlcFuncion().getIdFun()}"></c:out>"/><a href="#"><spring:message code="generic.consultar"/></a></li>
													</c:if>

												</ul>
											</li>										
										<!-- /llena modulo -->
								</c:if>
								<c:if test="${i == privilegios.size()-1}">
									<!-- cierra modulo -->
									  </ul>
									</li>
									<!-- /cierra modulo -->
								</c:if>
								
							</c:if>
						</c:forEach>					
					
					</ul>
				</li>
			</ul>

	
			<div>
				<button class="btn btn-default fa fa-floppy-o" id="gurdarPrivilegios"><spring:message code="generic.guardar"/></button>
			</div>

		</c:if>
		
		
		<c:if test="${privilegios.size() < 1}">
			<div id="div_error_privilegios" class="alert alert-danger" role="alert" style="display: block;">
				<spring:message code="privilegios.vacio"/>
			</div>
		</c:if>
		
	</div><!-- /modal-body -->

	<div class="modal-footer"><!-- modal-footer -->
		<button type="button" id="closeModalPrivilegios" class="btn btn-default" data-dismiss="modal"><spring:message code="generic.cerrar"/></button>
	</div><!-- /modal-footer -->
	
	
	<script src="resources/js/privilegios.js"></script>
	
</body>
</html>