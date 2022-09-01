package applifting.controller;

import applifting.model.MonitoredEndpoint;
import applifting.model.MonitoringResult;
import applifting.service.MonitoringResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonitoringResultController {

    private final MonitoringResultService monitoringResultService;

    @Autowired
    public MonitoringResultController(MonitoringResultService monitoringResultService) {
        this.monitoringResultService = monitoringResultService;
    }

    @GetMapping("/result/{id}")
    public List<MonitoringResult> getMonitoredResult(@PathVariable Long id) {
        return monitoringResultService.getLastTen(id);
    }

}
