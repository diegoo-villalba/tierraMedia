package services;

import model.nullobjects.NullUser;
import persistence.UsuariosDAO;
import persistence.commons.DAOFactory;
import tierraMadre.Usuario;

public class LoginService {

	public Usuario login(String username, String password) {
		UsuariosDAO userDao = DAOFactory.getUsuariosDAO();
    	Usuario usuario = userDao.findByNombre(username);
    	
    	if (usuario.isNull() || !usuario.checkPassword(password)) {
    		usuario = NullUser.build();
    	}
    	return usuario;
	}

} 
