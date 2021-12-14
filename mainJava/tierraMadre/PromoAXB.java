package tierraMadre;

import java.util.List;

public class PromoAXB extends Promocion {

	public PromoAXB(Integer id, String nombre) {
		super(id, nombre);
	}
	
	public PromoAXB(String nombre,List<Atraccion> atraccionesPromo, double montoPromo, TipoPromo tipo) {
		super(nombre, atraccionesPromo, montoPromo, tipo);
	}

	@Override
	public void ofrecerPromo() {
		System.out.println("Pack " + getNombre() + ": Si compra" + atraccionesPromo.get(0).getNombre() 
				+ " y " + atraccionesPromo.get(1).getNombre() + ", "  +  atraccionesPromo.get(2).getNombre() + " es gratis.");
	
	}

}
