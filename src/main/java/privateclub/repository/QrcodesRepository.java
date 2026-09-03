package privateclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import privateclub.model.Qrсodes;

@Repository
public interface QrcodesRepository extends JpaRepository<Qrсodes, Long> {
}
