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
		 <h4 class="modal-title"><spring:message code="unidad.frmUnidades.titulo"/><c:out value=" ${unidad.getUnicTipoUnidad().getNomUnidad()}"></c:out></h4>
	</div><!-- /modal-header -->
	
	<div class="modal-body"><!-- modal-body -->

	
			<form id="unidadForm" method="post" class="form-horizontal" action="setUnidad">

			<!-- Este campo sera util unicamente cuando se edita el usuario -->
			<div class="form-group">
				<div class="col-lg-5">
					<input type="hidden" id="idUnidad" name="idUnidad" value="<c:out value="${unidad.getIdUnidad()}"></c:out>"/>
				</div>
			</div>
			
			<!-- Este caso sera util unicamente cuando se da de alta un nuevo contrato -->
			<div class="form-group">
				<div class="col-lg-5">
					<input type="hidden" id="idContrato" name="idContrato" value="<c:out value="${idContrato}"></c:out>"/>
				</div>
			</div>
			
			<!-- idTipoUnidad -->
			<div class="form-group">
				<div class="col-lg-5">
					<input type="hidden" id="idTipoUnidad" name="idTipoUnidad" value="<c:out value="${unidad.getUnicTipoUnidad().getIdTipoUnidad()}"></c:out>"/>
				</div>
			</div>
	
			<!-- Este campo es de texto para el usuario -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="generic.nombre"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="nombreUnidad" name="nombreUnidad" value="<c:out value="${unidad.getNombre()}"></c:out>"/>
				</div>
			</div>

			<!-- Este campo es de texto para el vencimiento de CEspecia -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.car.especial"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<input type="text" class="form-control" id="carEspecial" name="carEspecial" value="<c:out value="${unidad.getCarEspecial()}"></c:out>"/>
				</div>
			</div>

			<!-- Combo de flotillas -->
			<div class="form-group">
				<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="flotillas"/></label>
				<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<select class="form-control" id="flotilla" data-toggle="dropdown">
					
						<!-- Set de las flotillas -->
						<!-- Si se esta en el modo de actualizacion, cargamos la flotilla seleccionado previamente -->
						<c:if test="${flotillas.size() > 0}">
							<c:forEach var="i" begin="0" end="${flotillas.size()-1}">
								<c:choose>
								      <c:when test="${ unidad != null && unidad.getAfstFlotilla().getIdFlotilla() == flotillas.get(i).getIdFlotilla()}">
									  	<option value="<c:out value="${flotillas.get(i).getIdFlotilla()}"></c:out>" selected><c:out value="${flotillas.get(i).getNombre()}"></c:out></option>
								      </c:when>
								
								      <c:otherwise>
									  	<option value="<c:out value="${flotillas.get(i).getIdFlotilla()}"></c:out>"><c:out value="${flotillas.get(i).getNombre()}"></c:out></option>
								      </c:otherwise>
								</c:choose>
							</c:forEach>
						</c:if>
						
					</select>
				</div>
			</div>			
			
						<!-- Combo de tipos de unidad -->
			
			<c:if test="${unidad.getUnicTipoUnidad().getIdTipoUnidad() == null}">
				<div class="form-group">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.tipo.unidad"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<select class="form-control" id="idTipoDeUnidad" data-toggle="dropdown">
						
							<!-- Set de los de tipos de unidad -->
							<!-- Si se esta en el modo de actualizacion, cargamos el grupo seleccionado previamente -->
							<c:if test="${tiposDeUnidad.size() > 0}">
								<c:forEach var="i" begin="0" end="${tiposDeUnidad.size()-1}">
									<option value="<c:out value="${tiposDeUnidad.get(i).getIdTipoUnidad()}"></c:out>"><c:out value="${tiposDeUnidad.get(i).getNomUnidad()}"></c:out></option>
								</c:forEach>
							</c:if>
							
						</select>
					</div>
				</div>
			</c:if>
	
															<!-- Campos de uniad -->

			<c:if test="${unidad.getUnicTipoUnidad().getIdTipoUnidad() == 1 || unidad.getUnicTipoUnidad().getIdTipoUnidad() == null}">
				<!-- Este campo es de texto para el placa -->
				<div class="form-group" id="placas_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.placas"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="placas" name="placas" value="<c:out value="${unidad.getPlacas()}"></c:out>"/>
					</div>
				</div>
		
				<!-- Este campo es de texto para el motor -->
				<div class="form-group" id="motor_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.motor"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="motor" name="motor" value="<c:out value="${unidad.getMotor()}"></c:out>"/>
					</div>
				</div>
		
				<!-- Este campo es de texto para el color -->
				<div class="form-group" id="color_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.color"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="color" name="color" value="<c:out value="${unidad.getColor()}"></c:out>"/>
					</div>
				</div>
		
				<!-- Este campo es de texto para el no de puertas -->
				<div class="form-group" id="noPuertas_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.no.puertas"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="noPuertas" name="noPuertas" value="<c:out value="${unidad.getNoPuertas()}"></c:out>"/>
					</div>
				</div>
		
				<!-- Este campo es de texto para el anio -->
				<div class="form-group" id="anio_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.anio"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="anio" name="anio" value="<c:out value="${unidad.getAnio()}"></c:out>"/>
					</div>
				</div>
		
				<!-- Este campo es de texto para el capacidad de combustible -->
				<div class="form-group" id="capCombustible_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.cap.combustible"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="capCombustible" name="capCombustible" value="<c:out value="${unidad.getCapCombustible()}"></c:out>"/>
					</div>
				</div>
		
				<!-- Este campo es de texto para el odometro -->
				<div class="form-group" id="ondometro_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.ondometro"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="ondometro" name="ondometro" value="<c:out value="${unidad.getOndometro()}"></c:out>"/>
					</div>
				</div>
		
				<!-- Este campo es de texto para el capacidad de carga -->
				<div class="form-group" id="capCarga_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.cap.carga"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="capCarga" name="capCarga" value="<c:out value="${unidad.getCapCarga()}"></c:out>"/>
					</div>
				</div>
		
				<!-- Este campo es de texto para el no de poliza -->
				<div class="form-group" id="noPoliza_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.no.poliza"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="noPoliza" name="noPoliza" value="<c:out value="${unidad.getNoPoliza()}"></c:out>"/>
					</div>
				</div>
		
				<!-- Este campo es de texto para el vencimiento de poliza -->
				<div class="form-group" id="venPoliza_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.ven.poliza"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="venPoliza" name="venPoliza" value="<c:out value="${unidad.getVenPoliza()}"></c:out>"/>
					</div>
				</div>
			</c:if>
			
															<!-- Campos de movil -->
			<c:if test="${unidad.getUnicTipoUnidad().getIdTipoUnidad() == 2 || unidad.getUnicTipoUnidad().getIdTipoUnidad() == null}">
				<!-- Este campo es de texto para el vencimiento de tecnologiaCel -->
				<div class="form-group" id="tecnologiaCel_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.tecnologia"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="tecnologiaCel" name="tecnologiaCel" value="<c:out value="${unidad.getTecnologiaCel()}"></c:out>"/>
					</div>
				</div>
			</c:if>
	
															<!-- Campos de objeto -->
															
			<c:if test="${unidad.getUnicTipoUnidad().getIdTipoUnidad() == 3 || unidad.getUnicTipoUnidad().getIdTipoUnidad() == null}">
				<!-- Este campo es de texto para el vencimiento de proporcion -->
				<div class="form-group" id="proporcion_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.proporcion"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="proporcion" name="proporcion" value="<c:out value="${unidad.getProporcion()}"></c:out>"/>
					</div>
				</div>
			</c:if>
															<!-- Campos de persona -->
			<c:if test="${unidad.getUnicTipoUnidad().getIdTipoUnidad() == 4 || unidad.getUnicTipoUnidad().getIdTipoUnidad() == null}">				
				<!-- Este campo es de texto para el vencimiento de genero -->
				<div class="form-group" id="genero_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.genero"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						
						<!-- true => hombre, false => mujer -->
						<div class="radio">
							<label>
								<c:choose>
								      <c:when test="${unidad.getGenero()}">
									  	<input type="radio" name="opciones" id="generoHombre" value="<c:out value="${generoHombre}"></c:out>" checked>
								      </c:when>
								
								      <c:otherwise>
									  	<input type="radio" name="opciones" id="generoHombre" value="<c:out value="${generoHombre}"></c:out>">
								      </c:otherwise>
								</c:choose>
								<spring:message code="generic.genero.hombre"/>
							</label>
						</div>
						
						<div class="radio">
							<label>
								<c:choose>
								      <c:when test="${!unidad.getGenero()}">
									  	<input type="radio" name="opciones" id="generoMujer" value="<c:out value="${generoMujer}"></c:out>" checked>
								      </c:when>
								
								      <c:otherwise>
									  	<input type="radio" name="opciones" id="generoMujer" value="<c:out value="${generoMujer}"></c:out>">
								      </c:otherwise>
								</c:choose>
								<spring:message code="generic.genero.mujer"/>
							</label>
						</div>
						
					</div>
				</div>

				<!-- Este campo es de texto para el vencimiento de fechaNacimiento -->
				<div class="form-group" id="fechaNacimiento_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.fecha.nacimiento"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="fechaNacimiento" name="fechaNacimiento" value="<c:out value="${unidad.getFechaNacimiento()}"></c:out>"/>
					</div>
				</div>
			</c:if>
			
			<c:if test="${unidad.getUnicTipoUnidad().getIdTipoUnidad() == 1 || unidad.getUnicTipoUnidad().getIdTipoUnidad() == 2 || unidad.getUnicTipoUnidad().getIdTipoUnidad() == null}">
				<!-- Este campo es de texto para el modelo -->
				<div class="form-group" id="modelo_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.modelo"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="modelo" name="modelo" value="<c:out value="${unidad.getModelo()}"></c:out>"/>
					</div>
				</div>
				
				<!-- Este campo es de texto para el marca -->
				<div class="form-group" id="marca_">
					<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label"><spring:message code="unidad.marca"/></label>
					<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
						<input type="text" class="form-control" id="marca" name="marca" value="<c:out value="${unidad.getMarca()}"></c:out>"/>
					</div>
				</div>
			</c:if>

			
			<div class="form-group">
				<div class="col-lg-9 col-lg-offset-3 col-md-9 col-md-offset-3 col-sm-9 col-sm-offset-3">
					<button class="btn btn-default fa fa-floppy-o" id="guardarUnidad"><spring:message code="generic.guardar"/></button>
				</div>
			</div>
		</form>
			
	</div><!-- /modal-body -->

	<div class="modal-footer"><!-- modal-footer -->
		<button type="button" id="closeModal" class="btn btn-default" data-dismiss="modal"><spring:message code="generic.cerrar"/></button>
	</div><!-- /modal-footer -->
	
	
	<script src="resources/js/unidad.js"></script>
	
</body>
</html>