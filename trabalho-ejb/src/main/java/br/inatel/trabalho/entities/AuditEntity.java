package br.inatel.trabalho.entities;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="AUDIT",schema="PUBLIC")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private int id;
	@JsonProperty("registerCode")
	private int registerCode;
	@JsonProperty("operation")
	private String operation;
	@JsonProperty("timestamp")
	private LocalDateTime timestamp;
	

	
	public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            String formattedTimestamp = timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            this.timestamp = LocalDateTime.parse(formattedTimestamp);
        	
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
	}
	
    public static AuditEntity fromJson(String json) {    	
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {        	
            return objectMapper.readValue(json, AuditEntity.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }	
}
