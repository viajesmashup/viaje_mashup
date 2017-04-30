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

		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		String fechaSalida = request.getParameter("fechaLlegada");
		String fechaLlegada = request.getParameter("fechaSalida");

		Busqueda busqueda = new Busqueda(origen, destino, fechaSalida, fechaLlegada);

		RequestDispatcher rd = null;
		YoutubeResources youtubeResources = new YoutubeResources();

		Youtube youtube = youtubeResources.getVideo(destino);
		request.setAttribute("videos", youtube.getItems());
		request.setAttribute("busqueda", busqueda);

		log.log(Level.FINE, "Buscando vídeos de la ciudad: ");

		rd = request.getRequestDispatcher("/youtube.jsp");

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
