package persistence.commons;

import persistence.AtraccionesDAO;
import persistence.PromocionesDAO;
import persistence.UsuariosDAO;
import persistence.impl.AtraccionesDAOImpl;
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

}
