package privateclub.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import privateclub.dto.ParticipantsDto;
import privateclub.dto.QrcodesDto;
import privateclub.service.ParticipantsQrcodesService;

@RestController
@RequestMapping("api/v1/private-club")
@AllArgsConstructor
public class ParticipantsQrcodesController {
    private final ParticipantsQrcodesService participantsQrcodesService;

    @PostMapping
    public ParticipantsDto createUser(@RequestBody ParticipantsDto requestDto) {
        return participantsQrcodesService.createUserWithQrcode(requestDto);
    }

    @GetMapping("/{id}/qrcode")
    public QrcodesDto getQrcode (@PathVariable Long id){
        return participantsQrcodesService.getAndDeleteQrcode(id);
    }

}
