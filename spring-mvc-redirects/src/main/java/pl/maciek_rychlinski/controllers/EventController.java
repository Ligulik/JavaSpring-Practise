package pl.maciek_rychlinski.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maciek_rychlinski.components.EventHolder;
import pl.maciek_rychlinski.model.Participant;

@Controller
public class EventController {

    private EventHolder eventHolder;

    @Autowired
    public EventController(EventHolder eventHolder){
        this.eventHolder=eventHolder;
    }

    @PostMapping("/register")
    public String register(@RequestParam String firstName,
                           @RequestParam String lastName){
        Participant participant=new Participant(firstName,lastName);
        if(eventHolder.chechParticipant(participant)){
            return "redirect:error";
        }else{
            eventHolder.addParticipant(participant);
            return "redirect:success";
        }
    }


    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/success")
    public String success(){
        return "success";
    }

    @GetMapping("/show")
    public String show(){
        for(Participant participant:eventHolder.getParticipants()){
            System.out.println(participant);
        }
        return "redirect:/";
    }
}
