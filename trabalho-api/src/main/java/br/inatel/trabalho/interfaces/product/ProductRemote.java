package br.inatel.trabalho.interfaces.product;

import br.inatel.trabalho.api.product.ProductInterface;
import jakarta.ejb.Remote;

@Remote
public interface ProductRemote extends ProductInterface {
}
