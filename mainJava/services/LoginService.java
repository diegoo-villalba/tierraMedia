package services;

import model.nullobjects.NullUser;
import tierraMadre.Usuario;
import tierraMedia.dao.UsuariosDAO;

public class LoginService {

	public Usuario login(String username, String password) {
    	UsuariosDAO user = new UsuariosDAO();
    	Usuario usuario = user.findByUsername(username);
    	
    	if (usuario.isNull() || !usuario.checkPassword(password)) {
    		usuario = NullUser.build();
    	}
    	return usuario;
	}

} 
