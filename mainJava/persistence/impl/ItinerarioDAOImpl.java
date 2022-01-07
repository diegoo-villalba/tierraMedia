package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.Itinerario;
import model.Usuario;
import persistence.ItinerarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;

public class ItinerarioDAOImpl implements ItinerarioDAO {

	public int insert(String nombre, List<Atraccion> atracciones, double totalCosto, double tiempoTotal)
			throws SQLException {
		String query = "insert into Itinerarios (Nombre,Resumen,TotalCosto,TotalTiempo) values(?,?,?,?)";

		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setString(1, nombre);
		preparedStatement.setObject(2, atracciones);
		preparedStatement.setDouble(3, totalCosto);
		preparedStatement.setDouble(4, tiempoTotal);

		int rowsUpdated = preparedStatement.executeUpdate();

		return rowsUpdated;
	}

	public static Itinerario toItinerario(ResultSet resultSet) {
		try {
			int id = resultSet.getInt("Id");
			String nombre = resultSet.getString("Nombre");
			String resumen = resultSet.getString("Resumen");
			Integer costoTotal = resultSet.getInt("TotalCosto");
			Double tiempoTotal = resultSet.getDouble("TotalTiempo");

			Itinerario itinerario = new Itinerario(id, nombre, resumen, costoTotal, tiempoTotal);
			return itinerario;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Itinerario> findAll() {
		try {
			String sql = "SELECT * FROM Itinerarios";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Itinerario> itinerario = new LinkedList<Itinerario>();
			while (resultados.next()) {
				itinerario.add(toItinerario(resultados));
			}

			return itinerario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	public static void main(String[] args) {
		ItinerarioDAOImpl itinerarioDAO = new ItinerarioDAOImpl();
		Itinerario itinerario = itinerarioDAO.find(1);
		System.out.println(itinerario.getNombre());
		}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Itinerario itinerario) {
		try {
			String sql = "INSERT INTO Itinerarios (Nombre, Resumen, TotalCosto, TotalTiempo) VALUES (?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, itinerario.getNombre());
			statement.setString(i++, itinerario.getResumen());
			statement.setInt(i++, itinerario.getCostoTotal());
			statement.setDouble(i++, itinerario.getTiempoTotal());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Itinerario itinerario) {
		try {
			String sql = "UPDATE Itinerarios SET Resumen = ?, TotalCosto = ?, TotalTiempo = ? WHERE Id = ?";

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, itinerario.getResumen());
			statement.setInt(i++, itinerario.getCostoTotal());
			statement.setDouble(i++, itinerario.getTiempoTotal());
			statement.setInt(i++, itinerario.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Itinerario t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Itinerario find(Integer id) {
		try {
			String sql = "SELECT * FROM Itinerarios WHERE Id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Itinerario itinerario = null;
			if (resultados.next()) {
				itinerario = toItinerario(resultados);
			}

			return itinerario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	

}
