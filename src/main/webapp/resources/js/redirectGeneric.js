$(document).ready(function() {
	
	//para las tablas que tienen link en tr de las tablas, la siguiente funcion permite cargar la agina en funcion del href
	$('tbody tr[data-href]').addClass('clickable').click( function() {

		if($(this).attr('data-href') != null && $(this).attr('data-href') != "")
		{
			//si el 1er caracter de path es '/' lo quitamos remplazandolo por ''
			path = $(this).attr('data-href');
			path = path.substr(0,1)=='/'?path.replace('/', ''):path;
			alert(path);
			setUrlCallBackLoad(path);
			//$("#listCamino").append('<li><a href='+path+'>'+path+'</a></li>');
			//$("#listCamino").append('<li><button type="button" class="btn btn-link load" id='+path+'_>'+path+'</button></li>');
			$("#pruebaDivContenedor").load(path);
		}
	}).find('a').hover( function() {
		$(this).parents('tr').unbind('click');
	}, function() {
		$(this).parents('tr').click( function() {

			if($(this).attr('data-href') != null && $(this).attr('data-href') != "")
			{
				//si el 1er caracter de path es '/' lo quitamos remplazandolo por ''
				path = $(this).attr('data-href');
				path = path.substr(0,1)=='/'?path.replace('/', ''):path; 
				alert(path);
				setUrlCallBackLoad(path);
				//$("#listCamino").append('<li><a href='+path+'>'+path+'</a></li>');
				//$("#listCamino").append('<li><button type="button" class="btn btn-link load" id='+path+'_>'+path+'</button></li>');
				$("#pruebaDivContenedor").load(path);
			}
		});
	});
	
	
	/*$("#listCamino li a").click(function(){
		var $btn = $(this);
		
		//var url = $btn.attr('id');
		var url = $btn.attr('href');
		$btn.attr('href','#');
		//url = url.substring(0, url.length-1);
		console.log("url = "+url);
		$("#pruebaDivContenedor").load(url);
	});*/
	
});