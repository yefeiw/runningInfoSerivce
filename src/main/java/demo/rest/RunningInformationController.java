package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/9/17.
 */
@RestController
public class RunningInformationController {
    private RunningInformationService runningInformationService;

    @Autowired
    public RunningInformationController(RunningInformationService runningInformationService) {
        this.runningInformationService = runningInformationService;
    }

    @RequestMapping(value = "/running",method = RequestMethod.GET)
    public Page<RunningInformation> display() {
        //page: first page(0), page size 2
        return this.runningInformationService.findAllOrderByHealthWarningLevelAndHeartRate(new PageRequest(0,2));
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public void deleteByRunningId(@RequestBody String id) {
        this.runningInformationService.deleteByRunningID(id);
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> informationList) {
        this.runningInformationService.SaveRunningInformation(informationList);
    }
}
