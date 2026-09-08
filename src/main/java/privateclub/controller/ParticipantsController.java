package privateclub.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import privateclub.dto.ParticipantsDto;
import privateclub.service.ParticipantsService;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/participants")

public class ParticipantsController {

    public final ParticipantsService participantsService;

    @GetMapping("/{id}")
    public ParticipantsDto getParticipant(@PathVariable long id) {
        return participantsService.getUserById(id);
    }

    @PostMapping("/{id}")
    public ParticipantsDto createParticipant(@RequestBody ParticipantsDto requestParticipantsDto) {
        return participantsService.createUser(requestParticipantsDto);
    }

    @PutMapping("/{id}")
    public ParticipantsDto updateParticipant(@PathVariable long id, @RequestBody ParticipantsDto requestParticipantsDto) {
        return participantsService.updateUser(id, requestParticipantsDto);

    }

    @DeleteMapping("/{id}")
    public ParticipantsDto deleteParticipant(@PathVariable long id) {
        return participantsService.deleteUser(id);
    }
}
