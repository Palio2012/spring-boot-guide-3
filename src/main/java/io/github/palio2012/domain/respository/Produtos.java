package io.github.palio2012.domain.respository;

import io.github.palio2012.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository <Produto, Integer> {
}
