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
					accion : $input.data('accion')
				};
				
				privilegios.push(datos);
				console.log("VHM: "+JSON.stringify(datos));
			}
		});
		
		/*console.log("elementos "+privilegios.length);
		
		for(var i=0;i<privilegios.length;i++)
			console.log(JSON.stringify(privilegios[i]));*/
		
        var urlSet = "/org/setPrivilegios";
        var urlLoad = getUrlCallBackLoad(path);
        
    	$().setEntity(privilegios, urlSet, urlLoad);
	});
	
});