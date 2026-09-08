package privateclub.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import privateclub.dto.QrcodesDto;
import privateclub.service.QrcodesService;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/qrcodes")
public class QrcodesController {

    private final QrcodesService qrcodesService;


    @GetMapping("/{id}")
    public QrcodesDto getQrcode(@PathVariable long id) {
        return qrcodesService.getCodeById(id);
    }

    @PostMapping("/{id}")
    public QrcodesDto createQrcode(@RequestBody QrcodesDto requestQrcodesDto) {
        return qrcodesService.createCode(requestQrcodesDto);
    }

    @PutMapping("/{id}")
    public QrcodesDto updateQrcode(@PathVariable long id, @RequestBody QrcodesDto requestQrcodesDto) {
        return qrcodesService.updateCode(id, requestQrcodesDto);
    }

    @DeleteMapping("/{id}")
    public QrcodesDto deleteQrcode(@PathVariable long id) {
        return qrcodesService.deleteCode(id);
    }
}
