package br.com.rezende.gestao_vagas.modules.empresa.controllers;

import br.com.rezende.gestao_vagas.modules.empresa.VagasEntity;
import br.com.rezende.gestao_vagas.modules.empresa.services.CriarVagasDTO;
import br.com.rezende.gestao_vagas.modules.empresa.services.CriarVagasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vagas")
public class VagasController {

    @Autowired
    private CriarVagasService service;
    @PostMapping("/")
    public ResponseEntity<VagasEntity> CriarVaga(@Valid @RequestBody CriarVagasDTO dto) {
        VagasEntity resultado = service.criarVaga(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }


}
