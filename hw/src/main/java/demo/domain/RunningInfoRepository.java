package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by vagrant on 6/9/17.
 */

public interface RunningInfoRepository extends JpaRepository<RunningInformation,Long> {
    @Transactional
    @Modifying
    void removeRunningInformationsByRunningId(@Param("runningId") String id);
    Page<RunningInformation> findByHeartRateGreaterThan( @Param("heartRate") int heartRate, Pageable pageable);
}
