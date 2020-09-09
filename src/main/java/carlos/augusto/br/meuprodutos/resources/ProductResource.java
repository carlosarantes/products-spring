package carlos.augusto.br.meuprodutos.resources;

import carlos.augusto.br.meuprodutos.entities.Product;
import carlos.augusto.br.meuprodutos.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    /**
     * ---  COMMONS CRUD METHODS ---
     * */
    @GetMapping("/")
    public List<Product> findAll() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return this.productService.findById(id);
    }

    @PostMapping("/")
    public Product create(@Valid @RequestBody Product product) {
        return this.productService.create(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable("id") Long id, @Valid @RequestBody Product product) {
        return this.productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable("id") Long id) {
        return this.productService.delete(id);
    }
}

