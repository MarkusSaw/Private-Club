package privateclub.controller;

import org.springframework.web.bind.annotation.*;
import privateclub.model.Participants;
import privateclub.model.Qrсodes;

@RestController
@RequestMapping("api/v1/qrcodes")
public class QrcodesController {
    @GetMapping("/{id}")
    public Qrсodes getQrсode(@PathVariable long id){

    }
    @PostMapping
    public Qrсodes createQrсode(@RequestBody Participants participants){

    }
    @PostMapping("/{id}")
    public  Qrсodes updateQrсode(@PathVariable long id,@RequestBody Participants participants){

    }
    @DeleteMapping("/{id}")
    public  Qrсodes deleteQrсode(@PathVariable long id){

    }
}
