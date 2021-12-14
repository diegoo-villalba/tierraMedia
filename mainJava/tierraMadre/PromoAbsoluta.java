package tierraMadre;

import java.util.List;

public class PromoAbsoluta extends Promocion{
	
	public PromoAbsoluta(Integer id, String nombre) {
		super(id, nombre);
	}

	public PromoAbsoluta (String nombre,List<Atraccion> atracciones, double montoPromo, TipoPromo tipo) {
		super(nombre, atracciones, montoPromo, tipo);
	}
	
	@Override
	public void ofrecerPromo() {
		 System.out.println("Pack " + getNombre() + ": " + atraccionesPromo.get(0).getNombre() + " y " 
				+ atraccionesPromo.get(1).getNombre() + " a solo $" + getMontoPromo());
	}
	
	
}
