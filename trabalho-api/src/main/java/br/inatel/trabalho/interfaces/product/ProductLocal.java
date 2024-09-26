package br.inatel.trabalho.interfaces.product;

import java.util.List;

import br.inatel.trabalho.api.product.ProductTO;

public interface ProductLocal {
	public void saveState(ProductTO product);
	public List<ProductTO> getProducts();
	public List<ProductTO> getProductById(int id);
	public void updateProduct(ProductTO product);
	public void deleteProduct(int id);
}
