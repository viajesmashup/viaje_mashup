package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.bing.Photo;

public class BingResourcesTest {

	private static final String BING_CONSULTA = "Paris";

	static BingResources sr = new BingResources();

	@Test
	public void testGetBingPhotos() throws UnsupportedEncodingException {
		Photo photo = sr.getBingPhotos(BING_CONSULTA);

		// Assert.assertThat("The id of the photo does not match",
		// BING_CONSULTA,
		// CoreMatchers.containsString(photo.getValue().get(0).getName()));
		assertNotNull("The collection of photo is null", photo);

		System.out.println("Url photo: " + photo.getValue().get(0).getContentUrl());

	}
}
