package aiss.model.resources;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.weather.Weather;

public class WeatherResourcesTest {

	private static final String WEATHER_CONSULTA = "Paris";

	static WeatherResources sr = new WeatherResources();

	@Test
	public void testGetWeather() throws UnsupportedEncodingException {
		Weather weather = sr.getWeather(WEATHER_CONSULTA);

		assertEquals("The id of the weather does not match", WEATHER_CONSULTA, weather.getCity().getName());
		// Show result
		System.out.println("Name city: " + weather.getCity().getName());
		System.out.println("Country: " + weather.getCity().getCountry());
		System.out.println("Date and Time: " + weather.getList().get(0).getDt_txt());
		System.out.println("Temperature: " + weather.getList().get(0).getMain().getTemp());
		System.out.println("Minimum temperature: " + weather.getList().get(0).getMain().getTemp_min());
		System.out.println("Maximum temperature: " + weather.getList().get(0).getMain().getTemp_max());

	}
}
