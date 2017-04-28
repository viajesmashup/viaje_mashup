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

import aiss.model.skyscanner.Flights;

public class SkyscannerResources {
	private static final Logger log = Logger.getLogger(SkyscannerResources.class.getName());
	private static final String SKYSCANNER_API_KEY = "bu317168613791557276499071709357";

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

	public Flights getLugar(String ciudad) throws UnsupportedEncodingException {
		// String encodeQuery = URLEncoder.encode(ciudad, "UTF-8");

		String encodeQuery = "FR";
		String uri = "http://partners.api.skyscanner.net/apiservices/browseroutes/v1.0/FR/eur/en-US" + "/us/"
				+ encodeQuery + "/anytime/anytime?apikey=" + SKYSCANNER_API_KEY;
		log.log(Level.INFO, uri);

		ClientResource cr = new ClientResource(uri);
		
		addHeader(cr, "Accept", "application/json");
		log.log(Level.INFO, "BING RESOURCES");


		return cr.get(Flights.class);

	}
}
