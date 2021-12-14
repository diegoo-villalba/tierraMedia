package tierraMadre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import tierraMedia.dao.AtraccionesDAOImpl;
import tierraMedia.dao.PromocionesDAOImpl;

public abstract class Promocion {

	protected Integer id;
	protected List<Atraccion> atraccionesPromo;
	protected String nombre;
	protected double montoPromo;
	protected TipoPromo tipoPromo;
	private AtraccionesDAOImpl atraccionesDAO;
	
	public Promocion(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Promocion(Integer id, String nombre, List<Atraccion> atraccionesPromo, double montoPromo, TipoPromo tipo) {
		this.id = id;
		this.nombre = nombre;
		this.atraccionesPromo = atraccionesPromo;
		this.montoPromo = montoPromo;
		this.tipoPromo = tipo;
	}

	public Promocion(String nombre, List<Atraccion> atraccionesPromo, double montoPromo, TipoPromo tipo) {
		this.nombre = nombre;
		this.atraccionesPromo = atraccionesPromo;
		this.montoPromo = montoPromo;
		this.tipoPromo = tipo;
	}

	public TipoPromo getTipo() {
		return tipoPromo;
	}

	public double getMontoPromo() {
		return montoPromo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getTiempoDeRecorrido() {
		// el tiempo que le tomar� realizar esta promo
		double sumaTiempos = 0;
		for (Atraccion x : atraccionesPromo) {
			sumaTiempos += x.getTiempoRecorrido();
		}
		return sumaTiempos;
	}

	public boolean puedeRecorrer(Usuario turista) {
		// me dice si la persona tiene el tiempo para recorrer las atracciones de la
		// promo
		return turista.getTiempoDisponible() >= getTiempoDeRecorrido();
	}

	public boolean puedePagar(Usuario turista) {
		// me dice si puede pagar la promo
		return turista.getPresupuesto() >= montoPromo;
	}

	private boolean tienenCupo() {
		boolean cupo = true;
		for (Atraccion atraccion : atraccionesPromo) {
			if (atraccion.getCupo() == 0) {
				cupo = false;
			}
		}
		return cupo;
	}

	public boolean puedoOfrecer(Usuario turista) {
		// si el tursita tiene la plata y el tiempo para esa promo, devuelve true
		// caso contrario, false
		return puedeRecorrer(turista) && puedePagar(turista) && tienenCupo();
	}

	public void aceptarPromocion() {
		for (Atraccion atraccion : atraccionesPromo) {
			atraccion.elegirAtraccion();
		}
	}

	public List<Atraccion> getAtraccionesPromo() {
		return atraccionesPromo;
	}

	public void ofrecerPromo() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(atraccionesPromo, montoPromo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Objects.equals(atraccionesPromo, other.atraccionesPromo)
				&& Double.doubleToLongBits(montoPromo) == Double.doubleToLongBits(other.montoPromo);
	}

	public static List<Atraccion> filtroAtraccion(String a1, String a2, String a3, List<Atraccion> atracciones) {
		// va a hacer la lista de las atracciones que est�n en la promo, para as� usarla
		// en el generador
		List<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
		for (Atraccion a : atracciones) {
			if (a.getNombre().equalsIgnoreCase(a1) || a.getNombre().equalsIgnoreCase(a2)
					|| a.getNombre().equalsIgnoreCase(a3)) {
				listaAtracciones.add(a);
			}
		}
		return listaAtracciones;
	}

	public static List<Promocion> filtraPromosPreferidas(TipoDeAtraccion tipo, List<Promocion> listaPromo) {
		// nos devuelve una lista con las promociones del tipo preferido del usuario
		List<Promocion> listaPreferida = new ArrayList<Promocion>();
		for (Promocion promocion : listaPromo) {
			// como las promo son siempre del mismo tipo, me basta con vos el tipo de la
			// primer atraccion de la lista de atracciones de la promo
			TipoDeAtraccion tipoPromo = promocion.getAtraccionesPromo().get(0).getTipo();
			if (tipo.equals(tipoPromo)) {
				listaPreferida.add(promocion);
			}
		}
		return listaPreferida;
	}

	@Override
	public String toString() {
		return "Te ofrecemos la promocion de: " + 
				nombre + 
				" que contiene las siguientes atracciones"+ 
				atraccionesPromo + " por un valor de " + montoPromo +".";
	}

	public static void main(String[] args) {
		AtraccionesDAOImpl atraccionesDAO = new AtraccionesDAOImpl();
		List<Atraccion> atraccionesList = atraccionesDAO.getAtracciones();

		// cargo las promociones a una promocionesList
		List<Promocion> promociones = PromocionesDAOImpl.getPromociones(atraccionesList);

		for (Promocion promocion : promociones) {
			System.out.println(promocion.getAtraccionesPromo());

		}
	}
}
