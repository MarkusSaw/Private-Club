package privateclub.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import privateclub.dto.ParticipantsDto;
import privateclub.exception.NotFoundException;
import privateclub.mapper.ParticipantsMapper;
import privateclub.model.Participants;
import privateclub.repository.ParticipantsRepository;

@AllArgsConstructor
@Service
public class ParticipantsService {
    private final ParticipantsRepository participantsRepository;

    public ParticipantsDto getUserById(Long id) {
        Participants participants = participantsRepository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));
        return ParticipantsMapper.toDto(participants);
    }

    public ParticipantsDto createUser(ParticipantsDto requestParticipantsDto) {
        Participants createParticipants = new Participants();
        createParticipants.setFirstname(requestParticipantsDto.firstname());
        createParticipants.setLastname(requestParticipantsDto.lastname());
        createParticipants.setPatronymic(requestParticipantsDto.patronymic());
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
