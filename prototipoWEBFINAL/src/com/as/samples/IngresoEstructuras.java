package com.as.samples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.socrata.api.HttpLowLevel;
import com.socrata.api.Soda2Consumer;
import com.sun.jersey.api.client.ClientResponse;

/**
 * Servlet implementation class IngresoEstructuras
 */
@WebServlet("/IngresoEstructuras")
public class IngresoEstructuras extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresoEstructuras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String ids = request.getParameter("campos");
		String dominio = request.getParameter("dominio");
		mongoDB insertar = new mongoDB();
		Ingreso ingre = new Ingreso();
		validarEstructura valestruc = new validarEstructura();
		
		try {
			MetaData meta = new MetaData();
			List<String> al = new ArrayList<>();
			 JSONArray jsonarr = new JSONArray(meta.jsonGetRequest(ids, null,dominio));
			 JSONObject jsonobj2 = jsonarr.getJSONObject(0);
			 JSONArray jsonarr2 = jsonobj2.getJSONArray("columns");
			 System.out.println(jsonarr2.length());
			 for(int i = 0; i < jsonarr2.length(); i++){
				
			    
				JSONObject jsonobj3 = jsonarr2.getJSONObject(i);
			    al.add(jsonobj3.get("fieldName").toString());
			    
			 }
			
			
			
			//Set<String> hs = new HashSet<>();
			//hs.addAll(keys1);
			
		
		
			Collections.sort(al);
			
			System.out.println("1");
			if(valestruc.validacion(al)){
				System.out.println("2");
				request.getSession().setAttribute("mensaje", "This structure already exists");
				System.out.println("3");
			}else{
				System.out.println("4");
				insertar.insertarEstructura(ids,dominio);
				System.out.println("5");
				request.getSession().setAttribute("mensaje", "Properly inserted structure");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("6");
		response.sendRedirect("jsp/Respuesta.jsp");
	}

}
