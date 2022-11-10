package io.github.palio2012.domain.respository;

import io.github.palio2012.domain.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository <ItemPedido, Integer> {
}
