package services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import tierraMadre.Atraccion;
import tierraMadre.Usuario;
import tierraMedia.dao.AtraccionesDAO;
import tierraMedia.dao.UsuariosDAO;

public class BuyAttractionService {
	
	AtraccionesDAO atraccionesDAO = new AtraccionesDAO();
	UsuariosDAO usuariosDAO = new UsuariosDAO();

	public Map<String, String> buy(String usuario, Integer attractionId) throws SQLException {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario turista = usuariosDAO.findByUsername(usuario);
		Atraccion atraccion = atraccionesDAO.findById(attractionId);

		if (!atraccion.tieneCupo(1)) {
			errors.put("attraction", "Lo sentimos! No hay cupo disponible");
		}
		if (!turista.puedeComprar(atraccion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!turista.puedeSubir(atraccion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			turista.aceptarPromo(atraccion.getCosto(), atraccion.getTiempoRecorrido());
			atraccion.elegirAtraccion();

			AtraccionesDAO.update(atraccion);
			UsuariosDAO.update(turista);
		}

		return errors;

	}

}
