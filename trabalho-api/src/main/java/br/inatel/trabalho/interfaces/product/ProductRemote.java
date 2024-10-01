package br.inatel.trabalho.interfaces.product;

import java.util.List;

import br.inatel.trabalho.api.product.ProductTO;

public interface ProductRemote {
	public void saveState(ProductTO product);
	public String getProducts();
	public List<ProductTO> getProductById(int id);
	public void updateProduct(ProductTO product);
	public void deleteProduct(int id);
}
