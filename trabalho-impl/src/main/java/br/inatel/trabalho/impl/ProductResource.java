package br.inatel.trabalho.impl;

import java.util.List;


import br.inatel.trabalho.api.product.ProductInterface;
import br.inatel.trabalho.api.product.ProductTO;
import jakarta.enterprise.context.RequestScoped;

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
	
	//@Inject
	//Logger log;
	
	//@EJB
	//private ProductLocal productBean;
	
	@POST
	@Path("/state")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public void saveState(ProductTO product) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	@GET
	@Path("/products")
	@Produces(MediaType.TEXT_HTML)
	public String getProducts() {
		// TODO Auto-generated method stub
		return "Ok produtos";
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
