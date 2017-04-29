package aiss.model.generic;

public class Busqueda {

	String origen;
	String destino;
	String fechaSalida;
	String fechaLlegada;

	public Busqueda() {

		this.origen = "";
		this.destino = "";
		this.fechaSalida = "";
		this.fechaSalida = "";
	}

	public Busqueda(String origen, String destino, String fechaSalida, String fechaLlegada) {

		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;

	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

}
