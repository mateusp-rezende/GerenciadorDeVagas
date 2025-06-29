package br.com.rezende.gestao_vagas.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MensagemErroDTO {
    private String mensagem;
    private String campo;
}
