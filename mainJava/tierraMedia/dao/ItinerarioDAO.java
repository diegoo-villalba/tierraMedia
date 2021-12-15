package tierraMedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import modelos.Atraccion;
import persistence.commons.ConnectionProvider;

public class ItinerarioDAO {
		
			public int insert(String nombre, List<Atraccion> atracciones, double totalCosto, double tiempoTotal ) throws SQLException {
				String query = "insert into Itinerarios (Nombre,Resumen,TotalCosto,TotalTiempo) values(?,?,?,?)";
		
				Connection connection = ConnectionProvider.getConnection();
		
				PreparedStatement preparedStatement = connection.prepareStatement(query);
		
				preparedStatement.setString(1, nombre);
				preparedStatement.setObject(2, atracciones);
				preparedStatement.setDouble(3,totalCosto);
				preparedStatement.setDouble(4, tiempoTotal);
		
				int rowsUpdated = preparedStatement.executeUpdate();
		
				return rowsUpdated;
			}
		
		}
