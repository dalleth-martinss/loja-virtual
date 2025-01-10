package br.com.lojavirtual.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "forma_pagamento")
@SequenceGenerator(name = "seq_forma_pagamento", sequenceName = "seq_forma_pagamento", initialValue = 1, allocationSize = 1)
@Getter
@Setter
public class FormaPagamento implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "seq_forma_pagamento")
    private  Long id;

    @Column(nullable = false)
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FormaPagamento that = (FormaPagamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
