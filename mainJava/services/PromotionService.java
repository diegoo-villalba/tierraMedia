package services;

import java.sql.SQLException;
import java.util.List;

import tierraMadre.Promocion;
import tierraMedia.dao.AtraccionesDAOImpl;
import tierraMedia.dao.PromocionesDAO;



public class PromotionService {
	
	public List<Promocion> list() throws SQLException {
		return PromocionesDAO.getPromociones(AtraccionesDAOImpl.getAtracciones());
	}

}
