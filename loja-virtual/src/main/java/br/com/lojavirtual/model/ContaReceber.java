package br.com.lojavirtual.model;

import br.com.lojavirtual.enums.StatusContaReceber;
import br.com.lojavirtual.enums.TipoEndereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "conta_receber")
@SequenceGenerator(name = "seq_conta_receber", sequenceName = "seq_conta_receber", allocationSize = 1, initialValue = 1)
@Getter
@Setter
 public class ContaReceber implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta_receber")
   private Long id;

   private String descricao ;

   @Enumerated(EnumType.STRING)
   private StatusContaReceber status;

   @Temporal(TemporalType.DATE)
   private Date dataVencimento;

   @Temporal(TemporalType.DATE)
   private String dataPagamento ;
   private BigDecimal valorTotal;
   private BigDecimal valorDesconto;

   @ManyToOne(targetEntity = Pessoa.class)
   @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
   private Pessoa pessoa  ;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    ContaReceber that = (ContaReceber) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
