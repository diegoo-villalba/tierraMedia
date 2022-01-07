package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.enums.TipoDeAtraccion;
import utils.Adquirible;
import utils.Crypt;

public class Usuario {
	private int id;
	private String nombre, username, password;
	private Double presupuesto, tiempoDisponible;
	private String tipoAtraccion;
	private TipoDeAtraccion atraccion;
	private Boolean admin;
	private HashMap<String, String> errors;
	private List<Adquirible> adquisiciones = new ArrayList<Adquirible>();
	private List<Atraccion> itinerario = new ArrayList<Atraccion>();

	public Usuario(String nombre1, String username, String password, Double dinero, Double tiempo, boolean b) {
		this.nombre = nombre1;
		this.presupuesto = dinero;
		this.tiempoDisponible = tiempo;
		this.username = username;
		this.password = password;
		this.setAdmin(admin);
	}

	public Usuario(int id, String nombre, Double presupuesto, Double tiempoDisponible, String tipoAtraccion,
			String username, String password, Boolean admin) {
		this.setId(id);
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoAtraccion = tipoAtraccion;
		this.username = username;
		this.password = password;
		this.setAdmin(admin);
	}

	public Usuario(int id, String nombre, String username, String password, Double dinero, Double tiempo,
			Boolean admin) {
		this.setId(id);
		this.nombre = nombre;
		this.presupuesto = dinero;
		this.tiempoDisponible = tiempo;
		this.username = username;
		this.password = password;
		this.setAdmin(admin);
	}

	public Usuario(int i, String string, int j, int k, Object object, String string2, String string3, boolean b) {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public TipoDeAtraccion getAtraccion() {
		return atraccion;
	}

	public String getTipoAtraccion() {
		return tipoAtraccion;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public int getId() {
		return id;
	}
	
	public List<Adquirible> getAdquisiciones() {
		return adquisiciones;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public boolean puedeComprar(Atraccion unaAtraccion) {
		return this.presupuesto >= unaAtraccion.getCosto();
	}

	public boolean puedeSubir(Atraccion unaAtraccion) {
		return this.tiempoDisponible >= unaAtraccion.getTiempoRecorrido();
	}
	
	public boolean noTieneAtraccion(Atraccion atraccion) {
		return !yaTieneAtraccion(atraccion);
	}
	
	public boolean yaTieneAtraccion(Atraccion atraccion) {
		return adquisiciones.contains(atraccion);
	}

	public void aceptarPromo(double dineroGastado, double tiempoUsado) {
		this.presupuesto -= dineroGastado;
		this.tiempoDisponible -= tiempoUsado;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public boolean checkPassword(String password) {
		// this.password en realidad es el hash del password
		return Crypt.match(password, this.password);
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();

		if (presupuesto < 0) {
			errors.put("coins", "No debe ser negativo");
		}
		if (tiempoDisponible < 0) {
			errors.put("time", "No debe ser negativo");
		}
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public boolean isNull() {
		return false;
	}
	
	// Responde verdadero si tiene las monedas y el tiempo suficiente ---->
			// Verdadero, tengo dinero y tiempo para ir a...
		public boolean canGoAttraction(Atraccion atraccion) {

			return this.presupuesto >= atraccion.getCosto() 
					&& this.tiempoDisponible >= atraccion.getTiempoRecorrido()
					&& notYetAttraction(atraccion);								  
		}
		
		public boolean canGoPromo(Promocion promocion) {
			return this.presupuesto>= promocion.getCostoTotalPromo() 
					&& this.tiempoDisponible>= promocion.getTiempoDeRecorrido()
					&& notYetPromo(promocion);
		}

		// Si todavia no tiene en el itinerario la atraccion que le pasan como
		// parametro, da true --> Verdad, todavia no voy a .....
	public boolean notYetAttraction(Atraccion unaAtraccion) {

		for (Atraccion misAtracciones : this.itinerario) {
			if (misAtracciones.getNombre().equals(unaAtraccion.getNombre())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean notYetPromo(Promocion promocion) {

		for(Atraccion atraccionPromo : promocion.getAtracciones()) {
			for (Atraccion misAtracciones : this.itinerario) {
				if(misAtracciones.getNombre().equals(atraccionPromo.getNombre())) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void addAttraction(Atraccion unaAtraccion) {
		this.itinerario.add(unaAtraccion);
		this.tiempoDisponible -= unaAtraccion.getTiempoRecorrido();
	}
	
	public void payAttraction(Atraccion unaAtraccion) {
		this.presupuesto -= unaAtraccion.getCosto();
	}
	
	
}