package GeneralTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tierraMadre.Atraccion;
import tierraMadre.Promocion;
import tierraMadre.TipoDeAtraccion;
import tierraMadre.Usuario;

/*public class AtraccionTests {

	Promocion unaPromocion;
	Atraccion atraccion1;
	Atraccion atraccion2;
	List<Usuario> turistas = new ArrayList<Usuario>();
	List<Atraccion> atraccionesPromo = new ArrayList<Atraccion>();

	@Test
	public void unaAtraccionTest() {
		Atraccion unaAtraccion = new Atraccion("Moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		assertNotNull(unaAtraccion);
	}

	@Test
	public void obtenerAtributosTest() {
		Atraccion unaAtraccion = new Atraccion("Moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		assertEquals("Moria", unaAtraccion.getNombre());
		assertEquals(10, unaAtraccion.getCosto(), 0);
		assertEquals(2, unaAtraccion.getTiempoRecorrido(), 0);
		assertEquals(6, unaAtraccion.getCupo());
		assertEquals(TipoDeAtraccion.AVENTURA, unaAtraccion.getTipo());
	}

	@Test
	public void turistaOcupaAtraccionTest() {
		Atraccion unaAtraccion = new Atraccion("Moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		Usuario turista = new Usuario("Ewoyn", 16, 8, TipoDeAtraccion.AVENTURA);

		assertTrue(unaAtraccion.puedoOfrecer(turista));
		unaAtraccion.elegirAtraccion();
		assertEquals(5, unaAtraccion.getCupo());
	}

	@Test
	public void turistaNoPuedeOcuparAtraccionTest() {
		Atraccion unaAtraccion = new Atraccion("Moria", 17, 2, 6, TipoDeAtraccion.AVENTURA);
		Usuario turista = new Usuario("Ewoyn", 16, 1, TipoDeAtraccion.AVENTURA);

		assertFalse(unaAtraccion.puedoOfrecer(turista));
		assertEquals(6, unaAtraccion.getCupo());
	}


	
	@Test //TODO Ver porque no me imprime por pantalla
	public void ordenarAtraccionesPorPreferenciaUsuarioYCostoTest() {
		Usuario turista = new Usuario("Ewoyn", 16, 1, TipoDeAtraccion.AVENTURA);
		atraccionesPromo = ReaderFile.getAtracciones("Atracciones.txt");
		List<Atraccion> atraccionesReordenadas = ReaderFile.listaAtraccionesOrdenadas(turista, atraccionesPromo);
		for(Atraccion atracc: atraccionesReordenadas) {
			System.out.println("Nombre atraccion: " + atracc.getNombre() + ". Tipo atraccion: " + atracc.getTipo());
		}

	}	
}

*/
