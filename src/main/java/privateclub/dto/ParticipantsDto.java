package privateclub.dto;

import java.util.List;

public record ParticipantsDto(
        Long id,
        String firstname,
        String lastname,
        String patronymic,
        List<QrcodesDto> qrcodes
) {
}
