package br.com.lojavirtual.model;

import br.com.lojavirtual.enums.StatusContaPagar;
import br.com.lojavirtual.enums.StatusContaReceber;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "conta_pagar")
@SequenceGenerator(name = "seq_conta_pagar", sequenceName = "seq_conta_pagar", allocationSize = 1, initialValue = 1)
@Getter
@Setter
 public class ContaPagar implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta_pagar")
   private Long id;

    @Column(nullable = false)
   private String descricao ;

    @Column(nullable = false)
   private BigDecimal valorTotal;
    private BigDecimal valorDesconto;

    @Column(nullable = false)
   @Enumerated(EnumType.STRING)
   private StatusContaPagar status;

    @Column(nullable = false)
   @Temporal(TemporalType.DATE)
   private Date dataVencimento;

   @Temporal(TemporalType.DATE)
   private String dataPagamento ;

   @ManyToOne(targetEntity = Pessoa.class)
   @JoinColumn(name = "pessoa_id", nullable = false, foreignKey
               = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
                 private Pessoa pessoa  ;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_fornec_id", nullable = false, foreignKey
                = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fornec_fk"))
                private Pessoa pessoa_fornecedor  ;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    ContaPagar that = (ContaPagar) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
