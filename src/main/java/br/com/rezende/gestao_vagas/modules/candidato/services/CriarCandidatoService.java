package br.com.rezende.gestao_vagas.modules.candidato.services;

import br.com.rezende.gestao_vagas.exceptions.UsuarioExistente;
import br.com.rezende.gestao_vagas.modules.candidato.CandidatoEntity;
import br.com.rezende.gestao_vagas.modules.candidato.controllers.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarCandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public CandidatoEntity cadastrar(CandidatoEntity candidatoEntity){

        this.candidatoRepository
                .findByUsuarioOrEmail(candidatoEntity.getUsuario(),candidatoEntity.getEmail()).ifPresent((user) ->{
                    throw new UsuarioExistente();
                });
        return  this.candidatoRepository.save(candidatoEntity);
    }
}