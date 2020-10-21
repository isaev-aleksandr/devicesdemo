package ru.isaev.devicesdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.isaev.devicesdemo.buisness.ProjectService;
import ru.isaev.devicesdemo.rest.exception.ThereIsUnacceptableValueException;
import ru.isaev.devicesdemo.viev.ResponseDevices;
import ru.isaev.devicesdemo.viev.ResponseProject;

import java.util.List;
import java.util.Map;


@RestController
public class Controller {

    private final ProjectService projectServiceImpl;

    @Autowired
    public Controller(@Qualifier(value = "projectServiceImpl") ProjectService projectService) {
        this.projectServiceImpl = projectService;
    }

    @GetMapping("/get/{id}")
    public Map<String, ResponseDevices> findById(@PathVariable("id") int id) {
        if(id < 1){
            throw  new ThereIsUnacceptableValueException();
        }
        return projectServiceImpl.findProjectByIdInRepo(id);

    }

    @GetMapping("/get")
    public List<ResponseProject> findAll() {
        return projectServiceImpl.findAllProjects();

    }
}

