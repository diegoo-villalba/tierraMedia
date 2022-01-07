package general;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Atraccion;
import model.Itinerario;
import model.Promocion;
import model.Usuario;
import persistence.impl.AtraccionesDAOImpl;
import persistence.impl.ItinerarioDAOImpl;
import persistence.impl.PromocionesDAOImpl;
import persistence.impl.UsuariosDAOImpl;

@Deprecated
public class Sistema {
	public static void main(String[] args) throws IOException, SQLException {

		UsuariosDAOImpl usuariosDAO = new UsuariosDAOImpl();
		AtraccionesDAOImpl atraccionesDAO = new AtraccionesDAOImpl();
		PromocionesDAOImpl promocionesDAO = new PromocionesDAOImpl();

		// agrega usuario y atracciones a lista usuarioList y atraccionesList
		List<Usuario> turistaList = usuariosDAO.getUsuarios();
		List<Atraccion> atraccionesList = atraccionesDAO.getAtracciones();

		// cargo las promociones a una promocionesList
		List<Promocion> promociones = PromocionesDAOImpl.getPromociones(atraccionesList);

		/*
		 * para cada turista, recorro la lista de promociones que estan disponibles para
		 * el usuario, si la puede adquirir se la ofrezco, y si no que siga
		 */

		for (Usuario turista : turistaList) {

			double costoFinal = 0;
			Itinerario itinerario = new Itinerario();
			Scanner scanner = new Scanner(new InputStreamReader(System.in));

			System.out.println("Hola " + turista.getNombre() + ", tenemos las siguientes atracciones para ofrecerle, "
					+ "si desea adquirirlas escriba 'SI', de lo contrario escriba 'NO'. \n");

			for (Promocion promocion : promociones) {

				boolean contienePromo = itinerario.yaTienePromo(promocion.getAtracciones());

				if (promocion.puedoOfrecer(turista) && !contienePromo) {
					// ofrezco promo con el mensaje que corresponde a cada tipo de promo

					promocion.ofrecerPromo();

					String valorEntrada = scanner.nextLine();

					if (valorEntrada.equals("si") || valorEntrada.equals("no")) {

						if (valorEntrada.equals("si")) {

							// agregar la promo al itinerario

							itinerario.agregarPromo(promocion);

							// cambiarle tiempo disponible y presupuesto al turista seg�n la promo que
							// acept�

							turista.aceptarPromo(promocion.getCostoTotalPromo(), promocion.getTiempoDeRecorrido());

							// cambiarle el cupo a las atracciones
							promocion.aceptarPromocion();

							// le sumo al contador de plata el monto de la promo
							costoFinal += promocion.getCostoTotalPromo();
						}
						// si no es "si", es "no" entonces quiero que siga

					} else
						System.out.println(valorEntrada + " no es una opci�n valida ");
				}

				promocionesDAO.updateAtraccionPromo(promocion);

			}

			/*
			 * Ahora ofrezco las atracciones solas. Primero las que son del tipo preferido
			 * del usuario, ordenadas por costo luego las que no son del mismo tipo,
			 * ordenadas tambi�n por costo.
			 */

			List<Atraccion> atraccionesPreferidas = Atraccion.listaAtraccionesOrdenadas(turista, atraccionesList);

			for (Atraccion a : atraccionesPreferidas) {

				boolean contieneAtraccion = itinerario.yaTieneAtraccion(a);

				if (a.puedoOfrecer(turista) && !contieneAtraccion) {

					System.out.println("Atracci�n " + a.getNombre() + " con un costo de $" + a.getCosto());

					String valorEntrada = scanner.nextLine();

					if (valorEntrada.equals("si") || valorEntrada.equals("no")) {

						if (valorEntrada.equals("si")) {

							// agregar la promo al itinerario

							itinerario.agregarAtraccion(a);

							// cambiarle tiempo disponible y presupuesto al turista seg�n la promo que //
							// acept�

							turista.aceptarPromo(a.getCosto(), a.getTiempoRecorrido());

							// cambiarle el cupo a las atracciones
							a.elegirAtraccion();

							// le descuento a la atracci�n el cupo en la base de datos

							atraccionesDAO.update(a);
							// le sumo al contador de plata el monto de la promo
							costoFinal += a.getCosto();
						}
						// si no es "si", es "no" entonces quiero que siga

					} else
						System.out.println(valorEntrada + " no es una opci�n valida ");

				}

			}
			System.out.println(
					"Usted ya no tiene tiempo o dinero para seguir eligiendo atracciones, a continuaci�n crearemos "
							+ "su itinerario. \n\n");
			// Escribo itinerarios
			// itinerario.escribirItinerario(costoFinal, turista.getNombre() + " itinerario"
			// + ".txt");
			// Cambiar en base de datos
			usuariosDAO.update(turista);
			// Guardar itinerarios en la base de datos
			ItinerarioDAOImpl itinerarioDAO = new ItinerarioDAOImpl();
			itinerarioDAO.insert(turista.getNombre(), itinerario.getAtracciones(), costoFinal,
					itinerario.getTiempoTotal());
		}

	}

}
