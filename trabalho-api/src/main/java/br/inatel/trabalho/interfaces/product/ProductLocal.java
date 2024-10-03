 package br.inatel.trabalho.interfaces.product;

import java.util.List;

import br.inatel.trabalho.api.product.ProductTO;
import jakarta.ejb.Local;


@Local
public interface ProductLocal{
	public void createProduct(ProductTO product);
	public List<ProductTO> getProducts();
	public ProductTO getProductByCode(int code);
	public void updateProduct(ProductTO product);
	public void deleteProduct(int code);
}