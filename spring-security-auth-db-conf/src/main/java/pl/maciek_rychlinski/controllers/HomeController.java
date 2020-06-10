package pl.maciek_rychlinski.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "homepage";
    }

    @RequestMapping("/secured")
    @ResponseBody
    public String secured(){
        return "secured page";
    }
}
