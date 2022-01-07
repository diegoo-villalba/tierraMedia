package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.ElItinerario;
import model.Promocion;
import model.Usuario;
import persistence.ElItinerarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;

public class ElItinerarioDAOImpl implements ElItinerarioDAO {

	UsuariosDAOImpl unUser = new UsuariosDAOImpl();
	AtraccionesDAOImpl unaAtraccion = new AtraccionesDAOImpl();

	@Override
	public int cargarAtraccion(Atraccion atraccion, Usuario usuario) {
		try {
			String sql = "INSERT INTO ElItinerario (Id_user, Id_attraction) VALUES (?, ?)";

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, DAOFactory.getUsuariosDAO().findIDByNombre(usuario.getNombre()));
			statement.setInt(2, DAOFactory.getAtraccionesDAO().findIDByNombre(atraccion.getNombre()));
			int rows = statement.executeUpdate();

			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public ElItinerario toElItinerario(ResultSet resultado) {
		try {
			return new ElItinerario(unaAtraccion.findById(resultado.getInt("Id_attraction")),
					unUser.findById(resultado.getInt("Id_user")));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(ElItinerario t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ElItinerario t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ElItinerario t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ElItinerario> findAll() {
		try {
			String sql = "SELECT * FROM ElItinerario";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<ElItinerario> itinerarios = new LinkedList<ElItinerario>();

			while (resultados.next()) {
				itinerarios.add(toElItinerario(resultados));
			}

			return itinerarios;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT count(1) AS 'total' FROM ElItinerario";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("total");

			
			return total;
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public List<Atraccion> findItinerarioById(int id) {
		try {
		String sql = "SELECT * FROM ElItinerario WHERE Id_user = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultados = statement.executeQuery();

		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		
		String sql2 = "SELECT * FROM Atracciones WHERE Id= ?";
		
		while (resultados.next()) {


			Connection conn2 = ConnectionProvider.getConnection();
			PreparedStatement statement2 = conn2.prepareStatement(sql2);
			statement2.setInt(1, resultados.getInt("Id_attraction"));
			ResultSet resultados2 = statement2.executeQuery();
			
			
			atracciones.add(AtraccionesDAOImpl.toAtraccion(resultados2));
		}
		
		
		
		return atracciones;
		} catch(Exception e) {
			throw new MissingDataException(e);
		} 
	}

}
