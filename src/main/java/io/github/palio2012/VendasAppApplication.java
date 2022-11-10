package io.github.palio2012;

import io.github.palio2012.domain.entities.Cliente;
import io.github.palio2012.domain.respository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasAppApplication {

    @Bean
    public CommandLineRunner commandLineRunner (@Autowired Clientes clientes) {
        return args -> {
            Cliente c = new Cliente(null, "Fulano");
            clientes.save(c);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasAppApplication.class, args);
    }
}