package br.inatel.trabalho.impl;

import java.util.List;
import java.util.logging.Logger;

import br.inatel.trabalho.api.product.ProductInterface;
import br.inatel.trabalho.api.product.ProductTO;
import br.inatel.trabalho.interfaces.product.ProductLocal;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
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
	
	@Override
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createProduct(ProductTO product) {
		productBean.createProduct(product);
		
	}
	
	@Override
	@GET
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductTO> getProducts() {
		List<ProductTO> Products = productBean.getProducts();
		return Products;
	}

	@GET
	@Path("/product/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public ProductTO getProductByCode(@PathParam("code") int code) {
		ProductTO Product = productBean.getProductByCode(code);
		return Product;
	}
	
	@PUT
	@Path("/update")
	@Override
	public void updateProduct(ProductTO product) {
		productBean.updateProduct(product);
	}

	@DELETE
	@Path("/delete/{code}")
	@Override
	public void deleteProduct(@PathParam("code") int code) {
		productBean.deleteProduct(code);
	}

}
