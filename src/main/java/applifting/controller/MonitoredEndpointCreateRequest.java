package applifting.controller;

import javax.persistence.Column;

public class MonitoredEndpointCreateRequest {

    public String name;

    public String url;

    public Integer monitoredInterval;
}
