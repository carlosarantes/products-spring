package carlos.augusto.br.meuprodutos.resources;

import carlos.augusto.br.meuprodutos.entities.State;
import carlos.augusto.br.meuprodutos.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateResource {

    @Autowired
    private StateService stateService;

    /**
     * ---  COMMONS CRUD METHODS ---
     * */
    @GetMapping("/")
    public List<State> findAll() {
        return this.stateService.findAll();
    }

    @GetMapping("/{id}")
    public State findById(@PathVariable("id") Long id) {
        return this.stateService.findById(id);
    }

    @PostMapping("/")
    public State create(@Valid @RequestBody State product) {
        return this.stateService.create(product);
    }

    @PutMapping("/{id}")
    public State update(@PathVariable("id") Long id, @Valid @RequestBody State state) {
        return this.stateService.update(id, state);
    }

    @DeleteMapping("/{id}")
    public State delete(@PathVariable("id") Long id) {
        return this.stateService.delete(id);
    }
}
