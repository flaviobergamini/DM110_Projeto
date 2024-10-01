package br.inatel.trabalho.product.beans;

import java.util.List;
import java.util.logging.Logger;

import br.inatel.trabalho.api.product.ProductTO;
import br.inatel.trabalho.interfaces.product.ProductLocal;
import br.inatel.trabalho.interfaces.product.ProductRemote;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless
public class ProductBean implements ProductLocal, ProductRemote {
	
	@Inject
	Logger log;

	@Override
	public void saveState(ProductTO product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getProducts() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public List<ProductTO> getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(ProductTO product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}
}
