package br.com.rezende.gestao_vagas.modules.empresa.services;

import lombok.Data;

import java.util.UUID;

@Data
public class CriarVagasDTO {

        private String descricao;
        private String nivel;
        private String beneficios;
        private UUID empresaId;


}
