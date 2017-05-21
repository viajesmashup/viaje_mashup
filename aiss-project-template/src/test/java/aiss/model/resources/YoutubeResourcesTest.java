package aiss.model.resources;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.google.youtube.Youtube;

public class YoutubeResourcesTest {

	private static final String YOUTUBE_CONSULTA = "Paris";
	static YoutubeResources sr = new YoutubeResources();

	@Test
	public void testGetVideo() throws UnsupportedEncodingException {
		Youtube youtube = sr.getVideo(YOUTUBE_CONSULTA);

		assertNotNull("The collection of video is null", youtube);

		// Show result
		System.out.println("ID video: " + youtube.getItems().get(0).getId());

	}
}
