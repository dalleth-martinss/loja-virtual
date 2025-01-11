package br.com.lojavirtual.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
@Getter
@Setter
public class Usuario implements UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
        private Long id;

        private String login;

        private String senha;

        @Temporal(TemporalType.DATE)
        private Date dateAtualSenha;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

        //tabela do joinTable - usuario acesso unico - nas colunas user-id e acesso-id. O acesso é atrelado ao usuario criando fk de acesso.
        @OneToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "usuario_acesso", uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "acesso_id"},
                    name = "unique_acesso_user"),
                    joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario",
                    unique = false, foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),

                    inverseJoinColumns = @JoinColumn(name = "acesso_id",
                    unique = false, referencedColumnName = "id", table = "acesso",
                    foreignKey = @ForeignKey(name = "acesso_fk", value = ConstraintMode.CONSTRAINT ))
        )
        private List<Acesso> acessos;

        /*As athorities = são os acessos ou seja ROLE_ADMIN, ROLE_SECRETARIO, ROLE_FINANCEIRO */
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            // Verifica se acessos não é nulo para evitar NullPointerException
            return acessos != null ? acessos : List.of();
        }

        @Override
        public String getPassword() {
            return this.senha;
        }

        @Override
        public String getUsername() {
            return this.login;
        }

        @Override
        public boolean isAccountNonExpired() {
            return UserDetails.super.isAccountNonExpired();
        }

        @Override
        public boolean isAccountNonLocked() {
            return UserDetails.super.isAccountNonLocked();
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return UserDetails.super.isCredentialsNonExpired();
        }

        @Override
        public boolean isEnabled() {
            return UserDetails.super.isEnabled();
        }
}
