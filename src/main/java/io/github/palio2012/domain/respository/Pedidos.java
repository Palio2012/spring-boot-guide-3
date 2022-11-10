package io.github.palio2012.domain.respository;

import io.github.palio2012.domain.entities.Cliente;
import io.github.palio2012.domain.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface Pedidos extends JpaRepository <Pedido, Integer> {

    Set <Pedido> findByCliente (Cliente cliente);
}
