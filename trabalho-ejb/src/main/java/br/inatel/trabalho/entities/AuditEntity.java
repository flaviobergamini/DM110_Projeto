package br.inatel.trabalho.entities;
import java.time.LocalDateTime;

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
@Table(name="Audit")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int registerCode;
	private String operation;
	private LocalDateTime timestamp;
	
	
}
