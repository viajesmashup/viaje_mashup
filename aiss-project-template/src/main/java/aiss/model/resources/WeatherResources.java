package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.weather.Clouds;
import aiss.model.weather.Coord;
import aiss.model.weather.Main;
import aiss.model.weather.Sys;
import aiss.model.weather.Weather;
import aiss.model.weather.Weather_;
import aiss.model.weather.Wind;

public class WeatherResources {

	private static final String WEATHER_API_KEY = "3f2978eb3246c86133b448b0ea38ea45";
	private static final Logger log = Logger.getLogger(WeatherResources.class.getName());

	public Weather getWeather(String ciudad) throws UnsupportedEncodingException {

			String encodeQuery = URLEncoder.encode(ciudad, "UTF-8");

			String uri = "http://api.openweathermap.org/data/2.5/forecast?q="+encodeQuery+"&cnt=20"
					+ "&APPID="+WEATHER_API_KEY;

			ClientResource cr = new ClientResource(uri);
		
			log.log(Level.INFO, uri);
			

			return cr.get(Weather.class);
			
	}
		

}
