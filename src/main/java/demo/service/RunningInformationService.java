package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.*;

/**
 * Created by vagrant on 6/9/17.
 */
public interface RunningInformationService {
    Page<RunningInformation> findAllOrderByHealthWarningLevelAndHeartRate(Pageable pageable);
    void deleteByRunningID(String id);
    List<RunningInformation> SaveRunningInformation(List<RunningInformation> information);

}
