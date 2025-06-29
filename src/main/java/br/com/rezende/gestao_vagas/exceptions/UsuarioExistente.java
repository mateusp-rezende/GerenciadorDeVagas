package br.com.rezende.gestao_vagas.exceptions;

public class UsuarioExistente extends RuntimeException{
    public UsuarioExistente(){
        super("Usuario já existe");
    }

}
