package carlos.augusto.br.meuprodutos.services;

import carlos.augusto.br.meuprodutos.entities.Product;
import carlos.augusto.br.meuprodutos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {

        var t = productRepository.findById(id);
        if (t.isPresent()) {
            productRepository.save(product);
            return product;
        }

        return t.orElse(null);
    }

    public Product delete(Long id) {
        Product product = this.findById(id);
        productRepository.deleteById(id);
        return product;
    }
}