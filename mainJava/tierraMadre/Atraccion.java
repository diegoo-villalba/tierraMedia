package tierraMadre;

import java.util.*;

public class Atraccion {
	private String nombre;
	private int costo;
	private double tiempoRecorrido;
	private int cupo;
	private TipoDeAtraccion tipo;
	private Map<String, String> errors;

	public Atraccion(String nombre, int costo, double tiempoRecorrido, int cupo, TipoDeAtraccion tipo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoRecorrido = tiempoRecorrido;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getCosto() {
		return costo;

	}

	public boolean esValida() {
		validacion();
		return errors.isEmpty();
	}

	public void validacion() {
		errors = new HashMap<String, String>();

		if (costo <= 0) {
			errors.put("cost", "Error! El vlaor debe ser positivo");
		}
		if (tiempoRecorrido <= 0) {
			errors.put("duration", "Error! El vlaor debe ser positivo");
		}

		if (cupo <= 0) {
			errors.put("capacity", "Error! El vlaor debe ser positivo");
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
