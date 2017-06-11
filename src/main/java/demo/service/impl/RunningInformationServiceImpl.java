package demo.service.impl;

import demo.domain.RunningInfoRepository;
import demo.domain.RunningInformation;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created by vagrant on 6/9/17.
 */
@Service
public class RunningInformationServiceImpl implements RunningInformationService {
    private RunningInfoRepository repository;

    @Autowired
    public RunningInformationServiceImpl(RunningInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deleteByRunningID(String id) {
        repository.deleteByRunningId(id);
    }


    @Override
    public Page<RunningInformation> findByHeartRateGreaterThan(int heartRate, Pageable pageable) {
        return repository.findByHeartRateGreaterThan(heartRate, pageable);
    }

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> informationList) {
        return repository.save(informationList);
    }
}
