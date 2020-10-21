package ru.isaev.devicesdemo.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project projects;

    @Column(name = "serial_number", nullable = false)
    private String serialNumber;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "devices")
    private List<Event> events;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProjects() {
        return projects;
    }

    public void setProjects(Project projects) {
        this.projects = projects;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
