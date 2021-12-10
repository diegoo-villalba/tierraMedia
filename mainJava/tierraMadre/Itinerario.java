package tierraMadre;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Itinerario {
	private static List<Atraccion> atracciones;
	private static double tiempoTotal;

	public Itinerario() {
		atracciones = new ArrayList<Atraccion>();
	}

	public void agregarAtraccion(Atraccion atraccion) {
		atracciones.add(atraccion);
	}

	public void agregarPromo(Promocion promocion) {
		atracciones.addAll(promocion.getAtraccionesPromo());
	}

	public boolean yaTieneAtraccion(Atraccion atraccion) {
		return atracciones.contains(atraccion);
	}

	public boolean yaTienePromo(List<Atraccion> atraccionesPromo) {
		boolean contiene = false;
		for (Atraccion a : atraccionesPromo) {
			if (atracciones.contains(a)) {
				contiene = true;
			}
		}
		return contiene;
	}

	public double getTiempoTotal() {
		calculaTiempoTotal();
		return tiempoTotal;
	}

	private static void calculaTiempoTotal() {
		double sumaFinal = 0;
		for (Atraccion atraccion : atracciones) {
			sumaFinal += atraccion.getTiempoRecorrido();
		}
		tiempoTotal = sumaFinal;
	}

	public void escribirItinerario(double montoFinal, String file) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(file));
		calculaTiempoTotal();
		String tiempo = Double.toString(tiempoTotal);
		String monto = Double.toString(montoFinal);
		salida.println("Usted adquiri� las siguientes atracciones: \n");
		for (Atraccion atraccion : atracciones) {
			salida.println(atraccion);
		}
		salida.println("Realizar este recorrido le llevar� " + tiempo + " horas , y el total a pagar ser� $" + monto);
		salida.close();
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

}