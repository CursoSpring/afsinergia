<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="resources/img/favicon.ico">
<title>Principal</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/jansy-bootstrap/jasny-bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/navmenu-reveal.css" rel="stylesheet">
<link href="resources/css/mapas/mapa.css" rel="stylesheet">
<link href="resources/css/principal.css" rel="stylesheet">

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
</head>

<body>

	<div class="navmenu navmenu-default navmenu-fixed-left">
		<a class="navmenu-brand" href="#">Project name</a>
		<ul class="nav navmenu-nav">
			<li class="active"><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
		</ul>
	</div>

	<div class="canvas">
		<div class="navbar navbar-default navbar-fixed-top">
			<button id="menuLateral" type="button" class="navbar-toggle" data-toggle="offcanvas" data-recalc="false" data-target=".navmenu" data-canvas=".canvas">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
		</div>

		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<div class="navbar navbar-default" role="navigation">
						<div class="container-fluid">
							
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
								<button id="menuPrincipal" type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle close">
									<span class="sr-only">Toggle navigation</span> 
									<span  class=".hidden-lg" class=".hidden-md" class="icon-bar"></span>
									<span  class=".hidden-lg" class=".hidden-md" class="icon-bar"></span>
									<span  class=".hidden-lg" class=".hidden-md" class="icon-bar"></span>
								</button>
							</div>
							
							<!-- Collection of nav links and other content for toggling -->
							<div id="navbarCollapse" class="collapse navbar-collapse">
								<ul class="nav navbar-nav navbar-right">
									<li class="active">
										<button id="botonHome" type="button" class="btn btn-link">Home</button>
									</li>

									<li>
										<button id="botonAlarmas" type="button" class="btn btn-link"> Alarmas</button>
									</li>

									<li>
										<button id="botonReportes" type="button" class="btn btn-link"> Reportes</button>
									</li>

									<li>
										<button id="botonAdmin" type="button" class="btn btn-link"> Admin</button>
									</li>

								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xs-12" style="background-color: FFFFFF; layer-background-color: #FFFFFF;">
					<div class="row" style="background-color: FFFFFF; layer-background-color: #FFFFFF;">
						<div class="col-md-12" id="map-canvas"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.container -->
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type='text/javascript' src="resources/js/bootstrap/bootstrap.min.js"></script>
	<script type='text/javascript' src="resources/js/jansy-bootstrap/jasny-bootstrap.min.js"></script>
	<script type='text/javascript' src="resources/js/mapas/mapa.js"></script>
	<script type='text/javascript' src="resources/js/principal.js"></script>
</body>
</html>