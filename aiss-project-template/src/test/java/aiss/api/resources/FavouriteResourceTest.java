package aiss.api.resources;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import org.junit.runner.RunWith;


import aiss.DescriptionSorterRunner;
import aiss.api.model.Picture;
import aiss.api.model.Restaurant;
import aiss.api.model.UserCity;
import aiss.api.model.Video;
import aiss.api.model.Weather;


@RunWith(DescriptionSorterRunner.class)
public class FavouriteResourceTest {
	static UserCity UserCity1, UserCity2, UserCity3;
	static FavouriteResource sr = new FavouriteResource();
	
		@Test
	public void test10GetAll() {
		List<UserCity> listaCiudades = sr.getAll();
		assertNotNull("The collection of UserCity is null", listaCiudades);

		// Show result
		System.out.println(
				"*--------------------------------------------------------------------------------------------------*");
		System.out.println(
				"*------------------------------------Listing all UserCity------------------------------------------*");
		System.out.println(
				"*--------------------------------------------------------------------------------------------------*");

		System.out.println("Listing all UserCity:");
		int i = 0;
		for (UserCity city : listaCiudades) {
			System.out.println("UserCity " + i++ + " : Nombre " + city.getNombre() + " (ID=" + city.getId()
					+ "), País: " + city.getPais() + ", Photo: " + getUrl(city.getPictures()) + "\n");

		}
	}

	private List<String> getUrl(List<Picture> listaP) {
		List<String> res = new ArrayList<String>();
		if (listaP != null) {
			for (Picture p : listaP) {
				res.add(p.getUrl());
			}
		}
		return res;
	}

	private List<String> getUrlVideo(List<Video> lista) {
		List<String> res = new ArrayList<String>();
		if (lista != null) {
			for (Video p : lista) {
				res.add(p.getUrl());
			}
		}
		return res;
	}

	private List<String> getUrRestaurante(List<Restaurant> lista) {
		List<String> res = new ArrayList<String>();
		if (lista != null) {
			for (Restaurant p : lista) {
				res.add(p.getName());
			}
		}
		return res;
	}

	@Test
	public void test20GetFavouritesPorUser() {
		String user = "JOSE";
		List<UserCity> listaCiudades = sr.get(user);

		assertNotNull("The collection of UserCity is null", listaCiudades);
		System.out.println(
				"*------------------------------------------------------------------------------------------------*");
		System.out.println("*----------------------------------Listing user cities: " + user
				+ " ------------------------------------*");
		System.out.println(
				"*------------------------------------------------------------------------------------------------*");

		// Show result
		for (UserCity c : listaCiudades) {
			System.out.println("City named: " + c.getNombre());
			System.out.println("Country: " + c.getPais());
			System.out.println("Photo of the city(urls): " + getUrl(c.getPictures()));
			System.out.println("Videos of the city(urls): " + getUrlVideo(c.getVideos()) + "\n");

		}
	}

	@Test
	public void test30GetFavouritesPorUserId() {
		String user = "JOSE";
		String id = "5";
		UserCity ciudad = sr.getUserCity(user, id);

		assertNotNull("The collection of UserCity is null", ciudad);

		System.out.println(
				"*------------------------------------------------------------------------------------------------*");
		System.out.println("*--------------------------------- City: " + id + " of the user: " + user
				+ " ------------------------------------*");
		System.out.println(
				"*------------------------------------------------------------------------------------------------*");

		System.out.println("City ​​name: " + ciudad.getNombre());
		System.out.println("Country: " + ciudad.getPais());
		System.out.println("Photos of the city(urls): " + getUrl(ciudad.getPictures()));
		System.out.println("Videos of the city(urls): " + getUrlVideo(ciudad.getVideos()));
		System.out.println("Restaurants in the city: " + getUrRestaurante(ciudad.getRestaurants()) + "\n");

	}

	@Test
	public void testGetWeathers() {
		String user = "JOSE";
		String id = "5";
		List<Weather> lista = sr.getWeathers(user, id);

		assertNotNull("The collection of UserCity is null", lista);

		System.out.println(
				"*------------------------------------------------------------------------------------------------*");
		System.out.println("*----------------------- Listing details of user time " + user
				+ " in Lisboa city -----------------------*");
		System.out.println(
				"*------------------------------------------------------------------------------------------------*");
		for (Weather c : lista) {
			System.out.println("Temperature of the city: " + c.getTemperature());
			System.out.println("Minimum temperature of the city: " + c.getMinTemperature());
			System.out.println("Maximum temperature of the city: " + c.getMaxTemperature() + "\n");

		}
	}

	@Test
	public void testGetVideos() {
		String user = "JOSE";
		String id = "5";
		List<Video> lista = sr.getVideos(user, id);

		assertNotNull("The collection of UserCity is null", lista);

		System.out.println(
				"*------------------------------------------------------------------------------------------------*");
		System.out.println("*------------------------- Listing videos of user " + user
				+ " in Lisboa city ----------------------------*");
		System.out.println(
				"*------------------------------------------------------------------------------------------------*");
		for (Video c : lista) {
			System.out.println("Videos url: " + c.getUrl());

		}
	}

	@Test
	public void testGetRestaurants() {
		String user = "JOSE";
		String id = "5";
		List<Restaurant> lista = sr.getRestaurants(user, id);

		assertNotNull("The collection of UserCity is null", lista);

		System.out.println(
				"*------------------------------------------------------------------------------------------------*");
		System.out.println("*------------------------ Listing restaurants of user " + user
				+ " in Lisboa city -----------------------*");
		System.out.println(
				"*------------------------------------------------------------------------------------------------*");
		for (Restaurant c : lista) {
			System.out.println("Restaurant name: " + c.getName());
			System.out.println("Restaurant location: " + c.getLocation());
			System.out.println("City name: " + c.getNameCity() + "\n");

		}
	}

	@Test
	public void testRemoveFavouritesId() {
		String user = "JOSE";

		System.out.println(
				"*------------------------------------------------------------------------------------------------*");
		System.out.println("*------------------------------Removing the repository of user: " + user
				+ "------------------------------*");
		System.out.println(
				"*------------------------------------------------------------------------------------------------*");

		List<UserCity> listaCiudades = sr.get(user);
		assertNotNull("The collection of UserCity is null", listaCiudades);
		if (listaCiudades.size() > 0) {
			sr.removeFavouritesUserId(user);
			System.out.println("The entire user repository has been deleted: " + user + "\n");
		} else {
			System.out.println("The list is already empty \n");
		}
	}

	@Test
	public void testRemoveFavourites() {
		System.out.println(
				"*------------------------------------------------------------------------------------------------*");
		System.out.println(
				"*--------------------------------Removing the entire repository ---------------------------------*");
		System.out.println(
				"*------------------------------------------------------------------------------------------------*");

		List<UserCity> listaCiudades = sr.getAll();
		assertNotNull("The collection of UserCity is null", listaCiudades);
		if (listaCiudades.size() > 0) {
			sr.removeFavourites();
			System.out.println("Entire repositories have been removed \n");
		} else {
			System.out.println("The list is already empty \n");
		}
	}

}
