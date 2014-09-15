$(document).ready(function() {
	
	//FUNCIONES
	
	//Solicitud de login funcionesUtils.js
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	$('#submit').click(function(event) {
		
		var emp = {
				usuario : $('#name').val(),
				clave : $('#pass').val()
		};
		
		console.log(":::: _VHM"+JSON.stringify(emp));
		
		$.ajax({
			type : 'POST',
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			url : "/org/login",
			data : JSON.stringify(emp),

			//soliciyud exitosa
			success : function(data, textStatus) {
				console.log("--- request success.");
				console.log(data);
				var error = data["error"];
				
				//si no hubo error en el login redirect al inicio de la plataforma
				if(!error){
					//Componemos la url
					window.location.replace("redirect");
				}
				
				//caso en que hubo un error(credenciales invalidas, pero solicitud exitosa) 
				else
				{
					//desplegamos el div de errror
					$("#div_error").css("display", "block");
				}
			},
			
			//solicitud fallida
			error : function(xhr, textStatus, errorThrown) {
				console.log('--- request failed. ' + errorThrown +" - "+ JSON.stringify(xhr) +" - "+ textStatus);
			}
		});
		
	});
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
});