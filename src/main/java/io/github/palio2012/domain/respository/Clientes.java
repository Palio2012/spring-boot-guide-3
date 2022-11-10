package io.github.palio2012.domain.respository;


import io.github.palio2012.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Clientes extends JpaRepository <Cliente, Integer> {

    @Query (value = " select c from Cliente c where c.nome like :nome ")
    List <Cliente> encontrarPorNome ( @Param("nome") String nome);

    @Query (" delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deleteByNome (String nome);

    boolean existsByNome (String nome);

    @Query (" select c from Cliente c left join fetch c.pedidos where c.id =:id ")
    Cliente findClienteFetch ( @Param("id") Integer id);

}