package model;

import persistence.commons.DAOFactory;

public class Recommender {
	
public synchronized static void agregarYPagar(Usuario unUsuario, Atraccion unaAtraccion) {
		
		unaAtraccion.takeASit(unUsuario);
		DAOFactory.getElItinerarioDAO().cargarAtraccion(unaAtraccion, unUsuario);
		unUsuario.payAttraction(unaAtraccion);
		
		DAOFactory.getAtraccionesDAO().update(unaAtraccion);
		DAOFactory.getUsuariosDAO().update(unUsuario);
	}

public synchronized static void agregarYPagarPromo(Usuario unUsuario, Promocion unaPromocion) {
	
	for (Atraccion cadaAtraccion : unaPromocion.getAtracciones()) {
		
		cadaAtraccion.takeASit(unUsuario);
		DAOFactory.getElItinerarioDAO().cargarAtraccion(cadaAtraccion, unUsuario);
		
	}
	unUsuario.payPromo(unaPromocion);
	
	DAOFactory.getPromocionesDAO().updateAtracciones(unaPromocion);
	DAOFactory.getUsuariosDAO().update(unUsuario);
}

}
