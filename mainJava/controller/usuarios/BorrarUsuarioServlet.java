package controller.usuarios;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UsuarioService;

@WebServlet("/users/borrar.do")
public class BorrarUsuarioServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = -3754942209414765214L;
    private UsuarioService usuarioService;
    @Override
    public void init() throws ServletException {
        super.init();
        this.usuarioService = new UsuarioService();
    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Integer id = Integer.parseInt(req.getParameter("id"));
        
        usuarioService.borrar(id);
        resp.sendRedirect("/TierraMedia/users/indexu.do");
    }
    
}