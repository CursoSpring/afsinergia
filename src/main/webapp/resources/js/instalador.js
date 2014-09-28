$(document).ready(function() {
	
    $('#instaladorForm').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
		message: 'El valor no es valido.',
        feedbackIcons: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-times'
        },
        fields: {

        	nombreInstalador: {
                validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: 'Debe de tener de 3 a 20 caracteres.'
                    },
					regexp: {
                        regexp: /^[a-zA-Z\u00E0-\u00FC\s]+$/,
                        message: 'Solo acepta letras'
                    },
                }
            },
            appInstalador: {
                validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: 'Debe de tener de 3 a 20 caracteres.'
                    },
					regexp: {
                        regexp: /^[a-zA-Z\u00E0-\u00FC\s]+$/,
                        message: 'Solo acepta letras'
                    },
                }
            },
            apmInstalador: {
                validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: 'Debe de tener de 3 a 20 caracteres.'
                    },
					regexp: {
                        regexp: /^[a-zA-Z\u00E0-\u00FC\s]+$/,
                        message: 'Solo acepta letras'
                    },
                }
            },
            correoInstalador: {
                validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    emailAddress: {
                        message: 'El e-mail ingresado no es valido'
                    }
                }
            }
        }
    }).on('error.form.bv', function(e) {
       console.log("Error en el formulario!!");
	   
    }).on('success.form.bv', function(e) {
        console.log("Success en el formulario!!");
	
		var datos = {
				idInstalador : $('#idInstalador').val(),
				nombre : $('#nombreInstalador').val(),
				paterno : $('#appInstalador').val(),
				materno : $('#apmInstalador').val(),
				correo : $('#correoInstalador').val(),
				
				afstCliente: {
					idCliente : $('#idCliente').val()
				  }
		};
		
        var urlSet = "/org/setInstalador";
        var urlLoad = getUrlCallBackLoad(path);

        console.log(JSON.stringify(datos));
        
    	$().setEntity(datos, urlSet, urlLoad);
    }); 	
});