package GeneralTests;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import modelos.Atraccion;
import tierraMadre.PromoAbsoluta;
import tierraMadre.Promocion;
import tierraMadre.TipoDeAtraccion;
import tierraMadre.TipoPromo;
/*
public class TuristaTests {
	Promocion unaPromocion;
	Atraccion atraccion1;
	Atraccion atraccion2;
	List<Usuario> turistas = new ArrayList<Usuario>();
	List<Atraccion >atraccionesPromo = new  ArrayList<Atraccion>();
	
	//public Atraccion(String nombre, int costo, int tiempoRecorrido, int cupo, String tipo) {

	//public Promocion(String nombre, List<Atraccion> atraccionesPromo, double montoPromo, TipoPromo tipo) {
	
	@Test
	public void unTuristaTest() {
		Usuario turista = new Usuario("Ewoyn", 10, 8, TipoDeAtraccion.AVENTURA);
		assertNotNull(turista);
	}
	
	@Test
	public void obtenerAtributosTest() {
		Usuario turista = new Usuario("Ewoyn", 10, 8, TipoDeAtraccion.AVENTURA);
		assertEquals("Ewoyn", turista.getNombre());
		assertEquals(10, turista.getPresupuesto(),0);
		assertEquals(8, turista.getTiempoDisponible(),0);
		assertEquals(TipoDeAtraccion.AVENTURA, turista.getAtraccion());
	}
	
	@Test
	public void cargarEImprimirArchivoTuristasTest() {
		turistas = ReaderFile.getUsuarios("usuarios.txt");
		for(Usuario turista : turistas) {
			System.out.println(turista);
		}
		
	}
	
	@Test
	public void aceptaPromoTest() {
		Usuario turista = new Usuario("Ewoyn", 16, 8, TipoDeAtraccion.AVENTURA);
		atraccion1 = new Atraccion("Moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		atraccion2 = new Atraccion("Minas Tirith", 5, 3, 25, TipoDeAtraccion.PAISAJE);
		
		atraccionesPromo.add(atraccion1);
		atraccionesPromo.add(atraccion2);
		
		unaPromocion = new PromoAbsoluta("Promo Aventura", atraccionesPromo, 15, TipoPromo.ABSOLUTA);
		
		turista.aceptarPromo(unaPromocion.getMontoPromo(), unaPromocion.getTiempoDeRecorrido());
		
		assertEquals(1, turista.getPresupuesto(), 0);
		assertEquals(3, turista.getTiempoDisponible(), 0);
		
	}

}*/
