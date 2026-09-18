package privateclubtests.mockito;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import privateclub.controller.ParticipantsController;
import privateclub.dto.ParticipantsDto;
import privateclub.service.ParticipantsService;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockParticipantsServiceTest {

    @Mock
    ParticipantsService participantsService;

    @InjectMocks
    ParticipantsController participantsController;

    @Test
    void mockTestingParticipantsService() {
        ParticipantsDto dto = new ParticipantsDto(5L, "Karabas", "<Barabas", "Ivanovich", List.of());

        when(participantsService.getUserById(5L)).thenReturn(dto);
        when(participantsService.createUser(dto)).thenReturn(dto);
        when(participantsService.updateUser(5L, dto)).thenReturn(dto);
        when(participantsService.deleteUser(5L)).thenReturn(dto);

        participantsController.getParticipant(5L);
        participantsController.createParticipant(dto);
        participantsController.updateParticipant(5L, dto);
        participantsController.deleteParticipant(5L);

        verify(participantsService).getUserById(5L);
        verify(participantsService).createUser(dto);
        verify(participantsService).updateUser(5L, dto);
        verify(participantsService).deleteUser(5L);
    }
}



