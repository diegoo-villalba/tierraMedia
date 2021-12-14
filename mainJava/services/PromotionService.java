package services;

import java.util.List;

import persistence.commons.DAOFactory;
import tierraMadre.Promocion2;

public class PromotionService {

	public List<Promocion2> list() {
		return DAOFactory.getPromocionesDAO().findAll();

	}

}
