package tierraMedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.nullobjects.NullUser;
import tierraMadre.TipoDeAtraccion;
import tierraMadre.Usuario;
import tierraMedia.db.ConnectionProvider;

public class UsuariosDAO {
	
	public static List<Usuario> getUsuarios() throws SQLException {

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

	public static Usuario toUsuario(ResultSet resultados) throws SQLException {

		return new Usuario(resultados.getInt("id"), resultados.getString("Nombre"), resultados.getDouble("Dinero"),
				resultados.getDouble("Tiempo"), TipoDeAtraccion.valueOf(resultados.getString("Preferencia")), resultados.getString("username"),
				resultados.getString("password"), resultados.getBoolean("admin"));
	}

	public static int update(Usuario turista) throws SQLException {

		String sql = "UPDATE Usuarios SET Dinero = ?, Tiempo = ? WHERE Nombre = ? ";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);

		statement.setDouble(1, turista.getPresupuesto());
		statement.setDouble(2, turista.getTiempoDisponible());
		statement.setString(3, turista.getNombre());

		int rows = statement.executeUpdate();

		return rows;
	}
	
	public Usuario findByUsername(String username) {
		try {
			String sql = "SELECT * FROM Usuarios WHERE username = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUser.build();

			if (resultados.next()) {
				user = toUsuario(resultados);
			}

			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}

}
