package tierraMedia.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tierraMadre.Atraccion;
import tierraMedia.db.ConnectionProvider;

public class tierraMediaDAOTest {

	@Test
	public void testConnectionOk() throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		Assert.assertNotNull(connection);
	}

	@Test
	public void testCargaUsuario() throws SQLException {
		UsuariosDAO usuario = new UsuariosDAO();

		Connection connection = ConnectionProvider.getConnection();
		String query = "select * from Usuarios";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultados = preparedStatement.executeQuery();

		UsuariosDAO.toUsuario(resultados);

		assertNotNull(usuario);

	}

	@Test
	public void TestgetAtracciones() throws SQLException {
		List<Atraccion> atracciones = AtraccionesDAO.getAtracciones();

		assertNotNull(atracciones);
		assertEquals(8, atracciones.size());

	}
	

}
