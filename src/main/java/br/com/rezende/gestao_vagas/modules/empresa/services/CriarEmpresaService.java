package br.com.rezende.gestao_vagas.modules.empresa.services;

import br.com.rezende.gestao_vagas.exceptions.UsuarioExistente;
import br.com.rezende.gestao_vagas.modules.empresa.EmpresaEntity;
import br.com.rezende.gestao_vagas.modules.empresa.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarEmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaEntity criarEmpresa(EmpresaEntity empresa){

        this.empresaRepository.findByUsuarioOrEmail(empresa.getUsuario(), empresa.getEmail())
                .ifPresent((user) ->{
                    throw new UsuarioExistente();
                });

    return this.empresaRepository.save(empresa);

    }

}
