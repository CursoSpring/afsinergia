$(document).ready(function() {

	//Muestra los campos correspondientes en funcion del tipo de unidad seleccionada
	$("#idTipoDeUnidad").change(function () {
		tipoDeUndiad = $("#idTipoDeUnidad").val();
		
		//vehiculo
		if(tipoDeUndiad == 1)
		{
			//vehiculo
			$("#placas_").show();
			$("#motor_").show();
			$("#color_").show();
			$("#noPuertas_").show();
			$("#anio_").show();
			$("#capCombustible_").show();
			$("#ondometro_").show();
			$("#capCarga_").show();
			$("#noPoliza_").show();
			$("#venPoliza_").show();

			$("#modelo_").show();
			$("#marca_").show();
			
			//movil
			$("#tecnologiaCel_").hide();
			//objeto
			$("#proporcion_").hide();
			//persona
			$("#genero_").hide();
			$("#fechaNacimiento_").hide();
		}
		//movil
		else if(tipoDeUndiad == 2)
		{
			//vehiculo
			$("#placas_").hide();
			$("#motor_").hide();
			$("#color_").hide();
			$("#noPuertas_").hide();
			$("#anio_").hide();
			$("#capCombustible_").hide();
			$("#ondometro_").hide();
			$("#capCarga_").hide();
			$("#noPoliza_").hide();
			$("#venPoliza_").hide();
			
			//movil
			$("#tecnologiaCel_").show();
	
			$("#modelo_").show();
			$("#marca_").show();
			//objeto
			$("#proporcion_").hide();
			//persona
			$("#genero_").hide();
			$("#fechaNacimiento_").hide();
		}
		//objeto
		else if(tipoDeUndiad == 3)
		{
			//vehiculo
			$("#placas_").hide();
			$("#motor_").hide();
			$("#color_").hide();
			$("#noPuertas_").hide();
			$("#anio_").hide();
			$("#capCombustible_").hide();
			$("#ondometro_").hide();
			$("#capCarga_").hide();
			$("#noPoliza_").hide();
			$("#venPoliza_").hide();
	
			$("#modelo_").hide();
			$("#marca_").hide();
			
			//movil
			$("#tecnologiaCel_").hide();
			//objeto
			$("#proporcion_").show();
			//persona
			$("#genero_").hide();
			$("#fechaNacimiento_").hide();
		}
		//persona
		else if(tipoDeUndiad == 4)
		{
			//vehiculo
			$("#placas_").hide();
			$("#motor_").hide();
			$("#color_").hide();
			$("#noPuertas_").hide();
			$("#anio_").hide();
			$("#capCombustible_").hide();
			$("#ondometro_").hide();
			$("#capCarga_").hide();
			$("#noPoliza_").hide();
			$("#venPoliza_").hide();
	
			$("#modelo_").hide();
			$("#marca_").hide();
			
			//movil
			$("#tecnologiaCel_").hide();
			//objeto
			$("#proporcion_").hide();
			//persona
			$("#genero_").show();
			$("#fechaNacimiento_").show();
		}
		
		else
		{
			//vehiculo
			$("#placas_").hide();
			$("#motor_").hide();
			$("#color_").hide();
			$("#noPuertas_").hide();
			$("#anio_").hide();
			$("#capCombustible_").hide();
			$("#ondometro_").hide();
			$("#capCarga_").hide();
			$("#noPoliza_").hide();
			$("#venPoliza_").hide();
	
			$("#modelo_").hide();
			$("#marca_").hide();
			
			//movil
			$("#tecnologiaCel_").hide();
			//objeto
			$("#proporcion_").hide();
			//persona
			$("#genero_").hide();
			$("#fechaNacimiento_").hide();			
		}
	});

	//validacion del formulario de unidad
    $('#unidadForm').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
		message: 'El valor no es valido.',
        feedbackIcons: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-times'
        },
        fields: {

        	nombreUnidad: {
                validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    stringLength: {
                        min: 3,
                        max: 15,
                        message: 'Debe de tener de 3 a 15 caracteres.'
                    },
					regexp: {
                        regexp: /^[a-zA-Z\.\s·ÈÌÛ˙¡…Õ”⁄—Ò¸‹¸‹ 0-9]+$/,
                        message: ''
                    },
                }
            }
        }
    }).on('error.form.bv', function(e) {
       console.log("Error en el formulario!!");
	   
    }).on('success.form.bv', function(e) {
        console.log("Success en el formulario!!");
	
        if($('#flotilla').val() != 0)
        {	
	        var _idTipoDeUnidad = "";
	        
	        //Obtenemos el tipo de unidad
	        if($("#idTipoDeUnidad").val() === undefined)
	        	_idTipoDeUnidad = $("#idTipoUnidad").val();
	        else
	        	_idTipoDeUnidad = $("#idTipoDeUnidad").val();
	        
			var datos = {
					idUnidad : $('#idUnidad').val(),
					nombre : $('#nombreUnidad').val(),
					placas : $('#placas').val(),
					motor : $('#motor').val(),
					color : $('#color').val(),
					modelo : $('#modelo').val(),
					noPuertas : $('#noPuertas').val(),
					anio : $('#anio').val(),
					marca : $('#marca').val(),
					capCombustible : $('#capCombustible').val(),
					ondometro : $('#ondometro').val(),
					capCarga : $('#capCarga').val(),
					noPoliza : $('#noPoliza').val(),
					venPoliza : $('#venPoliza').val(),
					carEspecial : $('#carEspecial').val(),
					tecnologiaCel : $('#tecnologiaCel').val(),
					proporcion : $('#proporcion').val(),
					genero : $("input:checked").val(),
					fechaNacimiento : $('#fechaNacimiento').val(),
					unicTipoUnidad: {
						idTipoUnidad : _idTipoDeUnidad 
					},
					distDispositivo: {
						idDispositivo : '6'
					},
					afstFlotilla: {
						idFlotilla : $('#flotilla').val()
					}				  
			};
			
	        var urlSet = "/org/setUnidad";
	        var urlLoad = getUrlCallBackLoad(path);
	        
	        console.log(datos);
	    	//$().setEntity(datos, urlSet, urlLoad);
        }
        
        else
        {
        	alert("Seleccione una flotilla");
    	}	
    }); 	
});