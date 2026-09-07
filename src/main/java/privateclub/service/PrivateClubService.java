package privateclub.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import privateclub.dto.ParticipantsDto;
import privateclub.mapper.ParticipantsMapper;
import privateclub.model.Participants;
import privateclub.repository.ParticipantsRepository;
import privateclub.repository.QrcodesRepository;

@AllArgsConstructor
@Service
public class PrivateClubService {
    private final ParticipantsRepository participantsRepository;
//    private final QrcodesRepository qrcodesRepository;

    public ParticipantsDto getUserById(Long id) {
        Participants participants = participantsRepository.findById(id).orElseThrow();
        return ParticipantsMapper.toDto(participants);
    }

    public ParticipantsDto createUser(Participants participants) {
        Participants createParticipants = participantsRepository.save(participants);
        return ParticipantsMapper.toDto(createParticipants);
    }

    public ParticipantsDto updateUser(Long id, Participants participants) {
        Participants nowParticipants = participantsRepository.findById(id).orElseThrow();
        nowParticipants.setFirstname(participants.getFirstname());
        nowParticipants.setLastname(participants.getLastname());
        nowParticipants.setPatronymic(participants.getPatronymic());
        Participants updateParticipants = participantsRepository.save(nowParticipants);
        return ParticipantsMapper.toDto(updateParticipants);
    }

    public ParticipantsDto deleteUser(Long id) {
        Participants participants = participantsRepository.findById(id).orElseThrow();
        participantsRepository.delete(participants);
        return ParticipantsMapper.toDto(participants);
    }

}
