package services;

import java.util.List;

import tierraMadre.Atraccion;
import tierraMedia.dao.AtraccionesDAO;

public class AtraccionService {
	
	
	public List<Atraccion> list() {
		return AtraccionesDAO.getAtracciones();
	}
	
	/*public Atraccion crearAtraccion(String nombre, int costo, double tiempoRecorrido, int cupo, TipoDeAtraccion tipo) {
		Atraccion atraccion = new Atraccion(nombre, costo, tiempoRecorrido, cupo, tipo);
		
		if(atraccion.esValida()) {
			
		}
		
		return atraccion;
		
		
	}*/

}
