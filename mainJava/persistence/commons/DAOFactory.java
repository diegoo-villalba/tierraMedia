package persistence.commons;

import persistence.AtraccionesDAO;
import persistence.UsuariosDAO;
import tierraMedia.dao.AtraccionesDAOImpl;
import tierraMedia.dao.PromocionesDAO;
import tierraMedia.dao.PromocionesDAOImpl;
import tierraMedia.dao.UsuariosDAOImpl;

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

}
