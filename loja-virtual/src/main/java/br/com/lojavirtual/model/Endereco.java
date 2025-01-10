package br.com.lojavirtual.model;

import br.com.lojavirtual.enums.TipoEndereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "endereco")
@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1, initialValue = 1)
@Getter
@Setter
 public class Endereco implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
   private Long id;

    @Column(nullable = false)
   private String ruaLogradouro;

    @Column(nullable = false)
   private String cep;

    @Column(nullable = false)
   private String numero;

    private String complemento;

    @Column(nullable = false)
   private String bairro;

    @Column(nullable = false)
   private String uf;

    @Column(nullable = false)
   private String cidade;

   @ManyToOne(targetEntity = Pessoa.class)
   @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
   private Pessoa pessoa;

   @Enumerated(EnumType.STRING)
   private TipoEndereco tipoEndereco;

   @Override
   public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Endereco endereco = (Endereco) o;
    return Objects.equals(id, endereco.id);
  }

   @Override
   public int hashCode() {
    return Objects.hashCode(id);
   }
}
