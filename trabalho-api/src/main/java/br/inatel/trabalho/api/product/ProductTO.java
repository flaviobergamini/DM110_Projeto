package br.inatel.trabalho.api.product;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductTO implements Serializable {
	
	private static final long serialVersionUID = 8146653723075391669L;
	
	private int code;
	private String name;
	private String description;
	private double price; 
	private String category;
	
	public ProductTO(int code, String name, String description, double price, String category) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}	
}