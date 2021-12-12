package atracciones;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.oracle.wls.shaded.org.apache.xml.utils.SystemIDResolver;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AtraccionService;
import tierraMadre.Atraccion;

@WebServlet("/atracciones/index")
public class ListadoAtraccionesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 3663300047720714914L;
	private AtraccionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Atraccion> attractions = attractionService.list();
		req.setAttribute("attractions", attractions);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/index.jsp");
		dispatcher.forward(req, resp);

	}
	
	//http://localhost:8080/TierraMedia/atracciones/index
	
}


	

