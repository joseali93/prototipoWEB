<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Prototipo </title>

    <!-- Bootstrap -->
    <link href="http://localhost:8080/prototipoWEB/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="http://localhost:8080/prototipoWEB/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="http://localhost:8080/prototipoWEB/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="http://localhost:8080/prototipoWEB/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    
    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa fa-cogs"></i> <span>Prototipo</span></a>
            </div>

            <div class="clearfix"></div>

          
            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a href="/prototipoWEB/html/IngresoDatos.jsp"><i class="fa fa-database"></i> Ingreso datos </a>
                   
                  </li>
                  <li><a href="/prototipoWEB/Metricas"><i class="fa fa-bar-chart"></i> Calidad </span></a>
                   
                  </li>
                  <li><a href="/prototipoWEB/html/opendata.html"><i class="fa fa-check-square-o"></i> Madurez </a>
                   
                  </li>
                  
                </ul>
              </div>
              

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
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
    <div class="panel-heading">Ingrese losID´S</div>
    <div class="panel-body">
    	<form method="post" action="/prototipoWEB/recibirDatosServlet">
        <div class="text-center"> <h1>Ingrese los ID´s</h1></div>
        <div class="row">
        	<div class="col-md-3 col-md-offset-3">Ingrese los ID´S:Los id´s deben ir separados por comas (xxxx,xxxx,xxxx)
								<input type="text" name="ids" class="form-control">
			</div>
        	<div class="col-md-3">Ingrese el dominio:<br><br>
								<input type="text" name="domain" class="form-control"><br>
			</div>
        	<div class="col-md-1"><br><br><input type="submit" value="enviar" class="form-control"></div>
        </div>
        </form>
    
    
    </div>
  </div>
</div>
        
          
         
	        		
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="http://localhost:8080/prototipoWEB/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="http://localhost:8080/prototipoWEB/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <!-- Custom Theme Scripts -->
    <script src="http://localhost:8080/prototipoWEB/build/js/custom.min.js"></script>

  </body>
</html>