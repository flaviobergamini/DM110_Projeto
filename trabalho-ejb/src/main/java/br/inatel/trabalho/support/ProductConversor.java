package br.inatel.trabalho.support;

import java.util.List;
import java.util.stream.Collectors;

import br.inatel.trabalho.api.product.ProductTO;
import br.inatel.trabalho.entities.ProductEntity;

public class ProductConversor {

	public static ProductTO toProductTO(ProductEntity productEntity) {
		
		return new ProductTO(
				productEntity.getCode(), 
				productEntity.getName(), 
				productEntity.getDescription(), 
				productEntity.getPrice(),
				productEntity.getCategory()
		);
	}
	
	public static ProductEntity ToProductEntity(ProductTO productTO) {
		
		return new ProductEntity(
				productTO.getCode(), 
				productTO.getName(), 
				productTO.getDescription(), 
				productTO.getPrice(),
				productTO.getCategory()
		);
	}
	
	public static List<ProductTO> ToListProductTO(List<ProductEntity> productEntities) {
		
		return productEntities.stream().map(ProductConversor::toProductTO).collect(Collectors.toList());
	}
}