package tierraMedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.nullobjects.NullUser;
import persistence.UsuariosDAO;
import persistence.commons.MissingDataException;
import tierraMadre.TipoDeAtraccion;
import tierraMadre.Usuario;
import tierraMedia.db.ConnectionProvider;

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
				resultados.getDouble("Tiempo"), TipoDeAtraccion.valueOf(resultados.getString("Preferencia")), resultados.getString("username"),
				resultados.getString("password"), resultados.getBoolean("admin"));
	}
	
	@Override
	public int update(Usuario turista) {
		
		try {
		String sql = "UPDATE Usuarios SET Dinero = ?, Tiempo = ? WHERE Nombre = ? ";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);

		statement.setDouble(1, turista.getPresupuesto());
		statement.setDouble(2, turista.getTiempoDisponible());
		statement.setString(3, turista.getNombre());

		int rows = statement.executeUpdate();

		return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	@Override
	public int delete(Usuario turista) {
		try {
			String sql = "DELETE FROM Usuarios WHERE Nombre = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, turista.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Usuario findByNombre(String nombre) {
		try {
			String sql = "SELECT * FROM Usuarios WHERE Nombre = ?";
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
	public int insert(Usuario t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Usuario find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
