package br.inatel.trabalho.servlet;

import java.util.logging.Logger;

import br.inatel.trabalho.interfaces.product.AuditLocal;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/auditServlet")
public class AuditServlet extends HttpServlet {
	private static final long serialVersionUID = -2566168465470221066L;
	
	@Inject
	Logger log;
	
	@EJB
	private AuditLocal auditBean;
}
