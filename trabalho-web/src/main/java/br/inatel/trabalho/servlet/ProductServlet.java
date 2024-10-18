package br.inatel.trabalho.servlet;

import java.util.logging.Logger;

import br.inatel.trabalho.interfaces.product.ProductLocal;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = -2565168465470221066L;

	@Inject
	Logger log;
	
	@EJB
	private ProductLocal productBean;
}
