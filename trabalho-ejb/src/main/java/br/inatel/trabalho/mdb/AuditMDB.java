package br.inatel.trabalho.mdb;

import java.util.logging.Logger;

import br.inatel.trabalho.interfaces.product.AuditLocal;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.EJB;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;


@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/Stockqueue") })
public class AuditMDB implements MessageListener {
	@Inject
	Logger log;

	@EJB
	private AuditLocal auditBean;

	@Override
	public void onMessage(Message message) {
		try {

			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String json = textMessage.getText();
				auditBean.saveAudit(json);
				log.info("Message encaminhada para o AuditBean com sucesso!");
			}

		} catch (JMSException eJms) {
			eJms.printStackTrace();
		}
	}

}
