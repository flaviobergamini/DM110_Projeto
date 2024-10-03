package br.inatel.trabalho.product.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Product")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	
	@Id
	private int code;
	private String name;
	private String description;
	private double price; 
	private String category;
}