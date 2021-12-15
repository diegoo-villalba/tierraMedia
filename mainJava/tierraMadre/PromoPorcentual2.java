package tierraMadre;

import java.util.List;

import modelos.Atraccion;

public class PromoPorcentual2 extends Promocion2 {
	
	public PromoPorcentual2(Integer id, String nombre) {
		super(id, nombre);
	}
	
	
    public PromoPorcentual2(int id, TipoPromo tipoPromo, String nombre, int idAtr1, int idAtr2) {
		super(id, tipoPromo, nombre, idAtr1, idAtr2);
		// TODO Auto-generated constructor stub
	}


	public PromoPorcentual2(String nombre, List<Atraccion> atraccionesPromo, double montoPromo, TipoPromo tipo) {
		super(nombre, atraccionesPromo, montoPromo, tipo);
	}

	/*
    public double calculaPorcentajeDescuento() {
		//calculamos el porcentaje que le descontamos con la promo para mostrarlo en pantalla
		int sumaCostos = 0;
		for(Atraccion x : atraccionesPromo) {
			sumaCostos += x.getCosto();
			}
		return (sumaCostos - montoPromo) * 100 / sumaCostos ;
	}
    
    @Override
    public void ofrecerPromo() {

    	System.out.println("Pack " + getNombre() + ": " + atraccionesPromo.get(0).getNombre() 
				+ " y " + atraccionesPromo.get(1).getNombre() + " con un " + calculaPorcentajeDescuento()  + "% de descuento.");
	}
    */
}
