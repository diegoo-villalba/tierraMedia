package services;

import java.util.List;

import persistence.commons.DAOFactory;
import tierraMadre.Usuario;

public class UsuarioService {

	public List<Usuario> list() {
		return DAOFactory.getUsuariosDAO().findAll();
	}

//int id, String nombre, String username, String password, double dinero, double tiempo, Boolean admi

	public Usuario crear(String nombre, String username, String password, Double coins, Double time) {
		Usuario user = new Usuario(-1, nombre, username, password, coins, time, false);
		user.setPassword(password);

		if (user.isValid()) {
			DAOFactory.getUsuariosDAO().insert(user);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return user;
	}

}
