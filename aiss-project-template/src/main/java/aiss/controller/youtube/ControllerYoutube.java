package aiss.controller.youtube;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.controller.weather.ControllerWeather;
import aiss.model.generic.Busqueda;
import aiss.model.google.youtube.Youtube;
import aiss.model.resources.YoutubeResources;

/**
 * Servlet implementation class ControllerYoutube
 */
public class ControllerYoutube extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ControllerWeather.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerYoutube() {
		super();
		// TODO Auto-generated constructor stub
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

		Busqueda busqueda = new Busqueda(destino);
		log.log(Level.FINE, "Buscando vídeos de la ciudad: " + destino);
		RequestDispatcher rd = null;
		YoutubeResources youtubeResources = new YoutubeResources();

		Youtube youtube = youtubeResources.getVideo(destino);

		if (youtube != null && youtube.getItems().size()>0) {
			request.setAttribute("videos", youtube.getItems());
			request.setAttribute("busqueda", busqueda);
			rd = request.getRequestDispatcher("/youtube.jsp");
		} else {
			log.log(Level.SEVERE, "youtube object: " + youtube);
			request.setAttribute("busqueda", busqueda);
			rd = request.getRequestDispatcher("/errorYoutube.jsp");

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
