package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.Message;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

import aiss.model.bing.Photo;
import aiss.model.bing.QueryExpansion;

/**
 * 
 * ClientResource resource = new ClientResource(yourUrl); Form headers =
 * (Form)resource.getRequestAttributes().get("org.restlet.http.headers"); if
 * (headers == null) { headers = new Form();
 * resource.getRequestAttributes().put("org.restlet.http.headers", headers); }
 * headers.add("yourHeaderName", yourHeaderValue); resource.get(); Response
 * response = resource.getResponse(); String text =
 * response.getEntity().getText(); String status =
 * response.getStatus().toString();
 *
 */

public class BingResources {

	private static final String BING_API_KEY = "2c211f9c0b684ecba69fe38ace2d2963";
	private static final Logger log = Logger.getLogger(BingResources.class.getName());

	@SuppressWarnings("unchecked")
	static Series<Header> getMessageHeaders(Message message) {
		ConcurrentMap<String, Object> attrs = message.getAttributes();
		Series<Header> headers = (Series<Header>) attrs.get(HeaderConstants.ATTRIBUTE_HEADERS);
		if (headers == null) {
			headers = new Series<Header>(Header.class);
			Series<Header> prev = (Series<Header>) attrs.putIfAbsent(HeaderConstants.ATTRIBUTE_HEADERS, headers);
			if (prev != null) {
				headers = prev;
			}
		}
		return headers;
	}

	@SuppressWarnings("unchecked")
	public void addHeader(ClientResource cr, String headerName, String headerValue) {
		Series<Header> headers = (Series<Header>) cr.getRequest().getAttributes()
				.get(HeaderConstants.ATTRIBUTE_HEADERS);

		if (headers == null) {
			headers = new Series<Header>(Header.class);
			headers.add(headerName, headerValue);
		}

		if (headers != null) {
			cr.getRequest().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
		}
	}

	public Photo getBingPhotos(String lugar) throws UnsupportedEncodingException {

		String encodeQuery = URLEncoder.encode(lugar, "UTF-8");

		String uri = "https://api.cognitive.microsoft.com/bing/v5.0/images/search?q=" + encodeQuery
				+ "&count=15&mkt=en-us&safeSearch=Moderate&size=Wallpaper";

		ClientResource cr = new ClientResource(uri);

		log.log(Level.INFO, uri);

		addHeader(cr, "Ocp-Apim-Subscription-Key", BING_API_KEY);

		log.log(Level.INFO, "BING RESOURCES");
		return cr.get(Photo.class);

	}

}
