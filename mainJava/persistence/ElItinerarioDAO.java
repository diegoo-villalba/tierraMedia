package persistence;

import java.sql.ResultSet;
import java.util.List;

import model.Atraccion;
import model.ElItinerario;
import model.Usuario;
import persistence.commons.GenericDAO;

public interface ElItinerarioDAO extends GenericDAO<ElItinerario> {
	
	public List<ElItinerario> findAll();
	public int countAll();
	public int cargarAtraccion(Atraccion atraccion, Usuario usuario);
	public ElItinerario toElItinerario(ResultSet resultado);
	public List<Atraccion> findItinerarioById(int id);
}
