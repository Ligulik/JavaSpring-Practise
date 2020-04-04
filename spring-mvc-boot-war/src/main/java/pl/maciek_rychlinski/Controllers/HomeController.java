package pl.maciek_rychlinski.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

@RequestMapping("/")
    public String home(){
    return "home";
}


@PostMapping("/")
    public String calculate(@RequestParam(defaultValue ="0") int valueA,
                            @RequestParam(defaultValue = "0") int valueB){
    int result=valueA+valueB;
    System.out.printf("%d + %d = %d",valueA,valueB,result);
    return "home";
}
}
