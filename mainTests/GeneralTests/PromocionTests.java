package GeneralTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tierraMadre.Atraccion;
import tierraMadre.PromoAbsoluta;
import tierraMadre.Promocion;
import tierraMadre.TipoDeAtraccion;
import tierraMadre.TipoPromo;
import tierraMadre.Usuario;

/*public class PromocionTests {
	Usuario turista;
	Usuario turista2;
	Promocion promo;
	Atraccion atraccion1;
	Atraccion atraccion2;
	List<Usuario> turistas = new ArrayList<Usuario>();
	List<Atraccion >atraccionesPromo = new  ArrayList<Atraccion>();
	
	@Before
	public void setUp() {
		turista = new Usuario("Ewoyn", 16, 8, TipoDeAtraccion.AVENTURA);
		turista2 = new Usuario("Alf", 9, 2, TipoDeAtraccion.AVENTURA);
		atraccion1 = new Atraccion("Moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		atraccion2 = new Atraccion("Minas Tirith", 5, 3, 25, TipoDeAtraccion.PAISAJE);
		
		atraccionesPromo.add(atraccion1);
		atraccionesPromo.add(atraccion2);
		
		promo = new PromoAbsoluta("Promo Aventura", atraccionesPromo, 15, TipoPromo.ABSOLUTA);
		
		//public Promocion(String nombre, List<Atraccion> atraccionesPromo, double montoPromo, TipoPromo tipo) {
		
	}
	@Test
	public void unaPromocionTest() {
		assertNotNull(promo);
	}
	
	@Test
	public void obtenerAtributosTest() {
		assertEquals("Promo Aventura", promo.getNombre());
		assertEquals(15, promo.getMontoPromo(),0);
		assertEquals(TipoPromo.valueOf("ABSOLUTA"), promo.getTipo());
	}
	
	@Test
	public void obtenerTiempoTotalPromoTest() {
		assertEquals(5, promo.getTiempoDeRecorrido(), 0);
	}
	
	
	@Test
	public void cargarEImprimirArchivoTuristasTest() {
		turistas = ReaderFile.getUsuarios("usuarios.txt");
		for(Usuario turista : turistas) {
			System.out.println(turista);
		}
		
	}
	
	@Test
	public void puedeAdquirirPromoTest() {
		assertTrue(promo.puedoOfrecer(turista));
	}
	
	@Test
	public void noPuedeAdquirirPromoTest() {
		assertFalse(promo.puedoOfrecer(turista2));
	}
	
	@Test
	public void cargarEImprimirArchivoPromoTest() {
		List<Promocion> promociones = ReaderFile.getPromociones("Promociones.txt", atraccionesPromo);
		for(Promocion promo : promociones) {
			System.out.println(promo.getClass());
		}
	}
}*/
