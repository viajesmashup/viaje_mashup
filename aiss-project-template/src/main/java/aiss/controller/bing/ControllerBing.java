package aiss.controller.bing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.bing.Photo;
import aiss.model.resources.BingResources;

/**
 * Servlet implementation class ControllerBing
 */
public class ControllerBing extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ControllerBing.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerBing() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private String paisRandom() {
		Integer numero = (int) (Math.random() *7);
		List<String> listaPais = new ArrayList<>();
		listaPais.add("Madrid");
		listaPais.add("Barcelona");
		listaPais.add("Londres");
		listaPais.add("Lisboa");
		listaPais.add("Roma");
		listaPais.add("Valencia");
		listaPais.add("Nueva York");
		listaPais.add("Lisboa");
		return listaPais.get(numero);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String query = request.getParameter("destino");
		
		if (query == null || query.isEmpty()) {
			query = paisRandom();
		}
		
		
		

		// Search for photo in Bing
		log.log(Level.FINE, "Searching for BingImagenes Imagen of " + query);
		BingResources bing = new BingResources();
		Photo photoResults = bing.getBingPhotos(query);

		if (photoResults != null) {
			request.setAttribute("photos", photoResults);
			rd = request.getRequestDispatcher("/imagenes.jsp");

		} else {
			log.log(Level.SEVERE, "Bing object: " + photoResults);
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
