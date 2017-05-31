package com.as.samples;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * Servlet implementation class Madurez
 */
@WebServlet("/Madurez")
public class Madurez extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Madurez() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Served at: ").append(request.getContextPath());
		MongoClient mongoClient = null;
		 mongoClient = new MongoClient( "localhost" , 27017 );
		 DB db = mongoClient.getDB( "datos" );
		 DBCollection collection = db.getCollection("Tokens");
		 
		 DBCursor cursor = collection.find();
		 ArrayList<tokens> idesitos = new ArrayList<tokens>();
		while(cursor.hasNext()) {
		   //System.out.println(cursor.next().get("id"));
		    tokens ids = new tokens();
		    ids.setTokens(cursor.next().get("id").toString());
		    idesitos.add(ids);
		}
		
		DBCollection collectionCount = db.getCollection("contratos");
		 
		int count = collectionCount.find().count();
		System.out.println("idesitos:");
		System.out.println(idesitos);
		request.setAttribute("tokens_total", idesitos);
		request.setAttribute("registros_totales", count);
		RequestDispatcher view = request.getRequestDispatcher("html/opendata2.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
