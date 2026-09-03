package privateclub.dto;

import java.util.UUID;

public record QrcodesDto(
        Long id,
        UUID codes
) {
}
