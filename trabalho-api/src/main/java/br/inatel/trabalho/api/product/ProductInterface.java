package br.inatel.trabalho.api.product;

import java.util.List;

public interface ProductInterface {
	public void saveState(ProductTO product);
	public String getProducts();
	public List<ProductTO> getProductById(int id);
	public void updateProduct(ProductTO product);
	public void deleteProduct(int id);
}
