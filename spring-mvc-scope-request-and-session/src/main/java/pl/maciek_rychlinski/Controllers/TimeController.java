package pl.maciek_rychlinski.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import pl.maciek_rychlinski.Components.TimeComponent;

@Controller
public class TimeController {

private TimeComponent timeComponent;

@Autowired
    public TimeController(TimeComponent timeComponent){
    this.timeComponent=timeComponent;
}

    @GetMapping("/time")
    public String printTime(){

    System.out.println("Aktualny czas:"+timeComponent.getTime());

    return "index.jsp";
    }

}
