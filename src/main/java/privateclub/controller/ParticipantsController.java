package privateclub.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import privateclub.dto.ParticipantsDto;
import privateclub.model.Participants;
import privateclub.service.PrivateClubService;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/participants")

public class ParticipantsController {

    public final PrivateClubService privateClubService;

    @GetMapping("/{id}")
    public ParticipantsDto getParticipant(@PathVariable long id){
        return privateClubService.getUserById(id);
    }

    @PostMapping
    public ParticipantsDto createParticipant(@RequestBody Participants participants){
        return privateClubService.createUser(participants);
    }

    @PostMapping("/{id}")
    public  ParticipantsDto updateParticipant(@PathVariable long id,@RequestBody Participants participants){
        return privateClubService.updateUser(id , participants);

    }
    @DeleteMapping("/{id}")
    public  ParticipantsDto deleteParticipant(@PathVariable long id){
        return privateClubService.deleteUser(id);
    }
}
