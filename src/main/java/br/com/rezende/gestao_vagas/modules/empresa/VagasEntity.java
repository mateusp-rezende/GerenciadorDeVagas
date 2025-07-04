package br.com.rezende.gestao_vagas.modules.empresa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "vagas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VagasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "Esse campo é obrigatório")
    private String descricao;
    @NotBlank(message = "Esse campo é obrigatório")
    private String nivel;
    private String beneficios;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    private EmpresaEntity empresa;

    @CreationTimestamp
    private LocalDateTime horaCriacao;
}
