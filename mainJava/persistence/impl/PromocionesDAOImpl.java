package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.enums.TipoPromo;
import model.promotionsType.PromoAXB;
import model.promotionsType.PromoAbsoluta;
import model.promotionsType.PromoPorcentual;
import persistence.PromocionesDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;

public class PromocionesDAOImpl implements PromocionesDAO {

	public static List<Promocion> getPromociones(List<Atraccion> atracciones) {

		try {
			PromocionesDAOImpl promocionDAO = new PromocionesDAOImpl();
			List<Promocion> promociones = new ArrayList<Promocion>();
			Connection connection = ConnectionProvider.getConnection();

			String query = "select * from Promociones";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Promocion promocion = promocionDAO.crearPromo(resultSet);
				promociones.add(promocion);
			}

			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int updateAtraccionPromo(Promocion promo) {

		try {
			List<Atraccion> atracciones = promo.getAtracciones();

			int row = 0;

			for (Atraccion atraccion : atracciones) {

				String query = "UPDATE Atracciones SET Cupo = ?  WHERE Id = ?";

				Connection connection = ConnectionProvider.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setInt(1, atraccion.getCupo());
				preparedStatement.setInt(2, atraccion.getId());
				row = preparedStatement.executeUpdate();
				// row = row2;
			}
			return row;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Promocion> findAll() {
		try {
			String sql = "SELECT * FROM Promociones";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Promocion> promos = new LinkedList<Promocion>();
			while (resultados.next()) {
				promos.add(crearPromo(resultados));
			}

			return promos;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Promocion crearPromo(ResultSet resultSet) {
		try {
			AtraccionesDAOImpl atraccionesDAO = new AtraccionesDAOImpl();
			Promocion promo = null;

			int id = resultSet.getInt("Id");
			TipoPromo tipo = TipoPromo.valueOf(resultSet.getString("Tipo promocion"));
			String nombre = resultSet.getString("Nombre");
			int a1 = resultSet.getInt("Atraccion1");
			int a2 = resultSet.getInt("Atraccion2");
			int a3 = resultSet.getInt("Atraccion3");

			if (TipoPromo.valueOf(resultSet.getString("Tipo promocion")).equals(TipoPromo.ABSOLUTA)) {
				Atraccion atraccion1 = atraccionesDAO.find(a1);
				Atraccion atraccion2 = atraccionesDAO.find(a2);
				promo = new PromoAbsoluta(id, tipo, nombre, a1, a2);
				promo.getAtracciones().add(atraccion1);
				promo.getAtracciones().add(atraccion2);
			}

			if (TipoPromo.valueOf(resultSet.getString("Tipo promocion")).equals(TipoPromo.PORCENTUAL)) {
				Atraccion atraccion1 = atraccionesDAO.find(a1);
				Atraccion atraccion2 = atraccionesDAO.find(a2);
				promo = new PromoPorcentual(id, tipo, nombre, a1, a2);
				promo.getAtracciones().add(atraccion1);
				promo.getAtracciones().add(atraccion2);
			}

			if (TipoPromo.valueOf(resultSet.getString("Tipo promocion")).equals(TipoPromo.AXB)) {
				Atraccion atraccion1 = atraccionesDAO.find(a1);
				Atraccion atraccion2 = atraccionesDAO.find(a2);
				Atraccion atraccion3 = atraccionesDAO.find(a3);
				promo = new PromoAXB(id, tipo, nombre, a1, a2, a3);
				promo.getAtracciones().add(atraccion1);
				promo.getAtracciones().add(atraccion2);
				promo.getAtracciones().add(atraccion3);
			}
			return promo;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Promocion find(Integer id) {
		try {
			String sql = "SELECT * FROM Promociones WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Promocion promo = null;

			if (resultados.next()) {
				promo = crearPromo(resultados);
			}

			return promo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}
	
	public void updateAtracciones(Promocion promocion) {

		for (Atraccion atraccion : promocion.getAtracciones()) {
			DAOFactory.getAtraccionesDAO().update(atraccion);
		}
	}

	public static void main(String[] args) {
		PromocionesDAOImpl promoDAO = new PromocionesDAOImpl();
		Promocion promo = promoDAO.find(1);
		System.out.println(promo.getNombrePromo());
	}

	@Override
	public int insert(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
