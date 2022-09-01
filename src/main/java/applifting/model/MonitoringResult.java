package applifting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.time.LocalDateTime;

//mark class as an Entity
@Entity
public class MonitoringResult {

    //Defining id as primary key
    @Id

    //  Provides for the specification of generation strategies for the values of primary keys.
    //  https://docs.oracle.com/javaee/6/api/javax/persistence/GeneratedValue.html
    @GeneratedValue(strategy = GenerationType.AUTO)

    //  Specifies the mapped column for a persistent property or field.
    //  If no Column annotation is specified, the default values apply.
    //  https://docs.oracle.com/javaee/7/api/javax/persistence/Column.html
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dateOfCheck", nullable = false)
    private LocalDateTime dateOfCheck;

    @Column(name = "returnedHttpStatusCode", nullable = false)
    private Integer returnedHttpStatusCode;

    @Column(name = "returnedPayload", nullable = false)
    private String returnedPayload;

    //  Specifies a column for joining an entity association or element collection.
    //  If the JoinColumn annotation itself is defaulted, a single join column is assumed
    //  and the default values apply.
    //  https://docs.oracle.com/javaee/6/api/javax/persistence/JoinColumn.html#:~:text=Specifies%20a%20column%20for%20joining,and%20the%20default%20values%20apply.
    @JoinColumn(name = "idToMonitoredEndpointId", nullable = false)

    //  relationship is a type of cardinality that refers to the relationship between two entities
    //  https://en.wikipedia.org/wiki/Many-to-many_(data_model)
    @ManyToOne(cascade = CascadeType.ALL)
    private MonitoredEndpoint monitoredEndpointId;

    public MonitoringResult(Long id, LocalDateTime dateOfCheck,
            Integer returnedHttpStatusCode, String returnedPayload,
            MonitoredEndpoint monitoredEndpointId) {
        this.id = id;
        this.dateOfCheck = dateOfCheck;
        this.returnedHttpStatusCode = returnedHttpStatusCode;
        this.returnedPayload = returnedPayload;
        this.monitoredEndpointId = monitoredEndpointId;
    }

    public MonitoringResult() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfCheck() {
        return dateOfCheck;
    }

    public void setDateOfCheck(LocalDateTime dateOfCheck) {
        this.dateOfCheck = dateOfCheck;
    }

    public Integer getReturnedHttpStatusCode() {
        return returnedHttpStatusCode;
    }

    public void setReturnedHttpStatusCode(Integer returnedHttpStatusCode) {
        this.returnedHttpStatusCode = returnedHttpStatusCode;
    }

    public String getReturnedPayload() {
        return returnedPayload;
    }

    public void setReturnedPayload(String returnedPayload) {
        this.returnedPayload = returnedPayload;
    }

    public MonitoredEndpoint getMonitoredEndpointId() {
        return monitoredEndpointId;
    }

    public void setMonitoredEndpointId(MonitoredEndpoint monitoredEndpointId) {
        this.monitoredEndpointId = monitoredEndpointId;
    }

}
