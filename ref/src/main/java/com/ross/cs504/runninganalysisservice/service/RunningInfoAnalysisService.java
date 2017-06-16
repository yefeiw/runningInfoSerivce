package com.ross.cs504.runninganalysisservice.service;

import com.ross.cs504.runninganalysisservice.domain.RunningInformation;
import com.ross.cs504.runninganalysisservice.service.impl.RunningInfoDto;

import java.util.List;

public interface RunningInfoAnalysisService {
    List<RunningInformation> saveRunningInfo(List<RunningInformation> runningInfo);

    List<RunningInfoDto> findRunningInfoOrderByHealthLevel();
}
