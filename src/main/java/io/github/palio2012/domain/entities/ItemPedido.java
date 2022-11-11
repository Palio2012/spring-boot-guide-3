package io.github.palio2012.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table (name = "item_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn (name = "pedido_id")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn (name = "produto_id")
    private Produto produto;
    @Column
    private Integer quantidade;


}
