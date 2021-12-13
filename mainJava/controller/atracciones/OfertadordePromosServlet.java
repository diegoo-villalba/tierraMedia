package controller.atracciones;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PromotionService;
import tierraMadre.Promocion;

@WebServlet("/promociones")
public class OfertadordePromosServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7741411249743724516L;
	private PromotionService promotionService;
	private List<Promocion> promociones;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.promotionService = new PromotionService();

		try {
			promociones = promotionService.list();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("promociones", promociones);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Promociones.jsp");
		dispatcher.forward(req, resp);
		
	}

}
