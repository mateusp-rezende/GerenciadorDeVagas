package br.com.rezende.gestao_vagas.modules.empresa.controllers;

import br.com.rezende.gestao_vagas.modules.empresa.EmpresaEntity;
import br.com.rezende.gestao_vagas.modules.empresa.VagasEntity;
import br.com.rezende.gestao_vagas.modules.empresa.DTO.CriarVagasDTO;
import br.com.rezende.gestao_vagas.modules.empresa.repositories.EmpresaRepository;
import br.com.rezende.gestao_vagas.modules.empresa.services.CriarVagasService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/vagas")
public class VagasController {

    @Autowired
    private CriarVagasService service;

    @Autowired
    private EmpresaRepository empresaRepository;


    @PostMapping("/")
    public VagasEntity criarVaga(@Valid @RequestBody CriarVagasDTO dto, HttpServletRequest request) {
        var idEmpresa = request.getAttribute("id_empresa");

        if (idEmpresa == null) {
            throw new RuntimeException("ID da empresa não encontrado na requisição");
        }

        UUID empresaId = UUID.fromString(idEmpresa.toString());

        EmpresaEntity empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        VagasEntity vagasEntity = VagasEntity.builder()
                .descricao(dto.getDescricao())
                .empresa(empresa)
                .beneficios(dto.getBeneficios())
                .nivel(dto.getNivel())
                .build();

        return this.service.criarVaga(vagasEntity); // OK agora
    }


}
