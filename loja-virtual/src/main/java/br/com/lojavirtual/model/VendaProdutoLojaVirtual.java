package br.com.lojavirtual.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "venda_prod_loja_virt")
@SequenceGenerator(name = "seq_venda_prod_loja_virt", sequenceName = "seq_venda_prod_loja_virt", allocationSize = 1, initialValue = 1)
@Getter
@Setter
public class VendaProdutoLojaVirtual implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_venda_prod_loja_virt")
    private Long id;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "endereco_cobranca_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_cobranca_fk"))
    private Endereco enderecoCobranca;

    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_entrega_fk"))
    private Endereco enderecoEntrega;

    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "forma_pagamento_fk"))
    private FormaPagamento formaPagamento;

    @OneToOne
    @JoinColumn(name = "nota_fiscal_venda_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "nota_fiscal_venda_fk"))
    private NotaFiscalVenda notaFiscalVenda;

    @ManyToOne
    @JoinColumn(name = "cupom_desconto_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "cupom_desconto_fk"))
    private CupomDesconto cupomDesconto;

    private BigDecimal valorFrete;

    private Integer diaEntrega;

    @Temporal(TemporalType.DATE)
    private Date dataVenda;

    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VendaProdutoLojaVirtual that = (VendaProdutoLojaVirtual) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
