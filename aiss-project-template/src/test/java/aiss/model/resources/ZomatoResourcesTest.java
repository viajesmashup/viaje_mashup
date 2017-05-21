package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.zomato.Zomato;

public class ZomatoResourcesTest {

	private static final String ZOMATO_CONSULTA ="Paris";

	static ZomatoResources sr = new ZomatoResources();
	
	@Test
	public void testGetZomato() throws UnsupportedEncodingException {
		Zomato zomato  = sr.getZomato(ZOMATO_CONSULTA);
		
		assertEquals("The id of the zomato does not match", ZOMATO_CONSULTA, 
				zomato.getRestaurants().get(0).getRestaurant().getLocation().getCity());
		
		// Show result
		System.out.println("Name restaurant: " +  zomato.getRestaurants().get(0).getRestaurant().getName());
		System.out.println("Address restaurant: " +  zomato.getRestaurants().get(0).getRestaurant().getLocation().getAddress());
		System.out.println("Locality restaurant: " + zomato.getRestaurants().get(0).getRestaurant().getLocation().getLocality());
		System.out.println("City restaurant: " + zomato.getRestaurants().get(0).getRestaurant().getLocation().getCity());
		System.out.println("Url restaurant: " + zomato.getRestaurants().get(0).getRestaurant().getUrl());

	}

}
