package applifting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

//mark class as an Entity
@Entity

//defining class name as Table name
@Table(name= "monitoringUser")
public class User {

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

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "accessToken", nullable = false)
    private UUID accessToken;

    //  relationship is a type of cardinality that refers to the relationship between two entities
    //  https://en.wikipedia.org/wiki/One-to-many_(data_model)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<MonitoredEndpoint> monitoredEndpoints;

    public User(Long id, String username,
                String email, UUID accessToken,
                List<MonitoredEndpoint> monitoredEndpoints) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.accessToken = accessToken;
        this.monitoredEndpoints = monitoredEndpoints;
    }

    public User() {

    }

    public List<MonitoredEndpoint> getMonitoredEndpoints() {
        return monitoredEndpoints;
    }

    public void setMonitoredEndpoints(List<MonitoredEndpoint> monitoredEndpoints) {
        this.monitoredEndpoints = monitoredEndpoints;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(UUID accessToken) {
        this.accessToken = accessToken;
    }



}
