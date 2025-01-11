package br.com.lojavirtual.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.Date;

@Entity
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class PessoaFisica extends Pessoa {
    @Serial
    private static  final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)// para trabalhar com datas
    private Date dataNascimento;


}
