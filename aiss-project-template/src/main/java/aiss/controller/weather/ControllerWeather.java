package aiss.controller.weather;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.generic.Busqueda;
import aiss.model.resources.WeatherResources;
import aiss.model.weather.Weather;

/**
 * Servlet implementation class ControllerWeather
 */
public class ControllerWeather extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ControllerWeather.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerWeather() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String destino = request.getParameter("destino");

		if (destino == null || destino.isEmpty())
			destino = "madrid";

		log.log(Level.FINE, "Buscando el tiempo de la ciudad: " + destino);

		Busqueda busqueda = new Busqueda(destino);
		RequestDispatcher rd = null;

		try {

			WeatherResources weatherResources = new WeatherResources();
			Weather weather = weatherResources.getWeather(destino);
			if (weather != null && weather.getList().size() > 0) {

				request.setAttribute("weathers", weather);
				request.setAttribute("busqueda", busqueda);

				rd = request.getRequestDispatcher("/weather.jsp");
			}

		} catch (Exception e) {

			request.setAttribute("busqueda", busqueda);
			rd = request.getRequestDispatcher("/errorWeather.jsp");

		}
		log.log(Level.FINE, "Se redirije a la vista: ");
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
