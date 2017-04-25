 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Top navbar example for Bootstrap</title>

    <link href="http://localhost:8080/prototipoWEB/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="http://localhost:8080/prototipoWEB/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="http://localhost:8080/prototipoWEB/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
  </head>

  <body>
  <div id="wrapper">
    <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="adjust-nav">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img src="http://localhost:8080/prototipoWEB/img/logo.png" />

                    </a>
                    
                </div>
              
                <span class="logout-spn" >
                  <!-- <a href="#" style="color:#fff;">LOGOUT</a>   -->

                </span>
            </div>
        </div>
  
      <nav class="navbar-default navbar-side" role="navigation">
      <div class="sidebar-collapse">
            
        
          <ul class="nav" id="main-menu">
             <li>
              <a href="/prototipoWEB/html/prototipo.html"><i class="fa fa-bar-chart-o"></i>Prototipo</a>
            </li>
            <li class="active-link">
              <a href="/prototipoWEB/html/IngresoDatos.html"> <i class="fa fa-desktop "></i>Ingreso datos<span class="badge"></span></a>
            </li>
            <li >
              <a href="/prototipoWEB/Metricas"> <i class="fa fa-table "></i>Metricas <span class="badge"></span></a>
            </li>
            <li >
              <a href="/prototipoWEB/html/opendata.html"> <i class="fa fa-bar-chart-o"> </i>Open data</a>
            </li>
          </ul>
        
       </div>
      </nav>
    
      <div id="page-wrapper" >
            <div id="page-inner">
              <div class="container">
              <div class="jumbotron">
              <h1>Metricas</h1>
              <div class="text-center">
                
                 <table class="table">
                	<tr>
                		<th>Conjuntos de datos almacenados</th>
                	</tr>
                	
              
                
		                 <tr>
		                    <td>${registros_totales} </td>
		                  
		                </tr>
		              
            	
            	</table>
                
                
                
                <table class="table">
                <tr>
                	<th>Conjuntos de datos almacenados</th>
                </tr>
                <c:forEach var="ids" items="${tokens_total}">
              
                
                 <tr>
                    <td><div class="links"><c:out value="${ids.tokens}"/></div> </td>
                  
                </tr>
              
            </c:forEach>
            </table>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <h2>Completness</h2>
                  <br>
                  <iframe  scrolling="no" style="border-width:0px;" src="http://jose-xps:8980/api/rest/public/process/completness?&amp;width=500&amp;height=500" width="500" height="500"></iframe>
                </div>
                         <div class="col-md-6">
                         
                          Porcentaje de datos completos en fuente, datos de creacion y actualización.
                          
                         </div>
                     </div>
                     <div class="row">
                         <div class="col-md-6">
                         
                         Porcentaje de celdas completas y porcentaje de filas completas.
                         </div>
                         <div class="col-md-6">
                         <h2>Traceability</h2>
                          <br>
              <iframe  scrolling="no" style="border-width:0px;" src="http://jose-xps:8980/api/rest/public/process/traceability?&amp;width=500&amp;height=500" width="500" height="500"></iframe>
                
                          
                         </div>
                         
                      </div>
                      <div class="row">
                         <div class="col-md-6">
                         
                          <h2>compliance</h2>
                  <br>
              <iframe  scrolling="no"  style="border-width:0px;" src="http://jose-xps:8980/api/rest/public/process/compliance?&amp;width=500&amp;height=500" width="500" height="500"></iframe>
                         </div>
                         <div class="col-md-6">
                          Porcentaje de columnas con un estandar (formato asociado) y porcentaje de columnas que realmente cumplen este formato.
                         </div>
                         
              </div>
                
                
                
                
              </div>
          </div>
            </div>
      </div>      
  </div>
  <script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <script>


  </script>
  
  
  
  <!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
        <p>
        	grafica 1
        	
        		<div class="grafico1"></div>
        	grafica 2
        	
        		<div class="grafico2"></div>
        	grafica 3
        		<div class="grafico3"></div>
        
        </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
  </body>
  
  <script>
  
  $('.links').click(function(){
	  

	  $('.grafico1').empty();
	  $('.grafico2').empty();
	  $('.grafico3').empty();
	  
	  $('.grafico1').append('<iframe scrolling="no" style="border-width:0px;" src="http://jose-xps:8980/api/rest/public/process/traceability2?parametroid='+$(this).html()+'&amp;width=400&amp;height=300" width="400" height="300"></iframe>');
	  $('.grafico2').append('<iframe scrolling="no" style="border-width:0px;" src="http://jose-xps:8980/api/rest/public/process/completness2?parametroid='+$(this).html()+'&amp;width=400&amp;height=300" width="400" height="300"></iframe>');
	  $('.grafico3').append('<iframe scrolling="no" style="border-width:0px;" src="http://jose-xps:8980/api/rest/public/process/compliance2?parametroid='+$(this).html()+'&amp;width=400&amp;height=300" width="400" height="300"></iframe>');
	  $('#myModal').modal("show");
	  
  });
  
  
  
  </script>
</html>
