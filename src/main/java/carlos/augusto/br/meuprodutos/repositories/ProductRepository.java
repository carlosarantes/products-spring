package carlos.augusto.br.meuprodutos.repositories;

import carlos.augusto.br.meuprodutos.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
