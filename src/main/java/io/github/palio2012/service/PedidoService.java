package io.github.palio2012.service;

import io.github.palio2012.domain.entities.Pedido;
import io.github.palio2012.domain.enums.StatusPedido;
import io.github.palio2012.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus (Integer id, StatusPedido statusPedido);
}
