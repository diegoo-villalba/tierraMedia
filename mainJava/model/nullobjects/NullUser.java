package model.nullobjects;

import modelos.Usuario;

public class NullUser extends Usuario {

	public static Usuario build() {
		return new NullUser();
	}
	
	//int id,String nombre, double presupuesto, double tiempoDisponible, TipoDeAtraccion atraccion, String username, String password, Boolean admin
	public NullUser() {
		super(0, "", 0, 0, null, "", "", false);
	}
	
	@Override
	public boolean isNull() {
		return true;
	}
	
}
