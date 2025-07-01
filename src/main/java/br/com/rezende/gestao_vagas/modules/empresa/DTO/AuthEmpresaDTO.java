package br.com.rezende.gestao_vagas.modules.empresa.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthEmpresaDTO {
    private String senha;
    private String usuario;
}
