package es.tuespiral.soterocars;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomePageController {
    @GetMapping("/")
    public String wecomePage() {
        return "index";
    }
}
