package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import model.enums.TipoDeAtraccion;
import utils.Adquirible;
import utils.CostoComparacion;

public class Atraccion implements Adquirible {
	private Integer id;
	private String nombre;
	private Integer costo;
	private Double tiempoRecorrido;
	private Integer cupo;
	private TipoDeAtraccion tipo;
	protected static ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
	private Map<String, String> errors;

	public Atraccion(String nombre, Integer costo, Double tiempoRecorrido, Integer cupo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoRecorrido = tiempoRecorrido;
		this.cupo = cupo;
	}

	public Atraccion(Integer id, String nombre, Integer costo, Double tiempoRecorrido, Integer cupo) {
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoRecorrido = tiempoRecorrido;
		this.cupo = cupo;
	}

	public Atraccion(String nombre, Integer costo, Double tiempoRecorrido, Integer cupo, TipoDeAtraccion tipo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoRecorrido = tiempoRecorrido;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public Atraccion(Integer id, String nombre, Integer costo, Double tiempoRecorrido, Integer cupo,
			TipoDeAtraccion tipo) {
		this(nombre, costo, tiempoRecorrido, cupo, tipo);
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getCosto() {
		return costo;

	}

	public Integer getId() {
		return id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public void setTiempoRecorrido(Double tiempoRecorrido) {
		this.tiempoRecorrido = tiempoRecorrido;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public void setTipo(TipoDeAtraccion tipo) {
		this.tipo = tipo;
	}

	public static Atraccion encontrarPorId(int id) {

		Atraccion unaAtraccion = null;

		boolean found = false;

		Iterator<Atraccion> atraccionIterator = atracciones.iterator();
		while (atraccionIterator.hasNext() || !found) {
			Atraccion atraccion = atraccionIterator.next();
			if (atraccion.getId() == id) {
				found = true;
				unaAtraccion = atraccion;
			}
		}

		return unaAtraccion;
	}

	public boolean esValida() {
		validacion();
		return errors.isEmpty();
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void validacion() {
		errors = new HashMap<String, String>();

		if (costo <= 0) {
			errors.put("cost", "Error! El valor debe ser positivo");
		}
		if (tiempoRecorrido <= 0) {
			errors.put("duration", "Error! El valor debe ser positivo");
		}

		if (cupo <= 0) {
			errors.put("capacity", "Error! El valor debe ser positivo");
		}
	}

	public double getTiempoRecorrido() {
		return tiempoRecorrido;
	}

	public int getCupo() {
		return cupo;
	}

	public TipoDeAtraccion getTipo() {
		return tipo;
	}
	
	public void takeASit(Usuario unUsuario) {
		this.cupo-=1;
		unUsuario.addAttraction(this);
	}
	
	public boolean hasAPlace() {
		return this.cupo >= 1;
	}

	public void elegirAtraccion() {
		this.cupo -= 1;
	}

	public boolean tieneCupo(int i) {
		return this.cupo >= i;
	}

	public boolean puedoOfrecer(Usuario turista) {
		// el turista tiene tiempo, dinero y la atraccion tiene cupo
		boolean tieneTiempo = turista.getTiempoDisponible() >= tiempoRecorrido;
		boolean tienedinero = turista.getPresupuesto() >= costo;
		boolean hayCupo = cupo >= 1;

		return tieneTiempo && tienedinero && hayCupo;
	}

	public static List<Atraccion> listaAtraccionesOrdenadas(Usuario usuario, List<Atraccion> atracciones) {
		TipoDeAtraccion tipo = usuario.getAtraccion();

		// hacemos una lista con las atracciones preferidas del usuario

		List<Atraccion> listaAtraccionesP = new ArrayList<Atraccion>();
		List<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
		for (Atraccion a : atracciones) {
			if (tipo.equals(a.getTipo())) {
				listaAtraccionesP.add(a);
			} else {
				listaAtracciones.add(a);
			}
		}
		Collections.sort(listaAtraccionesP, new CostoComparacion());
		Collections.sort(listaAtracciones, new CostoComparacion());
		listaAtraccionesP.addAll(listaAtracciones);
		return listaAtraccionesP;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, cupo, nombre, tiempoRecorrido, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costo == other.costo && cupo == other.cupo && Objects.equals(nombre, other.nombre)
				&& tiempoRecorrido == other.tiempoRecorrido && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return nombre;
	}
}
