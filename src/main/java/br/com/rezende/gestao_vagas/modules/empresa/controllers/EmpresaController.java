package br.com.rezende.gestao_vagas.modules.empresa.controllers;

import br.com.rezende.gestao_vagas.exceptions.UsuarioExistente;
import br.com.rezende.gestao_vagas.modules.empresa.EmpresaEntity;
import br.com.rezende.gestao_vagas.modules.empresa.services.CriarEmpresaService;
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
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private CriarEmpresaService service;
    @PostMapping("/")
    public ResponseEntity<Object> criarEmpresa(@Valid @RequestBody EmpresaEntity empresa){

        try {
            EmpresaEntity resultado = service.criarEmpresa(empresa);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        }catch (UsuarioExistente e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }




    }

}
