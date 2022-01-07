package model.promotionsType;

import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.enums.TipoPromo;

public class PromoAbsoluta extends Promocion{
	
	public PromoAbsoluta(Integer id, String nombre) {
		super(id, nombre);
	}
	
	public PromoAbsoluta(int id, TipoPromo tipoPromo, String nombre, int idAtr1, int idAtr2) {
		super(id, tipoPromo, nombre, idAtr1, idAtr2);
		// TODO Auto-generated constructor stub
	}

	public PromoAbsoluta (String nombre,List<Atraccion> atracciones, double montoPromo, TipoPromo tipo) {
		super(nombre, atracciones, montoPromo, tipo);
	}
	
	/*@Override
	public void ofrecerPromo() {
		 System.out.println("Pack " + getNombrePromo() + ": " + atraccionesPromo.get(0).getNombre() + " y " 
				+ atraccionesPromo.get(1).getNombre() + " a solo $" + getMontoPromo());
	}
	*/
	
}
