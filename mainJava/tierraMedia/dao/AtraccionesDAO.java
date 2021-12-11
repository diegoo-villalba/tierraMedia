package tierraMedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tierraMadre.Atraccion;
import tierraMadre.TipoDeAtraccion;
import tierraMedia.db.ConnectionProvider;
public class AtraccionesDAO {
	
	public Atraccion findById(Integer id) {
		try {
			String sql = "SELECT * FROM Atracciones WHERE Id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Atraccion atraccion = null;

			if (resultados.next()) {
				atraccion = toAtraccion(resultados);
			}

			return atraccion;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}

	public static List<Atraccion> getAtracciones() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		
		try {
		Connection connection = ConnectionProvider.getConnection();

		String query = "select * from Atracciones";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Atraccion atraccion = toAtraccion(resultSet);
			atracciones.add(atraccion);
		}

		return atracciones;
		
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int elegirAtraccion(Atraccion atraccion) throws SQLException {
		String sql = "UPDATE Atracciones SET Cupo = ? WHERE Nombre = ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, atraccion.getCupo() - 1);
		statement.setString(2, atraccion.getNombre());
		int rows = statement.executeUpdate();
		return rows;
	}

	public static Atraccion toAtraccion(ResultSet resultSet) throws SQLException {
		String nombre = resultSet.getString("Nombre");
		int costo = resultSet.getInt("Costo");
		double tiempo = resultSet.getDouble("Tiempo");
		int cupo = resultSet.getInt("Cupo");
		TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(resultSet.getString("Tipo"));

		Atraccion atraccion = new Atraccion(nombre, costo, tiempo, cupo, tipo);
		return atraccion;
	}

	public static int update(Atraccion atraccion) throws SQLException {
		String sql = "UPDATE Atracciones SET Cupo = ? WHERE Nombre = ?";

		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, atraccion.getCupo());
		statement.setString(2, atraccion.getNombre());

		int rows = statement.executeUpdate();
		return rows;
	}
	
}
