package ru.isaev.devicesdemo.persist;

import ru.isaev.devicesdemo.model.Project;

import javax.persistence.EntityManager;
import java.util.List;

public interface ProjectRepository {

    public void setEntityManager(EntityManager entityManager);

    public Project findProjectById(int id);

    public List<Project> findAllProjects();

}
