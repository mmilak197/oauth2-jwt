package mmilak.dev.oauth2jwt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityApi {

    @GetMapping("/api/hello")
    public String sayHello() {
        return "Welcome :) " +
                "it is endpoint secure  by JWT token";
    }

}
