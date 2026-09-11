package privateclub.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import privateclub.dto.ParticipantsDto;
import privateclub.dto.QrcodesDto;
import privateclub.exception.NotFoundException;
import privateclub.mapper.ParticipantsMapper;
import privateclub.mapper.QrcodesMapper;
import privateclub.model.Participants;
import privateclub.model.Qrcodes;
import privateclub.repository.ParticipantsRepository;
import privateclub.repository.QrcodesRepository;

import java.util.UUID;

@AllArgsConstructor
@Service
public class ParticipantsQrcodesService {
    private final ParticipantsRepository participantsRepository;
    private final QrcodesRepository qrcodesRepository;

@Transactional
    public ParticipantsDto createUserWithQrcode(ParticipantsDto requestDto){

    Participants participant = new Participants();
    participant.setFirstname(requestDto.firstname());
    participant.setLastname(requestDto.lastname());
    participant.setPatronymic(requestDto.patronymic());
    Participants saveParticipant = participantsRepository.save(participant);

    Qrcodes qrcodes = new Qrcodes();
    qrcodes.setParticipant(saveParticipant);
    qrcodes.setCodes(UUID.randomUUID());
    qrcodesRepository.save(qrcodes);

    saveParticipant.getQrcodes().add(qrcodes);

    return ParticipantsMapper.toDto(saveParticipant);
}

@Transactional
    public QrcodesDto getAndDeleteQrcode(Long id){
    Participants participant = participantsRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));
    Qrcodes qrcodes = participant.getQrcodes().stream()
            .findFirst()
            .orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));

    participant.getQrcodes().remove(qrcodes);
    qrcodes.setParticipant(null);

    qrcodesRepository.delete(qrcodes);
    return QrcodesMapper.toQrDto(qrcodes);

}
}
