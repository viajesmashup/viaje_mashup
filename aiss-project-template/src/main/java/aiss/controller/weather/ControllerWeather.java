package aiss.controller.weather;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Estamos en controlador de weather: ").append(request.getContextPath());
		
		/*
		 * String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Search for albums in Spotify
		log.log(Level.FINE, "Searching for Spotify albums of " + query);
		SpotifyResource spotify = new SpotifyResource();
		AlbumSearch spotifyResults = spotify.getAlbums(query);
		 * 
		 * 
		 * 
		 */

		RequestDispatcher rd = null;
		WeatherResources weatherResources = new WeatherResources();
		
		
		Weather weather = weatherResources.getWeather("London");
		request.setAttribute("weathers", weather);
		response.getWriter().append("ID es: "+weather.getWeather()).append(request.getContextPath());
		
		log.log(Level.FINE, "Buscando el tiempo de la ciudad: " );
		
		rd = request.getRequestDispatcher("/weather.jsp");
		
		rd.forward(request, response);
		
		log.log(Level.FINE, "Se redirije a la vista: " );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
