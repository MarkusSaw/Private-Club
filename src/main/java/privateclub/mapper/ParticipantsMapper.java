package privateclub.mapper;

import privateclub.dto.ParticipantsDto;
import privateclub.model.Participants;


public class ParticipantsMapper {
    public static ParticipantsDto toDto(Participants ptc){
        return new ParticipantsDto(
                ptc.getId(),
                ptc.getFirstname(),
                ptc.getLastname(),
                ptc.getPatronymic()

        );
    }
}
