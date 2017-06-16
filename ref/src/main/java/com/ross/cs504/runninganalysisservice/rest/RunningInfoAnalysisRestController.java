package com.ross.cs504.runninganalysisservice.rest;

import com.ross.cs504.runninganalysisservice.domain.RunningInformation;
import com.ross.cs504.runninganalysisservice.service.RunningInfoAnalysisService;
import com.ross.cs504.runninganalysisservice.service.impl.RunningInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RunningInfoAnalysisRestController {

    @Autowired
    private RunningInfoAnalysisService analysisService;

    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    public List<RunningInfoDto> getRunningInfo() {
        return analysisService.findRunningInfoOrderByHealthLevel();
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    public List<RunningInformation> persistRunningInfo(@RequestBody List<RunningInformation> runningInformation) {
        return analysisService.saveRunningInfo(runningInformation);
    }
}
