package br.com.rezende.gestao_vagas.modules.empresa.repositories;

import br.com.rezende.gestao_vagas.modules.candidato.CandidatoEntity;
import br.com.rezende.gestao_vagas.modules.empresa.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, UUID> {
    Optional<EmpresaEntity> findByUsuarioOrEmail(String usuario, String email);
}
