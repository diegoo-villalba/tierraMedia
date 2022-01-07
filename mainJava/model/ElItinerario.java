package model;

public class ElItinerario {

	protected Atraccion unaAtraccion;
	protected Usuario unUsuario;

	public ElItinerario(Atraccion unaAtraccion, Usuario unUsuario) {
		this.unaAtraccion = unaAtraccion;
		this.unUsuario = unUsuario;

	}

	public Usuario getUsuario() {
		return this.unUsuario;
	}

	public Atraccion getAtraccion() {
		return this.unaAtraccion;
	}

}
