package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


/**
 * Created by vagrant on 6/9/17.
 */

public interface RunningInfoRepository extends JpaRepository<RunningInformation,Long> {
    Page<RunningInformation> findAllOrderByHealthWarningLevelAndHeartRate(Pageable pageable);
    void deleteByRunningId(@Param("runningId") String id);

}
