package aiss.controller.zomato;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.controller.bing.ControllerBing;
import aiss.model.generic.Busqueda;
import aiss.model.resources.ZomatoResources;
import aiss.model.zomato.Zomato;

/**
 * Servlet implementation class ControllerZomato
 */
public class ControllerZomato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ControllerBing.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerZomato() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;

		String destino = request.getParameter("destino");
		
		
		if(destino==null || destino.isEmpty())
			destino="paris";
		Busqueda busqueda = new Busqueda(destino);

		// Search for photo in Bing
		log.log(Level.FINE, "Searching for Zomato: " + destino);
		ZomatoResources zomato = new ZomatoResources();
		Zomato zomatoResults = zomato.getZomato(destino);

		request.setAttribute("zomato", zomatoResults);
		request.setAttribute("busqueda", busqueda);
		log.log(Level.FINE, "Searching for Zomato: " +destino);
		rd = request.getRequestDispatcher("/restaurantes.jsp");

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
