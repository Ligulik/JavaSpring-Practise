package pl.maciek_rychlinski.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.maciek_rychlinski.model.TimeData;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("timeData",new TimeData());
        return "index";
    }
}
