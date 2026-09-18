package privateclub.mapper;

import privateclub.dto.ParticipantsDto;
import privateclub.model.Participants;


public class ParticipantsMapper {
    public static ParticipantsDto toDto(Participants ptc){
        return new ParticipantsDto(
                ptc.getId(),
                ptc.getFirstname(),
                ptc.getLastname(),
                ptc.getPatronymic(),
                QrcodesMapper.listQrDto(ptc.getQrcodes())
        );
    }

    public static Participants toEntity(ParticipantsDto dto){
        Participants ptc = new Participants();
        ptc.setFirstname(dto.firstname());
        ptc.setLastname(dto.lastname());
        ptc.setPatronymic(dto.patronymic());
        ptc.setQrcodes(QrcodesMapper.listToEntity(dto.qrcodes()));
        return ptc;
    }
}
