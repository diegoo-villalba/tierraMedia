package services;

import java.util.HashMap;
import java.util.Map;

import modelos.Atraccion;
import modelos.Usuario;
import persistence.impl.AtraccionesDAOImpl;
import persistence.impl.UsuariosDAOImpl;

public class ComprarAtraccionService {
	
	AtraccionesDAOImpl atraccionesDAO = new AtraccionesDAOImpl();
	UsuariosDAOImpl usuariosDAO = new UsuariosDAOImpl();

	public Map<String, String> comprar(Integer usuarioId, Integer attractionId) {
		//Preparo un map de errores por si falla.
		Map<String, String> errors = new HashMap<String, String>();

		Usuario turista = usuariosDAO.find(usuarioId);
		Atraccion atraccion = atraccionesDAO.findById(attractionId);
		
		//Si la atraccion ya no tiene cupo
		if (!atraccion.tieneCupo(1)) {
			errors.put("attraction", "Lo sentimos! No hay cupo disponible");
		}
		//Si el turista no puede comprar
		if (!turista.puedeComprar(atraccion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		// Y/o si el turista no tiene mas tiempo, lanza alguno de los mensajes
		if (!turista.puedeSubir(atraccion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		/*Si no, es decir si el mapa esta vacio por ende no hubo errores, 
		 * entonces DESCONTAMOS del credito/tiempo del usuario
		 *  y restamos el cupo a la atraccion.
		*/
		if (errors.isEmpty()) {
			turista.aceptarPromo(atraccion.getCosto(), atraccion.getTiempoRecorrido());
			atraccion.elegirAtraccion();
			
			//TODO: AGREGAR METODO PARA NO OFRECER DE NUEVO UNA ATRACCION YA COMPRADA

			atraccionesDAO.update(atraccion);
			usuariosDAO.update2(turista);
		}
		//Siempre retorno la lista de errores, segun haya o no, si la lista esta vacia (VER Servlet)
		return errors;

	}

}
