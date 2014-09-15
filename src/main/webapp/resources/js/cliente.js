$(document).ready(function() {

    $('#clienteForm').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
		message: 'El valor no es valido.',
        feedbackIcons: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-times'
        },
        fields: {
		
            nombre: {
					validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: 'Debe de tener de 4 a 30 caracteres.'
                    },
                    regexp: {
                        regexp: /^[\w.+\-\sÒ—Ò·ÈÌÛ˙¡…Õ”⁄]+$/,
                        message: ''
                    }
                }
            },
            contacto: {
                validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: 'Debe de tener de 4 a 30 caracteres.'
                    },
                    regexp: {
                        regexp: /^[\w.+\-\sÒ—Ò·ÈÌÛ˙¡…Õ”⁄,]+$/,
                        message: ''
                    },
                }
            },
            telefono: {
                validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    stringLength: {
                        min: 6,
                        max: 10,
                        message: 'Debe de tener de 6 a 10 caracteres.'
                    },
                    numeric: {
                        message: 'Tecle un telefono valido.'
                    },
                    different: {
                        field: 'movil',
                        message: 'Debe ser diferente al movil.'
                    }
                }
            },
            movil: {
                validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    stringLength: {
                        min: 6,
                        max: 10,
                        message: 'Debe de tener de 6 a 10 caracteres.'
                    },
                    numeric: {
                        message: 'Tecle un telefono valido.'
                    },
                    different: {
                        field: 'telefono',
                        message: 'Debe ser diferente al telefono.'
                    }
                }
            },
            mail: {
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
        //Damos de alta el cliente
        var datos = {
				idCliente : $('#idCliente').val(),
				nombre : $('#nombre').val(),
				contacto : $('#contacto').val(),
				telefono : $('#telefono').val(),
				movil : $('#movil').val(),
				mail : $('#mail').val(),
				afstGpoemp : {
					idGpoemp : $('#idGpoemp').val()
				  }
		};
        var urlSet = "/org/setCliente";
        var urlLoad = "getClientes";
        //var urlLoad = getUrlCallBackLoad(path);
        
    	$().setEntity(datos, urlSet, urlLoad);
    });
    
});