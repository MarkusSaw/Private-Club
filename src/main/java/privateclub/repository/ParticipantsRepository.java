package privateclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import privateclub.model.Participants;

import java.util.List;

@Repository
public interface ParticipantsRepository extends JpaRepository<Participants, Long> {
    @Query("select a from Participants a join fetch a.qrсodes ")
    List<Participants>findAllWithQrcodes();

}
