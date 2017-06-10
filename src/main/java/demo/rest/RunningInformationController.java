package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Page<RunningInformation> display(@RequestParam(name = "page")int page))
        return this.runningInformationService.findAllOrOrderByHealthWarningLevelAndHeartRate(new PageRequest(page,2));
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public void deleteByRunningId(@RequestBody String id) {
        this.runningInformationService.deleteByRunningID(id);
    }

    @RequestMapping(value="/running",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> informationList) {
        this.runningInformationService.SaveRunningInformation(informationList);
}
