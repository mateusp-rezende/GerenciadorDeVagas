package br.com.rezende.gestao_vagas.providers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTProvider {

    @Value("${security.token.secret}")
    private String senhaSecreta;

    public String ValidaToken(String token){
        token = token.replace("Bearer ","");
        Algorithm algorithm = Algorithm.HMAC256(senhaSecreta);
       try {
           var subject = JWT.require(algorithm).build().verify(token).getSubject();
           return subject;
       }catch (JWTVerificationException e){
           e.printStackTrace();
           return null;
       }


    }
}
