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
import aiss.model.resources.BingResources;

public class FavouritesRepository {

	private Map<String, List<UserCity>> favourites;
	private static FavouritesRepository instance = null;

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

		// Create Video

		Video v1 = new Video();

		v1.setId("1");
		v1.setUrl("url1");

		Video v2 = new Video();

		v2.setId("2");
		v2.setUrl("url2");

		Video v3 = new Video();

		v3.setId("3");
		v3.setUrl("url3");

		Video v4 = new Video();

		v4.setId("4");
		v4.setUrl("4");

		Video v5 = new Video();

		v5.setId("5");
		v5.setUrl("5");

		List<Video> videos = new ArrayList<Video>();
		videos.add(v1);
		videos.add(v2);
		videos.add(v3);
		videos.add(v4);
		videos.add(v5);

		// create restaurant

		Restaurant r1 = new Restaurant();

		r1.setName("r1");
		r1.setStreet("street 1");
		r1.setNameCity("city 1");
		r1.setLocation("location 1");

		Restaurant r2 = new Restaurant();

		r2.setName("r2");
		r2.setStreet("street 2");
		r2.setNameCity("city 2");
		r2.setLocation("location 2");

		Restaurant r3 = new Restaurant();

		r3.setName("r3");
		r3.setStreet("street 3");
		r3.setNameCity("city 3");
		r3.setLocation("location 3");

		Restaurant r4 = new Restaurant();

		r4.setName("r4");
		r4.setStreet("street 4");
		r4.setNameCity("city 4");
		r4.setLocation("location 4");

		Restaurant r5 = new Restaurant();

		r5.setName("r5");
		r5.setStreet("street 5");
		r5.setNameCity("city 5");
		r5.setLocation("location 5");

		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		restaurants.add(r1);
		restaurants.add(r2);
		restaurants.add(r3);
		restaurants.add(r4);
		restaurants.add(r5);

		// create weather

		Weather w1 = new Weather();

		w1.setTemperature("t1");
		w1.setMinTemperature("t_min1");
		w1.setMaxTemperature("t_max1");

		Weather w2 = new Weather();

		w2.setTemperature("t2");
		w2.setMinTemperature("t_min2");
		w2.setMaxTemperature("t_max2");

		Weather w3 = new Weather();

		w3.setTemperature("t3");
		w3.setMinTemperature("t_min3");
		w3.setMaxTemperature("t_max3");

		Weather w4 = new Weather();

		w4.setTemperature("t4");
		w4.setMinTemperature("t_min4");
		w4.setMaxTemperature("t_max4");

		Weather w5 = new Weather();

		w5.setTemperature("t5");
		w5.setMinTemperature("t_min5");
		w5.setMaxTemperature("t_max5");
		List<Weather> weathers = new ArrayList<Weather>();

		weathers.add(w1);
		weathers.add(w2);
		weathers.add(w3);
		weathers.add(w4);
		weathers.add(w5);

		// Create UserCity
		UserCity lugar1 = new UserCity();

		lugar1.setNombre("Paris");
		lugar1.setPais("Francia");
		lugar1.setId("1");

		pictures = this.searchPicture(lugar1.getNombre());

		lugar1.setPictures(pictures);
		lugar1.setRestaurants(restaurants);
		lugar1.setVideos(videos);
		lugar1.setWeather(weathers);

		UserCity lugar2 = new UserCity();

		lugar2.setNombre("Sevilla");
		lugar2.setPais("España");
		lugar2.setId("2");
		pictures = this.searchPicture(lugar2.getNombre());
		
		lugar2.setPictures(pictures);
		lugar2.setRestaurants(restaurants);
		lugar2.setVideos(videos);
		lugar2.setWeather(weathers);

		UserCity lugar3 = new UserCity();

		lugar3.setNombre("Madrid");
		lugar3.setPais("España");
		lugar3.setId("3");
		pictures = this.searchPicture(lugar3.getNombre());
		lugar3.setPictures(pictures);
		lugar3.setRestaurants(restaurants);
		lugar3.setVideos(videos);
		lugar3.setWeather(weathers);

		UserCity lugar4 = new UserCity();

		lugar4.setNombre("Pamplona");
		lugar4.setPais("España");
		lugar4.setId("4");
		pictures = this.searchPicture(lugar4.getNombre());
		lugar4.setPictures(pictures);
		lugar4.setRestaurants(restaurants);
		lugar4.setVideos(videos);
		lugar4.setWeather(weathers);

		UserCity lugar5 = new UserCity();

		lugar5.setNombre("Pamplona");
		lugar5.setPais("España");
		lugar5.setId("5");
		pictures = this.searchPicture(lugar5.getNombre());
		lugar5.setPictures(pictures);
		lugar5.setRestaurants(restaurants);
		lugar5.setVideos(videos);
		lugar5.setWeather(weathers);

		// add cities
		List<UserCity> ciudades = new ArrayList<UserCity>();

		ciudades.add(lugar1);
		ciudades.add(lugar2);
		ciudades.add(lugar3);
		ciudades.add(lugar4);

		List<UserCity> ciudades2 = new ArrayList<UserCity>();

		ciudades2.add(lugar5);

		favourites.put("JOSE", ciudades);
		favourites.put("ANTONIO", ciudades2);

	}

	private List<Picture> searchPicture(String lugar) {

		List<Picture> pictures = new ArrayList<Picture>();
		Picture picture = new Picture();

		BingResources bing = new BingResources();

		try {
			Photo photoResults = bing.getBingPhotos(lugar);
			for (Value valor : photoResults.getValue()) {

				picture.setUrl(valor.getContentUrl());
				pictures.add(picture);

			}
		} catch (Exception e) {

		}

		return pictures;

	}

	public Collection<List<UserCity>> getAllFavourites() {

		return favourites.values();

	}

	public List<UserCity> getAllFavouritesUser(String userId) {

		return favourites.get(userId);

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

}
