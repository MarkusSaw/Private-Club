package privateclub.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import privateclub.dto.QrcodesDto;
import privateclub.exception.NotFoundException;
import privateclub.mapper.QrcodesMapper;
import privateclub.model.Qrcodes;
import privateclub.repository.QrcodesRepository;


@AllArgsConstructor
@Service
public class QrcodesService {

    private final QrcodesRepository qrcodesRepository;

    public QrcodesDto getCodeById(long id) {
        Qrcodes qrcodes = qrcodesRepository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));
        return QrcodesMapper.toQrDto(qrcodes);
    }

    public QrcodesDto createCode(QrcodesDto requestQrcodesDto) {
        Qrcodes createQrcode = new Qrcodes();
        createQrcode.setCodes(requestQrcodesDto.codes());
        Qrcodes savedQrcode = qrcodesRepository.save(createQrcode);
        return QrcodesMapper.toQrDto(savedQrcode);
    }

    public QrcodesDto updateCode(long id, QrcodesDto requestQrcodesDto) {
        Qrcodes nowQrcodes = qrcodesRepository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));
        nowQrcodes.setCodes(requestQrcodesDto.codes());
        Qrcodes updateQrcode = qrcodesRepository.save(nowQrcodes);
        return QrcodesMapper.toQrDto(updateQrcode);
    }

    public QrcodesDto deleteCode(long id) {
        Qrcodes qrcodes = qrcodesRepository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));
        qrcodesRepository.delete(qrcodes);
        return QrcodesMapper.toQrDto(qrcodes);
    }
}
