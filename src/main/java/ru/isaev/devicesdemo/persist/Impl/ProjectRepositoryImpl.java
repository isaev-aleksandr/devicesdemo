package ru.isaev.devicesdemo.persist.Impl;

import org.springframework.stereotype.Repository;
import ru.isaev.devicesdemo.model.Project;
import ru.isaev.devicesdemo.persist.ProjectRepository;
import ru.isaev.devicesdemo.rest.exception.ThereIsNotFoundProjectException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private EntityManager entityManager;

    @PersistenceContext
    @Override
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    };

    @Override
    public Project findProjectById(int id){
        Project project = entityManager.find(Project.class, id);
            if (project == null) {
                throw new ThereIsNotFoundProjectException();
            } else return project;
    }

    @Override
    public List<Project> findAllProjects(){
        return entityManager.createQuery("SELECT p FROM Project p ", Project.class).getResultList();

    }
}
