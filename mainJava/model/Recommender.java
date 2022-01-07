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

}
