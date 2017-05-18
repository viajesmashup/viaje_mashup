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
import java.util.Collection;
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
	public Collection<List<UserCity>> getAll() {
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
	public UserCity get(@PathParam("userId") String userId, @PathParam("cityId") String cityId) {
		UserCity city = repository.getFavouriteUserCity(userId, cityId);

		if (city == null) {
			throw new NotFoundException("No se encuentran ciudades para el usuario " + userId);

		}
		return city;
	}
	/*
	 * @POST
	 * 
	 * @Consumes("application/json")
	 * 
	 * @Produces("application/json") public Response addSong(@Context UriInfo
	 * uriInfo, Song song) {
	 * 
	 * if (song == null) throw new BadRequestException("The playlist with id=" +
	 * song + " was not found");
	 * 
	 * if (song.getTitle() == null || "".equals(song.getTitle())) throw new
	 * NotFoundException("The song with id=" + song + " was not found");
	 * 
	 * Song s = repository.getSong(song.getId()); if (s != null) { return
	 * Response.status(Status.CONFLICT).build();
	 * 
	 * // return Response.status(409).build(); }
	 * 
	 * repository.addSong(song);
	 * 
	 * // Builds the response UriBuilder ub =
	 * uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get"); URI uri =
	 * ub.build(song.getId()); ResponseBuilder resp = Response.created(uri);
	 * resp.entity(song); return resp.build(); }
	 * 
	 * @PUT
	 * 
	 * @Consumes("application/json") public Response updateSong(Song updateSong)
	 * {
	 * 
	 * Song oldSong = repository.getSong(updateSong.getId());
	 * 
	 * repository.updateSong(updateSong);
	 * 
	 * if (oldSong == null) throw new
	 * BadRequestException("No existe la canción para modificar");
	 * 
	 * return Response.noContent().build(); }
	 * 
	 * @DELETE
	 * 
	 * @Path("/{id}") public Response removeSong(@PathParam("id") String songId)
	 * {
	 * 
	 * Song songToDelete = repository.getSong(songId);
	 * 
	 * if (songToDelete == null) throw new
	 * BadRequestException("No existe la canción para eliminar");
	 * 
	 * repository.deleteSong(songId);
	 * 
	 * return Response.noContent().build();// 204
	 * 
	 * }
	 */

}
