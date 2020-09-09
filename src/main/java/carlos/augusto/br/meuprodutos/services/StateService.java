package carlos.augusto.br.meuprodutos.services;

import carlos.augusto.br.meuprodutos.entities.State;
import carlos.augusto.br.meuprodutos.repositories.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    private final StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<State> findAll() {
        return stateRepository.findAll();
    }

    public State findById(Long id) {
        return stateRepository.findById(id).orElse(null);
    }

    public State create(State state) {
        return stateRepository.save(state);
    }

    public State update(Long id, State state) {

        var t = stateRepository.findById(id);
        if (t.isPresent()) {
            stateRepository.save(state);
            return state;
        }

        return t.orElse(null);
    }

    public State delete(Long id) {
        State state = this.findById(id);
        stateRepository.deleteById(id);
        return state;
    }
}
