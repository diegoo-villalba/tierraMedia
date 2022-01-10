package persistence;

import model.Promocion;
import persistence.commons.GenericDAO;

public interface PromocionesDAO extends GenericDAO<Promocion>{

	void updateAtracciones(Promocion unaPromocion);
	
}
