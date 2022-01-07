package model;

import java.util.ArrayList;
import java.util.List;

import model.enums.TipoPromo;
import model.promotionsType.PromoAXB;
import model.promotionsType.PromoAbsoluta;
import model.promotionsType.PromoPorcentual;

public class Promocion {

		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		protected double costoPromo;
		protected String nombrePromo;
		private int idPromo;
		private TipoPromo tipoPromo;
		private int id_Atraccion1;
		private int id_Atraccion2;
		private int id_Atraccion3;

		public Promocion(int id, String nombre) {
			this.idPromo = id;
			this.nombrePromo = nombre;
		}

		public Promocion(int id, TipoPromo tipoPromo, String nombre, int idAtr1, int idAtr2) {
			this.idPromo = id;
			this.tipoPromo = tipoPromo;
			this.nombrePromo = nombre;
			this.id_Atraccion1 = idAtr1;
			this.id_Atraccion2 = idAtr2;
		}

		public Promocion(int id, TipoPromo tipoPromo, String nombre, int idAtr1, int idAtr2, int idAtr3) {
			this.idPromo = id;
			this.tipoPromo = tipoPromo;
			this.nombrePromo = nombre;
			this.id_Atraccion1 = idAtr1;
			this.id_Atraccion2 = idAtr2;
			this.id_Atraccion3 = idAtr3;
		}

		public Promocion(String nombre, List<Atraccion> atracciones2, double montoPromo, TipoPromo tipo) {
		}

		public int getIdPromo() {
			return idPromo;
		}

		public double getTiempoPromo() {
			return 0;
		}
		
		public double getCostoPromo() {
			return 0;
		}
		
		public TipoPromo getTipoPromo() {
			return tipoPromo;
		}
		
		public double getTiempoDeRecorrido() {
			// el tiempo que le tomará realizar esta promo
			double sumaTiempos = 0;
			for (Atraccion x : atracciones) {
				sumaTiempos += x.getTiempoRecorrido();
			}
			return sumaTiempos;
		}
		
		public double getCostoTotalPromo() {
			// el dinero que le costará realizar esta promo
			double sumaCostos = 0;
			for (Atraccion x : atracciones) {
				sumaCostos += x.getCosto();
			}
			return sumaCostos;
		}
		
		public boolean tienenCupo() {
			boolean cupo = true;
			for (Atraccion atraccion : atracciones) {
				if (atraccion.getCupo() == 0) {
					cupo = false;
				}
			}
			return cupo;
		}
		
		public void ofrecer(Usuario turista) {
		}
		
		public void ofrecerPromo() {
		}

		public boolean puedeRecorrer(Usuario turista) {
			return turista.getTiempoDisponible() >= getTiempoDeRecorrido();
		}

		public boolean puedePagar(Usuario turista) {
			return turista.getPresupuesto() >= getCostoTotalPromo();
		}
		
		public boolean puedoOfrecer(Usuario turista) {
			return puedeRecorrer(turista) && puedePagar(turista) && tienenCupo();
		}

		public void aceptarPromocion() {
			for (Atraccion atraccion : atracciones) {
				atraccion.elegirAtraccion();
			}
		}

		public String getNombrePromo() {
			return nombrePromo;
		}

		public List<Atraccion> getAtracciones() {
			return atracciones;
		}

		public void getCupo() {
			for (Atraccion atraccion : atracciones) {
				System.out.println(atraccion.getCupo());
			}
		}

		public Atraccion getAtraccion() {
			Atraccion unaAtraccion = null;
			for (Atraccion atraccion : atracciones) {
				unaAtraccion = atraccion;
			}

			return unaAtraccion;
		}

		@Override
		public String toString() {
			return "Promocion " + nombrePromo + ", que incluye las siguientes atracciones: " + "\n"
					+ atracciones.get(0).getNombre() + " y " + atracciones.get(1).getNombre();
		}

		public static Promocion generarPromo(String[] datos, TipoPromo tipoDePromocion) {

			Promocion promocion = null;

			switch (tipoDePromocion) {

			case ABSOLUTA:
				promocion = new PromoAbsoluta(Integer.parseInt(datos[0]), datos[2]);
				break;
			case PORCENTUAL:
				promocion = new PromoPorcentual(Integer.parseInt(datos[0]), datos[2]);
				break;
			case AXB:
				promocion = new PromoAXB(Integer.parseInt(datos[0]), datos[2]);
				break;
			default:
				break;

			}
			return promocion;
		}

}
