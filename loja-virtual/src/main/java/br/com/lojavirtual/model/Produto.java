package br.com.lojavirtual.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
@Getter
@Setter
public class Produto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long id;

    private String tipoUnidade;
    private String nome;
    private Boolean ativo = Boolean.TRUE;

    @Column(columnDefinition = "text", length = 2000)
    private String descricao;


  //  private NotaItemProduto notaItemProduto; ASSOCIAR

    private Double peso;
    private Double largura;
    private Double altura;
    private Double profundidade;

    private BigDecimal valorVenda;
    private Integer qtdEstoque;
    private Integer qtdAlertaEstoque;
    private String linkYouTube;
    private Boolean alertaQtdEstoque = Boolean.FALSE;
    private Integer qtdClique = 0;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
