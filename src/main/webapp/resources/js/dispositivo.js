$(document).ready(function() {
	
    $('#dispositivoForm').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
		message: 'El valor no es valido.',
        feedbackIcons: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-times'
        },
        fields: {

        	imei: {
                validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    stringLength: {
                        min: 14,
                        max: 15,
                        message: 'Debe de tener de 14 a 15 caracteres.'
                    },
                    /*imei: {
                        message: 'No es un valor valido para un IMEI.'
                    },*/
                }
            }
        }
    }).on('error.form.bv', function(e) {
       console.log("Error en el formulario!!");
	   
    }).on('success.form.bv', function(e) {
        console.log("Success en el formulario!!");
	
		var datos = {
				idDispositivo : $('#idDispositivo').val(),
				distSim: {
			    	idSim : '3'
				  },
				afstContrato : {
					idContrato : '1'
				  },
				imei : $('#imei').val(),
		};
		
        var urlSet = "/org/setDispositivo";
        var urlLoad = getUrlCallBackLoad(path);

    	$().setEntity(datos, urlSet, urlLoad);
    }); 	
});