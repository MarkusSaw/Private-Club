package privateclub.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import privateclub.dto.ParticipantsDto;
import privateclub.model.Participants;
import privateclub.service.ParticipantsService;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/participants")

public class ParticipantsController {

    public final ParticipantsService participantsService;

    @GetMapping("/{id}")
    public ParticipantsDto getParticipant(@PathVariable long id){
        return participantsService.getUserById(id);
    }

    @PostMapping("/{id}")
    public ParticipantsDto createParticipant(@RequestBody Participants participants){
        return participantsService.createUser(participants);
    }

    @PutMapping("/{id}")
    public  ParticipantsDto updateParticipant(@PathVariable long id,@RequestBody Participants participants){
        return participantsService.updateUser(id , participants);

    }
    @DeleteMapping("/{id}")
    public  ParticipantsDto deleteParticipant(@PathVariable long id){
        return participantsService.deleteUser(id);
    }
}
