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

import persistence.AtraccionesDAO;
import tierraMadre.Atraccion;
import tierraMadre.Usuario;
import tierraMedia.db.ConnectionProvider;

public class tierraMediaDAOTest {

	@Test
	public void testConnectionOk() throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		Assert.assertNotNull(connection);
	}

	@Test
	public void testCargaUsuario() throws SQLException {
		UsuariosDAOImpl usuariosDAO = new UsuariosDAOImpl();

		Connection connection = ConnectionProvider.getConnection();
		String query = "select * from Usuarios";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultados = preparedStatement.executeQuery();

		Usuario usuario = usuariosDAO.toUsuario(resultados);

		assertNotNull(usuario);

	}

	@Test
	public void TestgetAtracciones() throws SQLException {
		AtraccionesDAOImpl atraccionesDAO = new AtraccionesDAOImpl();
		List<Atraccion> atracciones = atraccionesDAO.getAtracciones();

		assertNotNull(atracciones);
		assertEquals(8, atracciones.size());

	}
	

}
