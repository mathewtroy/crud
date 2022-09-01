package applifting.service;

import applifting.interfaces.MonitoredEndpointRepository;
import applifting.interfaces.UserRepository;
import applifting.model.MonitoredEndpoint;
import applifting.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MonitoredEndpointService {

    @Autowired
    private final MonitoredEndpointRepository monitoredEndpointRepository;

    public MonitoredEndpointService(MonitoredEndpointRepository monitoredEndpointRepository, UserRepository userRepository) {
        this.monitoredEndpointRepository = monitoredEndpointRepository;
        this.userRepository = userRepository;
    }

    @Autowired
    private final UserRepository userRepository;

    public List<MonitoredEndpoint> getMonitoredEndPoint() {

        return monitoredEndpointRepository.findAll();
    }

    public MonitoredEndpoint setMonitoredEndPoint(String name, String url, Integer monitoredInterval) {

        MonitoredEndpoint endpoint = new MonitoredEndpoint();
        endpoint.setName(name);
        endpoint.setUrl(url);
        endpoint.setMonitoredInterval(monitoredInterval);
        endpoint.setDateOfCreation(LocalDateTime.now());
        endpoint.setDateOfLastCheck(LocalDateTime.now());

        //User owner = null;
        endpoint.setOwner(userRepository.getReferenceById(1L));

        return monitoredEndpointRepository.save(endpoint);
    }
}
