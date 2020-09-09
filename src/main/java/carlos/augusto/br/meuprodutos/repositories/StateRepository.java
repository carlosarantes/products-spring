package carlos.augusto.br.meuprodutos.repositories;

import carlos.augusto.br.meuprodutos.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long>  {
}
