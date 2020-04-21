package pl.maciek_rychlinski.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.maciek_rychlinski.model.City;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homr(Model model){
        model.addAttribute("cityModel",new City());
        return "index";
    }

}
