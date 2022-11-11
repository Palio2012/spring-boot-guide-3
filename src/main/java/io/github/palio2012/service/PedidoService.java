package io.github.palio2012.service;


import io.github.palio2012.domain.entities.Pedido;
import io.github.palio2012.rest.dto.PedidoDTO;
import org.springframework.stereotype.Service;


public interface PedidoService {

    Pedido salvar (PedidoDTO dto);
}
