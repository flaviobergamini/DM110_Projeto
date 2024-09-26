package br.inatel.trabalho.impl;

import java.util.List;

import br.inatel.trabalho.api.product.ProductInterface;
import br.inatel.trabalho.api.product.ProductTO;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;

public class ProductResource implements ProductInterface {
	
	@POST
	@Override
	public void saveState(ProductTO product) {
		// TODO Auto-generated method stub
		
	}
	
	@GET
	@Override
	public List<ProductTO> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Override
	public List<ProductTO> getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PUT
	@Override
	public void updateProduct(ProductTO product) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}

}
