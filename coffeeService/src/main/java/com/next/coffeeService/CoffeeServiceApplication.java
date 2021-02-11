package com.next.coffeeService;

import ch.qos.logback.core.db.dialect.PostgreSQLDialect;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.r2dbc.dialect.PostgresDialect;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class CoffeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeServiceApplication.class, args);
	}

}
//cabaility to make the connection to data base
@Configuration
class DatabaseConfig {
	@Bean
	PostgreSQLDialect connectionFactory(){
		return new PostgreSQLDialect
		)
	}
}


interface CoffeeRepository extends ReactiveCrudRepository<Coffee, Long>{
	//reactory for postgress
	@Query("DELETE FROM COFFEE")
	Mono<Coffee> deleteAllById();
}

@Data
@RequiredArgsConstructor
class Coffee{
	@Id
	private Long id;
	@NonNull
	private String name;

}
