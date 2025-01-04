package br.com.lojavirtual.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "status_rastreio")
@SequenceGenerator(name = "seq_status_rastreio", sequenceName = "seq_status_rastreio", allocationSize = 1, initialValue = 1)
@Getter
@Setter
 public class StatusRastreio implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status_rastreio")
   private Long id;
   private String centroDistribuicao;
   private String cidade;
   private String estado;
   private String status;

    @ManyToOne
    @JoinColumn(name = "venda_prod_loja_virt_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "venda_prod_loja_virt_fk"))
    private VendaProdutoLojaVirtual vendaProdutoLojaVirtual;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    StatusRastreio that = (StatusRastreio) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
