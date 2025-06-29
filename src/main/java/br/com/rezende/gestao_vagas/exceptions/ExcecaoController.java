package br.com.rezende.gestao_vagas.exceptions;

// Controle de exceções

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExcecaoController {
    private MessageSource messageSource;

    public ExcecaoController(MessageSource message){
        this.messageSource = message;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MensagemErroDTO>> tratarErrosDeValidacao(MethodArgumentNotValidException e) {

        List<MensagemErroDTO> dto = new ArrayList<>();


        e.getBindingResult().getFieldErrors().forEach(err -> {
            String mensagem = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            MensagemErroDTO error = new MensagemErroDTO(mensagem, err.getField());

            dto.add(error);
        });

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
