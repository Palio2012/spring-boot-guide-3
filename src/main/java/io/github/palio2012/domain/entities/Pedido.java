package io.github.palio2012.domain.entities;

import io.github.palio2012.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "cliente_id")
    private Cliente cliente;

    @Column (name = "data_pedido")
    private LocalDate dataPedido;

    @Column (name = "total", precision = 20, scale = 2)
    private BigDecimal total;

    @Enumerated (EnumType.STRING)
    @Column (name = "status")
    private StatusPedido status;

    @OneToMany (mappedBy = "pedido")
    private List <ItemPedido> itens;

}
