package com.as.samples;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			response.sendRedirect("jsp/Respuesta.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}