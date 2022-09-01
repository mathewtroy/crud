package applifting.service;

import applifting.interfaces.MonitoredEndpointRepository;
import applifting.interfaces.MonitoringResultRepository;
import applifting.model.MonitoredEndpoint;
import applifting.model.MonitoringResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoringResultService {

    private final MonitoringResultRepository monitoringResultRepository;

    public MonitoringResultService(MonitoringResultRepository monitoringResultRepository) {
        this.monitoringResultRepository = monitoringResultRepository;
    }

    @Autowired
    private MonitoredEndpointRepository monitoredEndpointRepository;

    public List<MonitoringResult> getLastTen(Long id) {
        MonitoredEndpoint endpoint = monitoredEndpointRepository.getReferenceById(id);
        return monitoringResultRepository.findTop10ByMonitoredEndpointIdOrderByDateOfCheck(endpoint);
    }

}
