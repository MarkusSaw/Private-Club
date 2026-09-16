package privateclub.service;


import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import privateclub.dto.ParticipantsDto;
import privateclub.exception.NotFoundException;
import privateclub.mapper.ParticipantsMapper;
import privateclub.model.Participants;
import privateclub.model.Qrcodes;
import privateclub.repository.ParticipantsRepository;

import java.util.UUID;


@AllArgsConstructor
@Service
public class ParticipantsService {

    private final ParticipantsRepository participantsRepository;
    private final QrcodesService qrcodesService;

    @Transactional
    public ParticipantsDto getUserById(Long id) {
        Participants participants = participantsRepository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));
        Qrcodes qrcodes = participants.getQrcodes().stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));

        participants.getQrcodes().remove(qrcodes);

        qrcodesService.deleteCode(qrcodes.getId());
        return ParticipantsMapper.toDto(participants);
    }

    @Transactional
    public ParticipantsDto createUser(ParticipantsDto requestParticipantsDto) {
        Participants createParticipants = new Participants();
        createParticipants.setFirstname(requestParticipantsDto.firstname());
        createParticipants.setLastname(requestParticipantsDto.lastname());
        createParticipants.setPatronymic(requestParticipantsDto.patronymic());

        Qrcodes qrcode = new Qrcodes();
        qrcode.setCodes(UUID.randomUUID());
        qrcode.setParticipant(createParticipants);
        createParticipants.getQrcodes().add(qrcode);

        Participants savedParticipant = participantsRepository.save(createParticipants);
        return ParticipantsMapper.toDto(savedParticipant);
    }

    public ParticipantsDto updateUser(Long id, ParticipantsDto requestParticipantsDto) {
        Participants nowParticipants = participantsRepository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));
        nowParticipants.setFirstname(requestParticipantsDto.firstname());
        nowParticipants.setLastname(requestParticipantsDto.lastname());
        nowParticipants.setPatronymic(requestParticipantsDto.patronymic());
        Participants updateParticipants = participantsRepository.save(nowParticipants);
        return ParticipantsMapper.toDto(updateParticipants);
    }

    public ParticipantsDto deleteUser(Long id) {
        Participants participants = participantsRepository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));
        participantsRepository.delete(participants);
        return ParticipantsMapper.toDto(participants);
    }

}
