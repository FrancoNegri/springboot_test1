package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {
		return args -> {
			List<Role> roleHistory1 = new ArrayList<>();
			roleHistory1.add(new Role("burglar", 50l));
			roleHistory1.add(new Role("burglar", 100l));
			List<Role> roleHistory2 = new ArrayList<>();
			roleHistory2.add(new Role("burglar", 10l));
			roleHistory2.add(new Role("burglar", 40l));

			Map<String, String> metadata2 = new HashMap<>();
			metadata2.put("key1", "valor1");
			metadata2.put("key2", "valor2");
			log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", new Role("burglar", 100l), roleHistory1, Collections.emptyMap())));
			log.info("Preloading " + repository.save(new Employee("Frodo Baggins", new Role("thief", 100l), roleHistory2, metadata2)));
		};
	}
}