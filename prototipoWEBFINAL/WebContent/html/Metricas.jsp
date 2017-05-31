<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Prototype </title>

  <!-- Bootstrap -->
  <link href="http://54.202.53.71:8080/prototipoWEBFINAL/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome -->
  <link href="http://54.202.53.71:8080/prototipoWEBFINAL/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <!-- NProgress -->
  <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
  <!-- bootstrap-progressbar -->
  <link href="http://54.202.53.71:8080/prototipoWEBFINAL/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
  <!-- bootstrap-daterangepicker -->
  <link href="http://54.202.53.71:8080/prototipoWEBFINAL/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

  <!-- Custom Theme Style -->
  <link href="http://54.202.53.71:8080/prototipoWEBFINAL/build/css/custom.min.css" rel="stylesheet">
    <link href="http://54.202.53.71:8080/prototipoWEBFINAL/build/css/table.css" rel="stylesheet">
</head>
<style> 


</style>
<body class="nav-md">
  <div class="container body">
    <div class="main_container">
      <div class="col-md-3 left_col">
        <div class="left_col scroll-view">
          <div class="navbar nav_title" style="border: 0;">
            <a href="ingresoDatos.jsp" class="site_title"><i class="fa fa-cogs"></i> <span>Prototype</span></a>
          </div>

          <div class="clearfix"></div>


          <br />

          <!-- sidebar menu -->
          <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
              <h3>General</h3>
              <ul class="nav side-menu">
                <li><a href="/prototipoWEBFINAL/html/ingresoDatos.jsp"><i class="fa fa-database"></i> Add data </a>

                </li>
                <li><a href="/prototipoWEBFINAL/html/ingresoEstructuras.jsp"><i class="fa fa-database"></i> Add structure </a>
                   
                  </li>
                <li><a href="/prototipoWEBFINAL/Metricas"><i class="fa fa-bar-chart"></i> Data quality </span></a>

                </li>
                <li><a href="/prototipoWEBFINAL/html/opendata.jsp"><i class="fa fa-check-square-o"></i> Data maturity </a>

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
          <h2>Prototype</h2>
          <div class="panel panel-default">
            <div class="panel-heading">Data quality</div>
            <div class="panel-body">
            <div class="row">
          
              <div class="col-md-3">
                <h2>Completeness</h2>
                  <br>
                  <iframe  scrolling="no" style="border-width:0px;" src="http://54.202.53.71:8081/api/rest/public/process/completness?&amp;width=350&amp;height=400" width="350" height="400"></iframe>
              		Percentage of complete cells and percentage of complete rows.
              </div>
              <div class="col-md-3">
                 <h2>Traceability</h2>
                  <br>
                  <iframe  scrolling="no" style="border-width:0px;" src="http://54.202.53.71:8081/api/rest/public/process/traceability?&amp;width=350&amp;height=400" width="350" height="400"></iframe>
					Percentage of complete data in the repository, data of creation and update.
              </div>
               <div class="col-md-3">
                 <h2>Compliance</h2>
                  <br>
                  <iframe  scrolling="no"  style="border-width:0px;" src="http://54.202.53.71:8081/api/rest/public/process/compliance?&amp;width=350&amp;height=400" width="350" height="400"></iframe>
              		Percentage of columns with a standard (associated format) and percentage of columns that actually comply with this format.
              		
              </div>
              
              
              <div class="col-md-3 ">
                     <table class="table">
                          <tr>
                            <th>Stored datasets</th>
                          </tr>



                          <tr>
                            <td>${registros_totales} </td>

                          </tr>


                        </table>


	
                        <table class="table table-striped">
                        <thead>
                          <tr>
                            <th>Stored datasets</th>
                          </tr>
                          </thead>
                          <tbody>
                          <c:forEach var="ids" items="${tokens_total}">


                          <tr>
                            <td class="filterable-cell"><div class="links"><a href="#"><c:out value="${ids.tokens}"/></a></div> </td>

                          </tr>

                        </c:forEach>
                        </tbody>
                      </table>



              </div>


               
            </div>



           
           




          </div>
        </div>



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


<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Metrics per datasets</h4>
      </div>
      <div class="modal-body">
      
      <div class="row">
	      <div class="col-md-3 col-md-offset-1">
	      	 	Traceability

          		<div class="grafico1"></div>
          		Percentage of complete data in the repository, data of creation and update.
	      </div>
	      <div class="col-md-3">
	      		Completeness

         		<div class="grafico2"></div>
	      		Percentage of complete cells and percentage of complete rows.
	      </div>
	      <div class="col-md-3 ">
	      
	      		
         		Compliance
          		<div class="grafico3"></div>
          		Percentage of columns with a standard (associated format) and percentage of columns that actually comply with this format.
	      		
	      </div>
	    </div>
        <p>
        
          
        </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

<!-- jQuery -->
<script src="http://54.202.53.71:8080/prototipoWEBFINAL/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="http://54.202.53.71:8080/prototipoWEBFINAL/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<!-- Custom Theme Scripts -->
<script src="http://54.202.53.71:8080/prototipoWEBFINAL/build/js/custom.min.js"></script>

<script>

  $('.links').click(function(){


    $('.grafico1').empty();
    $('.grafico2').empty();
    $('.grafico3').empty();
    
    $('.grafico1').append('<iframe scrolling="no" style="border-width:0px;" src="http://54.202.53.71:8081/api/rest/public/process/traceability2?parametroid='+$(this).children().html()+'&amp;width=400&amp;height=300" width="400" height="300"></iframe>');
    $('.grafico2').append('<iframe scrolling="no" style="border-width:0px;" src="http://54.202.53.71:8081/api/rest/public/process/completness2?parametroid='+$(this).children().html()+'&amp;width=400&amp;height=300" width="400" height="300"></iframe>');
    $('.grafico3').append('<iframe scrolling="no" style="border-width:0px;" src="http://54.202.53.71:8081/api/rest/public/process/compliance2?parametroid='+$(this).children().html()+'&amp;width=400&amp;height=300" width="400" height="300"></iframe>');
    $('#myModal').modal("show");

  });



</script>

</body>
</html>