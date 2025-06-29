package br.com.rezende.gestao_vagas.modules.candidato;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.validation.constraints.Email;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidato")
public class CandidatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Pattern(regexp = "\\S+", message = "O usuario não pode conter espaços em branco")
    @Column(name = "usuario")
    private String usuario;

    @Column(name = "email")
    @Email(message = "Insira um e-mail válido")
    private String email;

    @Length(min = 10, max = 100, message = "A senha deve ter no minimo 10 e no maximo 100 caracteres")
    @Column(name = "senha")
    private String senha;

    @Column(name = "descricao")
    private  String descricao;

    @Column(name = "curriculo")
    private String curriculo;

    @CreationTimestamp
    @Column(name = "hora_criacao")
    private LocalDateTime horaCriacao;

}
