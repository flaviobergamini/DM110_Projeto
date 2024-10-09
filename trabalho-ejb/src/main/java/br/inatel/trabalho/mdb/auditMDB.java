package br.inatel.trabalho.mdb;

import java.util.logging.Logger;

import br.inatel.trabalho.entities.AuditEntity;
import br.inatel.trabalho.support.AuditConversor;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;



@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/Stockqueue") })
public class auditMDB implements MessageListener {
	@Inject 
	Logger log;
	
	@PersistenceContext(unitName = "product_pu")
	private EntityManager em;
	
	
	@Override
	public void onMessage(Message message) {
		log.info("AUDITORIA SENDO REALIZADA");
		try {
			
			if(message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String json = textMessage.getText();
				AuditEntity auditEntity = AuditConversor.converterFromJson(json);
				
				if(auditEntity!=null) {
					log.info("Auditoria registrada com sucesso");
					em.persist(auditEntity);
					
				}else {
					log.warning("Auditoria não registrada");
				}
			}
			
		}catch(JMSException eJms) {
			eJms.printStackTrace();
		}
		
		
	}

}
