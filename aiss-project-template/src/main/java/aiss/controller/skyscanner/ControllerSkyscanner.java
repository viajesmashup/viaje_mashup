package aiss.controller.skyscanner;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import aiss.model.resources.SkyscannerResources;
import aiss.model.skyscanner.Flights;

/**
 * Servlet implementation class ControllerSkyscanner
 */
public class ControllerSkyscanner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SkyscannerResources.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerSkyscanner() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * Servlet implementation class ControllerSkyscanner
		 */

		RequestDispatcher rd = null;
		SkyscannerResources skyscannerResource = new SkyscannerResources();

		Flights flights = skyscannerResource.getLugar("FR");
		request.setAttribute("flights", flights);
		//response.getWriter().append("ID es: " + flights.getQuotes().get(0).getQuoteId());

		log.log(Level.FINE, "Buscando la ruta de la ciudad: ");

		rd = request.getRequestDispatcher("/vuelos.jsp");

		rd.forward(request, response);

		log.log(Level.FINE, "Se redirije a la vista: ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
