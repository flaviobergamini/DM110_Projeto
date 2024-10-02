package br.inatel.trabalho.api.product;

import java.util.List;

public interface ProductInterface {
	public void createProduct(ProductTO product);
	public List<ProductTO> getProducts();
	public ProductTO getProductByCode(int code);
	public void updateProduct(ProductTO product);
	public void deleteProduct(int code);
}
