package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Usuario;
import model.nullobjects.NullUser;
import persistence.UsuariosDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class UsuariosDAOImpl implements UsuariosDAO {

	public List<Usuario> getUsuarios() throws SQLException {

		List<Usuario> usuario = new ArrayList<Usuario>();
		Connection connection = ConnectionProvider.getConnection();

		String query = "select * from Usuarios";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		ResultSet resultados = preparedStatement.executeQuery();

		while (resultados.next()) {
			Usuario usuarios1 = toUsuario(resultados);
			usuario.add(usuarios1);
		}

		return usuario;

	}

	public Usuario toUsuario(ResultSet resultados) throws SQLException {

		return new Usuario(resultados.getInt("id"), resultados.getString("Nombre"), resultados.getDouble("Dinero"),
				resultados.getDouble("Tiempo"), resultados.getString("Preferencia"), resultados.getString("username"),
				resultados.getString("password"), resultados.getBoolean("admin"));
	}

	@Override
	public int update(Usuario usuario) {

		try {
			String sql = "UPDATE Usuarios SET Nombre = ?, Dinero = ?, Tiempo = ?, username = ?, password = ? WHERE Id = ?";

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, usuario.getNombre());
			statement.setDouble(i++, usuario.getPresupuesto());
			statement.setDouble(i++, usuario.getTiempoDisponible());
			statement.setString(i++, usuario.getUsername());
			statement.setString(i++, usuario.getPassword());
			statement.setInt(i++, usuario.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Usuario turista) {
		try {
			String sql = "DELETE FROM Usuarios WHERE Id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, turista.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM Usuarios";
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
	public int insert(Usuario turista) {
		try {
			String sql = "INSERT INTO USUARIOS (NOMBRE, DINERO, TIEMPO, USERNAME, PASSWORD) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			// id, nombre, preferencia, dinero, tiempo, username, password
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, turista.getNombre());
			statement.setDouble(2, turista.getPresupuesto());
			statement.setDouble(3, turista.getTiempoDisponible());
			statement.setString(4, turista.getUsername());
			statement.setString(5, turista.getPassword());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public Usuario find(Integer id) {
		try {
			String sql = "SELECT * FROM Usuarios WHERE Id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Usuario turista = NullUser.build();

			if (resultados.next()) {
				turista = toUsuario(resultados);
			}

			return turista;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM Usuarios";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int findIDByNombre(String nombre) {
		try {
			String sql = "SELECT Id FROM Usuarios WHERE Nombre = ? AND Deleted = 0";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			return resultados.getInt("Id");
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Usuario findByNombre(String nombre) {
		try {
			String sql = "SELECT * FROM Usuarios WHERE username = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			Usuario turista = NullUser.build();

			if (resultados.next()) {
				turista = toUsuario(resultados);
			}

			return turista;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}

	public Usuario findById(Integer id) {
		try {
			String sql = "SELECT * FROM Usuarios WHERE Id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Usuario turista = NullUser.build();

			if (resultados.next()) {
				turista = toUsuario(resultados);
			}

			return turista;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int logicalDelete(Usuario usuario) {
		try {
			String sql = "UPDATE Usuarios SET Deleted = 1 WHERE Nombre = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
