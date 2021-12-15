package controller.atracciones;

import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Atraccion;
import services.AtraccionService;

@WebServlet("/atracciones/editar.do")
public class EditarAtraccionServlet extends HttpServlet implements Servlet {
	
	private static final long serialVersionUID = 7598291131560345626L;
	private AtraccionService attractionService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Atraccion attraction = attractionService.find(id);
		req.setAttribute("attraction", attraction);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/editar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Integer cost = Integer.parseInt(req.getParameter("cost"));
		Double duration = Double.parseDouble(req.getParameter("duration"));
		Integer capacity = Integer.parseInt(req.getParameter("capacity"));
		Atraccion attraction = attractionService.update(id, name, cost, duration, capacity);
		if (attraction.esValida()) {
			resp.sendRedirect("/TierraMedia/atracciones/index.do");
		} else {
			req.setAttribute("attraction", attraction);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/editar.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
