package pl.maciek_rychlinski.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maciek_rychlinski.model.Book;

import java.util.Arrays;

@Controller
public class AppController {

    @RequestMapping("/")
    public String hoe(Model model){
        model.addAttribute("book",new Book());
        return "home";
    }

    @PostMapping("/bookadd")
    public String bookadd(@ModelAttribute Book book,Model model){
        model.addAttribute("message","Book" + book + "added!");
        return "home";
    }

    @GetMapping("/if")
    public String ifExample(Model model){
        model.addAttribute("text","Sample Text");
        model.addAttribute("a",123);
        model.addAttribute("b",456);
        return "if";
    }

    @GetMapping("/loop")
    public String loopExample(Model model){
        model.addAttribute("books", Arrays.asList(
                new Book("Ksiązka 1","Autor 1",19.99),
                new Book("Ksiązka 2","Autor 2",29.99),
                new Book("Ksiązka 3","Autor 3",39.99),
                new Book("Ksiązka 4","Autor 4",49.99)
        ));
        return "loop";
    }
}
