package controller.atracciones;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.commons.DAOFactory;
import services.ComprarPromocionService;

@WebServlet("/promociones/comprar.do")
public class comprarPromocionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 3966188068793716237L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ComprarPromocionService comprarPromocionService = new ComprarPromocionService();
		
		/*Primero levanta el id de la atraccion que quiero comprar
		 *y tambien levanta el usuario que inicio sesion (el que esta logueado)
		 * */
		Integer promoId = Integer.parseInt(req.getParameter("id"));
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		
		/*Con esa informacion, ahora delegamos al SERVICIO de comprar atraccion pasandole
		 * el usuario que quiere comprar y el id de la atraccion*/
		Map<String, String> errors = comprarPromocionService.comprar(user.getId(), promoId);
		
		Usuario user2 = DAOFactory.getUsuariosDAO().find(user.getId());
		req.getSession().setAttribute("user", user2);
		
		if (errors.isEmpty()) {
			//TODO: Poner mensaje de "exito" en vez de "Flash"
			req.setAttribute("flash", "¡Gracias por su compra! La promocion y sus atracciones fueron añadidas al itinerario.");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "Lo sentimos! No pudo realizarse la compra");
		}
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/promociones/index.do");
		dispatcher.forward(req, resp);
	}
}
