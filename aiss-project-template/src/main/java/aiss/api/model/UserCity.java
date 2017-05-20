package aiss.api.model;

import java.util.ArrayList;
import java.util.List;

public class UserCity {

	private String id;
	private String nombre;
	private String pais;
	private List<Video> videos;
	private List<Restaurant> restaurants;
	private List<Picture> pictures;
	private List<Weather> weather;

	public UserCity() {
		this.id="";
		this.nombre="";
		this.pais="";
		this.videos = new ArrayList<Video>();
		this.restaurants = new ArrayList<Restaurant>();
		this.pictures = new ArrayList<Picture>();
		this.weather = new ArrayList<Weather>();
	
	}
	
	

	public UserCity(String id, String nombre, String pais, List<Video> videos, List<Restaurant> restaurants,
			List<Picture> pictures, List<Weather> weather) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.videos = videos;
		this.restaurants = restaurants;
		this.pictures = pictures;
		this.weather = weather;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	/*public void addPicture(Picture p) {

		this.pictures.add(p);

	}

	public void addVideo(Video v) {

		this.videos.add(v);

	}*/
	
	
	


}
