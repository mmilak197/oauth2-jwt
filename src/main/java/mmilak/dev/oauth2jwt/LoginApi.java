package mmilak.dev.oauth2jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginApi {

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        long currentTimeMillis = System.currentTimeMillis();

        return Jwts.builder()
                .setSubject(user.getLogin())
                .claim("rules", "user")
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 1000 * 20))
                .signWith(SignatureAlgorithm.HS512, user.getPassword())
                .compact();
    }
}
