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
import jakarta.ws.rs.core.Response;

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
	public Response createProduct(ProductTO product) {
		try {
			productBean.createProduct(product);
			return Response.status(Response.Status.CREATED).entity(product).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
	}
	
	@Override
	@GET
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts() {
		try {
			List<ProductTO> Products = productBean.getProducts();
			return Response.ok(Products).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	@GET
	@Path("/product/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductByCode(@PathParam("code") int code) {
		try {
			ProductTO Product = productBean.getProductByCode(code);
			
			if (Product == null)
				return Response.status(Response.Status.NOT_FOUND).build();
			
			return Response.ok(Product).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	
	@Override
	@PUT
	@Path("/update")
	public Response updateProduct(ProductTO product) {
		try {
			ProductTO Product = productBean.getProductByCode(product.getCode());
			
			if (Product == null)
				return Response.status(Response.Status.NOT_FOUND).build();
			
			productBean.updateProduct(product);
			
			return Response.status(Response.Status.NO_CONTENT).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@DELETE
	@Path("/delete/{code}")
	@Override
	public Response deleteProduct(@PathParam("code") int code) {
		try {
			ProductTO Product = productBean.getProductByCode(code);
			
			if (Product == null)
				return Response.status(Response.Status.NOT_FOUND).build();
			
			productBean.deleteProduct(code);
			
			return Response.status(Response.Status.NO_CONTENT).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
	}

}
