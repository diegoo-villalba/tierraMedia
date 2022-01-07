package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import utils.Adquirible;

public class Itinerario {
	private int id;
	private String nombre;
	private String resumen;
	private Integer costoTotal;
	private Double tiempoTotal;
	public Atraccion atraccion;
	private Usuario turista;
	private static List<Atraccion> atracciones;

	public Itinerario() {
	}
	
	public Itinerario(int id, String nombre, String resumen, Integer costoTotal, Double tiempoTotal) {
		this.setId(id);
		this.nombre = nombre;
		this.resumen = resumen;
		this.costoTotal = costoTotal;
		this.tiempoTotal = tiempoTotal;
	}

	public Itinerario(String nombre, String resumen, Integer costoTotal, Double tiempoTotal) {
		super();
		this.nombre = nombre;
		this.resumen = resumen;
		this.costoTotal = costoTotal;
		this.tiempoTotal = tiempoTotal;
	}

	public String getNombre() {
		return nombre;
	}

	public String getResumen() {
		return resumen;
	}

	public Integer getCostoTotal() {
		return costoTotal;
	}

	public void setNameTurista(String nombre) {
		this.nombre = turista.getNombre();
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setResumen(String resumen) {
		this.resumen = this.atraccion.getNombre();
	}

	public void setCostoTotal(Integer costoTotal) {
		this.costoTotal = atraccion.getCosto();
	}

	public void setTiempoTotal(Double tiempoTotal) {
		this.tiempoTotal = atraccion.getTiempoRecorrido();
	}

	public void agregarAtraccion(Atraccion atraccion) {
		atracciones.add(atraccion);
	}

	public void agregarPromo(Promocion promocion) {
		atracciones.addAll(promocion.getAtracciones());
	}

	public boolean yaTieneAtraccion(Atraccion atraccion) {
		return atracciones.contains(atraccion);
	}

	public boolean noTieneAtraccion(Atraccion atraccion) {
		return !yaTieneAtraccion(atraccion);
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

	private void calculaTiempoTotal() {
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

	public int getId() {
		return id;
	}

}