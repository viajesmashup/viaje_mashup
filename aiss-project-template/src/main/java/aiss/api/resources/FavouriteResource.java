package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.model.*;
import aiss.api.respository.FavouritesRepository;

import java.net.URI;
import java.util.List;

@Path("/favourites")
public class FavouriteResource {

	public static FavouriteResource _instance = null;
	FavouritesRepository repository;

	public FavouriteResource() {
		repository = FavouritesRepository.getInstance();
	}

	public static FavouriteResource getInstance() {
		if (_instance == null)
			_instance = new FavouriteResource();
		return _instance;
	}

	@GET
	@Produces("application/json")
	public List<UserCity> getAll() {
		return repository.getAllFavourites();
	}

	@GET
	@Path("/{userId}")
	@Produces("application/json")
	public List<UserCity> get(@PathParam("userId") String userId) {
		List<UserCity> cities = repository.getAllFavouritesUser(userId);
		if (cities == null) {
			throw new NotFoundException("El usuario " + userId + " No se encuentra");

		}
		return cities;
	}

	@GET
	@Path("/{userId}/{cityId}")
	@Produces("application/json")
	public UserCity getUserCity(@PathParam("userId") String userId, @PathParam("cityId") String cityId) {
		UserCity city = repository.getFavouriteUserCity(userId, cityId);

		if (city == null) {
			throw new NotFoundException("No se encuentran ciudades para el usuario " + userId);

		}
		return city;
	}
	
	@GET
	@Path("/{userId}/{cityId}/weather")
	@Produces("application/json")
	public List<Weather> getWeathers(@PathParam("userId") String userId, @PathParam("cityId") String cityId) {
		List<Weather> weather = repository.getWeatherUserCity(userId, cityId);

		if (weather == null) {
			throw new NotFoundException("No se encuentran ciudades para el usuario " + userId);

		}
		return weather;
	}
	
	@GET
	@Path("/{userId}/{cityId}/videos")
	@Produces("application/json")
	public List<Video> getVideos(@PathParam("userId") String userId, @PathParam("cityId") String cityId) {
		List<Video> videos = repository.getVideosUserCity(userId, cityId);

		if (videos == null) {
			throw new NotFoundException("No se encuentran ciudades para el usuario " + userId);

		}
		return videos;
	}
	
	@GET
	@Path("/{userId}/{cityId}/restaurants")
	@Produces("application/json")
	public List<Restaurant> getRestaurants(@PathParam("userId") String userId, @PathParam("cityId") String cityId) {
		List<Restaurant> restaurants = repository.getRestaurantsUserCity(userId, cityId);

		if (restaurants == null) {
			throw new NotFoundException("No se encuentran ciudades para el usuario " + userId);

		}
		return restaurants;
	}
	
	
	@DELETE
	public Response removeFavourites() {
		List<UserCity> favourites = repository.getAllFavourites();
		if (favourites == null)
			throw new NotFoundException("Was not found");
		else
			repository.deleteFavourites();
		
		return Response.noContent().build();
	}

	
	@DELETE
	@Path("/{userId}")
	public Response removeFavouritesUserId(@PathParam("userId") String userId) {
		List<UserCity> cities = repository.getAllFavouritesUser(userId);
		if (cities == null)
			throw new NotFoundException("The user "+ userId +" was not found");
		else
			repository.deleteFavourites(userId);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Consumes("application/json")
	@Produces("application/json")
	public Response addFavourite(@Context UriInfo uriInfo,UserCity userCity)
	{				
	
		repository.addCity(userCity);	

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(userCity);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(userCity);			
		return resp.build();
	}
	
	@POST	
	@Path("/{userId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addFavouriteUser(@Context UriInfo uriInfo,UserCity userCity,@PathParam("userId") String userId)
	{				
	
		repository.addUserCity(userId, userCity);	

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(userCity);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(userCity);			
		return resp.build();
	}
	
	@PUT
	@Path("/{userId}/{cityId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateFavouritesUser(@Context UriInfo uriInfo,@PathParam("userId") String userId,@PathParam("cityId") String cityId,UserCity userCity) {

		UserCity userCityOld = repository.getFavouriteUserCity(userId, cityId);

		if (userCityOld == null)
			throw new BadRequestException("No existe la ciudad para modificar");
		
		repository.updateCity(userCityOld, userCity, userId);
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(userCity);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(userCity);			
		return resp.build();
	}



	


	
	

}
