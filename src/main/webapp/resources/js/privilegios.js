$(document).ready(function() {

	$("#gurdarPrivilegios").click(function(){
		
		var privilegios = [];
		
		//obtenemos los checkbox(privilegios) selecciondados y los almacenamos en un array JSON
		$('ul li input:checkbox').each(function(){
			var $input = $(this);
			
			if($input.is(":checked"))
			{
				//2 maneras de extraer nodos JSON complejos
				//console.log("(1)Modulo : "+privilegios[i-1]['ptlcModulo']['idModulo']);
				//console.log("(2)Modulo : "+privilegios[i-1].ptlcModulo['idModulo']);
				
				var datos = {
						ptlcModulo : {
							idModulo : $input.data('modulo')
						  },
						ptlcFuncion : {
							idFun : $input.data('funcion')
						  },
						usutGpousu : {
							idGpousu : $('#idGpoUsuPrivilegios').val()
						  },
						alta : '',
						baja : '',
						cambio : '',
						consulta : ''
					};
				datos = setOperacion($input.data('operacion'), datos);
				privilegios.push(datos);				
			}
		});
				
        var urlSet = "/org/setPrivilegios";
        var urlLoad = getUrlCallBackLoad(path);
        
    	$().setEntity(privilegios, urlSet, urlLoad);
	});
	
	//Hace un set al JSON de privilegios de la propiedad(alta, baja, cambio o consulta segun sea el caso)
	function setOperacion(op, datos)
	{
		//alta
		if(op == 1){
			datos['alta'] = op;
		}
		//baja
		else if(op == 2){
			datos['baja'] = op;
		}
		//cambio
		else if(op == 3){
			datos['cambio'] = op;	
		}
		//consulta
		else{
			datos['consulta'] = op;	
		}

		return datos;
	}
	
});