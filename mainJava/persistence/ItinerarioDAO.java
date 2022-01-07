package persistence;

import model.Atraccion;
import model.Itinerario;
import model.Usuario;
import persistence.commons.GenericDAO;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {

	Itinerario find(Integer id);
	
}
