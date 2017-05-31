<!DOCTYPE html>
<html lang="en">
<%@ page import= "com.as.samples.mongoDB" %> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Prototype</title>

<!-- Bootstrap -->
<link
	href="http://54.202.53.71:8080/prototipoWEBFINAL/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="http://54.202.53.71:8080/prototipoWEBFINAL/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- bootstrap-progressbar -->
<link
	href="http://54.202.53.71:8080/prototipoWEBFINAL/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link
	href="http://54.202.53.71:8080/prototipoWEBFINAL/vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="http://54.202.53.71:8080/prototipoWEBFINAL/build/css/custom.min.css"
	rel="stylesheet">
	

</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="ingresoDatos.jsp" class="site_title"><i class="fa fa-cogs"></i>
							<span>Prototype</span></a>
					</div>

					<div class="clearfix"></div>


					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>General</h3>
							<ul class="nav side-menu">
								<li><a href="/prototipoWEBFINAL/html/ingresoDatos.jsp"><i
										class="fa fa-database"></i> Add data </a></li>
										<li><a href="/prototipoWEBFINAL/html/ingresoEstructuras.jsp"><i class="fa fa-database"></i> Add structure </a>
                   
                  </li>
								<li><a href="/prototipoWEBFINAL/Metricas"><i
										class="fa fa-bar-chart"></i> Data quality </span></a></li>
								<li><a href="/prototipoWEBFINAL/html/opendata.jsp"><i
										class="fa fa-check-square-o"></i> Data maturity </a></li>
										

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
								<li><a href="/prototipoWEBFINAL/html/opendata.jsp"> <i
										class="fa fa-table "></i>General <span class="badge"></span></a></li>
								<li><a href="/prototipoWEBFINAL/Madurez"> <i
										class="fa fa-bar-chart-o"> </i>Individual<span class="badge"></span></a>
								</li>
							</ul>

							<h1>General</h1>
							
							
							</table>
							<h2>Complete</h2>
							<br>
							 <iframe  scrolling="no" style="border-width:0px;" src="http://jose-xps:8081/api/rest/public/process/Completes?"  width="550" height="400"></iframe>
							<br>
							<h2>Primary</h2>
							 <iframe  scrolling="yes" style="border-width:0px;" src="http://jose-xps:8081/api/rest/public/process/primarios%20general?"  width="550" height="200"></iframe>
							<br>
							<h2>Timely</h2>
							<br>
							 <iframe  scrolling="yes" style="border-width:0px;" src="http://jose-xps:8081/api/rest/public/process/timely?"  width="550" height="300"></iframe>
							<br>
							<h2>Accessible</h2>
							 <iframe  scrolling="yes" style="border-width:0px;" src="http://jose-xps:8081/api/rest/public/process/accesibles?"  width="550" height="200"></iframe>
							<br>
							<h2>Machine Processable</h2>
							<iframe  scrolling="yes" style="border-width:0px;" src="http://jose-xps:8081/api/rest/public/process/machine_proccesable?"  width="300" height="200"></iframe>
							<br>
							<h2>Non-Discriminatory</h2>
							<iframe  scrolling="yes" style="border-width:0px;" src="http://jose-xps:8081/api/rest/public/process/nodiscrimimatorio%20general?"  width="550" height="400"></iframe>
							<br>
							<h2>Non-Proprietary</h2>
							<iframe  scrolling="yes" style="border-width:0px;" src="http://jose-xps:8081/api/rest/public/process/no%20propietario%20general?"  width="550" height="200"></iframe>
							<br>
							<h2>License Free</h2>
							<iframe  scrolling="yes" style="border-width:0px;" src="http://jose-xps:8081/api/rest/public/process/license%20general?"  width="550" height="200"></iframe>

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
		src="http://54.202.53.71:8080/prototipoWEBFINAL/vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="http://54.202.53.71:8080/prototipoWEBFINAL/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<!-- Custom Theme Scripts -->
	<script src="http://54.202.53.71:8080/prototipoWEBFINAL/build/js/custom.min.js"></script>