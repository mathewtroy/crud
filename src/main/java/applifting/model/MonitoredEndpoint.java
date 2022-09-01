package applifting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.time.LocalDateTime;

//mark class as an Entity
@Entity

public class MonitoredEndpoint {

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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "dateOfCreation", nullable = false)
    private LocalDateTime dateOfCreation;

    @Column(name = "dateOfLastCheck", nullable = false)
    private LocalDateTime dateOfLastCheck;

    @Column(name = "monitoredInterval", nullable = false)
    private Integer monitoredInterval;

    //  used at field level to mark a property or list of properties to be ignored
    @JsonIgnore

    //  relationship is a type of cardinality that refers to the relationship between two entities
    //  https://en.wikipedia.org/wiki/Many-to-many_(data_model)
    @ManyToOne()

    //  Specifies a column for joining an entity association or element collection.
    //  If the JoinColumn annotation itself is defaulted, a single join column is assumed
    //  and the default values apply.
    //  https://docs.oracle.com/javaee/6/api/javax/persistence/JoinColumn.html#:~:text=Specifies%20a%20column%20for%20joining,and%20the%20default%20values%20apply.
    @JoinColumn(name = "owner", nullable = false)
    private User owner;

    public MonitoredEndpoint(Long id, String name, String url,
            LocalDateTime dateOfCreation, LocalDateTime dateOfLastCheck,
            Integer monitoredInterval, User owner) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.dateOfCreation = dateOfCreation;
        this.dateOfLastCheck = dateOfLastCheck;
        this.monitoredInterval = monitoredInterval;
        this.owner = owner;
    }

    public MonitoredEndpoint() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDateTime getDateOfLastCheck() {
        return dateOfLastCheck;
    }

    public void setDateOfLastCheck(LocalDateTime dateOfLastCheck) {
        this.dateOfLastCheck = dateOfLastCheck;
    }

    public Integer getMonitoredInterval() {
        return monitoredInterval;
    }

    public void setMonitoredInterval(Integer monitoredInterval) {
        this.monitoredInterval = monitoredInterval;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
