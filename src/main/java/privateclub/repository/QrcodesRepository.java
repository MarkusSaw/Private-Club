package privateclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import privateclub.model.Qrcodes;

@Repository
public interface QrcodesRepository extends JpaRepository<Qrcodes, Long> {
}
