package com.as.samples;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Metricas
 */
@WebServlet("/Metricas")
public class Metricas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Metricas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	
		request.setAttribute("tokens_total", idesitos);
		request.setAttribute("registros_totales", count);
		RequestDispatcher view = request.getRequestDispatcher("html/Metricas.jsp");
		view.forward(request, response);
		 
		
		//response.sendRedirect("jsp/Respuesta.jsp");
		 /*
		ArrayList<tokens> tokens = new ArrayList<tokens>();
		while (resultSet.next()) {
		    User user = new User();
		    user.setActionTime(resultSet.getString("action_time"));
		    user.setUserAction(resultSet.getString("user_action"));
		    user.setUserId(resultSet.getString("user_ip"));
		    user.setUserIp(resultSet.getString("user_id"));
		    users.add(user);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
