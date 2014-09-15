$(document).ready(function() {
  
   /*$('#inicio_contrato').datetimepicker({
        pickTime: false,
		format: 'YYYY-MM-DD',
		language: 'en',
		minDate: new Date()});*/

    $('#contratoForm').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
		message: 'El valor no es valido.',
        feedbackIcons: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-times'
        },
        fields: {

			nombre_contrato: {
                validators: {
                    notEmpty: {
                        message: 'Es requrido, no puede quedar vacio.'
                    },
                    stringLength: {
                        min: 6,
                        max: 45,
                        message: 'Debe de tener de 6 a 45 caracteres.'
                    },
					regexp: {
                        regexp: /^[a-zA-Z0-9\.\s\-]+$/,
                        message: ''
                    },
                }
            }
        }
    }).on('error.form.bv', function(e) {
       console.log("Error en el formulario!!");
	   
    }).on('success.form.bv', function(e) {
        console.log("Success en el formulario!!");
        
        var clave = "";	
        var idContrato = $('#idContrato').val();
        
        //si va a ser alta de contrato generamos una clave unica (anio mes dia hr min seg concatenados)
        if(idContrato == null || idContrato == "")
		{
			clave = new Date();
			clave = clave.getFullYear()+""+(clave.getMonth()+1)+""+clave.getDate()+""+clave.getHours()+""+clave.getMinutes()+""+clave.getSeconds();
		}
		
		var datos = {
				idContrato : $('#idContrato').val(),
				noContrato : clave,
				nomContrato : $('#nombre_contrato').val(),
				inicioContrato : "2014-10-10",
				plazo : $('#plazo_contrato').val(),
				noUnidades : "0",
				afstCliente: {
					idCliente : $('#idCliente').val()
				  }
		};
		
        var urlSet = "/org/setContrato";
        //var urlLoad = "getContratos/"+$('#idCliente').val();
        var urlLoad = getUrlCallBackLoad(path);
        
        console.log(datos);
    	$().setEntity(datos, urlSet, urlLoad);
    });
});