package ru.isaev.devicesdemo.buisness;

import ru.isaev.devicesdemo.persist.ProjectRepository;
import ru.isaev.devicesdemo.viev.ResponseDevices;
import ru.isaev.devicesdemo.viev.ResponseProject;

import java.util.HashMap;
import java.util.List;

public interface ProjectService {

    public void setProjectRepository(ProjectRepository bookRepositoryImpl);

    void setProjectsBuilderForResponse(ProjectsBuilderForResponse projectBuilderForResponse);

    public HashMap<String, ResponseDevices> findProjectByIdInRepo(int id);

    public void setDevicesBuilderForResponse(DevicesBuilderForResponse devicesBuilderForResponse);

    public List<ResponseProject> findAllProjects();
}
