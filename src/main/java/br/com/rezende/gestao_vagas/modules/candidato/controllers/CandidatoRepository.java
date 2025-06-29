package br.com.rezende.gestao_vagas.modules.candidato.controllers;

import br.com.rezende.gestao_vagas.modules.candidato.CandidatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CandidatoRepository extends JpaRepository<CandidatoEntity, UUID> {
    Optional<CandidatoEntity> findByUsuarioOrEmail(String usuario, String email);
}
