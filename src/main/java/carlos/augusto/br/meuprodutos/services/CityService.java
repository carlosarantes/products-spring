package carlos.augusto.br.meuprodutos.services;

import carlos.augusto.br.meuprodutos.entities.City;
import carlos.augusto.br.meuprodutos.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City create(City city) {
        return cityRepository.save(city);
    }

    public City update(Long id, City city) {

        var t = cityRepository.findById(id);
        if (t.isPresent()) {
            cityRepository.save(city);
            return city;
        }

        return t.orElse(null);
    }

    public City delete(Long id) {
        City city = this.findById(id);
        cityRepository.deleteById(id);
        return city;
    }
}
