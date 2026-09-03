package privateclub.controller;

import org.springframework.web.bind.annotation.*;
import privateclub.model.Participants;

@RestController
@RequestMapping("api/v1/participants")

public class ParticipantsController {

    @GetMapping("/{id}")
    public Participants getParticipant(@PathVariable long id){

    }
    @PostMapping
    public Participants createParticipant(@RequestBody Participants participants){

    }
    @PostMapping("/{id}")
    public  Participants updateParticipant(@PathVariable long id,@RequestBody Participants participants){

    }
    @DeleteMapping("/{id}")
    public  Participants deleteParticipant(@PathVariable long id){

    }
}
