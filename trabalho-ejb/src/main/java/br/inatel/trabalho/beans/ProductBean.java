package br.inatel.trabalho.beans;

import java.util.List;
import java.util.logging.Logger;

import br.inatel.trabalho.api.product.ProductTO;
import br.inatel.trabalho.entities.ProductEntity;
import br.inatel.trabalho.interfaces.product.ProductLocal;
import br.inatel.trabalho.interfaces.product.ProductRemote;
import br.inatel.trabalho.support.ProductConversor;
import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Stateless
@Local(ProductLocal.class)
@Remote(ProductRemote.class)
public class ProductBean implements ProductLocal, ProductRemote {
	
	@Inject 
	Logger log;
	
	@PersistenceContext(unitName = "product_pu")
	private EntityManager em;

	@Override
	public void createProduct(ProductTO product) {
		log.info("Saving Product in Database - Product: " + product.getName());
		
		ProductEntity productEnity = ProductConversor.ToProductEntity(product);
		
		em.persist(productEnity);
		
	}

	@Override
	public List<ProductTO> getProducts() {
		log.info("Querying All Products objects");
		
		String hql = "SELECT p FROM ProductEntity p";
		
		TypedQuery<ProductEntity> query = em.createQuery(hql, ProductEntity.class);
		
		return ProductConversor.ToListProductTO(query.getResultList());
	}

	@Override
	public ProductTO getProductByCode(int code) {
		ProductEntity product = em.find(ProductEntity.class, code);
		
		if (product == null)
			return null;
		
		return ProductConversor.toProductTO(product);
	}

	@Override
	public void updateProduct(ProductTO product) {
		ProductEntity productEntity = ProductConversor.ToProductEntity(product);
		
		if(productEntity != null) {
			em.merge(productEntity);
		
			log.info("Product updated, code " + product.getCode());
		}
		else {
			log.info("Product to update not found, code " + product.getCode());
		}
	}

	@SuppressWarnings("null")
	@Override
	public void deleteProduct(int code) {
		ProductEntity product = em.find(ProductEntity.class, code);
		
		if(product != null) {
			em.remove(product);
		
			log.info("Product removed, code " + product.getCode());
		}
		else {
			log.info("Product to remove not found, code " + product.getCode());
		}
	}
}
