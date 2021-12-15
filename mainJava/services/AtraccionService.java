package services;

import java.util.List;

import persistence.AtraccionesDAO;
import persistence.commons.DAOFactory;
import tierraMadre.Atraccion;

public class AtraccionService {

	public List<Atraccion> list() {

		return DAOFactory.getAtraccionesDAO().findAll();
	}
	
	public void delete(Integer id) {
		Atraccion attraction = new Atraccion(id, null, null, null, null);

		AtraccionesDAO attractionDAO = DAOFactory.getAtraccionesDAO();
		attractionDAO.delete(attraction);
	}

	public Atraccion find(Integer id) {
		return DAOFactory.getAtraccionesDAO().find(id);
	}
	
	public Atraccion crear(String nombre, Integer costo, Double tiempoRecorrido, Integer cupo) {

		Atraccion atraccion = new Atraccion(nombre, costo, tiempoRecorrido, cupo);

		if (atraccion.esValida()) {
			AtraccionesDAO attractionDAO = DAOFactory.getAtraccionesDAO();
			attractionDAO.insert(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}
	
	public Atraccion update(Integer id, String name, Integer cost, Double duration, Integer capacity) {
				
				AtraccionesDAO attractionDAO = DAOFactory.getAtraccionesDAO();
				Atraccion attraction = attractionDAO.find(id);
				
				attraction.setNombre(name);
				attraction.setCosto(cost);
				attraction.setTiempoRecorrido(duration);
				attraction.setCupo(capacity);
				
				
				if (attraction.esValida()) {
					attractionDAO.update(attraction);
					// XXX: si no devuelve "1", es que hubo más errores
				}
			
		return attraction;
			}
	

}
