
package br.com.starwars;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan({"br.com.starwars.enterprise.repository.*"})
public class Application {

	public static void main(final String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

}
