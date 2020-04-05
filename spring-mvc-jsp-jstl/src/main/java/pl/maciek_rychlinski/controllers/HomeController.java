package pl.maciek_rychlinski.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

@GetMapping("/")
    public String homr(Model model){
    model.addAttribute("helloMessage","Hello! :)");
    return "index";
}
}
