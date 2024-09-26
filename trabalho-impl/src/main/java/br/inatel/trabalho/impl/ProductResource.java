package br.inatel.trabalho.impl;

import java.util.List;
import java.util.logging.Logger;

import br.inatel.trabalho.api.product.ProductInterface;
import br.inatel.trabalho.api.product.ProductTO;
import br.inatel.trabalho.interfaces.product.ProductLocal;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RequestScoped
@Path("/product")
public class ProductResource implements ProductInterface {
	
	@Inject
	Logger log;
	
	@EJB
	private ProductLocal productBean;
	
	@POST
	@Path("/state")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public void saveState(ProductTO product) {
		// TODO Auto-generated method stub
		
	}
	
	@GET
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<ProductTO> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<ProductTO> getProductById(@PathParam("id") int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PUT
	@Path("/update")
	@Override
	public void updateProduct(ProductTO product) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Path("/delete/{id}")
	@Override
	public void deleteProduct(@PathParam("id") int id) {
		// TODO Auto-generated method stub
		
	}

}
