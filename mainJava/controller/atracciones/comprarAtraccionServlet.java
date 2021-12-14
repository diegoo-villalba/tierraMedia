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
import persistence.commons.DAOFactory;
import services.comprarAtraccionService;
import tierraMadre.Usuario;

@WebServlet("/atracciones/comprar.do")
public class comprarAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 3966188068793716237L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		comprarAtraccionService comprarAtraccionService = new comprarAtraccionService();
		
		/*Primero levanta el id de la atraccion que quiero comprar
		 *y tambien levanta el usuario que inicio sesion (el que esta logueado)
		 * */
		Integer atracctionId = Integer.parseInt(req.getParameter("id"));
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		
		/*Con esa informacion, ahora delegamos al SERVICIO de comprar atraccion pasandole
		 * el usuario que quiere comprar y el id de la atraccion*/
		Map<String, String> errors = comprarAtraccionService.comprar(user.getId(), atracctionId);
		
		Usuario user2 = DAOFactory.getUsuariosDAO().find(user.getId());
		req.getSession().setAttribute("user", user2);
		
		if (errors.isEmpty()) {
			//TODO: Poner mensaje de "exito" en vez de "Flash"
			req.setAttribute("flash", "Gracias por su compra!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "Lo sentimos! No pudo realizarse la compra");
		}
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/atracciones/index.do");
		dispatcher.forward(req, resp);
	}
}
