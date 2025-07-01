package br.com.rezende.gestao_vagas.modules.empresa.services;

import br.com.rezende.gestao_vagas.modules.empresa.VagasEntity;
import br.com.rezende.gestao_vagas.modules.empresa.repositories.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarVagasService {

    @Autowired
    private VagasRepository vagasRepository;

    public VagasEntity criarVaga(VagasEntity vaga) {
        return this.vagasRepository.save(vaga);
    }
}
