package com.ross.cs504.runninganalysisservice.service.impl;

import com.ross.cs504.runninganalysisservice.domain.RunningInformation;
import com.ross.cs504.runninganalysisservice.domain.RunningInformationRepository;
import com.ross.cs504.runninganalysisservice.service.RunningInfoAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class RunningInfoAnalysisServiceImpl implements RunningInfoAnalysisService {

    @Autowired
    private RunningInformationRepository repository;

    @Override
    public List<RunningInformation> saveRunningInfo(List<RunningInformation> runningInfo) {

        return repository.save(runningInfo.stream().map(temp -> {
            temp.setHeartRate(ThreadLocalRandom.current().nextInt(60, 200));
            return temp;
        }).collect(Collectors.toList()));
    }

    @Override
    public List<RunningInfoDto> findRunningInfoOrderByHealthLevel() {
        return convertToRunningInfoDtoList(repository.findByOrderByHeartRateDesc());
    }

    private List<RunningInfoDto> convertToRunningInfoDtoList(List<RunningInformation> runningInfo) {
        return runningInfo.stream().map(RunningInfoDto::new).collect(Collectors.toList());
    }

}
