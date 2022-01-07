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


@WebServlet("/users/create.do")
public class CrearUsuarioServlet extends HttpServlet implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2743244100097809474L;
	
	
    private UsuarioService usuarioService;
    @Override
    public void init() throws ServletException {
        super.init();
        this.usuarioService = new UsuarioService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/views/users/create.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nombre");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Double presupuesto = Double.parseDouble(req.getParameter("coins"));
        Double time = Double.parseDouble(req.getParameter("time"));
        Usuario tmp_user = usuarioService.crear(name, username, password, presupuesto, time);
        if (tmp_user.isValid()) {
            resp.sendRedirect("/TierraMedia/users/indexu.do");
        } else {
            req.setAttribute("user", tmp_user);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/create.jsp");
            dispatcher.forward(req, resp);
        }
    }

}
