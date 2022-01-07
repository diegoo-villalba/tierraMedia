package controller.itineraries;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.ElItinerario;
import model.Usuario;
import services.ItinerarioService;

@WebServlet("/itinerarios/index.do")
public class ItinerarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 8892005185510616593L;	
	private ItinerarioService itinerarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioService = new ItinerarioService();
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		
		
		List<Atraccion> attractions = itinerarioService.listItinerario(user.getId());
		req.setAttribute("attractions", attractions);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/itinerarios/index.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	/*
	 @WebServlet("/attractions/itinerario.do")
public class ObtenerItinerarioServlet extends HttpServlet implements Servlet {


		private static final long serialVersionUID = -8346640902238722429L;
		private AttractionService attractionService;

		@Override
		public void init() throws ServletException {
			super.init();
			this.attractionService = new AttractionService();
		}

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			Usuario user = (Usuario) req.getSession().getAttribute("user");
			
			
			List<Atraccion> attractions = attractionService.listItinerario(user.getId());
			req.setAttribute("attractions", attractions);

			double acumulador=0;
			for(Atraccion atraccion : attractions) {
				acumulador+= atraccion.getTiempoDeUso();
			}

			req.setAttribute("tiempoTotal", acumulador);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/user/itinerario.jsp");
			dispatcher.forward(req, resp);

		}
	  */
}
