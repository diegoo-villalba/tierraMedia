package model.promotionsType;

import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.enums.TipoPromo;

public class PromoAXB extends Promocion {

	public PromoAXB(Integer id, String nombre) {
		super(id, nombre);
	}
	
	
	public PromoAXB(int id, TipoPromo tipoPromo, String nombre, int idAtr1, int idAtr2, int idAtr3) {
		super(id, tipoPromo, nombre, idAtr1, idAtr2, idAtr3);
		// TODO Auto-generated constructor stub
	}


	public PromoAXB(String nombre,List<Atraccion> atraccionesPromo, double montoPromo, TipoPromo tipo) {
		super(nombre, atraccionesPromo, montoPromo, tipo);
	}

	/*
	@Override
	public void ofrecerPromo() {
		System.out.println("Pack " + getNombre() + ": Si compra" + atraccionesPromo.get(0).getNombre() 
				+ " y " + atraccionesPromo.get(1).getNombre() + ", "  +  atraccionesPromo.get(2).getNombre() + " es gratis.");
	
	}*/

}
