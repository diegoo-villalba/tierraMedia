package tierraMedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tierraMadre.Atraccion;
import tierraMadre.PromoFactory;
import tierraMadre.Promocion;
import tierraMadre.TipoPromo;
import tierraMedia.db.ConnectionProvider;

public class PromocionesDAO {

	private static List<Atraccion> filtroAtraccion(String a1, String a2, String a3, List<Atraccion> atracciones) {
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

	public static Promocion toPromocion(ResultSet resultSet, List<Atraccion> atracciones) throws SQLException {
		String nombre = resultSet.getString("Nombre");
		String a1 = resultSet.getString("Atraccion1");
		String a2 = resultSet.getString("Atraccion2");
		String a3 = resultSet.getString("Atraccion3");
		double monto = resultSet.getDouble("Monto");
		TipoPromo tipo = TipoPromo.valueOf(resultSet.getString("Tipo promocion"));

		// Armo lista de las atracciones que van en la promo
		List<Atraccion> atraccionesPromo = filtroAtraccion(a1, a2, a3, atracciones);

		Promocion p = PromoFactory.buildPromocion(nombre, atraccionesPromo, tipo, monto);

		return p;
	}

	public static List<Promocion> getPromociones(List<Atraccion> atracciones) throws SQLException {
		List<Promocion> promociones = new ArrayList<Promocion>();
		Connection connection = ConnectionProvider.getConnection();

		String query = "select * from Promociones2";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Promocion promocion = toPromocion(resultSet, atracciones);
			promociones.add(promocion);
		}

		return promociones;
	}
	public static int updateAtraccionPromo(Promocion promo) throws SQLException {
		List<Atraccion> atracciones = promo.getAtraccionesPromo();
		
		int row = 0;
		
		for (Atraccion atraccion : atracciones) {
			
			String query = "UPDATE Atracciones SET Cupo = ? WHERE Nombre = ?";

			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, atraccion.getCupo());
			preparedStatement.setString(2, atraccion.getNombre());
			row = preparedStatement.executeUpdate();
			//row = row2;
		}
		return row;
	}
}
