package io.github.palio2012;


import io.github.palio2012.domain.entities.Cliente;
import io.github.palio2012.domain.entities.Pedido;
import io.github.palio2012.domain.respository.Clientes;
import io.github.palio2012.domain.respository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasAppApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos
    ){
        return args -> {
            System.out.println("Salvando clientes");
            Cliente fulano = new Cliente("Daniel");
            clientes.save(fulano);


            Pedido p = new Pedido();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

//            Cliente cliente = clientes.findClienteFetch(fulano.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

            pedidos.findByCliente(fulano).forEach(System.out :: println);

        };
    }
            public static void main(String[]args){
                SpringApplication.run(VendasAppApplication.class, args);
            }

}
