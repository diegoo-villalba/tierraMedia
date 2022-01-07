package services;

import java.util.List;

import model.Atraccion;
import model.ElItinerario;
import model.Itinerario;
import model.Promocion;
import model.Usuario;
import persistence.ElItinerarioDAO;
import persistence.ItinerarioDAO;
import persistence.commons.DAOFactory;

public class ItinerarioService {

	public List<ElItinerario> list() {

		return DAOFactory.getElItinerarioDAO().findAll();
	}

	public Itinerario find(Integer id) {
		return DAOFactory.getItinerarioDAO().find(id);
	}
	
	public List<Atraccion> listItinerario(int id) {
		return DAOFactory.getElItinerarioDAO().findItinerarioById(id);
	}

	public Itinerario crear(String nombre, String resumen, Integer costoTotal, Double tiempoTotal) {

		Itinerario itinerario = new Itinerario(nombre, resumen, costoTotal, tiempoTotal);

		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		itinerarioDAO.insert(itinerario);

		return itinerario;
	}
	/*
	public List<Promocion> getListPromotions(Usuario user) {

		return ElItinerarioDAO.findAllPromotions(user);

	}

	public List<Atraccion> getLisAttraction(Usuario user) {

		return ElItinerarioDAO.findAllAttractions(user);

	}*/

}
