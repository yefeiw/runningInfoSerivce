package demo.service;

import demo.domain.RunningInformation;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by vagrant on 6/9/17.
 */
public interface RunningInformationService {
    Page<RunningInformation> findAllOrOrderByHealthWarningLevelAndHeartRate(Pageable pageable);
    void deleteByRunningID(String id);
    List<RunningInformation> SaveRunningInformation(List<RunningInformation> information);

}
