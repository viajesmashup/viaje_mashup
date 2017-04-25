package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.restlet.resource.ClientResource;

import aiss.model.google.youtube.Youtube;

public class YoutubeResources {

	private static final String YOUTUBE_API_KEY = "AIzaSyDxZHWGoGv0aRVsPj5CEr8_wVi9q4aMATM";
	private static final Logger log = Logger.getLogger(YoutubeResources.class.getName());

	public Youtube getVideo(String ciudad) throws UnsupportedEncodingException {

		String encodeQuery = URLEncoder.encode(ciudad, "UTF-8");

		String uri = "https://www.googleapis.com/youtube/v3/search?part=snippet%20" + "&q=" + encodeQuery + "&key="
				+ YOUTUBE_API_KEY;

		ClientResource cr = new ClientResource(uri);

		log.log(Level.INFO, uri);

		return cr.get(Youtube.class);

	}

}
