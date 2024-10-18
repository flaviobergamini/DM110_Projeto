package br.inatel.trabalho.interfaces.product;

import jakarta.ejb.Local;

@Local
public interface AuditLocal {
	public void saveAudit(String message);
}
