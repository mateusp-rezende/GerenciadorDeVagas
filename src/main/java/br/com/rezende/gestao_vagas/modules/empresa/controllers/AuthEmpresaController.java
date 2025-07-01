package br.com.rezende.gestao_vagas.modules.empresa.controllers;

import br.com.rezende.gestao_vagas.modules.empresa.DTO.AuthEmpresaDTO;
import br.com.rezende.gestao_vagas.modules.empresa.services.AuthEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthEmpresaController {

    @Autowired
    private AuthEmpresaService service;
    @PostMapping("/empresa")
    public ResponseEntity<Object> Criar(@RequestBody AuthEmpresaDTO dto)  {

        try{
          var resultado =  this.service.GeradorToken(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
