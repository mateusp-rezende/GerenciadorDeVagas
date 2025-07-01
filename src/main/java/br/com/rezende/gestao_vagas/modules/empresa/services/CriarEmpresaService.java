package br.com.rezende.gestao_vagas.modules.empresa.services;

import br.com.rezende.gestao_vagas.exceptions.UsuarioExistente;
import br.com.rezende.gestao_vagas.modules.empresa.EmpresaEntity;
import br.com.rezende.gestao_vagas.modules.empresa.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CriarEmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public EmpresaEntity criarEmpresa(EmpresaEntity empresa){

        this.empresaRepository.findByUsuarioOrEmail(empresa.getUsuario(), empresa.getEmail())
                .ifPresent((user) ->{
                    throw new UsuarioExistente();
                });

        empresa.setId(UUID.randomUUID());
        var senha = passwordEncoder.encode(empresa.getSenha());
        empresa.setSenha(senha);

    return this.empresaRepository.save(empresa);

    }

}
