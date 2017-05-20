package aiss.api.respository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiss.api.model.Picture;
import aiss.api.model.Restaurant;
import aiss.api.model.UserCity;
import aiss.api.model.Video;
import aiss.api.model.Weather;
import aiss.model.bing.Photo;
import aiss.model.bing.Value;
import aiss.model.google.youtube.Item;
import aiss.model.google.youtube.Youtube;
import aiss.model.resources.BingResources;
import aiss.model.resources.WeatherResources;
import aiss.model.resources.YoutubeResources;
import aiss.model.resources.ZomatoResources;
import aiss.model.zomato.Zomato;

public class FavouritesRepository {

	private Map<String, List<UserCity>> favourites;
	private static FavouritesRepository instance = null;
	private List<UserCity> ciudades = new ArrayList<UserCity>();

	public static FavouritesRepository getInstance() {

		if (instance == null) {
			instance = new FavouritesRepository();
			instance.init();
		}

		return instance;
	}

	public void init() {

		favourites = new HashMap<String, List<UserCity>>();
		List<Picture> pictures = new ArrayList<Picture>();
		List<Video> videos = new ArrayList<Video>();
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		List<Weather> weathers = new ArrayList<Weather>();

		// Create UserCity
		// city 1
		UserCity lugar1 = new UserCity();

		lugar1.setNombre("Paris");
		lugar1.setPais("Francia");
		lugar1.setId("1");

		pictures = this.searchPictures(lugar1.getNombre());
		videos = this.searchVideos(lugar1.getNombre());
		restaurants = this.searchRestaurants(lugar1.getNombre());
		weathers = this.searchWeather(lugar1.getNombre());

		lugar1.setPictures(pictures);
		lugar1.setRestaurants(restaurants);
		lugar1.setVideos(videos);
		lugar1.setWeather(weathers);

		// city 2
		UserCity lugar2 = new UserCity();

		lugar2.setNombre("Sevilla");
		lugar2.setPais("España");
		lugar2.setId("2");
		pictures = this.searchPictures(lugar2.getNombre());
		videos = this.searchVideos(lugar2.getNombre());
		restaurants = this.searchRestaurants(lugar2.getNombre());
		weathers = this.searchWeather(lugar2.getNombre());

		lugar2.setPictures(pictures);
		lugar2.setRestaurants(restaurants);
		lugar2.setVideos(videos);
		lugar2.setWeather(weathers);

		// city 3
		UserCity lugar3 = new UserCity();

		lugar3.setNombre("Madrid");
		lugar3.setPais("España");
		lugar3.setId("3");
		pictures = this.searchPictures(lugar3.getNombre());
		videos = this.searchVideos(lugar3.getNombre());
		restaurants = this.searchRestaurants(lugar3.getNombre());
		weathers = this.searchWeather(lugar3.getNombre());

		lugar3.setPictures(pictures);
		lugar3.setRestaurants(restaurants);
		lugar3.setVideos(videos);
		lugar3.setWeather(weathers);

		// city 4
		UserCity lugar4 = new UserCity();

		lugar4.setNombre("Pamplona");
		lugar4.setPais("España");
		lugar4.setId("4");
		pictures = this.searchPictures(lugar4.getNombre());
		videos = this.searchVideos(lugar4.getNombre());
		restaurants = this.searchRestaurants(lugar4.getNombre());
		weathers = this.searchWeather(lugar4.getNombre());

		lugar4.setPictures(pictures);
		lugar4.setRestaurants(restaurants);
		lugar4.setVideos(videos);
		lugar4.setWeather(weathers);

		// city 5
		UserCity lugar5 = new UserCity();

		lugar5.setNombre("Lisboa");
		lugar5.setPais("Portugal");
		lugar5.setId("5");
		pictures = this.searchPictures(lugar5.getNombre());
		videos = this.searchVideos(lugar5.getNombre());
		restaurants = this.searchRestaurants(lugar5.getNombre());
		weathers = this.searchWeather(lugar5.getNombre());

		lugar5.setPictures(pictures);
		lugar5.setRestaurants(restaurants);
		lugar5.setVideos(videos);
		lugar5.setWeather(weathers);

		// add cities

		ciudades.add(lugar1);
		ciudades.add(lugar2);
		ciudades.add(lugar3);
		ciudades.add(lugar4);
		ciudades.add(lugar5);

		// favourites users

		this.addUserCities("JOSE", ciudades);
		this.addUserCity("ANTONIO",lugar1);

	}

	public void addCity(UserCity userCity) {

		this.ciudades.add(userCity);

	}

	public void addUserCities(String userId, List<UserCity> userCities) {

		favourites.put(userId, userCities);

	}

	public void addUserCity(String userId, UserCity userCity) {
		 List<UserCity> ciudades = new ArrayList<UserCity>();

		
		
		if(this.favourites.containsKey(userId))
			this.favourites.get(userId).add(userCity);
		else{
			ciudades.add(userCity);
			this.favourites.put(userId, ciudades);
		}
			

	}

	/**
	 * Método para buscar fotos y te devuelve una lista de fotos
	 */

	private List<Picture> searchPictures(String lugar) {

		List<Picture> pictures = new ArrayList<Picture>();
		Picture picture;

		BingResources bing = new BingResources();

		try {
			Photo photoResults = bing.getBingPhotos(lugar);
			for (Value valor : photoResults.getValue()) {

				picture = new Picture();
				picture.setUrl(valor.getContentUrl());
				pictures.add(picture);
				picture = null;

			}
		} catch (Exception e) {

		}

		return pictures;

	}

	/**
	 * Método para buscar el tiempo y te devuelve una lista de tiempo
	 */
	private List<Weather> searchWeather(String lugar) {

		List<Weather> weathers = new ArrayList<Weather>();
		Weather weather;

		WeatherResources weatherResources = new WeatherResources();

		try {
			aiss.model.weather.Weather w = weatherResources.getWeather(lugar);

			for (aiss.model.weather.List valor : w.getList()) {

				weather = new Weather();
				weather.setTemperature(String.valueOf(valor.getMain().getTemp()));
				weather.setMinTemperature(String.valueOf(valor.getMain().getTemp_min()));
				weather.setMaxTemperature(String.valueOf(valor.getMain().getTemp_max()));
				weathers.add(weather);

				weather = null;

			}
		} catch (Exception e) {

		}

		return weathers;

	}

	/**
	 * Método para buscar videos y te devuelve una lista de videos
	 */

	private List<Video> searchVideos(String lugar) {

		List<Video> videos = new ArrayList<Video>();
		Video video;

		YoutubeResources youtubeResources = new YoutubeResources();

		try {
			Youtube youtube = youtubeResources.getVideo(lugar);

			for (Item valor : youtube.getItems()) {

				video = new Video();
				video.setId(valor.getId().getVideoId());
				video.setUrl("https://www.youtube.com/watch?v=" + video.getId());
				videos.add(video);
				video = null;

			}
		} catch (Exception e) {

		}

		return videos;

	}

	/**
	 * Método para buscar restaurantes y te devuelve una lista de restaurantes
	 */

	private List<Restaurant> searchRestaurants(String lugar) {

		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		Restaurant restaurant;

		ZomatoResources zomato = new ZomatoResources();

		try {
			Zomato zomatoResults = zomato.getZomato(lugar);

			for (aiss.model.zomato.Restaurant valor : zomatoResults.getRestaurants()) {

				restaurant = new Restaurant();
				restaurant.setName(valor.getRestaurant().getName());
				restaurant.setNameCity(valor.getRestaurant().getLocation().getCity());
				restaurant.setStreet(valor.getRestaurant().getLocation().getAddress());
				restaurant.setLocation(valor.getRestaurant().getLocation().getLocality());

				restaurants.add(restaurant);
				restaurant = null;

			}
		} catch (Exception e) {

		}

		return restaurants;

	}

	public List<UserCity> getAllFavourites() {

		return this.ciudades;

	}

	public List<UserCity> getAllFavouritesUser(String userId) {

		return favourites.get(userId);

	}
	
	public void updateCity(UserCity oldCity,UserCity newCity,String userId){
		
		this.getAllFavouritesUser(userId).remove(oldCity);	
		this.addUserCity(userId, newCity);
		
	}

	public UserCity getFavouriteUserCity(String userId, String cityId) {

		List<UserCity> cities = this.getAllFavouritesUser(userId);

		UserCity c = null;

		for (UserCity city : cities) {

			if (city.getId().equals(cityId)) {
				c = city;
				break;
			}
		}

		return c;

	}

	public List<Weather> getWeatherUserCity(String userId, String cityId) {

		UserCity city = this.getFavouriteUserCity(userId, cityId);

		List<Weather> retorno = null;

		if (city != null)
			retorno = city.getWeather();

		return retorno;

	}

	public List<Video> getVideosUserCity(String userId, String cityId) {

		UserCity city = this.getFavouriteUserCity(userId, cityId);

		List<Video> retorno = null;

		if (city != null)
			retorno = city.getVideos();

		return retorno;

	}

	public List<Restaurant> getRestaurantsUserCity(String userId, String cityId) {

		UserCity city = this.getFavouriteUserCity(userId, cityId);

		List<Restaurant> retorno = null;

		if (city != null)
			retorno = city.getRestaurants();

		return retorno;

	}

	public void deleteFavourites() {
		this.getAllFavourites().clear();
	}

	public void deleteFavourites(String userId) {

		this.favourites.get(userId).clear();
	}

}
