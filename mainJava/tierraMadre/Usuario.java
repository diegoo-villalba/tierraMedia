package tierraMadre;

import java.util.HashMap;
import java.util.Map;

import utils.Crypt;

public class Usuario {
	private int id;
	private String nombre, username, password;
	private double presupuesto, tiempoDisponible;
	private TipoDeAtraccion atraccion;
	private Boolean admin; 
	private HashMap<String, String> errors;


	public Usuario(int id,String nombre, double presupuesto, double tiempoDisponible, TipoDeAtraccion atraccion, String username, String password, Boolean admin) {
		this.setId(id);
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccion = atraccion;
		this.username = username;
		this.password=password;
		this.setAdmin(admin);
	}
	//Integer id, String username, String password, Integer coins, Double time, Boolean admin
	
	public Usuario(int id, String nombre, String username, String password, double dinero, double tiempo, Boolean admin ) {
		this.setId(id);
		this.nombre = nombre;
		this.presupuesto = dinero;
		this.tiempoDisponible = tiempo;
		this.username = username;
		this.password=password;
		this.setAdmin(admin);
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
	
	public boolean puedeComprar(Atraccion unaAtraccion) {
		return this.presupuesto >= unaAtraccion.getCosto();
	}
	
	public boolean puedeSubir(Atraccion unaAtraccion) {
		return this.tiempoDisponible >= unaAtraccion.getTiempoRecorrido();
	}

	public void aceptarPromo(double dineroGastado, double tiempoUsado) {
		this.presupuesto -= dineroGastado;
		this.tiempoDisponible -= tiempoUsado;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = Crypt.hash(password);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public Boolean isAdmin() {
		return admin;
	}

	public boolean isNull() {
		return false;
	}

}