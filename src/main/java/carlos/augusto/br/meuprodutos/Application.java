package carlos.augusto.br.meuprodutos;

import carlos.augusto.br.meuprodutos.services.StateService;
import carlos.augusto.br.meuprodutos.utils.Seeder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = "carlos.augusto.br.meuprodutos.entities")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(StateService stateService) {
		Seeder seeder = new Seeder();
		return args -> {
			seeder.statesCitiesSeeder(stateService);
		};
	}
}
