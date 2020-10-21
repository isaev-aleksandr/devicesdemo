package ru.isaev.devicesdemo.buisness.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isaev.devicesdemo.buisness.ProjectsBuilderForResponse;
import ru.isaev.devicesdemo.buisness.ProjectService;
import ru.isaev.devicesdemo.buisness.DevicesBuilderForResponse;
import ru.isaev.devicesdemo.persist.ProjectRepository;
import ru.isaev.devicesdemo.viev.ResponseDevices;
import ru.isaev.devicesdemo.viev.ResponseProject;

import java.util.HashMap;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private DevicesBuilderForResponse devicesBuilderForResponse;
    private ProjectsBuilderForResponse projectBuilderForResponse;

    @Autowired
    @Override
    public void setProjectRepository(ProjectRepository projectRepositoryImpl){
        this.projectRepository = projectRepositoryImpl;
    };

    @Autowired
    @Override
    public void setDevicesBuilderForResponse(DevicesBuilderForResponse devicesBuilderForResponse){
        this.devicesBuilderForResponse = devicesBuilderForResponse;
    };

    @Autowired
    @Override
    public void setProjectsBuilderForResponse(ProjectsBuilderForResponse projectBuilderForResponse){
        this.projectBuilderForResponse = projectBuilderForResponse;
    };

    @Override
    @Transactional
    public HashMap<String, ResponseDevices> findProjectByIdInRepo(int id){
        return devicesBuilderForResponse.getDevicesResponse(
                projectRepository.findProjectById(id)
        );

    }

    @Override
    @Transactional
    public List<ResponseProject> findAllProjects(){
        return projectBuilderForResponse.getProjectResponse(
                projectRepository.findAllProjects()
        );

    }

}
