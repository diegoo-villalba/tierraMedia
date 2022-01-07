package controller.usuarios;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UsuarioService;


@WebServlet("/users/editar.do")
public class EditarUsuarioServlet extends HttpServlet implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2953626115657156115L;
	
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Usuario user = usuarioService.find(id);
		req.setAttribute("user", user);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/editar.jsp");
		dispatcher.forward(req, resp);
	}

	//Usuario crear(String nombre, String username, String password, Double coins, Double time)
	

	//Nombre dinero tiempo username password
	
	//public Usuario update(Integer id,  Double coins, Double time, String nombre, String username, String password
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("name");
		Double coins = Double.parseDouble(req.getParameter("coins"));
		Double time = Double.parseDouble(req.getParameter("time"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		Usuario user = usuarioService.update(id, nombre, coins, time, username, password );
		if (user.isValid()) {
			resp.sendRedirect("/TierraMedia/users/indexu.do");
		} else {
			req.setAttribute("user", user);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/editar.jsp");
			dispatcher.forward(req, resp);
		}
	}
}

