package com.sipress.apiRest.service;

import com.sipress.apiRest.models.Project;
import com.sipress.apiRest.repository.ProjectRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
        public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
            return projectRepository.findById(id).map(projectUpdate -> {
                projectUpdate.setId(project.getId());
                projectUpdate.setNom(project.getNom());
                projectUpdate.setPromoteur(project.getPromoteur());
                projectUpdate.setSite(project.getSite());
                projectUpdate.setVille(project.getVille());
                projectUpdate.setTitrePropriete(project.getTitrePropriete());
                projectUpdate.setPrixMaitreCarre(project.getPrixMaitreCarre());
                projectUpdate.setPrixTerrain(project.getPrixTerrain());
                projectUpdate.setSurfaceTerrain(project.getSurfaceTerrain());
                projectUpdate.setDescription(project.getDescription());
                return projectRepository.save(projectUpdate);

            }).orElseThrow(() -> new ResourceNotFoundException("PostId " + id + " not found"));
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
