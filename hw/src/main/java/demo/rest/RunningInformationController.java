package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Created by vagrant on 6/9/17.
 */
@RestController
public class RunningInformationController {
    //constants
    private final int kMinHeartBeat = 59;
    private final String kDefaultPageNum = "0";//usually the first page
    private final String kDefaultPageSize = "2";//HW requirement

    private RunningInformationService runningInformationService;

    @Autowired
    public RunningInformationController(RunningInformationService runningInformationService) {
        this.runningInformationService = runningInformationService;
    }

    @RequestMapping(value = "/running",method = RequestMethod.GET)
    public ResponseEntity<?> display(
            @RequestParam(name = "page", required = false, defaultValue = kDefaultPageNum) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = kDefaultPageSize) Integer size)
     {
        //Step 1: get paging inputs
         Sort sort = new Sort(
                 new Sort.Order(Sort.Direction.DESC, "heartRate")
         );
        Page<RunningInformation> input =  this.runningInformationService.findByHeartRateGreaterThan(59, new PageRequest(page,size,sort));
        List<RunningInformation> items = input.getContent();
        System.out.println("Result logs have size"+items.size());
        // Step 2: display them
        List<JSONObject> results = new ArrayList<JSONObject>();
        for (RunningInformation item : items) {
            JSONObject info = new JSONObject();
            info.put("runningId", item.getRunningId());
            info.put("totalRunningTime", item.getTotalRunningTime());
            info.put("heartRate", item.getHeartRate());
            info.put("userId", item.getId());
            info.put("userName", item.getUserInfo().getUsername());
            info.put("userAddress", item.getUserInfo().getAddress());
            info.put("healthWarningLevel", item.getHealthWarningLevel());
            results.add(info);
        }

        return new ResponseEntity<List<JSONObject>>(results, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{runningId}",method = RequestMethod.POST)
    public void deleteByRunningId(@PathVariable String runningId) {
        System.out.println("deleting running ID "+runningId);
        this.runningInformationService.removeRunningInformationsByRunningId(runningId);
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> informationList) {
        System.out.printf("Pushing %d items to database\n",informationList.size());
        this.runningInformationService.saveRunningInformation(informationList);
    }
}
