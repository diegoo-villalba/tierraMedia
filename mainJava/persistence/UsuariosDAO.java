package persistence;

import model.Usuario;
import persistence.commons.GenericDAO;

public interface UsuariosDAO extends GenericDAO<Usuario>{
	
	public abstract Usuario findByNombre(String nombre);
	public abstract Usuario find(Integer id);
	public int findIDByNombre(String nombre);
	public int logicalDelete(Usuario usuario);
	
}
