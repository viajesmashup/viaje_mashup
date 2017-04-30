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
import aiss.model.weather.City;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		String fechaSalida = request.getParameter("fechaLlegada");
		String fechaLlegada = request.getParameter("fechaSalida");
		
		Busqueda busqueda = new Busqueda(origen,destino,fechaSalida,fechaLlegada);

		RequestDispatcher rd = null;
		WeatherResources weatherResources = new WeatherResources();
		
		
		Weather weather = weatherResources.getWeather(destino);
		request.setAttribute("weathers", weather);
		request.setAttribute("busqueda", busqueda);
		
		
		
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
