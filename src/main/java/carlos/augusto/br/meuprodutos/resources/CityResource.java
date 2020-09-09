package carlos.augusto.br.meuprodutos.resources;

import carlos.augusto.br.meuprodutos.entities.City;
import carlos.augusto.br.meuprodutos.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityResource {

    @Autowired
    private CityService cityService;

    /**
     * ---  COMMONS CRUD METHODS ---
     * */
    @GetMapping("/")
    public List<City> findAll() {
        return this.cityService.findAll();
    }

    @GetMapping("/{id}")
    public City findById(@PathVariable("id") Long id) {
        return this.cityService.findById(id);
    }

    @PostMapping("/")
    public City create(@Valid @RequestBody City city) {
        return this.cityService.create(city);
    }

    @PutMapping("/{id}")
    public City update(@PathVariable("id") Long id, @Valid @RequestBody City city) {
        return this.cityService.update(id, city);
    }

    @DeleteMapping("/{id}")
    public City delete(@PathVariable("id") Long id) {
        return this.cityService.delete(id);
    }
}
