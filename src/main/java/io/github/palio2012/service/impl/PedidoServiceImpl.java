package io.github.palio2012.service.impl;


import io.github.palio2012.domain.respository.Pedidos;
import io.github.palio2012.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
