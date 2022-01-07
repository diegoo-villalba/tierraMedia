package services;

import java.util.List;

import model.Usuario;
import persistence.UsuariosDAO;
import persistence.commons.DAOFactory;
import persistence.impl.UsuariosDAOImpl;

public class UsuarioService {

	public List<Usuario> list() {
		return DAOFactory.getUsuariosDAO().findAll();
	}

	public Usuario crear(String nombre, String username, String password, Double coins, Double time) {
		Usuario user = new Usuario(-1, nombre, username, password, coins, time, false);
		user.setPassword(password);

		if (user.isValid()) {
			DAOFactory.getUsuariosDAO().insert(user);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return user;
	}

	// Nombre dinero tiempo username password
	
	public Usuario update(Integer id, String nombre,  Double coins, Double time, String username, String password) {

		UsuariosDAOImpl usuarioDAO = new UsuariosDAOImpl();
		Usuario user = usuarioDAO.find(id);

		user.setNombre(nombre);
		user.setPresupuesto(coins);
		user.setTiempoDisponible(time);
		user.setUsername(username);
		user.setPassword(password);

		if (user.isValid()) {
			usuarioDAO.update(user);
		}

		return user;
	}

	public Usuario find(Integer id) {
		return DAOFactory.getUsuariosDAO().find(id);
	}
	
	 public void borrar(Integer id) {
		 Usuario user = new Usuario(id, null, null, null, null, null, null, null);
		 
		 UsuariosDAOImpl usuarioDAO = new UsuariosDAOImpl();
		 
         usuarioDAO.find(id);
         usuarioDAO.delete(user);
 }

}
