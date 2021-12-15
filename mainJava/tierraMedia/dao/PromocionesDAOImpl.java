package tierraMedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import persistence.commons.MissingDataException;
import tierraMadre.Atraccion;
import tierraMadre.PromoAXB2;
import tierraMadre.PromoAbsoluta2;
import tierraMadre.PromoFactory;
import tierraMadre.PromoPorcentual2;
import tierraMadre.Promocion;
import tierraMadre.Promocion2;
import tierraMadre.TipoPromo;
import tierraMedia.db.ConnectionProvider;

public class PromocionesDAOImpl implements PromocionesDAO {

	private static List<Atraccion> filtroAtraccion(String a1, String a2, String a3, List<Atraccion> atracciones) {
		// va a hacer la lista de las atracciones que est�n en la promo, para as� usarla
		// en el generador
		List<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
		for (Atraccion a : atracciones) {
			if (a.getNombre().equalsIgnoreCase(a1) || a.getNombre().equalsIgnoreCase(a2)
					|| a.getNombre().equalsIgnoreCase(a3)) {
				listaAtracciones.add(a);
			}
		}
		return listaAtracciones;
	}

	public static Promocion toPromocion(ResultSet resultSet, List<Atraccion> atracciones) {
		try {
		String nombre = resultSet.getString("Nombre");
		String a1 = resultSet.getString("Atraccion1");
		String a2 = resultSet.getString("Atraccion2");
		String a3 = resultSet.getString("Atraccion3");
		double monto = resultSet.getDouble("Monto");
		TipoPromo tipo = TipoPromo.valueOf(resultSet.getString("Tipo promocion"));

		// Armo lista de las atracciones que van en la promo
		List<Atraccion> atraccionesPromo = filtroAtraccion(a1, a2, a3, atracciones);

		Promocion p = PromoFactory.buildPromocion(nombre, atraccionesPromo, tipo, monto);

		return p;
		
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public static List<Promocion> getPromociones(List<Atraccion> atracciones) {
		
		try {
		List<Promocion> promociones = new ArrayList<Promocion>();
		Connection connection = ConnectionProvider.getConnection();

		String query = "select * from Promociones";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Promocion promocion = toPromocion(resultSet, atracciones);
			promociones.add(promocion);
		}

		return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	public int updateAtraccionPromo(Promocion2 promo) {
		
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
			//row = row2;
		}
		return row;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Promocion2> findAll() {
		try {
			String sql = "SELECT * FROM Promociones";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Promocion2> promos = new LinkedList<Promocion2>();
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

	
	public Promocion2 crearPromo(ResultSet resultSet)  {
		try {
		AtraccionesDAOImpl atraccionesDAO = new AtraccionesDAOImpl();
		Promocion2 promo = null;
		
		int id = resultSet.getInt("Id");
		TipoPromo tipo = TipoPromo.valueOf(resultSet.getString("Tipo promocion"));
		String nombre = resultSet.getString("Nombre");
		int a1 = resultSet.getInt("Atraccion1");
		int a2 = resultSet.getInt("Atraccion2");
		int a3 = resultSet.getInt("Atraccion3");
		
		if(TipoPromo.valueOf(resultSet.getString("Tipo promocion")).equals(TipoPromo.ABSOLUTA)) {
			Atraccion atraccion1 = atraccionesDAO.find(a1);
			Atraccion atraccion2 = atraccionesDAO.find(a2);
			promo = new PromoAbsoluta2(id, tipo, nombre, a1, a2);
			promo.getAtracciones().add(atraccion1);
			promo.getAtracciones().add(atraccion2);
		}
		
		if(TipoPromo.valueOf(resultSet.getString("Tipo promocion")).equals(TipoPromo.PORCENTUAL)) {
			Atraccion atraccion1 = atraccionesDAO.find(a1);
			Atraccion atraccion2 = atraccionesDAO.find(a2);
			promo = new PromoPorcentual2(id, tipo, nombre, a1, a2);
			promo.getAtracciones().add(atraccion1);
			promo.getAtracciones().add(atraccion2);
		}
		
		if(TipoPromo.valueOf(resultSet.getString("Tipo promocion")).equals(TipoPromo.AXB)) {
			Atraccion atraccion1 = atraccionesDAO.find(a1);
			Atraccion atraccion2 = atraccionesDAO.find(a2);
			Atraccion atraccion3 = atraccionesDAO.find(a3);
			promo = new PromoAXB2(id, tipo, nombre, a1, a2, a3);
			promo.getAtracciones().add(atraccion1);
			promo.getAtracciones().add(atraccion2);
			promo.getAtracciones().add(atraccion3);
		}
		return promo;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Promocion2 find(Integer id) {
		try {
			String sql = "SELECT * FROM Promociones WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Promocion2 promo = null;

			if (resultados.next()) {
				promo = crearPromo(resultados);
			}

			return promo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}
	
	public static void main(String[] args) {
		PromocionesDAOImpl promoDAO = new PromocionesDAOImpl();
		Promocion2 promo = promoDAO.find(1);
		System.out.println(promo.getNombrePromo());
	}

	@Override
	public int insert(Promocion2 t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Promocion2 t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Promocion2 t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
