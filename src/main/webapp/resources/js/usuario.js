$(document).ready(function() {
	
    $('#usuarioForm').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
		message: 'El valor no es valido.',
        feedbackIcons: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-times'
        },
        fields: {

        	usuario: {
                validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    stringLength: {
                        min: 5,
                        max: 15,
                        message: 'Debe de tener de 5 a 15 caracteres.'
                    },
					regexp: {
                        regexp: /^[a-zA-Z\w]+$/,
                        message: 'Acepta letras, numeros. sin espacios'
                    },
                }
            },
            clave: {
                validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    identical: {
                        field: 'claveConfirm',
                        message: 'Debe de ser identico a la confirmacion.'
                    },
                    stringLength: {
                        min: 4,
                        max: 15,
                        message: 'Debe de tener de 4 a 15 caracteres.'
                    },
					regexp: {
                        regexp: /^[a-zA-Z\w]+$/,
                        message: 'Acepta letras, numeros y caracteres especiales'
                    },
                }
            },
            claveConfirm: {
                validators: {
                    identical: {
                        field: 'clave',
                        message: 'Debe de ser identico a la clave.'
                    }
                }
            },
            nombre: {
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
            apePat: {
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
            apeMat: {
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
            }
        }
    }).on('error.form.bv', function(e) {
       console.log("Error en el formulario!!");
	   
    }).on('success.form.bv', function(e) {
        console.log("Success en el formulario!!");
	
        var status = "INACTIVE";
        //si es activo
        if($('#status').is(':checked'))
        	status = "ACTIVE";
        
        console.log("status del usuario: "+status);

		var datos = {
				idUsuario : $('#idUsuario').val(),
				usuario : $('#usuario').val(),
				nombre : $('#nombre').val(),
				apePat : $('#apePat').val(),
				apeMat : $('#apeMat').val(),
				clave : $('#clave').val(),
				status : status,
				usutGpousu: {
					idGpousu : $('#gpoUsu').val()
				  }
		};
		
        var urlSet = "/org/setUsuario";
        var urlLoad = getUrlCallBackLoad(path);


		alert("---------"+getUrlCallBackLoad(path));
        
    	$().setEntity(datos, urlSet, urlLoad);
    }); 	
});