package br.com.rezende.gestao_vagas.modules.empresa.services;

import br.com.rezende.gestao_vagas.exceptions.UsuarioExistente;
import br.com.rezende.gestao_vagas.modules.empresa.DTO.AuthEmpresaDTO;
import br.com.rezende.gestao_vagas.modules.empresa.repositories.EmpresaRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;

@Service
public class AuthEmpresaService {

    @Value("${security.token.secret}")
    private String senhaSecreta;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String GeradorToken(AuthEmpresaDTO dto) throws AuthenticationException {
        var empresa = this.empresaRepository.findByUsuario(dto.getUsuario()).orElseThrow(
                () -> {
                    throw new UsernameNotFoundException("Usuario/Senha não encontrado");
                }
        );
        //verfica senha
        var senhasIguais = this.passwordEncoder.matches(dto.getSenha(), empresa.getSenha());

        if (!senhasIguais){
            throw  new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(senhaSecreta);


        var token = JWT.create().withIssuer("Rezendevagas")
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withSubject(empresa.getId().toString())
                .sign(algorithm);


        return token;

    }
}
