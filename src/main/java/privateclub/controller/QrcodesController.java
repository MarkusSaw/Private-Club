package privateclub.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import privateclub.dto.QrcodesDto;
import privateclub.model.Participants;
import privateclub.model.Qrcodes;
import privateclub.service.PrivateClubService;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/qrcodes")
public class QrcodesController {

    public final PrivateClubService privateClubService;

    @GetMapping("/{id}")
    public QrcodesDto getQrcode(@PathVariable long id){

    }
    @PostMapping
    public QrcodesDto createQrcode(@RequestBody Participants participants){

    }
    @PostMapping("/{id}")
    public QrcodesDto updateQrcode(@PathVariable long id, @RequestBody Participants participants){

    }
    @DeleteMapping("/{id}")
    public QrcodesDto deleteQrcode(@PathVariable long id){

    }
}
