package br.inatel.trabalho.api.product;

import java.util.List;

import jakarta.ws.rs.core.Response;

public interface ProductInterface {
	public Response createProduct(ProductTO product);
	public Response getProducts();
	public Response getProductByCode(int code);
	public Response updateProduct(ProductTO product);
	public Response deleteProduct(int code);
}
