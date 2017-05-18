package aiss.api.favouritesUserApplication;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import aiss.api.resources.FavouriteResource;;




public class UserApplication extends Application {
	private Set<Object> favourites = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	// Loads all resources that are implemented in the application
	// so that they can be found by RESTEasy.
	public UserApplication() {
		favourites.add(FavouriteResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return favourites;
	}
}