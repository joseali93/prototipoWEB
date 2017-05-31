package com.as.samples;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * Servlet implementation class recibirDatosServlet
*/

public class recibirDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String ids = request.getParameter("ids");
		String domain = request.getParameter("domain");
		Ingreso validacion = new Ingreso();
		try {	
			String resultado = validacion.Ingresar(ids,domain);
			request.getSession().setAttribute("mensaje", resultado);
			MongoClient mongoClient = null;
			 mongoClient = new MongoClient( "localhost" , 27017 );
			 DB db = mongoClient.getDB( "datos" );
			 DBCollection collection = db.getCollection("Estructuras");
			 DBCursor cursor = collection.find();
			 ArrayList<tokens> idesitos = new ArrayList<tokens>();
			while(cursor.hasNext()) {
			   //System.out.println(cursor.next().get("id"));
			    tokens ids1 = new tokens();
			    String campos =cursor.next().get("campos").toString();
			    ids1.setTokens(campos.replace(",", ", "));
			    idesitos.add(ids1);
			}
		
		
			request.setAttribute("estructuras", idesitos);
			
			
			RequestDispatcher view = request.getRequestDispatcher("jsp/Respuesta.jsp");
			view.forward(request, response);
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}