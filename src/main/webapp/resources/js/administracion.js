$(document).ready(function() {
	
	//Cachamos el onclick de x boton del menu de administracion
	$("button").click(callReportes);
	
});
callReportes = function(){
	var idBoton = $(this).attr("id");

	//cargaos la pagina corresponciente en funcion del idBoton => (llamamos al metodo controlador cuya ruta es = al idBoton)
	if(idBoton != undefined && idBoton != null )
	{		
		$("#pruebaDivContenedor").load(idBoton);
	}
	else
	{
		console.log("Path no encontrado: "+idBoton);
	}
};