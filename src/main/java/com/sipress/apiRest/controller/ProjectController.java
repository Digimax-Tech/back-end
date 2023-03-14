package com.sipress.apiRest.controller;
import com.sipress.apiRest.models.Project;
import com.sipress.apiRest.models.ProjectStatus;
import com.sipress.apiRest.repository.ProjectRepository;
import com.sipress.apiRest.service.ProjectService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class ProjectController {
    private ProjectService projectService;
private ProjectRepository projectRepository;

     public ProjectController(ProjectService projectService, ProjectRepository projectRepository)
     {
        this.projectService = projectService;

         this.projectRepository = projectRepository;
     }


    @PutMapping("/projects/{id}")
    public Project updatePost(@PathVariable Long id, @RequestBody  Project project)
    {
        return projectRepository.findById(id).map(post -> {
            post.setNom(project.getNom());
            post.setDescription(project.getDescription());
            post.setPrixTerrain(project.getPrixTerrain());
            post.setPrixMaitreCarre(project.getPrixMaitreCarre());
            post.setPromoteur(project.getPromoteur());
            post.setVille(project.getVille());
            post.setSite(project.getSite());
            post.setSurfaceTerrain(project.getSurfaceTerrain());
            post.setFonciers(project.getFonciers());
            post.setTitrePropriete(project.getTitrePropriete());
            post.setEtudeFonciers(project.getEtudeFonciers());
            post.setCreatedAt(project.getCreatedAt());
            return projectRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("projectId " + id + " not found"));
    }



    @PostMapping("/addProject")
    public Project saveProject(@RequestBody Project project)
    {   project.setStatus(ProjectStatus.ENCOURS);
        return projectService.saveProject(project);
    }

    @GetMapping("/projects")
    public List<Project> fetchProjectList()
    {
        return projectService.fetchProjectList();
    }


    @GetMapping("/approveProject/{id}")
   // @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
    public String approveProject(@PathVariable Long id) {
        Project project = projectRepository.findById(id).get();
        project.setStatus(ProjectStatus.REALISE);
        projectRepository.save(project);
        return "Project  Approved !!";
    }

    @GetMapping("/project/{id}")
    public Optional<Project> findProjectById(@PathVariable("id") Long id)
    {
        return projectService.findProjectById(id);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Project>> searchProjects(@RequestParam("query") String query)
    {
        return ResponseEntity.ok(projectService.searchProjects(query));
    }


    @DeleteMapping("/projects/{id}")
    public String deleteProjectById(@PathVariable("id") Long id)
    {
        projectService.deleteProjecttById(id);
        return "Deleted Successfully";
    }


    @GetMapping("/viewAllProject")
    public  List<Project> viewAllProject(){
        return projectRepository.findAll().stream()
                .filter(post -> post.getStatus().equals(ProjectStatus.REALISE))
                .collect(Collectors.toList());
    }

}

