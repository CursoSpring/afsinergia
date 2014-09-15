$(document).ready(function() {
	
	//Destruimos la modal para que no traiga los mismos datos a la hr de consultar otra entidad
	$("#myModal").on('hidden.bs.modal', function () {
	    $(this).data('bs.modal', null);
	});
	
	//Damos de alta el objeto en la entidad correspondiente
	jQuery.fn.setEntity = function(datos, urlSet, urlLoad) {
		
		console.log("datos: "+JSON.stringify(datos));
		console.log("urlSet: "+urlSet);
		console.log("urlLoad: "+urlLoad);
		
		//peticion ajax
		$.ajax({
			type : 'POST',
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			url : urlSet,
			data : JSON.stringify(datos),
			
			//solicitud exitosa
			success : function(data, textStatus) {
				
				console.log(data);
				var error = data["error"];
				
				//si no hubo error en el login redirect al inicio de la plataforma
				if(!error){
					//forzamos el click del boton que cierra la modal
					$("#closeModal").trigger('click');
					//refrecamos la tabla
					alert("urlLoad = "+urlLoad);
					$('#pruebaDivContenedor').load(urlLoad);
				}
				
				//caso en que el contorlador retorno error = true 
				else
				{
					//desplegamos el div de errror
					//$("#div_error").css("display", "block");
				}
			},
			
			//solicitud fallida
			error : function(xhr, textStatus, errorThrown) {
				console.log('--- request failed. ' + errorThrown +" - "+ JSON.stringify(xhr) +" - "+ textStatus);
				alert('--- request failed. ' + errorThrown +" - "+ JSON.stringify(xhr) +" - "+ textStatus);
			}
		});
	};
	
});