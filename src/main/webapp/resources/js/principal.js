$(document).ready(function() {

	//Funciones para traer las seccion correspondiente en la pagina principal
	$("#botonHome").click(callHome);
	$("#botonAlarmas").click(callAlarmas);
	$("#botonReportes").click(callReportes);
	$("#botonAdmin").click(callAdmin);
});

//Mostramos el mapa
callHome = function(){
	location.reload();
	$("#menuLateral").show();
};

callAlarmas = function(){
	$("#map-canvas").load('view1');
	$("#menuLateral").hide();
};

callReportes = function(){
	$("#map-canvas").load('view2');
	$("#menuLateral").hide();
};

callAdmin = function(){
	$("#map-canvas").load('view3');
	$("#menuLateral").hide();
};