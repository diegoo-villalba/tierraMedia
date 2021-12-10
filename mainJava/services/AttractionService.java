package services;

import java.sql.SQLException;
import java.util.List;

import model.Attraction;
import persistence.AttractionDAO;
import persistence.commons.DAOFactory;
import tierraMadre.Atraccion;
import tierraMadre.TipoDeAtraccion;
import tierraMedia.dao.AtraccionesDAO;

public class AttractionService {

	public List<Atraccion> list() throws SQLException {
		return AtraccionesDAO.getAtracciones();
	}
//String nombre, int costo, double tiempoRecorrido, int cupo, TipoDeAtraccion tipo
	public Atraccion create(String name, Integer cost, Double duration, Integer capacity, TipoDeAtraccion tipo) {

		Atraccion attraction = new Atraccion(name, cost, duration, capacity, tipo);

		if (attraction.isValid()) {
			AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
			attractionDAO.insert(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public Attraction update(Integer id, String name, Integer cost, Double duration, Integer capacity) {

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		Attraction attraction = attractionDAO.find(id);

		attraction.setName(name);
		attraction.setCost(cost);
		attraction.setDuration(duration);
		attraction.setCapacity(capacity);

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public void delete(Integer id) {
		Attraction attraction = new Attraction(id, null, null, null, null);

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.delete(attraction);
	}

	public Attraction find(Integer id) {
		return DAOFactory.getAttractionDAO().find(id);
	}

}
