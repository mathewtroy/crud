package applifting.controller;

import applifting.model.MonitoredEndpoint;
import applifting.service.MonitoredEndpointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitored/end/point")
public class MonitoredEndpointController {

    private final MonitoredEndpointService monitoredEndpointService;

    @Autowired
    public MonitoredEndpointController(MonitoredEndpointService monitoredEndpointService,
            MonitoredEndpointService monitoredEndpointService1) {

        this.monitoredEndpointService = monitoredEndpointService1;
    }

    @GetMapping
    public List<MonitoredEndpoint> getMonitoredEndPoint() {
        return monitoredEndpointService.getMonitoredEndPoint();
    }

    @PostMapping
    public MonitoredEndpoint setMonitoredEndPoint(@RequestBody MonitoredEndpointCreateRequest request) {
        return monitoredEndpointService.setMonitoredEndPoint(request.name,
                request.url, request.monitoredInterval);
    }

}
