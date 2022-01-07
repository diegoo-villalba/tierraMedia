package persistence.commons;

import persistence.AtraccionesDAO;
import persistence.ElItinerarioDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionesDAO;
import persistence.UsuariosDAO;
import persistence.impl.AtraccionesDAOImpl;
import persistence.impl.ElItinerarioDAOImpl;
import persistence.impl.ItinerarioDAOImpl;
import persistence.impl.PromocionesDAOImpl;
import persistence.impl.UsuariosDAOImpl;

public class DAOFactory {
	
	public static UsuariosDAO getUsuariosDAO() {
		return new UsuariosDAOImpl();
	}
	
	public static AtraccionesDAO getAtraccionesDAO() {
		return new AtraccionesDAOImpl();
	}
	
	public static PromocionesDAO getPromocionesDAO() {
		return new PromocionesDAOImpl();
	}
	
	public static ItinerarioDAO getItinerarioDAO() {
		return new ItinerarioDAOImpl();
	}
	
	public static ElItinerarioDAO getElItinerarioDAO() {
		return new ElItinerarioDAOImpl();
	}

}
