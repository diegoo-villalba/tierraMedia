package tierraMadre;

import java.util.List;

import modelos.Atraccion;

public class PromoFactory {

	public static Promocion buildPromocion(String nombre, List<Atraccion> atraccionesPromo, TipoPromo promotionType, double montoPromo ) {
		Promocion promocion = null;
		switch (promotionType) {
		case ABSOLUTA:
			promocion = new PromoAbsoluta(nombre, atraccionesPromo,montoPromo, TipoPromo.ABSOLUTA);
			break;
		case AXB:
			promocion = new PromoAXB(nombre, atraccionesPromo,montoPromo, TipoPromo.AXB);
			break;
		case PORCENTUAL:
			promocion = new PromoPorcentual(nombre, atraccionesPromo,montoPromo, TipoPromo.PORCENTUAL);
			break;
		default:
			break;
		}
		return promocion;
	}
}
