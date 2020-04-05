package pl.maciek_rychlinski.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.maciek_rychlinski.model.Article;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("helloMessage","Hello Themeleaf!");
        model.addAttribute("formArticle", new Article("Some title","Content","tag1, tag2 etc."));
        return "index";
    }
}
