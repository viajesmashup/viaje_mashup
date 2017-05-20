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

import aiss.model.zomato.IdZomato;
import aiss.model.zomato.Zomato;

public class ZomatoResources {
	
	private static final String ZOMATO_API_KEY = "25dff576ca075fc1b71c48667e116342";
	private static final Logger log = Logger.getLogger(BingResources.class.getName());
	
	@SuppressWarnings("unchecked")
	static Series<Header> getMessageHeaders(Message message) {
		ConcurrentMap<String, Object> attrs = message.getAttributes();
		Series<Header> headers = (Series<Header>) attrs.get(HeaderConstants.HEADER_ACCESS_CONTROL_ALLOW_HEADERS);
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

	public Zomato getZomato(String lugar) throws UnsupportedEncodingException {
	
		IdZomato idZomato = getIdZomato(lugar);
		Integer idCity = -1;
		try{
		log.log(Level.INFO,"La id de zomato es: "+idZomato.getLocationSuggestions().get(0).getId());
		 idCity = idZomato.getLocationSuggestions().get(0).getId();
		}
		catch(Exception e){
			
			log.log(Level.SEVERE, "Se ha capturado una excepción null pointer"+e.getMessage());

			
		}
		
		//log.log(Level.INFO,"La id de city es: "+idCity);

		String uri = "https://developers.zomato.com/api/v2.1/search?entity_id="+idCity+"&entity_type=city";

		ClientResource cr = new ClientResource(uri);
		
		

	
		addHeader(cr, "user-key",ZOMATO_API_KEY);
		//addHeader(cr, "Accept", "application/json");
		
		log.log(Level.INFO, uri);
		
		return cr.get(Zomato.class);

	}
	
	
	public IdZomato getIdZomato (String lugar) throws UnsupportedEncodingException {

		String encodeQuery = URLEncoder.encode(lugar, "UTF-8");

		String uri = "https://developers.zomato.com/api/v2.1/cities?q="+encodeQuery;

		ClientResource cr = new ClientResource(uri);
		
		

	
		addHeader(cr, "user-key",ZOMATO_API_KEY);
		//addHeader(cr, "Accept", "application/json");
		
		log.log(Level.INFO, uri);
		
		return cr.get(IdZomato.class);

	}

}
