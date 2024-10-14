package br.inatel.trabalho.support;

import org.json.JSONObject;

import br.inatel.trabalho.entities.AuditEntity;

import java.time.*;

public class AuditConversor {
	public static AuditEntity converterFromJson(String jsonData) {
		try {
            JSONObject jsonObject = new JSONObject(jsonData);
            AuditEntity auditEntity = new AuditEntity();
            auditEntity.setRegisterCode(jsonObject.getInt("registerCode"));
            auditEntity.setOperation(jsonObject.getString("operation"));
            auditEntity.setTimestamp(LocalDateTime.parse(jsonObject.getString("timestamp")));
            return auditEntity;
            
			
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
}
