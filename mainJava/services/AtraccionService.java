package services;

import java.util.List;

import persistence.commons.DAOFactory;
import tierraMadre.Atraccion;

public class AtraccionService {

	public List<Atraccion> list() {

		return DAOFactory.getAtraccionesDAO().findAll();
	}
}
