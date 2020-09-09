package carlos.augusto.br.meuprodutos.utils;

import carlos.augusto.br.meuprodutos.entities.City;
import carlos.augusto.br.meuprodutos.entities.State;
import carlos.augusto.br.meuprodutos.services.StateService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Seeder {

    public void statesCitiesSeeder(StateService stateService){
       if (stateService.findAll().toArray().length == 0) {
            try {

                ObjectMapper mapper = new ObjectMapper();
                TypeReference<List<State>> typeReference = new TypeReference<List<State>>(){};
                InputStream inputStream = TypeReference.class.getResourceAsStream("/json/cidades-estados.json");

                List<State> states = mapper.readValue(inputStream, typeReference);

                System.out.println("-------------------------------------------");
                for (State es : states) {
                    if (es.getCities() != null) {
                        for (City ci : es.getCities()) {
                            System.out.println(ci);
                            ci.setState(es);
                        }
                        System.out.println("Salvando estado: "+es.getName());
                        stateService.create(es);
                    }
                }
                System.out.println("-------------------------------------------");

            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao ler json de estados / cidades");
                System.out.println(e.getMessage());
                System.out.println("-------------------------------------------");
            } catch (Exception e) {
                System.out.println("**** Ocorreu um erro");
                e.printStackTrace();
             //   System.out.println(e.printStackTrace() );
                System.out.println("-------------------------------------------");
            }
       }
    }
}
