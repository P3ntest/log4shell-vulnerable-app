package fr.christophetd.log4shell.vulnerableapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class MainController {

    private static final Logger logger = LogManager.getLogger("HelloWorld");

    @GetMapping("/")
    public String index() {
        return "<h1>Login zu meinem coolen Java Server</h1><form action=\"/login\" method=\"get\"><input type=\"text\" name=\"username\" id=\"username\" placeholder=\"username\"><button type=\"submit\">Login</button></form>";
    }

    @GetMapping("/login")
    public String index(@RequestParam("username") String username) {
        logger.info("Received a request to login with username: " + username);
        return "Benutzer " + username + " nicht gefunden!";
    }

}