package persistence;

import persistence.commons.GenericDAO;
import tierraMadre.Usuario;

public interface UsuariosDAO extends GenericDAO<Usuario>{
	
	public abstract Usuario findByNombre(String nombre);
	
}
