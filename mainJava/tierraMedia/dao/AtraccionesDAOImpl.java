package tierraMedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import persistence.AtraccionesDAO;
import persistence.commons.MissingDataException;
import tierraMadre.Atraccion;
import tierraMadre.TipoDeAtraccion;
import tierraMedia.db.ConnectionProvider;

public class AtraccionesDAOImpl implements AtraccionesDAO {

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

	public List<Atraccion> getAtracciones() {
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
		Integer id = resultSet.getInt("Id");
		String nombre = resultSet.getString("Nombre");
		int costo = resultSet.getInt("Costo");
		double tiempo = resultSet.getDouble("Tiempo");
		int cupo = resultSet.getInt("Cupo");
		TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(resultSet.getString("Tipo"));

		Atraccion atraccion = new Atraccion(id, nombre, costo, tiempo, cupo, tipo);
		return atraccion;
	}

	@Override
	public int update(Atraccion atraccion) {

		try {
			String sql = "UPDATE Atracciones SET Nombre = ?, Costo = ?, Tiempo = ?, Cupo = ? WHERE Id = ?";

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, atraccion.getNombre());
			statement.setInt(i++, atraccion.getCosto());
			statement.setDouble(i++, atraccion.getTiempoRecorrido());
			statement.setInt(i++, atraccion.getCupo());
			statement.setInt(i++, atraccion.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Atraccion> findAll() {
		try {
			String sql = "SELECT * FROM Atracciones";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Atraccion> attractions = new LinkedList<Atraccion>();
			while (resultados.next()) {
				attractions.add(toAtraccion(resultados));
			}

			return attractions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Atraccion find(Integer id) {
		try {
			String sql = "SELECT * FROM Atracciones WHERE Id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Atraccion attraction = null;
			if (resultados.next()) {
				attraction = toAtraccion(resultados);
			}

			return attraction;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM Atracciones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Atraccion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Atraccion t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
