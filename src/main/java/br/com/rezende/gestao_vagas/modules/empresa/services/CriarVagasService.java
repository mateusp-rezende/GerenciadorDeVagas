package br.com.rezende.gestao_vagas.modules.empresa.services;

import br.com.rezende.gestao_vagas.modules.empresa.EmpresaEntity;
import br.com.rezende.gestao_vagas.modules.empresa.VagasEntity;
import br.com.rezende.gestao_vagas.modules.empresa.repositories.EmpresaRepository;
import br.com.rezende.gestao_vagas.modules.empresa.repositories.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class CriarVagasService {

    @Autowired
    private VagasRepository vagasRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

  public VagasEntity criarVaga( CriarVagasDTO dto){

      EmpresaEntity empresa = empresaRepository.findById(dto.getEmpresaId())
             .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

      VagasEntity vaga = new VagasEntity();
      vaga.setDescricao(dto.getDescricao());
      vaga.setNivel(dto.getNivel());
      vaga.setBeneficios(dto.getBeneficios());
      vaga.setEmpresa(empresa);

      return this.vagasRepository.save(vaga);
  }

}
