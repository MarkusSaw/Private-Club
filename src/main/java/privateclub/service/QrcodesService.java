package privateclub.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import privateclub.dto.ParticipantsDto;
import privateclub.dto.QrcodesDto;
import privateclub.mapper.QrcodesMapper;
import privateclub.model.Qrcodes;
import privateclub.repository.QrcodesRepository;


@AllArgsConstructor
@Service
public class QrcodesService {
    private final QrcodesRepository qrcodesRepository;

    public QrcodesDto getCodeById(Long id){
        Qrcodes qrcodes = qrcodesRepository.findById(id).orElseThrow();
        return QrcodesMapper.toQrDto(qrcodes);
    }

    public QrcodesDto createCode(Qrcodes qrcodes){
        Qrcodes createQrcode = qrcodesRepository.save(qrcodes);
        return QrcodesMapper.toQrDto(createQrcode);
    }

    public QrcodesDto updateCode(Long id , Qrcodes qrcodes){
        Qrcodes nowQrcodes = qrcodesRepository.findById(id).orElseThrow();
        nowQrcodes.setCodes(qrcodes.getCodes());
        Qrcodes updateQrcode = qrcodesRepository.save(nowQrcodes);
        return QrcodesMapper.toQrDto(updateQrcode);
    }

    public QrcodesDto deleteCode(Long id){
        Qrcodes qrcodes = qrcodesRepository.findById(id).orElseThrow();
        qrcodesRepository.delete(qrcodes);
        return QrcodesMapper.toQrDto(qrcodes);
    }
}
