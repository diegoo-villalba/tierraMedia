package services;

import java.util.List;

import model.Promocion;
import persistence.commons.DAOFactory;

public class PromotionService {

	public List<Promocion> list() {
		return DAOFactory.getPromocionesDAO().findAll();

	}

}
