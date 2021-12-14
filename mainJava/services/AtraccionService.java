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
}
