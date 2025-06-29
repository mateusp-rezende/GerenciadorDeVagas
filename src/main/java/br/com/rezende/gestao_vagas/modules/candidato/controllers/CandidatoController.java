package br.com.rezende.gestao_vagas.modules.candidato.controllers;

import br.com.rezende.gestao_vagas.exceptions.UsuarioExistente;
import br.com.rezende.gestao_vagas.modules.candidato.CandidatoEntity;
import br.com.rezende.gestao_vagas.modules.candidato.services.CriarCandidatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.rezende.gestao_vagas.exceptions.UsuarioExistente;


@RestController
@RequestMapping("/candidato")
public class CandidatoController {

  @Autowired
   private CriarCandidatoService service;
    @PostMapping("/")
    public ResponseEntity<Object> criar(@Valid @RequestBody CandidatoEntity candidatoEntity) {
        try {
            CandidatoEntity resultado = service.cadastrar(candidatoEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        } catch (UsuarioExistente e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
