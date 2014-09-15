$(document).ready(function() {
	
    $('#flotillaForm').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
		message: 'El valor no es valido.',
        feedbackIcons: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-times'
        },
        fields: {

        	nombreFlotilla: {
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
                        regexp: /^[a-zA-Z\u00E0-\u00FC0-9\.\s]+$/,
                        message: ''
                    },
                }
            }
        }
    }).on('error.form.bv', function(e) {
       console.log("Error en el formulario!!");
	   
    }).on('success.form.bv', function(e) {
        console.log("Success en el formulario!!");
	
		var datos = {
				idFlotilla : $('#idFlotilla').val(),
				nombre : $('#nombreFlotilla').val(),
				afstContrato: {
					idContrato : $('#idContrato').val()
				  }
		};
		
        var urlSet = "/org/setFlotilla";
        var urlLoad = getUrlCallBackLoad(path);

    	$().setEntity(datos, urlSet, urlLoad);
    }); 	
});