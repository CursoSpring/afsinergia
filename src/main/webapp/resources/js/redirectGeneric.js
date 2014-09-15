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
			//$("#listCamino").append('<li><a href='+path+' onclick ='+alert("aaa")+'>'+path+'</a></li>');
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
				//$("#listCamino").append('<li><a href='+path+' onclick ='+alert("aaa")+'>'+path+'</a></li>');
				$("#pruebaDivContenedor").load(path);
			}
		});
	});
	
});