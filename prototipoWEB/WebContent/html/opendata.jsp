<!DOCTYPE html>
<html lang="en">
<%@ page import= "com.as.samples.mongoDB" %> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Prototipo</title>

<!-- Bootstrap -->
<link
	href="http://localhost:8080/prototipoWEB/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="http://localhost:8080/prototipoWEB/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- bootstrap-progressbar -->
<link
	href="http://localhost:8080/prototipoWEB/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link
	href="http://localhost:8080/prototipoWEB/vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="http://localhost:8080/prototipoWEB/build/css/custom.min.css"
	rel="stylesheet">
	
	<style>
table {
    width:100%;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color:#fff;
}
table#t01 th {
    background-color: black;
    color: white;
}
</style>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-cogs"></i>
							<span>Prototipo</span></a>
					</div>

					<div class="clearfix"></div>


					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>General</h3>
							<ul class="nav side-menu">
								<li><a href="/prototipoWEB/html/ingresoDatos.jsp"><i
										class="fa fa-database"></i> Ingreso datos </a></li>
								<li><a href="/prototipoWEB/Metricas"><i
										class="fa fa-bar-chart"></i> Calidad </span></a></li>
								<li><a href="/prototipoWEB/html/opendata.jsp"><i
										class="fa fa-check-square-o"></i> Madurez </a></li>

							</ul>
						</div>


					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Settings">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
							<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Logout"
							href="login.html"> <span class="glyphicon glyphicon-off"
							aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>

						<br>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">



				<div class="container">
					<h2>Prototipo</h2>
					<div class="panel panel-default">
						<div class="panel-heading">Calidad</div>
						<div class="panel-body">
							<ul class="nav" id="main-menu">
								<li><a href="/prototipoWEB/html/opendata.jsp"> <i
										class="fa fa-table "></i>General <span class="badge"></span></a></li>
								<li><a href="/prototipoWEB/html/opendata2.html"> <i
										class="fa fa-bar-chart-o"> </i>Individual<span class="badge"></span></a>
								</li>
							</ul>

							<h1>General</h1>
							
							<%
								mongoDB mdb = new mongoDB();
								//out.write("<table> <tr> <th> Nombre set </th> <th> Token </th> </tr>");
								
								out.write(mdb.consultaids());						
							%>
							
							<h2>Complete</h2>
							<br>
							 <iframe  scrolling="no" style="border-width:0px;" src="http://Jose-XPS:8980/api/rest/public/process/completos%20general?"  width="550" height="400"></iframe>
							<br>
							<h2>Primary</h2>
							 <iframe  scrolling="no" style="border-width:0px;" src="http://Jose-XPS:8980/api/rest/public/process/primarios%20general?"  width="550" height="400"></iframe>
							<br>
							<h2>Timely</h2>
							<br>
							 <iframe  scrolling="no" style="border-width:0px;" src="http://Jose-XPS:8980/api/rest/public/process/timely?"  width="550" height="400"></iframe>
							<br>
							<h2>Accessible</h2>
							 <iframe  scrolling="no" style="border-width:0px;" src="http://Jose-XPS:8980/api/rest/public/process/accesibles?"  width="550" height="400"></iframe>
							<br>
							<h2>Machine Processable</h2>
							<iframe  scrolling="no" style="border-width:0px;" src="http://Jose-XPS:8980/api/rest/public/process/machine_proccesable?"  width="550" height="400"></iframe>
							<br>
							<h2>Non-Discriminatory</h2>
							<iframe  scrolling="no" style="border-width:0px;" src="http://Jose-XPS:8980/api/rest/public/process/nodiscrimimatorio%20general?"  width="550" height="400"></iframe>
							<br>
							<h2>Non-Proprietary</h2>
							<iframe  scrolling="no" style="border-width:0px;" src="http://Jose-XPS:8980/api/rest/public/process/no%20propietario%20general?"  width="550" height="400"></iframe>
							<br>
							<h2>License Free</h2>
							<iframe  scrolling="no" style="border-width:0px;" src="http://Jose-XPS:8980/api/rest/public/process/license%20general?"  width="550" height="400"></iframe>

							<br>



						</div>
					</div>



				</div>
			</div>






		</div>
		<!-- /page content -->

		<!-- footer content -->
		<footer>
			<div class="pull-right">
				Gentelella - Bootstrap Admin Template by <a
					href="https://colorlib.com">Colorlib</a>
			</div>
			<div class="clearfix"></div>
		</footer>
		<!-- /footer content -->
	</div>
	</div>




	<!-- jQuery -->
	<script
		src="http://localhost:8080/prototipoWEB/vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="http://localhost:8080/prototipoWEB/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<!-- Custom Theme Scripts -->
	<script src="http://localhost:8080/prototipoWEB/build/js/custom.min.js"></script>