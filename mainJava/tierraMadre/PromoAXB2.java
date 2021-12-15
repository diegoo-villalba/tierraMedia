package tierraMadre;

import java.util.List;

import modelos.Atraccion;

public class PromoAXB2 extends Promocion2 {

	public PromoAXB2(Integer id, String nombre) {
		super(id, nombre);
	}
	
	
	public PromoAXB2(int id, TipoPromo tipoPromo, String nombre, int idAtr1, int idAtr2, int idAtr3) {
		super(id, tipoPromo, nombre, idAtr1, idAtr2, idAtr3);
		// TODO Auto-generated constructor stub
	}


	public PromoAXB2(String nombre,List<Atraccion> atraccionesPromo, double montoPromo, TipoPromo tipo) {
		super(nombre, atraccionesPromo, montoPromo, tipo);
	}

	/*
	@Override
	public void ofrecerPromo() {
		System.out.println("Pack " + getNombre() + ": Si compra" + atraccionesPromo.get(0).getNombre() 
				+ " y " + atraccionesPromo.get(1).getNombre() + ", "  +  atraccionesPromo.get(2).getNombre() + " es gratis.");
	
	}*/

}
