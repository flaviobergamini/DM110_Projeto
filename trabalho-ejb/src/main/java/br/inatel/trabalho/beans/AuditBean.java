package br.inatel.trabalho.beans;

import java.util.logging.Logger;

import br.inatel.trabalho.entities.AuditEntity;
import br.inatel.trabalho.interfaces.product.AuditLocal;
import br.inatel.trabalho.interfaces.product.AuditRemote;
import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
@Local(AuditLocal.class)
//@Remote(AuditRemote.class)
public class AuditBean implements AuditLocal {
	@Inject 
	Logger log;
	
	@PersistenceContext(unitName = "product_pu")
	private EntityManager em;

	@Override
	public void saveAudit(String message) {
		AuditEntity auditEntity = AuditEntity.fromJson(message);
		
		if(auditEntity!=null) {
			em.persist(auditEntity);
			log.info("Auditoria realizada");
		}else {
			log.warning("Auditoria não realizada");
		}
		
	}


}
