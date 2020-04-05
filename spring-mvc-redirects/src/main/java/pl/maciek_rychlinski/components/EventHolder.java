package pl.maciek_rychlinski.components;


import org.springframework.stereotype.Component;
import pl.maciek_rychlinski.model.Participant;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventHolder {

private List<Participant> participants;

public EventHolder(){
    participants=new ArrayList<>();
}

public void addParticipant(Participant participant){
    participants.add(participant);
}

public List<Participant> getParticipants(){
    return participants;
}

public boolean chechParticipant(Participant participant){
    return participants.contains(participant);
}
}
