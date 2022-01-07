package persistence;

import model.Atraccion;
import persistence.commons.GenericDAO;

public interface AtraccionesDAO extends GenericDAO<Atraccion> {
	
	public int findIDByNombre(String nombre);
	Atraccion find(Integer id);
	
}
