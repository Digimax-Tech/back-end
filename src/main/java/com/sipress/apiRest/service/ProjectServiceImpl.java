package com.sipress.apiRest.service;

import com.sipress.apiRest.models.Project;
import com.sipress.apiRest.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;

    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> searchProjects(String query) {
        List<Project> projects = projectRepository.searchProjects(query);
        return projects;

    }

    @Override
    public List<Project> fetchProjectList() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Project project, Long id) {
        Project project1 = projectRepository.findById(id).get();
        project.setId(project1.getId());
        project.setNom(project1.getNom());
        project.setPromoteur(project1.getPromoteur());
        project.setSite(project1.getSite());
        project.setVille(project1.getVille());
        project.setTitrePropriete(project1.getTitrePropriete());
        project.setPrixMaitreCarre(project1.getPrixMaitreCarre());
        project.setPrixTerrain(project1.getPrixTerrain());
        project.setSurface(project1.getSurface());
        project.setDescription(project1.getDescription());
        return projectRepository.save(project1);
    }



    @Override
    public Optional<Project> findProjectById(Long id) {

        return projectRepository.findById(id);
    }

    @Override
    public void deleteProjecttById(Long id) {
        projectRepository.deleteById(id);

    }

}
