package br.com.lojavirtual.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

    @Entity
    @Table(name = "marca_produto")
    @SequenceGenerator(name = "seq_marca_produto", sequenceName = "seq_marca_produto", allocationSize = 1, initialValue = 1)
    @Getter
    @Setter
    public class MarcaProduto implements Serializable {
     @Serial
     private static final long serialVersionUID = 1L;

     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca_produto")
     private Long id;
     private  String nomeDesc;

    }
