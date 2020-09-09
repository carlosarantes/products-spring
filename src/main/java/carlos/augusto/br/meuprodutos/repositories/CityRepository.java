package carlos.augusto.br.meuprodutos.repositories;

import carlos.augusto.br.meuprodutos.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long>  {
}
