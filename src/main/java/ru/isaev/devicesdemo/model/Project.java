package ru.isaev.devicesdemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
//@NamedQueries({
//        @NamedQuery(name = "Project.findByID",
//                query = "SELECT p FROM Project p " +
//                        "LEFT JOIN FETCH p.devices d " +
//                        "LEFT JOIN FETCH d.events e " +
//                        "WHERE p.id = :Id")
//})
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;


    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "projects")
    private List<Device> devices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
